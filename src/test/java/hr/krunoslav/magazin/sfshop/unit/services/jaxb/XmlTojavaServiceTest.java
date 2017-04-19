package hr.krunoslav.magazin.sfshop.unit.services.jaxb;

import java.io.File;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import static org.junit.Assert.*;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import hr.krunoslav.magazin.sfshop.jaxb.elements.Inventory;
import hr.krunoslav.magazin.sfshop.jaxb.elements.Item;
import hr.krunoslav.magazin.sfshop.services.file.FileNameValidator;
import hr.krunoslav.magazin.sfshop.services.jaxb.XmlTojavaService;

/**
 * Tests mapping between xml tags and java objects.
 * Tests possible conversions.
 * 
 * @author Krunoslav Magazin
 *
 */
public class XmlTojavaServiceTest {

	String pathToXmlFilesDir = String.join("/", System.getProperty("user.dir"), "target", "test-classes", "XmlTestExamples");
	// učitaj file
	// convertiraj file to java
	// usporedi s entitetima koje očekujem ??
	
	@Test
	public void testHappyConvertToJava(){
		String fileName = "data_happy.xml";
		String absolutePath = String.join("/", pathToXmlFilesDir, fileName);
		
		File file = FileNameValidator.checkIfFileExist(absolutePath);
		
		Inventory invertory = XmlTojavaService.convertToJava(file);
		
		String xsdFileName = "data_full.xsd";
		String pathToXsdFilesDir = String.join("/", System.getProperty("user.dir"), "target", "test-classes", "XSD");
		String absolutePathToXsd = String.join("/", pathToXsdFilesDir, xsdFileName);

		Inventory inventory = null;

		
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI );
		Schema schema = null;
		try {
			schema = sf.newSchema( new File(absolutePathToXsd) );
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Inventory.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			jaxbUnmarshaller.setSchema(schema);
			jaxbUnmarshaller.setEventHandler(new MyValidationEventHandler());
			inventory = (Inventory) jaxbUnmarshaller.unmarshal(file);

		//	LOG.trace(inventory);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof UnmarshalException){
				throw new RuntimeException("eee");
			}
		//	LOG.error("Xml can not be converted to java.", e);
		}
		
//		Validator validator = schema.newValidator();
//		validator.setErrorHandler( new MyErrorHandler() );
//		
		
		assertNotNull("Invertory can not be NULL !", invertory);
		assertNotNull("Template can not be null !", invertory.getTemplate());
		assertNotNull("Items can not be NULL! ", invertory.getItems());
		assertEquals("Items size not correct !", 3, invertory.getItems().getItem().size());

	}
	
	/**
	 * Removed template tag from xml file
	 */
	@Test
	public void testConvertToJavaNoTemplate(){
		String fileName = "data_no_template.xml";
		String absolutePath = String.join("/", pathToXmlFilesDir, fileName);
		
		File file = FileNameValidator.checkIfFileExist(absolutePath);
		
		Inventory invertory = XmlTojavaService.convertToJava(file);
		
		assertNotNull("Invertory can not be NULL !", invertory);
		assertNull("Template must be NULL !", invertory.getTemplate());
		assertNotNull("Items can not be NULL! ", invertory.getItems());
		assertEquals("Items size not correct !", 3, invertory.getItems().getItem().size());
	}
	
	/**
	 * Removed ignored tags in item tag from xml file
	 */
	@Test
	public void testConvertToJavaNoIgnoredItemSubtags(){
		String fileName = "data_no_ignored_item_subtags.xml";
		String absolutePath = String.join("/", pathToXmlFilesDir, fileName);
		
		File file = FileNameValidator.checkIfFileExist(absolutePath);
		
		Inventory invertory = XmlTojavaService.convertToJava(file);
		
		assertNotNull("Invertory can not be NULL !", invertory);
		assertNull("Template must be NULL !", invertory.getTemplate());
		assertNotNull("Items can not be NULL! ", invertory.getItems());
		List<Item> itemList = invertory.getItems().getItem();
		assertEquals("Items size not correct !", 3, itemList.size());
		for (int i =0;i<itemList.size();i++){
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
}
