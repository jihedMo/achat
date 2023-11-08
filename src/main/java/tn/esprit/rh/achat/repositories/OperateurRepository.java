package tn.esprit.rh.achat.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.rh.achat.entities.Operateur;

import java.util.List;

@Repository
public interface OperateurRepository extends CrudRepository<Operateur, Long> {


}
