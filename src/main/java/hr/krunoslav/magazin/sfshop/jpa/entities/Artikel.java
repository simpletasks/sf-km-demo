package hr.krunoslav.magazin.sfshop.jpa.entities;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the artikel database table.
 * 
 */
@Entity
@Table(name="artikel")
@NamedQueries({
	@NamedQuery(name="Artikel.findAll", query="SELECT a FROM Artikel a"),
	@NamedQuery(name="Artikel.findAllByNummer2List", query="SELECT a FROM Artikel a where a.nummer2 IN :numbers"),
	@NamedQuery(name="Artikel.findByNummer2", query="SELECT a FROM Artikel a where a.nummer2 = :number")
})

public class Artikel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger id;

	@Lob
	@Column(name="BEMERKUNG")
	private String bemerkung;

	@Column(name="BEZEICHNUNG1")
	private String bezeichnung1;

	@Column(name="BEZEICHNUNG2")
	private String bezeichnung2;

	@Column(name="EINHEIT")
	private String einheit;

	@Column(name="INAKTIV")
	private boolean inaktiv;

	@Column(name="NUMMER1")
	private String nummer1;

	@Column(name="NUMMER2")
	private String nummer2;

	@Column(name="PREISEXKLMWST")
	private double preisexklmwst;

	@Column(name="VERPACKUNGSEINHEIT")
	private String verpackungseinheit;

	//bi-directional many-to-one association to Artikelgruppen
	@ManyToOne
	@JoinColumn(name="ArtikelGruppe_ID")
	private Artikelgruppen artikelgruppen;

	//bi-directional many-to-one association to Artikeldokumente
	@OneToMany(mappedBy="artikel")
	private List<Artikeldokumente> artikeldokumentes;

	//bi-directional many-to-one association to Artikellager
	@OneToMany(mappedBy="artikel")
	private List<Artikellager> artikellagers;

	//bi-directional many-to-one association to Artikelobjektzuweisungen
	@OneToMany(mappedBy="artikel")
	private List<Artikelobjektzuweisungen> artikelobjektzuweisungens;

	//bi-directional many-to-one association to Artikelsetdetail
	@OneToMany(mappedBy="artikel")
	private List<Artikelsetdetail> artikelsetdetails;

	//bi-directional many-to-one association to Warenkorbdetail
	@OneToMany(mappedBy="artikel")
	private List<Warenkorbdetail> warenkorbdetails;

	public Artikel() {
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getBemerkung() {
		return this.bemerkung;
	}

	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
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

	public String getEinheit() {
		return this.einheit;
	}

	public void setEinheit(String einheit) {
		this.einheit = einheit;
	}

	public boolean getInaktiv() {
		return this.inaktiv;
	}

	public void setInaktiv(boolean inaktiv) {
		this.inaktiv = inaktiv;
	}

	public String getNummer1() {
		return this.nummer1;
	}

	public void setNummer1(String nummer1) {
		this.nummer1 = nummer1;
	}

	public String getNummer2() {
		return this.nummer2;
	}

	public void setNummer2(String nummer2) {
		this.nummer2 = nummer2;
	}

	public double getPreisexklmwst() {
		return this.preisexklmwst;
	}

	public void setPreisexklmwst(double preisexklmwst) {
		this.preisexklmwst = preisexklmwst;
	}

	public String getVerpackungseinheit() {
		return this.verpackungseinheit;
	}

	public void setVerpackungseinheit(String verpackungseinheit) {
		this.verpackungseinheit = verpackungseinheit;
	}

	public Artikelgruppen getArtikelgruppen() {
		return this.artikelgruppen;
	}

	public void setArtikelgruppen(Artikelgruppen artikelgruppen) {
		this.artikelgruppen = artikelgruppen;
	}

	public List<Artikeldokumente> getArtikeldokumentes() {
		return this.artikeldokumentes;
	}

	public void setArtikeldokumentes(List<Artikeldokumente> artikeldokumentes) {
		this.artikeldokumentes = artikeldokumentes;
	}

	public Artikeldokumente addArtikeldokumente(Artikeldokumente artikeldokumente) {
		getArtikeldokumentes().add(artikeldokumente);
		artikeldokumente.setArtikel(this);

		return artikeldokumente;
	}

	public Artikeldokumente removeArtikeldokumente(Artikeldokumente artikeldokumente) {
		getArtikeldokumentes().remove(artikeldokumente);
		artikeldokumente.setArtikel(null);

		return artikeldokumente;
	}

	public List<Artikellager> getArtikellagers() {
		return this.artikellagers;
	}

	public void setArtikellagers(List<Artikellager> artikellagers) {
		this.artikellagers = artikellagers;
	}

	public Artikellager addArtikellager(Artikellager artikellager) {
		getArtikellagers().add(artikellager);
		artikellager.setArtikel(this);

		return artikellager;
	}

	public Artikellager removeArtikellager(Artikellager artikellager) {
		getArtikellagers().remove(artikellager);
		artikellager.setArtikel(null);

		return artikellager;
	}

	public List<Artikelobjektzuweisungen> getArtikelobjektzuweisungens() {
		return this.artikelobjektzuweisungens;
	}

	public void setArtikelobjektzuweisungens(List<Artikelobjektzuweisungen> artikelobjektzuweisungens) {
		this.artikelobjektzuweisungens = artikelobjektzuweisungens;
	}

	public Artikelobjektzuweisungen addArtikelobjektzuweisungen(Artikelobjektzuweisungen artikelobjektzuweisungen) {
		getArtikelobjektzuweisungens().add(artikelobjektzuweisungen);
		artikelobjektzuweisungen.setArtikel(this);

		return artikelobjektzuweisungen;
	}

	public Artikelobjektzuweisungen removeArtikelobjektzuweisungen(Artikelobjektzuweisungen artikelobjektzuweisungen) {
		getArtikelobjektzuweisungens().remove(artikelobjektzuweisungen);
		artikelobjektzuweisungen.setArtikel(null);

		return artikelobjektzuweisungen;
	}

	public List<Artikelsetdetail> getArtikelsetdetails() {
		return this.artikelsetdetails;
	}

	public void setArtikelsetdetails(List<Artikelsetdetail> artikelsetdetails) {
		this.artikelsetdetails = artikelsetdetails;
	}

	public Artikelsetdetail addArtikelsetdetail(Artikelsetdetail artikelsetdetail) {
		getArtikelsetdetails().add(artikelsetdetail);
		artikelsetdetail.setArtikel(this);

		return artikelsetdetail;
	}

	public Artikelsetdetail removeArtikelsetdetail(Artikelsetdetail artikelsetdetail) {
		getArtikelsetdetails().remove(artikelsetdetail);
		artikelsetdetail.setArtikel(null);

		return artikelsetdetail;
	}

	public List<Warenkorbdetail> getWarenkorbdetails() {
		return this.warenkorbdetails;
	}

	public void setWarenkorbdetails(List<Warenkorbdetail> warenkorbdetails) {
		this.warenkorbdetails = warenkorbdetails;
	}

	public Warenkorbdetail addWarenkorbdetail(Warenkorbdetail warenkorbdetail) {
		getWarenkorbdetails().add(warenkorbdetail);
		warenkorbdetail.setArtikel(this);

		return warenkorbdetail;
	}

	public Warenkorbdetail removeWarenkorbdetail(Warenkorbdetail warenkorbdetail) {
		getWarenkorbdetails().remove(warenkorbdetail);
		warenkorbdetail.setArtikel(null);

		return warenkorbdetail;
	}

}