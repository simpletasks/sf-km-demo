package hr.krunoslav.magazin.sfshop.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the lockings database table.
 * 
 */
@Embeddable
public class LockingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String keyvalue;

	private String tablename;

	public LockingPK() {
	}
	public String getKeyvalue() {
		return this.keyvalue;
	}
	public void setKeyvalue(String keyvalue) {
		this.keyvalue = keyvalue;
	}
	public String getTablename() {
		return this.tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LockingPK)) {
			return false;
		}
		LockingPK castOther = (LockingPK)other;
		return 
			this.keyvalue.equals(castOther.keyvalue)
			&& this.tablename.equals(castOther.tablename);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.keyvalue.hashCode();
		hash = hash * prime + this.tablename.hashCode();
		
		return hash;
	}
}