package com.jhw.modules.default_config;

import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.AbstractSwingMainModule;

public class DefaultConfigSwingModule implements AbstractSwingMainModule {

    public DefaultConfigSwingModule() {
    }

    @Override
    public void register(AbstractSwingApplication app) {
        System.out.println("Creando 'Configuracion por defecto'");
        GeneralNotificationService.init();//notificacenes por defecto
        GeneralExceptionHandler.init();
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
