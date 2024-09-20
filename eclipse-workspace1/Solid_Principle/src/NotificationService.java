
public class NotificationService {

	private INotifier notifier;// This depends on the interface, not a specific class

	public NotificationService(INotifier notifier) { // Constructor injection
		this.notifier = notifier;
	}
	
	public void sendnotification(String message) {
		notifier.Notify(message);// Uses the notifier to send a message
	}
}
