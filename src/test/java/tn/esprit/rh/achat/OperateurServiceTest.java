package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OperateurServiceTest {

    @Autowired
    private OperateurServiceImpl operateurService;

    @Test
    @Transactional
    public void testCrudOperations() {
        // Créer un nouvel opérateur
        Operateur operateur = new Operateur();
        operateur.setNom("gamra");
        operateur.setPrenom("benmarzouka");
        operateur.setPassword("password");

        // Ajouter l'opérateur
        operateurService.addOperateur(operateur);

        // Lire l'opérateur depuis la base de données
        Operateur retrievedOperateur = operateurService.retrieveOperateur(operateur.getIdOperateur());
        assertNotNull(retrievedOperateur);
        assertEquals("gamra", retrievedOperateur.getNom());

        // Mettre à jour l'opérateur
        retrievedOperateur.setNom("Jane");
        operateurService.updateOperateur(retrievedOperateur);

        // Lire l'opérateur mis à jour depuis la base de données
        Operateur updatedOperateur = operateurService.retrieveOperateur(retrievedOperateur.getIdOperateur());
        assertNotNull(updatedOperateur);
        assertEquals("Jane", updatedOperateur.getNom());

        // Supprimer l'opérateur
        operateurService.deleteOperateur(updatedOperateur.getIdOperateur());

        // Vérifier si l'opérateur a été supprimé
        Operateur deletedOperateur = operateurService.retrieveOperateur(updatedOperateur.getIdOperateur());
        assertNull(deletedOperateur);
    }
}
