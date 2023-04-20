package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Prperty_Utility {
	public String getKeyValue(String key) throws IOException {
      FileInputStream f=new FileInputStream("./src/test/resources/PropertyFileData.properties");
		
		Properties ps=new Properties();
		ps.load(f);
		String value = ps.getProperty(key);
		return value;
	}

}
