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
}