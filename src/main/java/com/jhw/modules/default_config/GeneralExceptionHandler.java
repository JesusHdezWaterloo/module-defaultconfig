/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.modules.default_config;

import com.clean.core.app.services.ExceptionHandlerServiceFunctional;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GeneralExceptionHandler extends ExceptionHandlerServiceFunctional {

    @Override
    protected void addAll() {
        addHandler(type, consumer);
    }

}
