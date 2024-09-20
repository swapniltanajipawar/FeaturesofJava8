import java.io.Console;

public class EmailNotifier implements INotifier {

	@Override
	public void Notify(String message) {
		System.out.println("Email:" + message);
	}

}
