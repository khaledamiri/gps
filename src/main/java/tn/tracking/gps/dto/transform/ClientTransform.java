package tn.tracking.gps.dto.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import tn.tracking.gps.dto.ClientDTO;
import tn.tracking.gps.models.Client;

public final class ClientTransform {

	public static ClientDTO client2ClientDTO(Client from) {
		ClientDTO to = new ClientDTO();
		if (from != null) {
			to.setId(from.getId());
			to.setNameClt(from.getNameClt());
			to.setVoitures(VoitureTransform.voiture2voitureDTO(from.getVoitures()));
		}
		return null;

	}

	public static List<ClientDTO> client2ClientDTO(List<Client> from) {

		List<ClientDTO> to = new ArrayList<>();
		if (from != null) {
			for (Client client : from) {
				to.add(client2ClientDTO(client));
			}
			return to;
		}

		return null;

	}

	public static Page<ClientDTO> voiturepage2VoiturePageDTO(Pageable page, Page<Client> from) {
		List<ClientDTO> to = client2ClientDTO(from.getContent());
		return new PageImpl<>(to, page, from.getTotalElements());

	}

}
