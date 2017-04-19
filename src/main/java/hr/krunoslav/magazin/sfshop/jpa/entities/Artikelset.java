package hr.krunoslav.magazin.sfshop.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the artikelsets database table.
 * 
 */
@Entity
@Table(name="artikelsets")
@NamedQuery(name="Artikelset.findAll", query="SELECT a FROM Artikelset a")
public class Artikelset implements Serializable {
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

	@Column(name="STANDARD")
	private byte standard;

	//bi-directional many-to-one association to Artikelsetdetail
	@OneToMany(mappedBy="artikelset")
	private List<Artikelsetdetail> artikelsetdetails;

	//bi-directional many-to-one association to Objekte
	@OneToMany(mappedBy="artikelset")
	private List<Objekte> objektes;

	public Artikelset() {
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

	public byte getStandard() {
		return this.standard;
	}

	public void setStandard(byte standard) {
		this.standard = standard;
	}

	public List<Artikelsetdetail> getArtikelsetdetails() {
		return this.artikelsetdetails;
	}

	public void setArtikelsetdetails(List<Artikelsetdetail> artikelsetdetails) {
		this.artikelsetdetails = artikelsetdetails;
	}

	public Artikelsetdetail addArtikelsetdetail(Artikelsetdetail artikelsetdetail) {
		getArtikelsetdetails().add(artikelsetdetail);
		artikelsetdetail.setArtikelset(this);

		return artikelsetdetail;
	}

	public Artikelsetdetail removeArtikelsetdetail(Artikelsetdetail artikelsetdetail) {
		getArtikelsetdetails().remove(artikelsetdetail);
		artikelsetdetail.setArtikelset(null);

		return artikelsetdetail;
	}

	public List<Objekte> getObjektes() {
		return this.objektes;
	}

	public void setObjektes(List<Objekte> objektes) {
		this.objektes = objektes;
	}

	public Objekte addObjekte(Objekte objekte) {
		getObjektes().add(objekte);
		objekte.setArtikelset(this);

		return objekte;
	}

	public Objekte removeObjekte(Objekte objekte) {
		getObjektes().remove(objekte);
		objekte.setArtikelset(null);

		return objekte;
	}

}