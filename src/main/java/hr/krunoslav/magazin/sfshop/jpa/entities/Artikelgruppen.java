package hr.krunoslav.magazin.sfshop.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the artikelgruppen database table.
 * 
 */
@Entity
@Table(name="artikelgruppen")
@NamedQuery(name="Artikelgruppen.findAll", query="SELECT a FROM Artikelgruppen a")
public class Artikelgruppen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="BEZEICHNUNGDE")
	private String bezeichnungde;

	@Column(name="BEZEICHNUNGEN")
	private String bezeichnungen;

	@Column(name="BEZEICHNUNGFR")
	private String bezeichnungfr;

	@Column(name="BEZEICHNUNGIT")
	private String bezeichnungit;

	@Column(name="PARENTID")
	private BigInteger parentid;

	//bi-directional many-to-one association to Artikel
	@OneToMany(mappedBy="artikelgruppen")
	private List<Artikel> artikels;

	public Artikelgruppen() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBezeichnungde() {
		return this.bezeichnungde;
	}

	public void setBezeichnungde(String bezeichnungde) {
		this.bezeichnungde = bezeichnungde;
	}

	public String getBezeichnungen() {
		return this.bezeichnungen;
	}

	public void setBezeichnungen(String bezeichnungen) {
		this.bezeichnungen = bezeichnungen;
	}

	public String getBezeichnungfr() {
		return this.bezeichnungfr;
	}

	public void setBezeichnungfr(String bezeichnungfr) {
		this.bezeichnungfr = bezeichnungfr;
	}

	public String getBezeichnungit() {
		return this.bezeichnungit;
	}

	public void setBezeichnungit(String bezeichnungit) {
		this.bezeichnungit = bezeichnungit;
	}

	public BigInteger getParentid() {
		return this.parentid;
	}

	public void setParentid(BigInteger parentid) {
		this.parentid = parentid;
	}

	public List<Artikel> getArtikels() {
		return this.artikels;
	}

	public void setArtikels(List<Artikel> artikels) {
		this.artikels = artikels;
	}

	public Artikel addArtikel(Artikel artikel) {
		getArtikels().add(artikel);
		artikel.setArtikelgruppen(this);

		return artikel;
	}

	public Artikel removeArtikel(Artikel artikel) {
		getArtikels().remove(artikel);
		artikel.setArtikelgruppen(null);

		return artikel;
	}

}