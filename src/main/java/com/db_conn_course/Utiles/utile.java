package com.db_conn_course.Utiles;

public class utile {
    public static java.sql.Date getSQLDate(java.util.Date date){
        return new java.sql.Date(date.getTime());
    }
}
