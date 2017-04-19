package hr.krunoslav.magazin.sfshop.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the uebersetzungen database table.
 * 
 */
@Entity
@Table(name="uebersetzungen")
@NamedQuery(name="Uebersetzungen.findAll", query="SELECT u FROM Uebersetzungen u")
public class Uebersetzungen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="key_name")
	private String keyName;

	@Lob
	@Column(name="DE")
	private String de;

	@Lob
	@Column(name="EN")
	private String en;

	@Lob
	@Column(name="FR")
	private String fr;

	public Uebersetzungen() {
	}

	public String getKeyName() {
		return this.keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getDe() {
		return this.de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getEn() {
		return this.en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public String getFr() {
		return this.fr;
	}

	public void setFr(String fr) {
		this.fr = fr;
	}

}