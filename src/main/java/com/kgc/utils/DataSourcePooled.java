package com.kgc.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourcePooled {
    private static ComboPooledDataSource dataSource;

    static{
        dataSource = new ComboPooledDataSource();
    }

    public static ComboPooledDataSource getDataSource(){
        return dataSource;
    }
}
