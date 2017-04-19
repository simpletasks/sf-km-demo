package hr.krunoslav.magazin.sfshop.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the warenkorbdetails database table.
 * 
 */
@Entity
@Table(name="warenkorbdetails")
@NamedQuery(name="Warenkorbdetail.findAll", query="SELECT w FROM Warenkorbdetail w")
public class Warenkorbdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name="ARTIKELNUMMER1")
	private String artikelnummer1;

	@Column(name="ARTIKELNUMMER2")
	private String artikelnummer2;

	@Column(name="BEZEICHNUNG1")
	private String bezeichnung1;

	@Column(name="BEZEICHNUNG2")
	private String bezeichnung2;

	@Column(name="MENGE")
	private BigInteger menge;

	@Column(name="PREISEXKLMWST")
	private double preisexklmwst;

	@ManyToOne
	@JoinColumn(name="ArtikelLager_ID")
	private Artikellager artikellager;

	@ManyToOne
	@JoinColumn(name="Artikel_ID")
	private Artikel artikel;

	@ManyToOne
	@JoinColumn(name="WarenkorbKopf_ID")
	private Warenkorbkoepfe warenkorbkoepfe;

	public Warenkorbdetail() {
	}

	
	public Warenkorbdetail(Warenkorbkoepfe warenkorbkoepfe) {
		this.warenkorbkoepfe = warenkorbkoepfe;
	}


	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getArtikelnummer1() {
		return this.artikelnummer1;
	}

	public void setArtikelnummer1(String artikelnummer1) {
		this.artikelnummer1 = artikelnummer1;
	}

	public String getArtikelnummer2() {
		return this.artikelnummer2;
	}

	public void setArtikelnummer2(String artikelnummer2) {
		this.artikelnummer2 = artikelnummer2;
	}

	public String getBezeichnung1() {
		return this.bezeichnung1;
	}

	public void setBezeichnung1(String bezeichnung1) {
		this.bezeichnung1 = bezeichnung1;
	}

	public String getBezeichnung2() {
		return this.bezeichnung2;
	}

	public void setBezeichnung2(String bezeichnung2) {
		this.bezeichnung2 = bezeichnung2;
	}

	public BigInteger getMenge() {
		return this.menge;
	}

	public void setMenge(BigInteger menge) {
		this.menge = menge;
	}

	public double getPreisexklmwst() {
		return this.preisexklmwst;
	}

	public void setPreisexklmwst(double preisexklmwst) {
		this.preisexklmwst = preisexklmwst;
	}

	public Artikellager getArtikellager() {
		return this.artikellager;
	}

	public void setArtikellager(Artikellager artikellager) {
		this.artikellager = artikellager;
	}

	public Artikel getArtikel() {
		return this.artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

	public Warenkorbkoepfe getWarenkorbkoepfe() {
		return this.warenkorbkoepfe;
	}

	public void setWarenkorbkoepfe(Warenkorbkoepfe warenkorbkoepfe) {
		this.warenkorbkoepfe = warenkorbkoepfe;
	}

}