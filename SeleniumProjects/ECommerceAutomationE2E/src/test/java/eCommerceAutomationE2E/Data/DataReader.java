package eCommerceAutomationE2E.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	
	public List<HashMap<String, String>> getData() throws IOException {
		
		//Convert JSON To String
		String fileDate = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
				"\\src\\test\\java\\eCommerceAutomationE2E\\Data\\PurchaseOrder.json"), StandardCharsets.UTF_8);
		
		//Convert JSON to HashMap - Jackson DataBind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(fileDate, new TypeReference<List<HashMap<String,String>>>() {
		});
		return data;
		
	
		
	}
}
