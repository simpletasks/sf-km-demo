package hr.krunoslav.magazin.sfshop.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the lockings database table.
 * 
 */
@Entity
@Table(name="lockings")
@NamedQuery(name="Locking.findAll", query="SELECT l FROM Locking l")
public class Locking implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LockingPK id;

	@Column(name="session_id")
	private String sessionId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date until;

	public Locking() {
	}

	public LockingPK getId() {
		return this.id;
	}

	public void setId(LockingPK id) {
		this.id = id;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getUntil() {
		return this.until;
	}

	public void setUntil(Date until) {
		this.until = until;
	}

}