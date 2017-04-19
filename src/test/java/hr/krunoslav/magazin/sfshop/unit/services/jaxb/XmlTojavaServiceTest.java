package hr.krunoslav.magazin.sfshop.unit.services.jaxb;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static org.junit.Assert.*;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import hr.krunoslav.magazin.sfshop.jaxb.elements.Inventory;
import hr.krunoslav.magazin.sfshop.jaxb.elements.Item;
import hr.krunoslav.magazin.sfshop.services.file.FileNameValidator;
import hr.krunoslav.magazin.sfshop.services.jaxb.XmlTojavaService;

/**
 * Tests mapping between xml tags and java objects. Tests possible conversions.
 * 
 * @author Krunoslav Magazin
 *
 */
public class XmlTojavaServiceTest {

	private static final String XML_TAG_ITEM = "item";
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

	/**
	 * Basic case. Happy path.
	 */
	@Test
	public void testHappyConvertToJava() {
		String xmlFileName = FILENAME_DATA_HAPPY_XML;
		String xsdFileName = FILENAME_DATA_FULL_XSD;
		// prepare
		File xmlFile = checkIfXmlDataFileExist(xmlFileName);
		File xsdFile = checkIfXsdSchemaFileExist(xsdFileName);
		int itemTagCount = getTagCount(XML_TAG_ITEM, xmlFile);

		// Method in test
		Inventory inventory;
		try {
			inventory = XmlTojavaService.convertToJava(xmlFile, xsdFile);
		} catch (SAXException e) {
			throw new RuntimeException();
		}

		assertNotNull("Invertory can not be NULL !", inventory);
		assertNotNull("Template can not be null !", inventory.getTemplate());
		assertNotNull("Items can not be NULL! ", inventory.getItems());
		assertEquals("Items size not correct !", itemTagCount, inventory.getItems().getItem().size());

	}

	/**
	 * Case with removed template tag from xml file
	 */
	@Test
	public void testConvertToJavaNoTemplate() {
		String xmlFileName = FILENAME_DATA_NO_TEMPLATE_XML;
		String xsdFileName = FILENAME_DATA_FULL_XSD;
		// prepare
		File xmlFile = checkIfXmlDataFileExist(xmlFileName);
		File xsdFile = checkIfXsdSchemaFileExist(xsdFileName);
		int itemTagCount = getTagCount(XML_TAG_ITEM, xmlFile);

		// Method in test
		Inventory inventory = convertToJava(xmlFile, xsdFile);

		assertNotNull("Invertory can not be NULL !", inventory);
		assertNull("Template must be NULL !", inventory.getTemplate());
		assertNotNull("Items can not be NULL! ", inventory.getItems());
		assertEquals("Items size not correct !", itemTagCount, inventory.getItems().getItem().size());
	}

	/**
	 * Case with removed ignored tags in item tag from xml file
	 */
	@Test
	public void testConvertToJavaNoIgnoredItemSubtags() {
		String xmlFileName = FILENAME_DATA_NO_IGNORED_ITEM_SUBTAGS_XML;
		String xsdFileName = FILENAME_DATA_FULL_XSD;
		// prepare
		File xmlFile = checkIfXmlDataFileExist(xmlFileName);
		File xsdFile = checkIfXsdSchemaFileExist(xsdFileName);
		int itemTagCount = getTagCount(XML_TAG_ITEM, xmlFile);

		// Method in test
		Inventory inventory = convertToJava(xmlFile, xsdFile);

		assertNotNull("Invertory can not be NULL !", inventory);
		assertNull("Template must be NULL !", inventory.getTemplate());
		assertNotNull("Items can not be NULL! ", inventory.getItems());
		List<Item> itemList = inventory.getItems().getItem();
		assertEquals("Items size not correct !", itemTagCount, itemList.size());
		for (int i = 0; i < itemList.size(); i++) {
			Integer uid = itemList.get(i).getUid();
			assertNotNull("Atribute UID is NULL!", uid);
			assertNull("Expected NULL for value5 on item with uid =" + uid, itemList.get(i).getValue5());
			assertNull("Expected NULL for value6 on item with uid =" + uid, itemList.get(i).getValue6());
			assertNull("Expected NULL for value7 on item with uid =" + uid, itemList.get(i).getValue7());
			assertNull("Expected NULL for value8 on item with uid =" + uid, itemList.get(i).getValue8());
			assertNull("Expected NULL for value9 on item with uid =" + uid, itemList.get(i).getValue9());
			assertNotNull("Value0 is NULL on item with uid =" + uid, itemList.get(i).getValue0());
			assertNotNull("Value2 is NULL on item with uid =" + uid, itemList.get(i).getValue2());
			assertNotNull("Value2 is NULL on item with uid =" + uid, itemList.get(i).getValue2());
			assertNotNull("Value in Value2 is NULL on item with uid =" + uid, itemList.get(i).getValue2());

		}
	}

	/**
	 * Test when missing <b>value2</b> tag. Inventory should be null.
	 */
	@Test
	public void testConvertToJavaMissingValue2Tag() {
		String xmlFileName = FILENAME_DATA_MISSING_VALUE2_TAG_XML;
		String xsdFileName = FILENAME_DATA_FULL_XSD;
		// prepare
		File xmlFile = checkIfXmlDataFileExist(xmlFileName);
		File xsdFile = checkIfXsdSchemaFileExist(xsdFileName);
		int itemTagCount = getTagCount(XML_TAG_ITEM, xmlFile);

		// Method in test
		Inventory inventory = convertToJava(xmlFile, xsdFile);

		assertNull("Invertory must be NULL !", inventory);
	}

	private Inventory convertToJava(File xmlFile, File xsdFile) {
		Inventory inventory = null;
		try {
			inventory = XmlTojavaService.convertToJava(xmlFile, xsdFile);
		} catch (SAXException e) {
			throw new RuntimeException("Schema problem!");
		}
		return inventory;
	}

	/**
	 * Counts tag occurrences in xml file. Xml file must be well formed or
	 * exception is thrown.
	 * 
	 * @param tagName
	 * @param xmlFile
	 * @return count of tagName occurrences
	 */
	private int getTagCount(String tagName, File xmlFile) {
		DocumentBuilderFactory docBuildFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = docBuildFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		}
		Document doc = null;
		try {
			doc = docBuilder.parse(xmlFile);
		} catch (SAXException | IOException e) {
			throw new RuntimeException("Xml must be well formed !", e);
		}
		doc.getDocumentElement().normalize();

		return doc.getElementsByTagName(tagName).getLength();
	}

	private File checkIfXmlDataFileExist(String xmlFileName) {
		String absolutePath = String.join(URI_PATH_DELIMITER, PATH_TO_XML_FILE_DIR, xmlFileName);
		File xmlFile = FileNameValidator.checkIfFileExist(absolutePath);
		return xmlFile;
	}

	private File checkIfXsdSchemaFileExist(String xsdFileName) {
		String absolutePathToXsd = String.join(URI_PATH_DELIMITER, PATH_TO_XSD_FILE_DIR, xsdFileName);
		File xsdFile = FileNameValidator.checkIfFileExist(absolutePathToXsd);
		return xsdFile;
	}
}
