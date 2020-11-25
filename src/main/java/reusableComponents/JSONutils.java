package reusableComponents;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import org.testng.annotations.DataProvider;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class JSONutils {
	private String testCase;
	private String location;
	private String fromdate;
	private String todate;
	private String adults;
	private String children;

	public String getTestCase() {
		return testCase;
	}

	public String getLocation() {
		return location;
	}

	public String getFromdate() {
		return fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public String getAdults() {
		return adults;
	}

	public String getChildren() {
		return children;
	}

	@Override
	public String toString() {
		return "TestData{" + "testCase='" + testCase + '\'' + ", location='" + location + '\'' + ", fromdate='"
				+ fromdate + '\'' + ", todate=" + todate + '\'' + ", adults='" + adults + '\'' + ", children='"
				+ children + '}';
	}

	@SuppressWarnings("deprecation")
	@DataProvider
	public Object[][] getData() throws FileNotFoundException {
		FileReader jsonfile = new FileReader("./resource/testData.json");
		JsonElement jsonData = new JsonParser().parse(jsonfile);
		JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
		List<JSONutils> testData = new Gson().fromJson(dataSet, new TypeToken<List<JSONutils>>() {
		}.getType());
		Object[][] returnValue = new Object[testData.size()][1];
		int index = 0;
		for (Object[] each : returnValue) {
			each[0] = testData.get(index++);
		}
		return returnValue;
	}
}
