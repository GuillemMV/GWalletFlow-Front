import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class sample {
	public static void main(String[] args) {
		addNew("10", "10-12-2023", "1", "Example");
	}
	
	public static void addNew(String amount, String date, String category, String description) {

		String apiUrl = "http://localhost:8080/expenses";
		try {

			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);

			String parametersString = "amount=" + amount + "&date=" + date + "&category=" + category + "&description="
					+ description;

			try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
				wr.writeBytes(parametersString);
				wr.flush();
			}
			
			connection.disconnect();

		} catch (MalformedURLException e) { 
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
