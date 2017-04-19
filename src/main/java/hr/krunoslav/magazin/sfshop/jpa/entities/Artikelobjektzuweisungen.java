package hr.krunoslav.magazin.sfshop.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the artikelobjektzuweisungen database table.
 * 
 */
@Entity
@Table(name="artikelobjektzuweisungen")
@NamedQuery(name="Artikelobjektzuweisungen.findAll", query="SELECT a FROM Artikelobjektzuweisungen a")
public class Artikelobjektzuweisungen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="INAKTIV")
	private byte inaktiv;

	@Column(name="MAXANZAHL")
	private BigInteger maxanzahl;

	@Column(name="VERRART")
	private byte verrart;

	//bi-directional many-to-one association to Artikelsetdetail
	@ManyToOne
	@JoinColumn(name="ArtikelSetDetail_ID")
	private Artikelsetdetail artikelsetdetail;

	//bi-directional many-to-one association to Artikel
	@ManyToOne
	@JoinColumn(name="Artikel_ID")
	private Artikel artikel;

	//bi-directional many-to-one association to Objekte
	@ManyToOne
	@JoinColumn(name="Objekt_ID")
	private Objekte objekte;

	public Artikelobjektzuweisungen() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte getInaktiv() {
		return this.inaktiv;
	}

	public void setInaktiv(byte inaktiv) {
		this.inaktiv = inaktiv;
	}

	public BigInteger getMaxanzahl() {
		return this.maxanzahl;
	}

	public void setMaxanzahl(BigInteger maxanzahl) {
		this.maxanzahl = maxanzahl;
	}

	public byte getVerrart() {
		return this.verrart;
	}

	public void setVerrart(byte verrart) {
		this.verrart = verrart;
	}

	public Artikelsetdetail getArtikelsetdetail() {
		return this.artikelsetdetail;
	}

	public void setArtikelsetdetail(Artikelsetdetail artikelsetdetail) {
		this.artikelsetdetail = artikelsetdetail;
	}

	public Artikel getArtikel() {
		return this.artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

	public Objekte getObjekte() {
		return this.objekte;
	}

	public void setObjekte(Objekte objekte) {
		this.objekte = objekte;
	}

}