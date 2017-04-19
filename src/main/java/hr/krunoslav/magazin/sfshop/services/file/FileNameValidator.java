package hr.krunoslav.magazin.sfshop.services.file;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileNameValidator {

	public static final String PATH_DELIMETER = "/";
	private static final Logger LOG = LogManager.getLogger(FileNameValidator.class);

	/**
	 * 
	 * @param fileName
	 *            relative or absolute path to file
	 * @return instance of {@link File} if path is valid and file exist or
	 *         <b>NULL</b> if path is not valid or file do not exist
	 */
	public static File checkIfFileExist(String fileName) {

		File file = null;

		if (fileName.startsWith(PATH_DELIMETER)) {
			file = new File(fileName);
			if (!file.exists()) {
				LOG.warn("Absolute path to xml file not valid or file do not exist.");
				return null;
			}
		} else {
			String currentDir = System.getProperty("user.dir");
			String absolutePathToFile = String.join(PATH_DELIMETER, currentDir, fileName);
			file = new File(absolutePathToFile);
			if (!file.exists()) {
				LOG.warn("Relative path to xml file not valid or file do not exist.");
				return null;
			}
		}
		return file;

	}
}
