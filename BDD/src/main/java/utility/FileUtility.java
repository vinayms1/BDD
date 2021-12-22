package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public static String getValueFromPropertyFile(String key) throws Throwable {
		FileInputStream file= new FileInputStream(FilePath.FILE_PATH);
		Properties p= new Properties();
		p.load(file);
		return p.getProperty(key);
	}

}
