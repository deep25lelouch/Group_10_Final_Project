/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.notification;
//Rijurik_Saha_002525961
import model.userAccount.UserAccount;
import model.workQueue.WorkRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author RIO
 */
public class NotificationService {
//Rijurik_Saha_002525961
    private static List<Notification> allNotifications = new ArrayList<>();

    public static class Notification {

        private String id;
        private String message;
        private UserAccount recipient;
        private Date timestamp;
        private boolean isRead;
        private NotificationType type;

        public Notification(String message, UserAccount recipient, NotificationType type) {
            this.id = "NOTIF-" + System.currentTimeMillis();
            this.message = message;
            this.recipient = recipient;
            this.timestamp = new Date();
            this.isRead = false;
            this.type = type;
        }

        // Getters and Setters
        public String getId() {
            return id;
        }

        public String getMessage() {
            return message;
        }

        public UserAccount getRecipient() {
            return recipient;
        }

        public Date getTimestamp() {
            return timestamp;
        }

        public boolean isRead() {
            return isRead;
        }

        public void markAsRead() {
            this.isRead = true;
        }

        public NotificationType getType() {
            return type;
        }
    }

    public enum NotificationType {
        NEW_ASSIGNMENT("New Assignment"),
        STATUS_UPDATE("Status Update"),
        ESCALATION("Escalation"),
        COMPLETION("Completion"),
        EMERGENCY("Emergency"),
        SYSTEM("System");

        private String value;

        NotificationType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static void sendNotification(UserAccount recipient, String message, NotificationType type) {
        if (recipient == null) {
            return;
        }

        Notification notification = new Notification(message, recipient, type);
        allNotifications.add(notification);
        System.out.println("Notification sent to " + recipient.getUsername() + ": " + message);
    }

    public static void notifyNewAssignment(UserAccount worker, WorkRequest request) {
        String message = "New work request assigned: " + request.getRequestId()
                + " - " + request.getIssueType().getValue();
        sendNotification(worker, message, NotificationType.NEW_ASSIGNMENT);
    }

    public static void notifyStatusUpdate(UserAccount citizen, WorkRequest request) {
        String message = "Your request " + request.getRequestId()
                + " status updated to: " + request.getStatus().getValue();
        sendNotification(citizen, message, NotificationType.STATUS_UPDATE);
    }

    public static void notifyEscalation(UserAccount supervisor, WorkRequest request) {
        String message = "Request " + request.getRequestId()
                + " has been escalated for your attention";
        sendNotification(supervisor, message, NotificationType.ESCALATION);
    }

    public static void notifyCompletion(UserAccount citizen, WorkRequest request) {
        String message = "Your request " + request.getRequestId()
                + " has been completed successfully";
        sendNotification(citizen, message, NotificationType.COMPLETION);
    }

    public static void notifyEmergency(List<UserAccount> coordinators, WorkRequest request) {
        String message = "EMERGENCY: " + request.getIssueType().getValue()
                + " at " + request.getLocation().toString();
        for (UserAccount coordinator : coordinators) {
            sendNotification(coordinator, message, NotificationType.EMERGENCY);
        }
    }

    public static List<Notification> getUserNotifications(UserAccount user) {
        List<Notification> userNotifications = new ArrayList<>();
        for (Notification notif : allNotifications) {
            if (notif.getRecipient().equals(user)) {
                userNotifications.add(notif);
            }
        }
        return userNotifications;
    }

    public static List<Notification> getUnreadNotifications(UserAccount user) {
        List<Notification> unread = new ArrayList<>();
        for (Notification notif : getUserNotifications(user)) {
            if (!notif.isRead()) {
                unread.add(notif);
            }
        }
        return unread;
    }

    public static int getUnreadCount(UserAccount user) {
        return getUnreadNotifications(user).size();
    }
}
