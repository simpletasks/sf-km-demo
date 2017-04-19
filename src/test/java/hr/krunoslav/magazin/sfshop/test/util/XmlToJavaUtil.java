package hr.krunoslav.magazin.sfshop.test.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import hr.krunoslav.magazin.sfshop.jaxb.elements.Inventory;
import hr.krunoslav.magazin.sfshop.services.jaxb.XmlTojavaService;

public class XmlToJavaUtil {

	/**
	 * Use in unit tests.
	 * 
	 * @param xmlFile
	 * @param xsdFile
	 * @return
	 */
	public static Inventory convertToJava(File xmlFile, File xsdFile) {
		Inventory inventory = null;
		try {
			inventory = XmlTojavaService.convertToJava(xmlFile, xsdFile);
		} catch (SAXException e) {
			throw new RuntimeException("Schema problem!");
		}
		return inventory;
	}

	/**
	 * Use when schema file is in archive.
	 * 
	 * @param xmlFile
	 * @param xsdSource
	 * @return
	 */
	public static Inventory convertToJava(File xmlFile, Source xsdSource) {
		Inventory inventory = null;
		try {
			inventory = XmlTojavaService.convertToJava(xmlFile, xsdSource);
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
	public static int getTagCount(String tagName, File xmlFile) {
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
}
