package hr.krunoslav.magazin.sfshop.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zugriffsbegrenzung database table.
 * 
 */
@Entity
@Table(name="zugriffsbegrenzung")
@NamedQuery(name="Zugriffsbegrenzung.findAll", query="SELECT z FROM Zugriffsbegrenzung z")
public class Zugriffsbegrenzung implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@ManyToOne
	@JoinColumn(name="objekt_id")
	private Objekte objekte;

	@ManyToOne
	private User user;

	public Zugriffsbegrenzung() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Objekte getObjekte() {
		return this.objekte;
	}

	public void setObjekte(Objekte objekte) {
		this.objekte = objekte;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}