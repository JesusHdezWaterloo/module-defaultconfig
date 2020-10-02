package com.jhw.module.util.default_config;

import com.clean.core.app.services.ExceptionHandler;
import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationsGeneralType;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MainTest {

    public static void main(String args[]) throws Exception {
        String abc = "bajo la ceiba de la fraternidad, la de al lado de la casa blanca, a la hora de pedir un deseo, antes que scanol se vuelva invencible";
        String cba = "";
        for (int i = 0; i < abc.length(); i++) {
            cba += abc.charAt(abc.length() - i - 1);
        }
        System.out.println(cba);
        for (int i = 0; i < cba.length(); i++) {
            if (cba.charAt(i) == ' ') {
                System.out.print(".");
            } else if (cba.charAt(i) == ',') {
                System.out.print(",");
            } else {
                System.out.print((int) cba.charAt(i) - 96 + " ");
            }
        }
    }

}
