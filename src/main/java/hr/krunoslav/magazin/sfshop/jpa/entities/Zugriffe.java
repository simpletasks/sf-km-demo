package hr.krunoslav.magazin.sfshop.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the zugriffe database table.
 * 
 */
@Entity
@Table(name="zugriffe")
@NamedQuery(name="Zugriffe.findAll", query="SELECT z FROM Zugriffe z")
public class Zugriffe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LOGIN")
	private Date login;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LOGOUT")
	private Date logout;

	@ManyToOne
	private User user;

	public Zugriffe() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getLogin() {
		return this.login;
	}

	public void setLogin(Date login) {
		this.login = login;
	}

	public Date getLogout() {
		return this.logout;
	}

	public void setLogout(Date logout) {
		this.logout = logout;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}