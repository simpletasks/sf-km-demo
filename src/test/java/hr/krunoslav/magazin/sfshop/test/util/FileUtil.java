package hr.krunoslav.magazin.sfshop.test.util;

import java.io.File;

import hr.krunoslav.magazin.sfshop.services.file.FileNameValidator;

public class FileUtil {

	private String uriPathDelimeter;
	private String pathToXmlFileDir;
	private String pathToXsdFileDir;

	public FileUtil(String uriPathDelimeter, String pathToXmlFileDir, String pathToXsdFileDir) {
		super();
		this.uriPathDelimeter = uriPathDelimeter;
		this.pathToXmlFileDir = pathToXmlFileDir;
		this.pathToXsdFileDir = pathToXsdFileDir;
	}

	public File checkIfXmlDataFileExist(String xmlFileName) {
		String absolutePath = String.join(uriPathDelimeter, pathToXmlFileDir, xmlFileName);
		File xmlFile = FileNameValidator.checkIfFileExist(absolutePath);
		return xmlFile;
	}

	public File checkIfXsdSchemaFileExist(String xsdFileName) {
		String absolutePathToXsd = String.join(uriPathDelimeter, pathToXsdFileDir, xsdFileName);
		File xsdFile = FileNameValidator.checkIfFileExist(absolutePathToXsd);
		return xsdFile;
	}
}
