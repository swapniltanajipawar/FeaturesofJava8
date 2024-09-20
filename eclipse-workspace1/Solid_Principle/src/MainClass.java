
public class MainClass {

	public static void main(String[] args) {

		INotifier notifier = new EmailNotifier(); // Create an EmailNotifier
		NotificationService notificationService = new NotificationService(notifier); // Pass it to the service
		notificationService.sendnotification("Hello, world!"); // Send a notification

	}

}

/*
 * DIP: The NotificationService does not depend on the concrete class
 * EmailNotifier. It depends on the INotifier interface, allowing for
 * flexibility.
 * Decoupled: NotificationService depends on the INotifier interface.
 * Flexible: You can easily add new notifiers (like SMS) later without changing NotificationService.
 * 
 * 
 * 
 * 
 * Without DIP
csharp
Copy code
public class EmailNotifier {
    public void Notify(string message) {
        Console.WriteLine("Email: " + message);
    }
}

public class NotificationService {
    private EmailNotifier _emailNotifier = new EmailNotifier();

    public void SendNotification(string message) {
        _emailNotifier.Notify(message);
    }
}
Problems:
Tight Coupling: NotificationService directly depends on EmailNotifier.
 */