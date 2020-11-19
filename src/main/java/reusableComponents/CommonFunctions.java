package reusableComponents;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonFunctions {

	public static String convertDate(String strDate) throws ParseException {
		String date1;
		if (strDate.contains("/")) {
			date1 = strDate.replace("/", "-");
			return date1;
		} else {
			return date1 = strDate;
		}
	}

	public static String getCurrentTimeStamp() {
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		return timestamp;
	}
}
