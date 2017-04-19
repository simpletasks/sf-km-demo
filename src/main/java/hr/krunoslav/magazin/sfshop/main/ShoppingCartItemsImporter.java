package hr.krunoslav.magazin.sfshop.main;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import hr.krunoslav.magazin.sfshop.jaxb.elements.Inventory;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.ArtikelDaoImpl;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.EntityManagerFactory;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.ObjekteDaoImpl;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.WarenkorbdetailsDaoImpl;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.WarenkorbkoepfeDaoImpl;
import hr.krunoslav.magazin.sfshop.jpa.entities.Warenkorbkoepfe;
import hr.krunoslav.magazin.sfshop.services.file.FileNameValidator;
import hr.krunoslav.magazin.sfshop.services.jaxb.XmlTojavaService;
import hr.krunoslav.magazin.sfshop.services.shopping_cart.ShoppingCartService;

public class ShoppingCartItemsImporter {

	/** Entity objekte ID used in this demo project */
	public static final BigInteger DEFAULT_OBJEKTE_ID = new BigInteger("1");
	public static final String INFO_FOR_PROPER_PATH_TO_XML_FILE = "Path to xml file must be prefixed with '/' for "
			+ "absolute path or without prefix for relative path from current directory!";
	/** Name of xsd schema file packaged in jar archive */
	public static final String XSD_FILENAME = "/input-data.xsd";

	private static final Logger LOG = LogManager.getLogger(ShoppingCartItemsImporter.class);

	public static void main(String[] args) {

		if (args.length == 0) {
			LOG.warn("No file name set ! Xml file name must be passed as first argument !");
			LOG.info(INFO_FOR_PROPER_PATH_TO_XML_FILE);

			System.exit(1);
		}

		ShoppingCartItemsImporter app = new ShoppingCartItemsImporter();
		if (!app.importFromXmlFile(args[0])) {
			System.exit(1);
		}

	}

	/**
	 * For input xml data file create {@link Warenkorbkoepfe} in database. Xsd schema
	 * file must be packaged in archive.
	 * 
	 * @param fileName absolute path to file or relative path from current execution directory
	 * @return true for success or false for every exception
	 */
	public boolean importFromXmlFile(String fileName) {

		// load xml file
		File xmlFile = FileNameValidator.checkIfFileExist(fileName);
		if (xmlFile == null) {
			LOG.info(INFO_FOR_PROPER_PATH_TO_XML_FILE);
			return false;
		}

		// load xsd schema file
		Source schemaSource = loadSchemaSource();
		if (schemaSource == null) {
			LOG.info("Processing aborted");
			return false;
		}

		Inventory invertory;
		try {
			invertory = XmlTojavaService.convertToJava(xmlFile, schemaSource);
		} catch (SAXException e) {
			LOG.error("Error using schema file: " + xmlFile.getName(), e);
			return false;
		}

		// create Warenkorbkoepfe for passed items
		ShoppingCartService service = new ShoppingCartService(new EntityManagerFactory(), new ArtikelDaoImpl(),
				new ObjekteDaoImpl(), new WarenkorbkoepfeDaoImpl(), new WarenkorbdetailsDaoImpl());
		if (!service.createShoppingCart(invertory.getItems())) {
			LOG.info("Processing aborted");
			return false;
		}
		LOG.info("Finished.");
		return true;
	}

	private Source loadSchemaSource() {
		InputStream is = getClass().getResourceAsStream(XSD_FILENAME);
		if (is == null) {
			LOG.error("Xsd schema file not found in archive. FileName: {}", XSD_FILENAME);
			return null;
		}
		InputStreamReader isr = new InputStreamReader(is);
		Source schemaSource = new StreamSource(isr);
		return schemaSource;
	}
}
