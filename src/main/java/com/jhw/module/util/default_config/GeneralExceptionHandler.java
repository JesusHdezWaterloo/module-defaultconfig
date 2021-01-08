/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.default_config;

import com.root101.clean.core.app.services.ExceptionHandler;
import com.root101.clean.core.app.services.ExceptionHandlerServiceFunctional;
import com.root101.clean.core.app.services.NotificationHandler;
import com.root101.clean.core.app.services.NotificationsGeneralType;
import com.root101.clean.core.domain.services.ResourceHandler;
import com.root101.utils.exceptions.ExceptionHandlerUtil;
import com.root101.utils.exceptions.ExceptionHandlerUtil;
import java.io.File;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GeneralExceptionHandler extends ExceptionHandlerServiceFunctional {

    private final File file = new File("error_log");

    public static GeneralExceptionHandler init() {
        GeneralExceptionHandler excep = new GeneralExceptionHandler();
        ExceptionHandler.registerExceptionService(excep);
        return excep;
    }

    @Override
    protected void addAll() {
        addHandler(ExceptionsGeneralType.EXCEPTION_VALIDATION, (Throwable e) -> {
            NotificationHandler.showNotification(NotificationsGeneralType.NOTIFICATION_ERROR, e.getMessage());
        });
        addHandler(ExceptionsGeneralType.EXCEPTION_VALIDATION_X, (Throwable e) -> {
            NotificationHandler.showNotification(NotificationsGeneralType.NOTIFICATION_ERROR,
                    ResourceHandler.getString(ExceptionsGeneralType.MSG_JAVAX_VALIDATION));
        });
        addHandler(ExceptionsGeneralType.EXCEPTION_RUNTIME, (Throwable e) -> {
            NotificationHandler.showConfirmDialog(NotificationsGeneralType.CONFIRM_ERROR,
                    e.getMessage());
        });
        addHandler(ExceptionsGeneralType.EXCEPTION_MALFORMED_URL, (Throwable e) -> {
            NotificationHandler.showConfirmDialog(NotificationsGeneralType.CONFIRM_ERROR,
                    ResourceHandler.getString(ExceptionsGeneralType.MSG_MALFORMED_URL));
            ExceptionHandlerUtil.saveException(file, e);
        });
        addHandler(ExceptionsGeneralType.EXCEPTION, (Throwable e) -> {
            NotificationHandler.showConfirmDialog(NotificationsGeneralType.CONFIRM_ERROR,
                    ResourceHandler.getString("msg.default_config.error.exception") + "\n" + e.getMessage());
            ExceptionHandlerUtil.saveException(file, e);
        });
    }

}
