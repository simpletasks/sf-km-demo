package hr.krunoslav.magazin.sfshop.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the artikelsetdetails database table.
 * 
 */
@Entity
@Table(name="artikelsetdetails")
@NamedQuery(name="Artikelsetdetail.findAll", query="SELECT a FROM Artikelsetdetail a")
public class Artikelsetdetail implements Serializable {
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

	//bi-directional many-to-one association to Artikelobjektzuweisungen
	@OneToMany(mappedBy="artikelsetdetail")
	private List<Artikelobjektzuweisungen> artikelobjektzuweisungens;

	//bi-directional many-to-one association to Artikelset
	@ManyToOne
	@JoinColumn(name="ArtikelSet_ID")
	private Artikelset artikelset;

	//bi-directional many-to-one association to Artikel
	@ManyToOne
	@JoinColumn(name="Artikel_ID")
	private Artikel artikel;

	public Artikelsetdetail() {
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

	public List<Artikelobjektzuweisungen> getArtikelobjektzuweisungens() {
		return this.artikelobjektzuweisungens;
	}

	public void setArtikelobjektzuweisungens(List<Artikelobjektzuweisungen> artikelobjektzuweisungens) {
		this.artikelobjektzuweisungens = artikelobjektzuweisungens;
	}

	public Artikelobjektzuweisungen addArtikelobjektzuweisungen(Artikelobjektzuweisungen artikelobjektzuweisungen) {
		getArtikelobjektzuweisungens().add(artikelobjektzuweisungen);
		artikelobjektzuweisungen.setArtikelsetdetail(this);

		return artikelobjektzuweisungen;
	}

	public Artikelobjektzuweisungen removeArtikelobjektzuweisungen(Artikelobjektzuweisungen artikelobjektzuweisungen) {
		getArtikelobjektzuweisungens().remove(artikelobjektzuweisungen);
		artikelobjektzuweisungen.setArtikelsetdetail(null);

		return artikelobjektzuweisungen;
	}

	public Artikelset getArtikelset() {
		return this.artikelset;
	}

	public void setArtikelset(Artikelset artikelset) {
		this.artikelset = artikelset;
	}

	public Artikel getArtikel() {
		return this.artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

}