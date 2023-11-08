package tn.esprit.rh.achat;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tn.esprit.rh.achat.controllers.ReglementRestController;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.services.IReglementService;
//new commentaire
// commentaire 2
@RunWith(MockitoJUnitRunner.class)
public class ReglementTest {
    @InjectMocks
    private ReglementRestController reglementController;

    @Mock
    private IReglementService reglementService;

    @Test
    public void testAddReglement() {
        // Création d'un objet Reglement de test
        Reglement reglement = new Reglement();
        reglement.setMontantPaye(100);
        reglement.setMontantRestant(50);

        // Définir le comportement de la méthode addReglement du service mock
        when(reglementService.addReglement(any(Reglement.class))).thenReturn(reglement);

        // Appeler la méthode du contrôleur
        Reglement createdReglement = reglementController.addReglement(reglement);

        // Vérifier si le Reglement renvoyé par le contrôleur correspond à celui renvoyé par le service mock
        assertEquals(reglement, createdReglement);
    }

    @Test
    public void testGetReglement() {
        // Création d'une liste de règlements de test
        List<Reglement> reglements = new ArrayList<>();
        // Ajouter des règlements à la liste (remplacez avec des objets Reglement appropriés)
        // ...

        // Définir le comportement de la méthode retrieveAllReglements du service mock
        when(reglementService.retrieveAllReglements()).thenReturn(reglements);

        // Appeler la méthode du contrôleur
        List<Reglement> retrievedReglements = reglementController.getReglement();

        // Vérifier si la liste de règlements renvoyée par le contrôleur correspond à celle renvoyée par le service mock
        assertEquals(reglements, retrievedReglements);
    }

    @Test
    public void testRetrieveReglement() {
        // Identifiant du règlement que l'on veut récupérer
        Long reglementId = 1L;

        // Création d'un objet Reglement de test
        Reglement reglement = new Reglement();
        // Initialiser les propriétés de reglement avec des valeurs appropriées
        // ...

        // Définir le comportement de la méthode retrieveReglement du service mock
        when(reglementService.retrieveReglement(reglementId)).thenReturn(reglement);

        // Appeler la méthode du contrôleur
        Reglement retrievedReglement = reglementController.retrieveReglement(reglementId);

        // Vérifier si le Reglement renvoyé par le contrôleur correspond à celui renvoyé par le service mock
        assertEquals(reglement, retrievedReglement);
    }

    @Test
    public void testRetrieveReglementByFacture() {
        // Identifiant de la facture pour laquelle on veut récupérer les règlements
        Long factureId = 1L;

        // Création d'une liste de règlements de test
        List<Reglement> reglements = new ArrayList<>();
        // Ajouter des règlements à la liste (remplacez avec des objets Reglement appropriés)
        // ...

        // Définir le comportement de la méthode retrieveReglementByFacture du service mock
        when(reglementService.retrieveReglementByFacture(factureId)).thenReturn(reglements);

        // Appeler la méthode du contrôleur
        List<Reglement> retrievedReglements = reglementController.retrieveReglementByFacture(factureId);

        // Vérifier si la liste de règlements renvoyée par le contrôleur correspond à celle renvoyée par le service mock
        assertEquals(reglements, retrievedReglements);
    }

    @Test
    public void testGetChiffreAffaireEntreDeuxDate() {
        // Dates de début et de fin pour le chiffre d'affaires
        Date startDate = new Date(); // Remplacez avec une date appropriée
        Date endDate = new Date();   // Remplacez avec une date appropriée

        // Définir le comportement de la méthode getChiffreAffaireEntreDeuxDate du service mock
        float chiffreAffaire = 1000.0f; // Remplacez avec un montant approprié
        when(reglementService.getChiffreAffaireEntreDeuxDate(startDate, endDate)).thenReturn(chiffreAffaire);

        // Appeler la méthode du contrôleur
        float retrievedChiffreAffaire = reglementController.getChiffreAffaireEntreDeuxDate(startDate, endDate);

        // Vérifier si le chiffre d'affaires renvoyé par le contrôleur correspond à celui renvoyé par le service mock
        assertEquals(chiffreAffaire, retrievedChiffreAffaire, 0.001); // Utilisation d'une tolérance pour les comparaisons de nombres flottants
    }
}
