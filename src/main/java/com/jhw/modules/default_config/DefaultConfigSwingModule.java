package com.jhw.modules.default_config;

import com.clean.core.app.services.ExceptionHandler;
import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.AbstractSwingMainModule;
import java.net.MalformedURLException;

public class DefaultConfigSwingModule implements AbstractSwingMainModule {

    private DefaultConfigSwingModule() {
    }

    public static DefaultConfigSwingModule init() {
        System.out.println("Creando 'Configuracion por defecto'");
        GeneralExceptionHandler.init();
        GeneralNotificationService.init();//notificacenes por defecto
        try {
            GeneralResourceService.init();
        } catch (MalformedURLException ex) {
            ExceptionHandler.handleException(ex);
        }
        return new DefaultConfigSwingModule();
    }

    @Override
    public void register(AbstractSwingApplication app) {
    }

    /**
     * Dont need navigation
     *
     * @param string
     * @param o
     */
    @Override
    public void navigateTo(String string, Object... o) {
    }

}
