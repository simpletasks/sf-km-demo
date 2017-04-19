package hr.krunoslav.magazin.sfshop.jaxb.elements;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
  * <p>Java class for anonymous complex type.
  * 
  * <p>The following schema fragment specifies the expected content contained within this class.
  * 
  * <pre>
  * &lt;complexType>
  *   &lt;complexContent>
  *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
  *       &lt;sequence>
  *         &lt;element name="field">
  *           &lt;complexType>
  *             &lt;complexContent>
  *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
  *                 &lt;attribute name="idx" type="{http://www.w3.org/2001/XMLSchema}int" />
  *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
  *                 &lt;attribute name="descr" type="{http://www.w3.org/2001/XMLSchema}string" />
  *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
  *                 &lt;attribute name="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
  *                 &lt;attribute name="access" type="{http://www.w3.org/2001/XMLSchema}string" />
  *                 &lt;attribute name="content" type="{http://www.w3.org/2001/XMLSchema}string" />
  *               &lt;/restriction>
  *             &lt;/complexContent>
  *           &lt;/complexType>
  *         &lt;/element>
  *       &lt;/sequence>
  *     &lt;/restriction>
  *   &lt;/complexContent>
  * &lt;/complexType>
  * </pre>
  * 
  * 
  */
 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name = "", propOrder = {
     "field"
 })
 public class Template {

     @Override
	public String toString() {
		return "Template [field=" + field + "]";
	}


     protected List<Field> field;

     /**
      * Gets the value of the field property.
      * 
      * <p>
      * This accessor method returns a reference to the live list,
      * not a snapshot. Therefore any modification you make to the
      * returned list will be present inside the JAXB object.
      * This is why there is not a <CODE>set</CODE> method for the field property.
      * 
      * <p>
      * For example, to add a new item, do as follows:
      * <pre>
      *    getField().add(newItem);
      * </pre>
      * 
      * 
      * <p>
      * Objects of the following type(s) are allowed in the list
      * {@link Inventory.Template.Field }
      * 
      * 
      */
     public List<Field> getField() {
         if (field == null) {
             field = new ArrayList<Field>();
         }
         return this.field;
     }

 }