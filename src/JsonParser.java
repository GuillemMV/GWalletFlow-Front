import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
	
	public static List<String> parseJsonArray(String jsonString) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<String> nombres = objectMapper.readValue(jsonString, ArrayList.class);
		return nombres;
	}
}
