package hr.krunoslav.magazin.sfshop.services.jaxb;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Contains method for locating xsd schema file in archive.
 * 
 * @author Krunoslav Magazin
 *
 */
public class SchemaSourceLocator {

	/** Name of xsd schema file packaged in jar archive */
	public static final String XSD_FILENAME = "/input-data.xsd";
	private static final Logger LOG = LogManager.getLogger(SchemaSourceLocator.class);

	public Source loadSchemaSource() {
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
