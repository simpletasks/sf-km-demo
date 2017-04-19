package hr.krunoslav.magazin.sfshop.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the objekte database table.
 * 
 */
@Entity
@Table(name="objekte")
@NamedQuery(name="Objekte.findAll", query="SELECT o FROM Objekte o")
public class Objekte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger id;

	@Column(name="AL")
	private BigInteger al;

	@Column(name="BOL")
	private BigInteger bol;

	@Column(name="INAKTIV")
	private boolean inaktiv;

	@Column(name="KUNDENMAIL_BEI_BEST")
	private byte kundenmailBeiBest;

	@Column(name="MAILSHOP1")
	private String mailshop1;

	@Column(name="MAILSHOP2")
	private String mailshop2;

	@Column(name="MAILSHOP3")
	private String mailshop3;

	@Column(name="MOL")
	private BigInteger mol;

	@Column(name="NAME2")
	private String name2;

	@Column(name="NAME3")
	private String name3;

	@Column(name="OBJENAME")
	private String objename;

	@Column(name="OBJENR")
	private BigInteger objenr;

	@Column(name="OL")
	private BigInteger ol;

	@Column(name="PROJNR2")
	private String projnr2;

	@Column(name="REFOBJENR")
	private BigInteger refobjenr;

	@Column(name="RL")
	private BigInteger rl;

	@ManyToOne
	@JoinColumn(name="ArtikelSet_ID")
	private Artikelset artikelset;


	public Objekte() {
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getAl() {
		return this.al;
	}

	public void setAl(BigInteger al) {
		this.al = al;
	}

	public BigInteger getBol() {
		return this.bol;
	}

	public void setBol(BigInteger bol) {
		this.bol = bol;
	}

	public boolean getInaktiv() {
		return this.inaktiv;
	}

	public void setInaktiv(boolean inaktiv) {
		this.inaktiv = inaktiv;
	}

	public byte getKundenmailBeiBest() {
		return this.kundenmailBeiBest;
	}

	public void setKundenmailBeiBest(byte kundenmailBeiBest) {
		this.kundenmailBeiBest = kundenmailBeiBest;
	}

	public String getMailshop1() {
		return this.mailshop1;
	}

	public void setMailshop1(String mailshop1) {
		this.mailshop1 = mailshop1;
	}

	public String getMailshop2() {
		return this.mailshop2;
	}

	public void setMailshop2(String mailshop2) {
		this.mailshop2 = mailshop2;
	}

	public String getMailshop3() {
		return this.mailshop3;
	}

	public void setMailshop3(String mailshop3) {
		this.mailshop3 = mailshop3;
	}

	public BigInteger getMol() {
		return this.mol;
	}

	public void setMol(BigInteger mol) {
		this.mol = mol;
	}

	public String getName2() {
		return this.name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getName3() {
		return this.name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public String getObjename() {
		return this.objename;
	}

	public void setObjename(String objename) {
		this.objename = objename;
	}

	public BigInteger getObjenr() {
		return this.objenr;
	}

	public void setObjenr(BigInteger objenr) {
		this.objenr = objenr;
	}

	public BigInteger getOl() {
		return this.ol;
	}

	public void setOl(BigInteger ol) {
		this.ol = ol;
	}

	public String getProjnr2() {
		return this.projnr2;
	}

	public void setProjnr2(String projnr2) {
		this.projnr2 = projnr2;
	}

	public BigInteger getRefobjenr() {
		return this.refobjenr;
	}

	public void setRefobjenr(BigInteger refobjenr) {
		this.refobjenr = refobjenr;
	}

	public BigInteger getRl() {
		return this.rl;
	}

	public void setRl(BigInteger rl) {
		this.rl = rl;
	}


	public Artikelset getArtikelset() {
		return this.artikelset;
	}

	public void setArtikelset(Artikelset artikelset) {
		this.artikelset = artikelset;
	}
}