package com.jhw.modules.default_config;

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
        JOptionPane.showConfirmDialog(null, "123",
                "Información",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        /*try {
            System.out.println("hi");
            int a = 5 / 0;
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }*/
    }

}
