package hr.krunoslav.magazin.sfshop.jaxb.elements;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

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
 *       &lt;attribute name="min" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="max" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class Value2 {

	@Override
	public String toString() {
		return "Value2 [min=" + min + ", max=" + max + ", value= " + value + "]";
	}

	@XmlValue
    protected BigInteger value;
	
	@XmlAttribute(name = "min")
	protected String min;
	
	@XmlAttribute(name = "max")
	protected String max;

	
	
	public String getMin() {
		return min;
	}

	public void setMin(String value) {
		this.min = value;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String value) {
		this.max = value;
	}

	public BigInteger getValue() {
		return value;
	}

	public void setValue(BigInteger value) {
		this.value = value;
	}

}