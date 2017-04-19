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

	@ManyToOne
	@JoinColumn(name="ArtikelGruppe_ID")
	private Artikelgruppen artikelgruppen;


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
}