package tn.esprit.rh.achat.services;

import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.Fournisseur;

import java.util.List;

@Service
public interface IFournisseurService {

	List<Fournisseur> retrieveAllFournisseurs();

	Fournisseur addFournisseur(Fournisseur f);

	void deleteFournisseur(Long id);

	Fournisseur updateFournisseur(Fournisseur f);

	Fournisseur retrieveFournisseur(Long id);
	
	void assignSecteurActiviteToFournisseur(Long idSecteurActivite, Long idFournisseur);

}
