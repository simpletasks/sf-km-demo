package hr.krunoslav.magazin.sfshop.jaxb.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
  *       &lt;attribute name="idx" type="{http://www.w3.org/2001/XMLSchema}int" />
  *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
  *       &lt;attribute name="descr" type="{http://www.w3.org/2001/XMLSchema}string" />
  *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
  *       &lt;attribute name="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
  *       &lt;attribute name="access" type="{http://www.w3.org/2001/XMLSchema}string" />
  *       &lt;attribute name="content" type="{http://www.w3.org/2001/XMLSchema}string" />
  *     &lt;/restriction>
  *   &lt;/complexContent>
  * &lt;/complexType>
  * </pre>
  * 
  * 
  */
 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name = "")
 public class Field {

     @Override
	public String toString() {
		return "Field [idx=" + idx + ", name=" + name + ", descr=" + descr + ", type=" + type + ", required=" + required
				+ ", access=" + access + ", content=" + content + "]";
	}

	@XmlAttribute(name = "idx")
     protected Integer idx;
	
     @XmlAttribute(name = "name")
     protected String name;
     
     @XmlAttribute(name = "descr")
     protected String descr;
     
     @XmlAttribute(name = "type")
     protected String type;
     
     @XmlAttribute(name = "required")
     protected Boolean required;
     
     @XmlAttribute(name = "access")
     protected String access;
     
     @XmlAttribute(name = "content")
     protected String content;


     public Integer getIdx() {
         return idx;
     }


     public void setIdx(Integer value) {
         this.idx = value;
     }


     public String getName() {
         return name;
     }

 
     public void setName(String value) {
         this.name = value;
     }


     public String getDescr() {
         return descr;
     }


     public void setDescr(String value) {
         this.descr = value;
     }


     public String getType() {
         return type;
     }


     public void setType(String value) {
         this.type = value;
     }


     public Boolean isRequired() {
         return required;
     }


     public void setRequired(Boolean value) {
         this.required = value;
     }


     public String getAccess() {
         return access;
     }


     public void setAccess(String value) {
         this.access = value;
     }


     public String getContent() {
         return content;
     }


     public void setContent(String value) {
         this.content = value;
     }

 }