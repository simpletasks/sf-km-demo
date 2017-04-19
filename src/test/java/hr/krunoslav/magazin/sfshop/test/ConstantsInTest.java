package hr.krunoslav.magazin.sfshop.test;

public interface ConstantsInTest {

	public static final String XML_TAG_ITEM = "item";
	// for concatenating path with filenames
	public static final String URI_PATH_DELIMITER = "/";
	// xml files
	public static final String FILENAME_DATA_HAPPY_XML = "data_happy.xml";
	public static final String FILENAME_DATA_NO_IGNORED_ITEM_SUBTAGS_XML = "data_no_ignored_item_subtags.xml";
	public static final String FILENAME_DATA_NO_TEMPLATE_XML = "data_no_template.xml";
	public static final String FILENAME_DATA_MISSING_VALUE2_TAG_XML = "missing-value2-tag.xml";

	// xsd files
	public static final String FILENAME_DATA_FULL_XSD = "data_full.xsd";
	// directory paths
	public static final String PATH_TO_XML_FILE_DIR = String.join(URI_PATH_DELIMITER, System.getProperty("user.dir"),
			"target", "test-classes", "XmlTestExamples");
	public static final String PATH_TO_XSD_FILE_DIR = String.join(URI_PATH_DELIMITER, System.getProperty("user.dir"),
			"target", "test-classes", "XSD");
}
