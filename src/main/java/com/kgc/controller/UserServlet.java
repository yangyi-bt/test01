package com.kgc.controller;

import com.kgc.entity.User;
import com.kgc.service.UserService;
import com.kgc.service.impl.UserServiceImpl;
import com.kgc.utils.EmptyUtils;
import com.kgc.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if ("findAll".equals(method)){
            this.doFindAll(request,response);
        }else if ("findById".equals(method)){
            this.doFindById(request,response);
        }else if ("update".equals(method)){
            this.doUpdate(request,response);
        }else if ("insert".equals(method)){
            this.doInsert(request,response);
        }else if ("delete".equals(method)){
            this.doDelete(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void doFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取user_name card_id
        String user_name = request.getParameter("user_name");
        String cardsId = request.getParameter("cards_id");
        Integer cards_id = -1;
        if (EmptyUtils.isNotEmpty(cardsId)){
            cards_id = Integer.valueOf(cardsId);
        }
        User user = new User();
        user.setUser_name(user_name);
        user.setCards_id(cards_id);
        //获取总行数
        int rows = userService.getRows(user);
        PageBean pageBean = new PageBean();
        pageBean.setTotalRows(rows);
        //获取当前页面数
        String page = request.getParameter("page");
        Integer curPage = 1;
        if (EmptyUtils.isNotEmpty(page)){
            curPage = Integer.valueOf(page);
        }
        pageBean.setCurrentPage(curPage);
        //按条件分页查询
        List<User> list = userService.findAll(pageBean,user);
        //将查询结果放入pageBean
        pageBean.setList(list);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/findAll.jsp").forward(request,response);
    }

    protected void doFindById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("user_id"));
        User user = userService.findById(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    protected void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_num = request.getParameter("user_num");
        String user_name = request.getParameter("user_name");
        String user_addr = request.getParameter("user_addr");
        Integer cards_id = Integer.valueOf(request.getParameter("cards_id"));
        User user = new User(null,user_num,user_name,user_addr,null,cards_id);
        userService.insert(user);
        response.sendRedirect("/UserServlet?method=findAll");
    }

    protected void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer user_id = Integer.valueOf(request.getParameter("user_id"));
        String user_name = request.getParameter("user_name");
        String user_addr = request.getParameter("user_addr");
        Integer cards_id = Integer.valueOf(request.getParameter("cards_id"));
        User user = new User();
        user.setUser_id(user_id);
        user.setUser_name(user_name);
        user.setUser_addr(user_addr);
        user.setCards_id(cards_id);
        System.out.println(user);
        userService.update(user);
        response.sendRedirect("/UserServlet?method=findAll");
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id");
        userService.delete(user_id);
        response.sendRedirect("/UserServlet?method=findAll");
    }
}
