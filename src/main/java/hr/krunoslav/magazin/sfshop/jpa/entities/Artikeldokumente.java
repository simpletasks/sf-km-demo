package hr.krunoslav.magazin.sfshop.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the artikeldokumente database table.
 * 
 */
@Entity
@Table(name="artikeldokumente")
@NamedQuery(name="Artikeldokumente.findAll", query="SELECT a FROM Artikeldokumente a")
public class Artikeldokumente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Lob
	@Column(name="ATTACHEMENT")
	private byte[] attachement;

	@Column(name="ATTACHEMENT_FILENAME")
	private String attachementFilename;

	@Column(name="ATTACHMENTTYP")
	private byte attachmenttyp;

	@Column(name="BESCHREIBUNG")
	private String beschreibung;

	@ManyToOne
	@JoinColumn(name="Artikel_ID")
	private Artikel artikel;

	public Artikeldokumente() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getAttachement() {
		return this.attachement;
	}

	public void setAttachement(byte[] attachement) {
		this.attachement = attachement;
	}

	public String getAttachementFilename() {
		return this.attachementFilename;
	}

	public void setAttachementFilename(String attachementFilename) {
		this.attachementFilename = attachementFilename;
	}

	public byte getAttachmenttyp() {
		return this.attachmenttyp;
	}

	public void setAttachmenttyp(byte attachmenttyp) {
		this.attachmenttyp = attachmenttyp;
	}

	public String getBeschreibung() {
		return this.beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Artikel getArtikel() {
		return this.artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

}