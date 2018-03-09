package tn.tracking.gps.dto;

import java.util.ArrayList;
import java.util.List;

public class ClientDTO {

	private Long id;
	private String nameClt;
	private List<VoitureDTO> voitures = new ArrayList<VoitureDTO>(0);

	public ClientDTO() {
		super();
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

	public List<VoitureDTO> getVoitures() {
		return voitures;
	}

	public void setVoitures(List<VoitureDTO> voitures) {
		this.voitures = voitures;
	}

}
