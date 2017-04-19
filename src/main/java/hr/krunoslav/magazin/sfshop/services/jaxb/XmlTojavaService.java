package hr.krunoslav.magazin.sfshop.services.jaxb;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hr.krunoslav.magazin.sfshop.jaxb.elements.Inventory;

public class XmlTojavaService {

	private static final Logger LOG = LogManager.getLogger(XmlTojavaService.class);

	public static Inventory convertToJava(File file) {

		Inventory inventory = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Inventory.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			inventory = (Inventory) jaxbUnmarshaller.unmarshal(file);

			LOG.trace(inventory);
		} catch (Exception e) {
			LOG.error("Xml can not be converted to java.", e);
		}
		return inventory;

	}
}
