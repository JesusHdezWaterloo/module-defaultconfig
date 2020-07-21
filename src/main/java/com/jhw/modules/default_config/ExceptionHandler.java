package com.jhw.modules.default_config;
/*
import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationsGeneralType;
import com.jhw.meca.application.services.NotificationServiceImplementation;
import com.jhw.utils.jackson.JACKSON;
import java.io.File;
import javax.persistence.RollbackException;
import com.jhw.meca.jpa.exceptions.IllegalOrphanException;
import com.jhw.meca.jpa.exceptions.NonexistentEntityException;
import com.jhw.meca.facade.swing.clases.ValidationException;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 *
public class ExceptionHandler {

    public static final String URL_EXC = "bugs" + File.separator + "exception" + File.separator;

    private ExceptionHandler() {
    }

    public static void handleException(Exception e) {
        if (e instanceof NonexistentEntityException) {
            handleNonexistentEntityException((NonexistentEntityException) e);
        } else if (e instanceof IllegalOrphanException) {
            handleIllegalOrphanException((IllegalOrphanException) e);
        } else if (e instanceof ValidationException) {
            handleModelInputErrorException((ValidationException) e);
        } else if (e instanceof javax.persistence.RollbackException) {
            handleRollbackException((RollbackException) e);
        } else {
            saveException(e);
            Notification.showConfirmDialog(NotificationsGeneralType.CONFIRM_ERROR, e.getMessage());
        }
    }

    public static void saveException(Exception e) {
        try {
            File f = new File(URL_EXC);
            f.mkdirs();
            JACKSON.write(new File(URL_EXC + System.currentTimeMillis() + ".bug"), e);
        } catch (Exception ex) {
        }
    }

    private static void handleModelInputErrorException(ValidationException e) {
        Notification.showNotification(NotificationsGeneralType.NOTIFICATION_ERROR, e.getMessage());
    }

    private static void handleIllegalOrphanException(IllegalOrphanException e) {
        Notification.showNotification(NotificationsGeneralType.NOTIFICATION_ERROR, "No se puede realizar la operacion debido a que afecta a otras entidades.");
    }

    private static void handleRollbackException(RollbackException e) {
        Notification.showNotification(NotificationsGeneralType.NOTIFICATION_ERROR, "El elemento que se intenta crear ya existe.");
    }

    private static void handleNonexistentEntityException(NonexistentEntityException e) {
        Notification.showNotification(NotificationsGeneralType.NOTIFICATION_ERROR, "La entidad ya no existe.");
    }

}
*/