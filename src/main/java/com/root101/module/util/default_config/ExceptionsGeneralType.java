/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.util.default_config;

import com.root101.clean.core.app.services.ExceptionHandlerServiceFunctional;
import com.root101.clean.core.exceptions.ValidationException;
import java.net.MalformedURLException;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
