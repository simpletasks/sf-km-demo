package hr.krunoslav.magazin.sfshop.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="ABACUSNR")
	private BigInteger abacusnr;

	@Column(name="ANREDE")
	private byte anrede;

	@Column(name="FIRMA")
	private String firma;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INACTIVE")
	private Date inactive;

	@Column(name="ISPORTALADMIN")
	private byte isportaladmin;

	@Column(name="LAND")
	private int land;

	@Column(name="LANGUAGE")
	private String language;

	@Column(name="NACHNAME")
	private String nachname;

	@Column(name="ORT")
	private String ort;

	@Column(name="PASSWORD")
	private String password;

	@Column(name="PLZ")
	private String plz;

	@Column(name="PWD_RESET_NACH_LOGIN")
	private byte pwdResetNachLogin;

	@Column(name="ROLE")
	private byte role;

	@Column(name="SALT")
	private String salt;

	@Column(name="TELNR")
	private String telnr;

	@Column(name="USERNAME")
	private String username;

	@Column(name="VERBRAUCH_GR")
	private byte verbrauchGr;

	@Column(name="VERRECHNUNG_AN_KD")
	private byte verrechnungAnKd;

	@Column(name="VORNAME")
	private String vorname;

	@Column(name="ZEILE1")
	private String zeile1;

	@Column(name="ZEILE2")
	private String zeile2;


	public User() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigInteger getAbacusnr() {
		return this.abacusnr;
	}

	public void setAbacusnr(BigInteger abacusnr) {
		this.abacusnr = abacusnr;
	}

	public byte getAnrede() {
		return this.anrede;
	}

	public void setAnrede(byte anrede) {
		this.anrede = anrede;
	}

	public String getFirma() {
		return this.firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public Date getInactive() {
		return this.inactive;
	}

	public void setInactive(Date inactive) {
		this.inactive = inactive;
	}

	public byte getIsportaladmin() {
		return this.isportaladmin;
	}

	public void setIsportaladmin(byte isportaladmin) {
		this.isportaladmin = isportaladmin;
	}

	public int getLand() {
		return this.land;
	}

	public void setLand(int land) {
		this.land = land;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getNachname() {
		return this.nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getOrt() {
		return this.ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlz() {
		return this.plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public byte getPwdResetNachLogin() {
		return this.pwdResetNachLogin;
	}

	public void setPwdResetNachLogin(byte pwdResetNachLogin) {
		this.pwdResetNachLogin = pwdResetNachLogin;
	}

	public byte getRole() {
		return this.role;
	}

	public void setRole(byte role) {
		this.role = role;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
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

	public byte getVerbrauchGr() {
		return this.verbrauchGr;
	}

	public void setVerbrauchGr(byte verbrauchGr) {
		this.verbrauchGr = verbrauchGr;
	}

	public byte getVerrechnungAnKd() {
		return this.verrechnungAnKd;
	}

	public void setVerrechnungAnKd(byte verrechnungAnKd) {
		this.verrechnungAnKd = verrechnungAnKd;
	}

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getZeile1() {
		return this.zeile1;
	}

	public void setZeile1(String zeile1) {
		this.zeile1 = zeile1;
	}

	public String getZeile2() {
		return this.zeile2;
	}

	public void setZeile2(String zeile2) {
		this.zeile2 = zeile2;
	}
}