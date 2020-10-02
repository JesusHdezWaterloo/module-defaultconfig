/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.default_config;

import com.clean.core.app.services.ExceptionHandler;
import com.clean.core.app.services.ExceptionHandlerServiceFunctional;
import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationsGeneralType;
import com.clean.core.domain.services.Resource;
import com.jhw.utils.exceptions.ExceptionHandlerUtil;
import java.io.File;
import java.util.function.Consumer;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GeneralExceptionHandler extends ExceptionHandlerServiceFunctional {

    private final File file = new File("error_log");

    public static GeneralExceptionHandler init() {
        GeneralExceptionHandler excep = new GeneralExceptionHandler();
        ExceptionHandler.registerExceptionHandlerService(excep);
        return excep;
    }

    public GeneralExceptionHandler() {
        addAll();
    }

    @Override
    protected void addAll() {
        addHandler(ExceptionsGeneralType.EXCEPTION_VALIDATION, (Throwable e) -> {
            Notification.showNotification(NotificationsGeneralType.NOTIFICATION_ERROR, e.getMessage());
        });
        addHandler(ExceptionsGeneralType.EXCEPTION_VALIDATION_X, (Throwable e) -> {
            Notification.showNotification(NotificationsGeneralType.NOTIFICATION_ERROR,
                    Resource.getString(ExceptionsGeneralType.MSG_JAVAX_VALIDATION));
        });
        addHandler(ExceptionsGeneralType.EXCEPTION_RUNTIME, (Throwable e) -> {
            Notification.showConfirmDialog(NotificationsGeneralType.CONFIRM_ERROR,
                    e.getMessage());
        });
        addHandler(ExceptionsGeneralType.EXCEPTION_MALFORMED_URL, (Throwable e) -> {
            Notification.showConfirmDialog(NotificationsGeneralType.CONFIRM_ERROR,
                    Resource.getString(ExceptionsGeneralType.MSG_MALFORMED_URL));
            ExceptionHandlerUtil.saveException(file, e);
        });
        addHandler(ExceptionsGeneralType.EXCEPTION, general);
    }

    private final Consumer<Throwable> general = (Throwable e) -> {
        Notification.showConfirmDialog(NotificationsGeneralType.CONFIRM_ERROR,
                Resource.getString("msg.default_config.error.exception") + "\n" + e.getMessage());
        ExceptionHandlerUtil.saveException(file, e);
    };
}
