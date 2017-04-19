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
  *         &lt;element name="item">
  *           &lt;complexType>
  *             &lt;complexContent>
  *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
  *                 &lt;sequence>
  *                   &lt;element name="value0" type="{http://www.w3.org/2001/XMLSchema}int"/>
  *                   &lt;element name="value2">
  *                     &lt;complexType>
  *                       &lt;complexContent>
  *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
  *                           &lt;attribute name="min" type="{http://www.w3.org/2001/XMLSchema}string" />
  *                           &lt;attribute name="max" type="{http://www.w3.org/2001/XMLSchema}string" />
  *                         &lt;/restriction>
  *                       &lt;/complexContent>
  *                     &lt;/complexType>
  *                   &lt;/element>
  *                   &lt;element name="value5" type="{http://www.w3.org/2001/XMLSchema}int"/>
  *                   &lt;element name="value6" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
  *                   &lt;element name="value7" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
  *                   &lt;element name="value8" type="{http://www.w3.org/2001/XMLSchema}string"/>
  *                   &lt;element name="value9" type="{http://www.w3.org/2001/XMLSchema}int"/>
  *                 &lt;/sequence>
  *                 &lt;attribute name="uid" type="{http://www.w3.org/2001/XMLSchema}int" />
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
     "item"
 })
 public class Items {

     @Override
	public String toString() {
		return "Items [item=" + item + "]";
	}


     protected List<Item> item;

     /**
      * Gets the value of the item property.
      * 
      * <p>
      * This accessor method returns a reference to the live list,
      * not a snapshot. Therefore any modification you make to the
      * returned list will be present inside the JAXB object.
      * This is why there is not a <CODE>set</CODE> method for the item property.
      * 
      * <p>
      * For example, to add a new item, do as follows:
      * <pre>
      *    getItem().add(newItem);
      * </pre>
      * 
      * 
      * <p>
      * Objects of the following type(s) are allowed in the list
      * {@link Inventory.Items.Item }
      * 
      * 
      */
     public List<Item> getItem() {
         if (item == null) {
             item = new ArrayList<Item>();
         }
         return this.item;
     }

 }