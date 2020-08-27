/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.modules.default_config;

import com.clean.core.app.services.NotificationServiceFunctional;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.notification.toast.types.notification.DialogNotificationToastGeneral;
import com.clean.core.app.services.NotificationsGeneralType;
import com.clean.core.app.services.Notification;
import com.clean.core.domain.services.Resource;
import com.jhw.personalization.core.domain.Personalization;
import com.jhw.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.standards.MaterialImages;
import com.jhw.utils.interfaces.Formateable;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class GeneralNotificationService extends NotificationServiceFunctional {

    public static final String DELETE = "DELETE";

    public static GeneralNotificationService init() {
        GeneralNotificationService notif = new GeneralNotificationService();
        Notification.registerNotificationService(notif);
        return notif;
    }

    public GeneralNotificationService() {
        addAll();
    }

    @Override
    protected void addNotifications() {
        super.addNotification(NotificationsGeneralType.NOTIFICATION_ERROR, (Object t) -> {
            DialogNotificationToastGeneral.from(
                    PersonalizationHandler.getInt(Personalization.KEY_INT_NOTIFICATION_DURATION),
                    objectToString(t),
                    MaterialIcons.BLOCK,
                    PersonalizationHandler.getColor(Personalization.KEY_COLOR_ERROR));
        });
        super.addNotification(NotificationsGeneralType.NOTIFICATION_SUCCESS, (Object t) -> {
            DialogNotificationToastGeneral.from(
                    PersonalizationHandler.getInt(Personalization.KEY_INT_NOTIFICATION_DURATION),
                    objectToString(t),
                    MaterialIcons.CHECK,
                    PersonalizationHandler.getColor(Personalization.KEY_COLOR_DONE));
        });
        super.addNotification(NotificationsGeneralType.NOTIFICATION_CREATE, (Object t) -> {
            DialogNotificationToastGeneral.from(
                    PersonalizationHandler.getInt(Personalization.KEY_INT_NOTIFICATION_DURATION),
                    "Elemento " + objectToString(t) + "CREADO exitosamente",
                    MaterialIcons.ADD,
                    PersonalizationHandler.getColor(Personalization.KEY_COLOR_DONE));
        });
        super.addNotification(NotificationsGeneralType.NOTIFICATION_DELETE, (Object t) -> {
            DialogNotificationToastGeneral.from(
                    PersonalizationHandler.getInt(Personalization.KEY_INT_NOTIFICATION_DURATION),
                    "Elemento " + objectToString(t) + "ELIMINADO exitosamente",
                    MaterialIcons.DELETE_FOREVER,
                    PersonalizationHandler.getColor(Personalization.KEY_COLOR_ERROR));
        });
        super.addNotification(NotificationsGeneralType.NOTIFICATION_EDIT, (Object t) -> {
            DialogNotificationToastGeneral.from(
                    PersonalizationHandler.getInt(Personalization.KEY_INT_NOTIFICATION_DURATION),
                    "Elemento " + objectToString(t) + "EDITADO exitosamente",
                    MaterialIcons.EDIT,
                    PersonalizationHandler.getColor(Personalization.KEY_COLOR_INFO));
        });
        super.addNotification(NotificationsGeneralType.NOTIFICATION_INFO, (Object t) -> {
            DialogNotificationToastGeneral.from(
                    PersonalizationHandler.getInt(Personalization.KEY_INT_NOTIFICATION_DURATION),
                    objectToString(t),
                    MaterialIcons.INFO_OUTLINE,
                    PersonalizationHandler.getColor(Personalization.KEY_COLOR_INFO));
        });
        super.addNotification(NotificationsGeneralType.NOTIFICATION_WARNING, (Object t) -> {
            DialogNotificationToastGeneral.from(
                    PersonalizationHandler.getInt(Personalization.KEY_INT_NOTIFICATION_DURATION),
                    objectToString(t),
                    MaterialIcons.WARNING,
                    PersonalizationHandler.getColor(Personalization.KEY_COLOR_WARNING));
        });
        super.addNotification(NotificationsGeneralType.NOTIFICATION_LOGIN, (Object t) -> {
            DialogNotificationToastGeneral.from(
                    PersonalizationHandler.getInt(Personalization.KEY_INT_NOTIFICATION_DURATION),
                    Resource.getString("msg.default_config.login.welcome") + "\n" + objectToString(t),
                    MaterialIcons.PERSON,
                    PersonalizationHandler.getColor(Personalization.KEY_COLOR_INFO));
        });
    }

    @Override
    protected void addConfirmDialog() {
        super.addConfirmDialog(NotificationsGeneralType.CONFIRM_CREATE, (Object t)
                -> JOptionPane.showConfirmDialog(null,
                        "Seguro desea crear el elemento " + objectToString(t, false) + " ?",
                        "Crear",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(MaterialImages.CREATE)) == 0);
        super.addConfirmDialog(NotificationsGeneralType.CONFIRM_EDIT, (Object t)
                -> JOptionPane.showConfirmDialog(null,
                        "Seguro desea editar el elemento " + objectToString(t, false) + " ?",
                        "Editar",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(MaterialImages.EDIT)) == 0);
        super.addConfirmDialog(NotificationsGeneralType.CONFIRM_DELETE, (Object t)
                -> showConfirmDialogDelete(t));
        super.addConfirmDialog(NotificationsGeneralType.CONFIRM_CANCEL, (Object t)
                -> JOptionPane.showConfirmDialog(null, "Seguro desea cancelar ?",
                        "Cancel",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.ERROR_MESSAGE) == 0);
        super.addConfirmDialog(NotificationsGeneralType.CONFIRM_CONTINUE, (Object t)
                -> JOptionPane.showConfirmDialog(null, "Seguro desea continuar ?",
                        "Terminar",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == 0);
        super.addConfirmDialog(NotificationsGeneralType.CONFIRM_ERROR, (Object t)
                -> JOptionPane.showConfirmDialog(null, objectToString(t, false),
                        "Error",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.ERROR_MESSAGE) == 0);
        super.addConfirmDialog(NotificationsGeneralType.CONFIRM_INFO, (Object t)
                -> JOptionPane.showConfirmDialog(null, objectToString(t, false),
                        "Información",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE) == 0);
        super.addConfirmDialog(NotificationsGeneralType.CONFIRM_GENERAL, (Object t)
                -> JOptionPane.showConfirmDialog(null,
                        objectToString(t, false),
                        "Confirmar",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon(MaterialImages.QUESTION)) == 0);
    }

    @Override
    protected void addInputDialog() {
        super.addInputDialog(NotificationsGeneralType.DIALOG_INPUT, (Object t) -> {
            return JOptionPane.showInputDialog(objectToString(t));
        });
    }

    private boolean showConfirmDialogDelete(Object obj) {
        String text = "Seguro desea eliminar " + objectToString(obj, false) + " ?";
        if (JOptionPane.showConfirmDialog(null, text, "Eliminar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, MaterialIcons.DELETE_FOREVER.deriveIcon(36f)) == 0) {
            if (PersonalizationHandler.getBoolean(Personalization.KEY_USE_DOUBLE_DELETE_CHECK)) {
                String conf = JOptionPane.showInputDialog(null, "Para confirmar introduzca la palabra: " + DELETE);
                if (conf != null && conf.toUpperCase().matches(DELETE)) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    private String objectToString(Object obj) {
        return objectToString(obj, true);
    }

    private String objectToString(Object obj, boolean ln) {
        String toString;
        if (obj == null) {
            toString = "";
        } else if (obj instanceof String) {
            return (String) obj;
        } else if (obj instanceof Formateable) {
            toString = ((Formateable) obj).format();
        } else {
            toString = obj.toString().trim();
        }
        String finall = toString.isEmpty() ? "" : "\'" + toString.toUpperCase() + "\'";
        if (ln) {
            finall += "\n";
        }
        return finall;
    }
}
