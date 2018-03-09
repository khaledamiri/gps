package tn.tracking.gps.dto.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import tn.tracking.gps.dto.VoitureDTO;
import tn.tracking.gps.models.Voiture;

public final class VoitureTransform {

	public static VoitureDTO voiture2VoitureDTO(Voiture from) {

		VoitureDTO to = new VoitureDTO();
		if (from != null) {
			to.setId(from.getId());
			to.setMatricule(from.getMatricule());
			to.setClient(ClientTransform.client2ClientDTO(from.getClient()));

		}
		return null;

	}

	public static List<VoitureDTO> voiture2voitureDTO(List<Voiture> from) {
		List<VoitureDTO> to = new ArrayList<VoitureDTO>();
		if (from != null) {
			for (Voiture voiture : from) {
				to.add(voiture2VoitureDTO(voiture));
			}
			return to;
		}
		return null;
	}

	public static Page<VoitureDTO> voiturePage2voiturePageDTO(Pageable page, Page<Voiture> from) {
		List<VoitureDTO> to = voiture2voitureDTO(from.getContent());
		return new PageImpl<>(to, page, from.getTotalElements());
	}

}
