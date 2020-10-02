package com.jhw.module.util.default_config;

import com.clean.core.app.services.ExceptionHandler;
import com.clean.swing.app.DefaultAbstractSwingMainModule;
import java.net.MalformedURLException;

public class DefaultConfigSwingModule extends DefaultAbstractSwingMainModule {

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

}
