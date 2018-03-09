package tn.tracking.gps.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nameClt;

	@OneToMany(mappedBy = "client")
	private Set<Voiture> voitures = new HashSet<Voiture>(0);;

	public Client() {

	}

	public Client(String nameClt) {
		super();
		this.nameClt = nameClt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameClt() {
		return nameClt;
	}

	public void setNameClt(String nameClt) {
		this.nameClt = nameClt;
	}

	public Set<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(Set<Voiture> voitures) {
		this.voitures = voitures;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nameClt=" + nameClt + ", voitures="
				+ voitures + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nameClt == null) ? 0 : nameClt.hashCode());
		result = prime * result
				+ ((voitures == null) ? 0 : voitures.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nameClt == null) {
			if (other.nameClt != null)
				return false;
		} else if (!nameClt.equals(other.nameClt))
			return false;
		if (voitures == null) {
			if (other.voitures != null)
				return false;
		} else if (!voitures.equals(other.voitures))
			return false;
		return true;
	}

}
