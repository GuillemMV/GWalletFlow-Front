import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ApiClient {

	public static String getTotal() {

		String apiUrl = "http://localhost:8080/expenses/total";
		try {

			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;
			
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			
			reader.close();
			connection.disconnect();
			return response.toString();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException pe) {
			pe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return "NULL";
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
