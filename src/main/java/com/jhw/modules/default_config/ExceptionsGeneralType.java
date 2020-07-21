/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.modules.default_config;

import com.clean.core.app.services.ExceptionHandlerServiceFunctional;
import com.clean.core.exceptions.ValidationException;
import java.sql.SQLIntegrityConstraintViolationException;
import com.jhw.utils.jpa.NonExistingEntityException;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ExceptionsGeneralType {

    //Excepcion general
    public static final String EXCEPTION = ExceptionHandlerServiceFunctional.getExceptionType(Exception.class);

    //Excepcion de las validaciones de clean, generalmente en el domain
    public static final String EXCEPTION_VALIDATION = ExceptionHandlerServiceFunctional.getExceptionType(ValidationException.class);

    //Excepcion de las validaciones del persistence como tal
    public static final String EXCEPTION_VALIDATION_X = ExceptionHandlerServiceFunctional.getExceptionType(ConstraintViolationException.class);

    //violacion de integridad, generalmente cuando se quiere crear un objeto que ya existe otro con igual unique
    public static final String EXCEPTION_JPA_INTEGRITY = ExceptionHandlerServiceFunctional.getExceptionType(SQLIntegrityConstraintViolationException.class);
    public static final String MSG_JPA_INTEGRITY = "msg.default_config.error.jpa_integrity";

    //cuando se va a eliminar o editar un entity que ya no existe
    public static final String EXCEPTION_JPA_NON_EXISTING_ENTITY = ExceptionHandlerServiceFunctional.getExceptionType(NonExistingEntityException.class);
    public static final String MSG_JPA_NON_EXISTING_ENTITY = "msg.default_config.error.jpa_non_existing_entity";

}
