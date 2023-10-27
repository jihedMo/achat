package tn.esprit.rh.achat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

@SpringBootTest

public class juinttestoperateur {
    @Autowired
    private OperateurServiceImpl operateurService;

    @Test
    @Transactional
    public void testAddOperateur() {
        // Création d'un opérateur
        Operateur operateur = new Operateur();
        operateur.setNom("John");
        operateur.setPrenom("Doe");
        operateur.setPassword("password");

        // Créez un ensemble de factures simulées
        Set<Facture> factures = new HashSet<>();
        Facture facture1 = new Facture();
        // Initialisez les propriétés de la facture si nécessaire
        factures.add(facture1);

        operateur.setFactures(factures);

        // Ajout de l'opérateur à la base de données via le service
        Operateur savedOperateur = operateurService.addOperateur(operateur);

        // Vérification de la sauvegarde et de l'ID généré
        assertNotNull(savedOperateur.getIdOperateur());

        // Vérification des valeurs
        assertEquals("John", savedOperateur.getNom());
        assertEquals("Doe", savedOperateur.getPrenom());
        assertEquals("password", savedOperateur.getPassword());

        // Vérification des factures associées
        Set<Facture> savedFactures = savedOperateur.getFactures();
        assertNotNull(savedFactures);
        assertEquals(1, savedFactures.size()); // Assurez-vous que la facture a été correctement associée.

        // Vous pouvez ajouter d'autres assertions selon vos besoins.
    }
}
