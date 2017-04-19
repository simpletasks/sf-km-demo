package hr.krunoslav.magazin.sfshop.main;

import java.io.File;
import java.math.BigInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hr.krunoslav.magazin.sfshop.jaxb.elements.Inventory;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.ArtikelDaoImpl;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.EntityManagerFactory;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.ObjekteDaoImpl;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.WarenkorbdetailsDaoImpl;
import hr.krunoslav.magazin.sfshop.jpa.dao.impl.WarenkorbkoepfeDaoImpl;
import hr.krunoslav.magazin.sfshop.services.file.FileNameValidator;
import hr.krunoslav.magazin.sfshop.services.jaxb.XmlTojavaService;
import hr.krunoslav.magazin.sfshop.services.shopping_cart.ShoppingCartService;

public class ShoppingCartItemsImporter {

	public static final BigInteger DEFAULT_OBJEKTE_ID = new BigInteger("1");
	public static final String INFO_FOR_PROPER_FILE_PATH = "Path to xml file must be prefixed with '/' for "
			+ "absolute path or without prefix for relative path from current directory!";

	private static final Logger LOG = LogManager.getLogger(ShoppingCartItemsImporter.class);

	public static void main(String[] args) {

		if (args.length == 0) {
			LOG.warn("No file name set ! Xml file name must be passed as first argument !");
			LOG.info(INFO_FOR_PROPER_FILE_PATH);

			System.exit(1);
		}

		ShoppingCartItemsImporter app = new ShoppingCartItemsImporter();
		if (!app.importFromXmlFile(args[0])) {
			System.exit(1);
		}

	}

	public boolean importFromXmlFile(String fileName) {

		File file = FileNameValidator.checkIfFileExist(fileName);
		if (file == null) {
			LOG.info(INFO_FOR_PROPER_FILE_PATH);
			return false;
		}

		Inventory invertory = XmlTojavaService.convertToJava(file);

		ShoppingCartService service = new ShoppingCartService(new EntityManagerFactory(), new ArtikelDaoImpl(),
				new ObjekteDaoImpl(), new WarenkorbkoepfeDaoImpl(), new WarenkorbdetailsDaoImpl());
		if (!service.createShoppingCart(invertory.getItems())) {
			LOG.info("Processing aborted");
			return false;
		}
		LOG.info("Finished.");
		return true;
	}
}
