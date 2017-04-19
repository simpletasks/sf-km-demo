package hr.krunoslav.magazin.sfshop.jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the warenkorbkoepfe database table.
 * 
 */
@Entity
@Table(name = "warenkorbkoepfe")
@NamedQuery(name = "Warenkorbkoepfe.findAll", query = "SELECT w FROM Warenkorbkoepfe w")
public class Warenkorbkoepfe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name = "ABACUSTRANSFERJN")
	private byte abacustransferjn;

	@Lob
	@Column(name = "ABACUSTRANSFERLOG")
	private String abacustransferlog;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ABGESCHLOSSENDATE")
	private Date abgeschlossendate;

	@Column(name = "ABGESCHLOSSENJN")
	private byte abgeschlossenjn;

	@Column(name = "ANREDE")
	private byte anrede;

	@Column(name = "AUFTRAGSREFERENZ")
	private String auftragsreferenz;

	@Lob
	@Column(name = "BEMERKUNG")
	private String bemerkung;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATIONDATE")
	private Date creationdate;

	@Column(name = "EMAILADRESSE")
	private String emailadresse;

	@Column(name = "EMAILVERSANDJN")
	private String emailversandjn;

	@Column(name = "FIRMA")
	private String firma;

	@Column(name = "KONTAKTPERSONVORORT")
	private String kontaktpersonvorort;

	@Column(name = "LAND")
	private int land;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LIEFERTERMIN")
	private Date liefertermin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFICATIONDATE")
	private Date modificationdate;

	@Column(name = "NAMEVORNAME")
	private String namevorname;

	@Column(name = "ORT")
	private String ort;

	@Column(name = "PLZ")
	private int plz;

	@Column(name = "POSTFACH")
	private String postfach;

	@Column(name = "STRASSE")
	private String strasse;

	@Column(name = "TELNR")
	private String telnr;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "USERROLE")
	private byte userrole;

	// bi-directional many-to-one association to Warenkorbdetail
	@OneToMany(mappedBy = "warenkorbkoepfe")
	private List<Warenkorbdetail> warenkorbdetails;

	// bi-directional many-to-one association to Objekte
	@ManyToOne
	@JoinColumn(name = "Objekt_ID")
	private Objekte objekte;

	public Warenkorbkoepfe() {
	}

	public Warenkorbkoepfe(Objekte objekte) {
		this.objekte = objekte;
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public byte getAbacustransferjn() {
		return this.abacustransferjn;
	}

	public void setAbacustransferjn(byte abacustransferjn) {
		this.abacustransferjn = abacustransferjn;
	}

	public String getAbacustransferlog() {
		return this.abacustransferlog;
	}

	public void setAbacustransferlog(String abacustransferlog) {
		this.abacustransferlog = abacustransferlog;
	}

	public Date getAbgeschlossendate() {
		return this.abgeschlossendate;
	}

	public void setAbgeschlossendate(Date abgeschlossendate) {
		this.abgeschlossendate = abgeschlossendate;
	}

	public byte getAbgeschlossenjn() {
		return this.abgeschlossenjn;
	}

	public void setAbgeschlossenjn(byte abgeschlossenjn) {
		this.abgeschlossenjn = abgeschlossenjn;
	}

	public byte getAnrede() {
		return this.anrede;
	}

	public void setAnrede(byte anrede) {
		this.anrede = anrede;
	}

	public String getAuftragsreferenz() {
		return this.auftragsreferenz;
	}

	public void setAuftragsreferenz(String auftragsreferenz) {
		this.auftragsreferenz = auftragsreferenz;
	}

	public String getBemerkung() {
		return this.bemerkung;
	}

	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}

	public Date getCreationdate() {
		return this.creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public String getEmailadresse() {
		return this.emailadresse;
	}

	public void setEmailadresse(String emailadresse) {
		this.emailadresse = emailadresse;
	}

	public String getEmailversandjn() {
		return this.emailversandjn;
	}

	public void setEmailversandjn(String emailversandjn) {
		this.emailversandjn = emailversandjn;
	}

	public String getFirma() {
		return this.firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getKontaktpersonvorort() {
		return this.kontaktpersonvorort;
	}

	public void setKontaktpersonvorort(String kontaktpersonvorort) {
		this.kontaktpersonvorort = kontaktpersonvorort;
	}

	public int getLand() {
		return this.land;
	}

	public void setLand(int land) {
		this.land = land;
	}

	public Date getLiefertermin() {
		return this.liefertermin;
	}

	public void setLiefertermin(Date liefertermin) {
		this.liefertermin = liefertermin;
	}

	public Date getModificationdate() {
		return this.modificationdate;
	}

	public void setModificationdate(Date modificationdate) {
		this.modificationdate = modificationdate;
	}

	public String getNamevorname() {
		return this.namevorname;
	}

	public void setNamevorname(String namevorname) {
		this.namevorname = namevorname;
	}

	public String getOrt() {
		return this.ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public int getPlz() {
		return this.plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getPostfach() {
		return this.postfach;
	}

	public void setPostfach(String postfach) {
		this.postfach = postfach;
	}

	public String getStrasse() {
		return this.strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getTelnr() {
		return this.telnr;
	}

	public void setTelnr(String telnr) {
		this.telnr = telnr;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte getUserrole() {
		return this.userrole;
	}

	public void setUserrole(byte userrole) {
		this.userrole = userrole;
	}

	public List<Warenkorbdetail> getWarenkorbdetails() {
		return this.warenkorbdetails;
	}

	public void setWarenkorbdetails(List<Warenkorbdetail> warenkorbdetails) {
		this.warenkorbdetails = warenkorbdetails;
	}

	public Warenkorbdetail addWarenkorbdetail(Warenkorbdetail warenkorbdetail) {
		getWarenkorbdetails().add(warenkorbdetail);
		warenkorbdetail.setWarenkorbkoepfe(this);

		return warenkorbdetail;
	}

	public Warenkorbdetail removeWarenkorbdetail(Warenkorbdetail warenkorbdetail) {
		getWarenkorbdetails().remove(warenkorbdetail);
		warenkorbdetail.setWarenkorbkoepfe(null);

		return warenkorbdetail;
	}

	public Objekte getObjekte() {
		return this.objekte;
	}

	public void setObjekte(Objekte objekte) {
		this.objekte = objekte;
	}

}