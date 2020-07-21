package com.jhw.modules.default_config;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MainTest {

    public static void main(String args[]) throws Exception {
        Exception e = new NullPointerException("bu");
        System.out.println(e.getClass().toGenericString());
        System.out.println(e.getClass().toString());
    }

}
