package com.kgc.controller;

import com.kgc.entity.Card;
import com.kgc.service.CardService;
import com.kgc.service.impl.CardServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/CardServlet")
public class CardServlet extends HttpServlet {
    private CardService cardService = new CardServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if ("findAll".equals(method)){
            this.doFindAll(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void doFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Card> cards = cardService.findAll();
        HttpSession session = request.getSession();
        session.setAttribute("cards",cards);
        response.sendRedirect("/UserServlet?method=findAll");
    }
}
