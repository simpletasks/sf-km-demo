package hr.krunoslav.magazin.sfshop.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the artikellager database table.
 * 
 */
@Entity
@Table(name="artikellager")
@NamedQuery(name="Artikellager.findAll", query="SELECT a FROM Artikellager a")
public class Artikellager implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="BEZEICHNUNG")
	private String bezeichnung;

	@Column(name="BINLOCATIONABAC")
	private String binlocationabac;

	@Column(name="HAUPTLAGER_JN")
	private byte hauptlagerJn;

	@Column(name="INAKTIV")
	private byte inaktiv;

	@Column(name="STOCKLOCATIONABAC")
	private String stocklocationabac;

	//bi-directional many-to-one association to Artikel
	@ManyToOne
	@JoinColumn(name="Artikel_ID")
	private Artikel artikel;

	//bi-directional many-to-one association to Warenkorbdetail
	@OneToMany(mappedBy="artikellager")
	private List<Warenkorbdetail> warenkorbdetails;

	public Artikellager() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBezeichnung() {
		return this.bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getBinlocationabac() {
		return this.binlocationabac;
	}

	public void setBinlocationabac(String binlocationabac) {
		this.binlocationabac = binlocationabac;
	}

	public byte getHauptlagerJn() {
		return this.hauptlagerJn;
	}

	public void setHauptlagerJn(byte hauptlagerJn) {
		this.hauptlagerJn = hauptlagerJn;
	}

	public byte getInaktiv() {
		return this.inaktiv;
	}

	public void setInaktiv(byte inaktiv) {
		this.inaktiv = inaktiv;
	}

	public String getStocklocationabac() {
		return this.stocklocationabac;
	}

	public void setStocklocationabac(String stocklocationabac) {
		this.stocklocationabac = stocklocationabac;
	}

	public Artikel getArtikel() {
		return this.artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

	public List<Warenkorbdetail> getWarenkorbdetails() {
		return this.warenkorbdetails;
	}

	public void setWarenkorbdetails(List<Warenkorbdetail> warenkorbdetails) {
		this.warenkorbdetails = warenkorbdetails;
	}

	public Warenkorbdetail addWarenkorbdetail(Warenkorbdetail warenkorbdetail) {
		getWarenkorbdetails().add(warenkorbdetail);
		warenkorbdetail.setArtikellager(this);

		return warenkorbdetail;
	}

	public Warenkorbdetail removeWarenkorbdetail(Warenkorbdetail warenkorbdetail) {
		getWarenkorbdetails().remove(warenkorbdetail);
		warenkorbdetail.setArtikellager(null);

		return warenkorbdetail;
	}

}