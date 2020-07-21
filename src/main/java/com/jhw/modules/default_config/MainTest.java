package com.jhw.modules.default_config;

import com.clean.core.app.services.ExceptionHandler;
import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationsGeneralType;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MainTest {

    public static void main(String args[]) throws Exception {
        new DefaultConfigSwingModule().register(null);
        Notification.showNotification(NotificationsGeneralType.CONFIRM_CANCEL, "123");

        /*try {
            System.out.println("hi");
            int a = 5 / 0;
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }*/
    }

}
