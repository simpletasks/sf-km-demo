package hr.krunoslav.magazin.sfshop.services.jaxb;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import hr.krunoslav.magazin.sfshop.jaxb.elements.Inventory;

public class XmlTojavaService {

	private static final Logger LOG = LogManager.getLogger(XmlTojavaService.class);

	/**
	 * Convert xml data file into objects. File structure validated against xsd schema
	 *  
	 * @param xmlFile
	 * @param xsdFile
	 * @return
	 * @throws SAXException
	 */
	public static Inventory convertToJava(File xmlFile, File xsdFile) throws SAXException {
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(xsdFile);
		return convertToJava(xmlFile, schema);

	}

	/**
	 * Convert xml data file into objects. File structure validated against xsd schema
	 * 
	 * @param xmlFile
	 * @param xsdSource
	 * @return
	 * @throws SAXException
	 */
	public static Inventory convertToJava(File xmlFile, Source xsdSource) throws SAXException {
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(xsdSource);
		return convertToJava(xmlFile, schema);

	}

	private static Inventory convertToJava(File xmlFile, Schema schema) {
		Inventory inventory = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Inventory.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			jaxbUnmarshaller.setSchema(schema);
			jaxbUnmarshaller.setEventHandler(new MyValidationEventHandler());
			inventory = (Inventory) jaxbUnmarshaller.unmarshal(xmlFile);

			LOG.trace(inventory);
		} catch (Exception e) {
			LOG.error("Xml can not be converted to java.", e);
		}
		return inventory;
	}

}
