package hr.krunoslav.magazin.sfshop.jaxb.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="value0" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="value2">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="min" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="max" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="value5" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="value6" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="value7" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="value8" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="value9" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "value0", "value2", "value5", "value6", "value7", "value8", "value9" })
public class Item {


	@Override
	public String toString() {
		return "Item [uid=" + uid + ", value0=" + value0 + ", value2=" + value2 + ", value5=" + value5 + ", value6="
				+ value6 + ", value7=" + value7 + ", value8=" + value8 + ", value9=" + value9 + "]";
	}

	@XmlAttribute(name = "uid")
	protected Integer uid;
	
	protected String value0;

	@XmlElement(required = true)
	protected Value2 value2;

	protected Integer value5;

	@XmlElement(required = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar value6;

	@XmlElement(required = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar value7;

	@XmlElement(required = true)
	protected String value8;

	protected Integer value9;


	
	
	public String getValue0() {
		return value0;
	}

	public void setValue0(String value) {
		this.value0 = value;
	}

	public Value2 getValue2() {
		return value2;
	}

	public void setValue2(Value2 value) {
		this.value2 = value;
	}

	public Integer getValue5() {
		return value5;
	}

	public void setValue5(Integer value) {
		this.value5 = value;
	}

	public XMLGregorianCalendar getValue6() {
		return value6;
	}

	public void setValue6(XMLGregorianCalendar value) {
		this.value6 = value;
	}

	public XMLGregorianCalendar getValue7() {
		return value7;
	}

	public void setValue7(XMLGregorianCalendar value) {
		this.value7 = value;
	}

	public String getValue8() {
		return value8;
	}

	public void setValue8(String value) {
		this.value8 = value;
	}

	public Integer getValue9() {
		return value9;
	}

	public void setValue9(Integer value) {
		this.value9 = value;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer value) {
		this.uid = value;
	}

}