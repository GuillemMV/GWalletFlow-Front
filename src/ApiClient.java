import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ApiClient {
	
	private final static String APIURL = "http://localhost:8080";
	private final static String GET = "GET";
	

	public static String getTotal() {

		String totalUrl = APIURL+"/expenses/total";
		try {
			
			URL url = new URL(totalUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(GET);
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

		return "0.0";
	}

	
	public static List<String> getCategories(){
		String getCategoriesUrl = APIURL+"/categories/names";
		String jsonresult = "";
		List<String> parsedResult = new ArrayList<String>();
		
		try {
			URL url = new URL(getCategoriesUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			
			while ((line = reader.readLine()) != null) {
				jsonresult += line.toString();
			}
			
			 parsedResult = JsonParser.parseJsonArray(jsonresult);
			
			reader.close();
			connection.disconnect();
			return JsonParser.parseJsonArray(jsonresult);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException pe) {
			pe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return parsedResult;
	}
	
	public static void insertNewExpense(BigDecimal amount, Date date, int category, String description) {
		System.out.println(amount);
		System.out.println(date);
		System.out.println(category);
		System.out.println(description);
	}

}
