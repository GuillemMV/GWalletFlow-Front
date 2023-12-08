import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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

		return "0";
	}

	
	public static List<String> getCategories() {
		String apiUrl = "http://localhost:8080/categories/names";
		List<String> categories = new ArrayList<String>();
		
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			
			while ((line = reader.readLine()) != null) {
				categories.add(line.toString());
			}
			
			reader.close();
			connection.disconnect();
			return categories;

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException pe) {
			pe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return categories;
	}

}
