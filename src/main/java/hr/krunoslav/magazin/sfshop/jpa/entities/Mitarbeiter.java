package hr.krunoslav.magazin.sfshop.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the mitarbeiter database table.
 * 
 */
@Entity
@Table(name="mitarbeiter")
@NamedQuery(name="Mitarbeiter.findAll", query="SELECT m FROM Mitarbeiter m")
public class Mitarbeiter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="BEMERKUNG")
	private String bemerkung;

	@Column(name="INACTIVE")
	private byte inactive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INACTIVESINCE")
	private Date inactivesince;

	@Column(name="MANR")
	private BigInteger manr;

	@Column(name="NAME")
	private String name;

	@Column(name="VORNAME")
	private String vorname;

	public Mitarbeiter() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBemerkung() {
		return this.bemerkung;
	}

	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}

	public byte getInactive() {
		return this.inactive;
	}

	public void setInactive(byte inactive) {
		this.inactive = inactive;
	}

	public Date getInactivesince() {
		return this.inactivesince;
	}

	public void setInactivesince(Date inactivesince) {
		this.inactivesince = inactivesince;
	}

	public BigInteger getManr() {
		return this.manr;
	}

	public void setManr(BigInteger manr) {
		this.manr = manr;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

}