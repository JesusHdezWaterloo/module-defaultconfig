/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.module.util.default_config;

import com.root101.clean.core.app.services.ExceptionHandlerServiceFunctional;
import com.root101.clean.core.exceptions.ValidationException;
import java.net.MalformedURLException;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ExceptionsGeneralType {

    //Excepcion general
    public static final String EXCEPTION = ExceptionHandlerServiceFunctional.getExceptionType(Exception.class);
    public static final String MSG_EXCEPTION = "msg.default_config.error.exception";

    public static final String EXCEPTION_RUNTIME = ExceptionHandlerServiceFunctional.getExceptionType(RuntimeException.class);

    //Excepcion de las validaciones de clean, generalmente en el domain
    public static final String EXCEPTION_VALIDATION = ExceptionHandlerServiceFunctional.getExceptionType(ValidationException.class);

    //Excepcion de las validaciones del persistence como tal
    public static final String EXCEPTION_VALIDATION_X = ExceptionHandlerServiceFunctional.getExceptionType(ConstraintViolationException.class);
    public static final String MSG_JAVAX_VALIDATION = "msg.default_config.error.javax.validation";

    public static final String EXCEPTION_MALFORMED_URL = ExceptionHandlerServiceFunctional.getExceptionType(MalformedURLException.class);
    public static final String MSG_MALFORMED_URL = "msg.default_config.error.malformed_url";

}
