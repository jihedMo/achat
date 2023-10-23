package tn.esprit.rh.achat.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class FournisseurServiceImplTestMock {

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    @Mock
    private FournisseurRepository fournisseurRepository;
    @Mock
    private DetailFournisseurRepository detailFournisseurRepository;

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Créez des données fictives pour simuler les résultats du repository
        Fournisseur fournisseur1 = new Fournisseur();
        Fournisseur fournisseur2 = new Fournisseur();
        List<Fournisseur> fournisseurs = Arrays.asList(fournisseur1, fournisseur2);
        // Configurez le comportement du repository pour renvoyer les données fictives
        when(fournisseurRepository.findAll()).thenReturn(fournisseurs);
    }


    @Test
    public void testRetrieveAllFournisseurs() {
        // Appelez la méthode à tester
        List<Fournisseur> result = fournisseurService.retrieveAllFournisseurs();

        // Vérifiez que la méthode a renvoyé les données attendues
        assertEquals(2, result.size()); // Vérifiez que deux fournisseurs ont été renvoyés
    }

    @Test
    public void testAddFournisseur() {
        // Créez un objet Fournisseur fictif pour le test
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setDetailFournisseur(new DetailFournisseur());

        // Configurez le comportement simulé du fournisseurRepository
        Mockito.when(fournisseurRepository.save(Mockito.any(Fournisseur.class))).thenReturn(fournisseur);

        // Appelez la méthode à tester
        Fournisseur result = fournisseurService.addFournisseur(fournisseur);

        // Vérifiez que la méthode a renvoyé le fournisseur simulé
        assertEquals(fournisseur, result);
    }

    @Test
    public void testUpdateFournisseur() {
        // Créez un fournisseur fictif avec un détail
        Fournisseur fournisseur = new Fournisseur();
        DetailFournisseur detailFournisseur = new DetailFournisseur();
        fournisseur.setDetailFournisseur(detailFournisseur);

        // Configurez le comportement du repository pour simuler la sauvegarde du détail
        when(detailFournisseurRepository.save(detailFournisseur)).thenReturn(detailFournisseur);

        // Appelez la méthode à tester
        Fournisseur updatedFournisseur = fournisseurService.updateFournisseur(fournisseur);

        // Vérifiez que le détail a été sauvegardé
        verify(detailFournisseurRepository, times(1)).save(detailFournisseur);

        // Vérifiez que la méthode a renvoyé le fournisseur mis à jour
        assertEquals(detailFournisseur, updatedFournisseur.getDetailFournisseur());
    }

    @Test
    public void testDeleteFournisseur() {
        // Identifiant du fournisseur à supprimer
        Long fournisseurId = 1L;

        // Appelez la méthode à tester
        fournisseurService.deleteFournisseur(fournisseurId);

        // Vérifiez que la méthode deleteById a été appelée avec l'identifiant du fournisseur
        verify(fournisseurRepository, times(1)).deleteById(fournisseurId);
    }

    @Test
    public void testRetrieveFournisseur() {
        // Identifiant du fournisseur à récupérer
        Long fournisseurId = 1L;

        // Créez un objet Fournisseur fictif
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setIdFournisseur(fournisseurId);

        // Configurez le comportement du repository pour renvoyer le fournisseur fictif
        when(fournisseurRepository.findById(fournisseurId)).thenReturn(Optional.of(fournisseur));

        // Appelez la méthode à tester
        Fournisseur retrievedFournisseur = fournisseurService.retrieveFournisseur(fournisseurId);

        // Vérifiez que la méthode findById a été appelée avec l'identifiant du fournisseur
        verify(fournisseurRepository, times(1)).findById(fournisseurId);

        // Vérifiez que le fournisseur récupéré correspond au fournisseur fictif
        assertEquals(fournisseur, retrievedFournisseur);
    }



}
