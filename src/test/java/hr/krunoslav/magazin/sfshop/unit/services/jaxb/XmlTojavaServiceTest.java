package hr.krunoslav.magazin.sfshop.unit.services.jaxb;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

import hr.krunoslav.magazin.sfshop.jaxb.elements.Inventory;
import hr.krunoslav.magazin.sfshop.jaxb.elements.Item;
import hr.krunoslav.magazin.sfshop.test.ConstantsInTest;
import hr.krunoslav.magazin.sfshop.test.util.FileUtil;
import hr.krunoslav.magazin.sfshop.test.util.XmlToJavaUtil;

/**
 * Tests mapping between xml tags and java objects. Tests possible conversions.
 * 
 * @author Krunoslav Magazin
 *
 */
public class XmlTojavaServiceTest implements ConstantsInTest {

	private FileUtil fileUtil = new FileUtil(URI_PATH_DELIMITER, PATH_TO_XML_FILE_DIR, PATH_TO_XSD_FILE_DIR);

	/**
	 * Basic case. Happy path.
	 */
	@Test
	public void testHappyConvertToJava() {
		String xmlFileName = FILENAME_DATA_HAPPY_XML;
		String xsdFileName = FILENAME_DATA_FULL_XSD;
		// prepare
		File xmlFile = fileUtil.checkIfXmlDataFileExist(xmlFileName);
		File xsdFile = fileUtil.checkIfXsdSchemaFileExist(xsdFileName);
		int itemTagCount = XmlToJavaUtil.getTagCount(XML_TAG_ITEM, xmlFile);

		// Method in test
		Inventory inventory = XmlToJavaUtil.convertToJava(xmlFile, xsdFile);
		;

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
		File xmlFile = fileUtil.checkIfXmlDataFileExist(xmlFileName);
		File xsdFile = fileUtil.checkIfXsdSchemaFileExist(xsdFileName);
		int itemTagCount = XmlToJavaUtil.getTagCount(XML_TAG_ITEM, xmlFile);

		// Method in test
		Inventory inventory = XmlToJavaUtil.convertToJava(xmlFile, xsdFile);

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
		File xmlFile = fileUtil.checkIfXmlDataFileExist(xmlFileName);
		File xsdFile = fileUtil.checkIfXsdSchemaFileExist(xsdFileName);
		int itemTagCount = XmlToJavaUtil.getTagCount(XML_TAG_ITEM, xmlFile);

		// Method in test
		Inventory inventory = XmlToJavaUtil.convertToJava(xmlFile, xsdFile);

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
	 * Test when missing <b>value2</b> tag. Inventory should be null. For item
	 * uid=1
	 */
	@Test
	public void testConvertToJavaMissingValue2Tag() {
		String xmlFileName = FILENAME_DATA_MISSING_VALUE2_TAG_XML;
		String xsdFileName = FILENAME_DATA_FULL_XSD;
		// prepare
		File xmlFile = fileUtil.checkIfXmlDataFileExist(xmlFileName);
		File xsdFile = fileUtil.checkIfXsdSchemaFileExist(xsdFileName);

		// Method in test
		Inventory inventory = XmlToJavaUtil.convertToJava(xmlFile, xsdFile);

		assertNull("Invertory must be NULL !", inventory);

	}

}
