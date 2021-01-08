/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.module.util.default_config;

import com.root101.clean.core.app.services.NotificationServiceFunctional;
import com.root101.swing.material.standards.MaterialIcons;
import com.root101.clean.core.app.services.NotificationsGeneralType;
import com.root101.clean.core.app.services.NotificationHandler;
import com.root101.clean.core.domain.services.ResourceHandler;
import com.jhw.module.util.personalization.core.domain.Personalization;
import com.jhw.module.util.personalization.services.PersonalizationHandler;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialImages;
import com.root101.swing.notification.NotificationBuilder;
import com.root101.swing.notification.NotificationFactory;
import com.root101.swing.notification.NotificationLocation;
import com.root101.utils.interfaces.Formateable;
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
        NotificationHandler.registerNotificationService(notif);
        return notif;
    }

    public GeneralNotificationService() {
        addAll();
    }

    @Override
    protected void addNotifications() {
        super.addNotification(NotificationsGeneralType.NOTIFICATION_ERROR, (Object t) -> {
            NotificationFactory.buildNotificationTOAST(NotificationBuilder.builder().
                    delaySeconds(PersonalizationHandler.getInt(Personalization.KEY_INT_NOTIFICATION_DURATION))
                    .text(objectToString(t))
                    .icon(MaterialIcons.BLOCK)
                    .color(PersonalizationHandler.getColor(Personalization.KEY_COLOR_ERROR)));

        });
        super.addNotification(NotificationsGeneralType.NOTIFICATION_SUCCESS, (Object t) -> {
            NotificationFactory.buildNotificationTOAST(NotificationBuilder.builder().
                    delaySeconds(PersonalizationHandler.getInt(Personalization.KEY_INT_NOTIFICATION_DURATION))
                    .text(objectToString(t))
                    .icon(MaterialIcons.CHECK)
                    .color(PersonalizationHandler.getColor(Personalization.KEY_COLOR_DONE)));

        });
        super.addNotification(NotificationsGeneralType.NOTIFICATION_CREATE, (Object t) -> {
            NotificationFactory.buildNotificationTOAST(NotificationBuilder.builder().
                    delaySeconds(PersonalizationHandler.getInt(Personalization.KEY_INT_NOTIFICATION_DURATION))
                    .text("Elemento " + objectToString(t) + "CREADO exitosamente")
                    .icon(MaterialIcons.ADD)
                    .color(PersonalizationHandler.getColor(Personalization.KEY_COLOR_DONE)));
        });
        super.addNotification(NotificationsGeneralType.NOTIFICATION_DELETE, (Object t) -> {
            NotificationFactory.buildNotificationTOAST(NotificationBuilder.builder().
                    delaySeconds(PersonalizationHandler.getInt(Personalization.KEY_INT_NOTIFICATION_DURATION))
                    .text("Elemento " + objectToString(t) + "ELIMINADO exitosamente")
                    .icon(MaterialIcons.DELETE_FOREVER)
                    .color(PersonalizationHandler.getColor(Personalization.KEY_COLOR_ERROR)));
        });
        super.addNotification(NotificationsGeneralType.NOTIFICATION_EDIT, (Object t) -> {
            NotificationFactory.buildNotificationTOAST(NotificationBuilder.builder().
                    delaySeconds(PersonalizationHandler.getInt(Personalization.KEY_INT_NOTIFICATION_DURATION))
                    .text("Elemento " + objectToString(t) + "EDITADO exitosamente")
                    .icon(MaterialIcons.EDIT)
                    .color(PersonalizationHandler.getColor(Personalization.KEY_COLOR_INFO)));
        });
        super.addNotification(NotificationsGeneralType.NOTIFICATION_INFO, (Object t) -> {
            NotificationFactory.buildNotificationTOAST(NotificationBuilder.builder().
                    delaySeconds(PersonalizationHandler.getInt(Personalization.KEY_INT_NOTIFICATION_DURATION))
                    .text(objectToString(t))
                    .icon(MaterialIcons.INFO_OUTLINE)
                    .color(PersonalizationHandler.getColor(Personalization.KEY_COLOR_INFO)));
        });
        super.addNotification(NotificationsGeneralType.NOTIFICATION_WARNING, (Object t) -> {
            NotificationFactory.buildNotificationTOAST(NotificationBuilder.builder().
                    delaySeconds(PersonalizationHandler.getInt(Personalization.KEY_INT_NOTIFICATION_DURATION))
                    .text(objectToString(t))
                    .icon(MaterialIcons.WARNING)
                    .color(PersonalizationHandler.getColor(Personalization.KEY_COLOR_WARNING)));
        });
        super.addNotification(NotificationsGeneralType.NOTIFICATION_SIMPLE_TEXT, (Object t) -> {
            NotificationFactory.buildTextTOAST(NotificationBuilder.builder().
                    delaySeconds(PersonalizationHandler.getInt(Personalization.KEY_INT_NOTIFICATION_DURATION))
                    .location(NotificationLocation.DOWN_CENTER)
                    .text(objectToString(t))
                    .color(MaterialColors.GREY_900));

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
                -> JOptionPane.showConfirmDialog(null, "Seguro desea cancelar ?" + objectToString(t, true),
                        "Cancel",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.ERROR_MESSAGE) == 0);
        super.addConfirmDialog(NotificationsGeneralType.CONFIRM_CONTINUE, (Object t)
                -> JOptionPane.showConfirmDialog(null, "Seguro desea continuar ?" + objectToString(t, true),
                        "Terminar",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == 0);
        super.addConfirmDialog(NotificationsGeneralType.CONFIRM_ERROR, (Object t)
                -> JOptionPane.showConfirmDialog(null, objectToString(t, false),
                        "Error",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.ERROR_MESSAGE) == 0);
        super.addConfirmDialog(NotificationsGeneralType.CONFIRM_WARNING, (Object t)
                -> JOptionPane.showConfirmDialog(null, objectToString(t, false),
                        "Advertencia",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE) == 0);
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
            toString = (String) obj;
            if (ln) {
                toString = "\n" + toString;
            }
        } else if (obj instanceof Formateable) {
            toString = ((Formateable) obj).format();
            if (ln) {
                toString = "\n" + toString;
            }
        } else {
            toString = obj.toString().trim();
            toString = toString.isEmpty() ? "" : "\'" + toString.toUpperCase() + "\'";
        }
        if (ln) {
            toString += "\n";
        }
        return toString;
    }
}
