package tn.esprit.rh.achat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class operateurtest {
    @InjectMocks
    private OperateurServiceImpl operateurService;

    @Mock
    private OperateurRepository operateurRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

    }


    @Test
    public void testRetrieveAllOperateurs() {
        // Créez des exemples d'opérateurs pour simuler les données de la base de données
        Operateur operateur1 = new Operateur();
        operateur1.setIdOperateur(1L);
        operateur1.setNom("John");
        operateur1.setPrenom("Doe");

        Operateur operateur2 = new Operateur();
        operateur2.setIdOperateur(2L);
        operateur2.setNom("Jane");
        operateur2.setPrenom("Smith");

        List<Operateur> operateurList = new ArrayList<>();
        operateurList.add(operateur1);
        operateurList.add(operateur2);

        // Configurez le mock pour retourner la liste simulée lorsque findAll est appelé
        when(operateurRepository.findAll()).thenReturn(operateurList);

        // Appelez la méthode à tester
        List<Operateur> result = operateurService.retrieveAllOperateurs();

        // Vérifiez que le résultat de la méthode est le même que la liste simulée
        assertEquals(operateurList, result);
    }

    @Test
    public void testDeleteOperateur() {
        // ID de l'opérateur à supprimer
        Long operateurId = 1L;

        // Appelez la méthode à tester
        operateurService.deleteOperateur(operateurId);

        // Vérifiez que l'opérateur a été supprimé en vérifiant que le repository n'a pas l'opérateur après l'appel de deleteOperateur.


    }
    @Before
    public void setUp() {
        operateurRepository = mock(OperateurRepository.class); // Crée un mock du repository

    }
    @Test
    public void testRetrieveOperateurWithValidId() {
        // Créez un objet Operateur factice pour le test
        Operateur operateurFactice = new Operateur();
        operateurFactice.setIdOperateur(1L);
        operateurFactice.setNom("John");
        operateurFactice.setPrenom("Doe");

        // Définissez le comportement du mock du repository lorsqu'il est appelé
        when(operateurRepository.findById(1L)).thenReturn(Optional.of(operateurFactice));

        // Appelez la méthode à tester
        Operateur resultat = operateurService.retrieveOperateur(1L);

        // Assurez-vous que le résultat est correct
        assertEquals(1L, (long) resultat.getIdOperateur());
        assertEquals("John", resultat.getNom());
        assertEquals("Doe", resultat.getPrenom());

        // Vérifiez que la méthode du repository a été appelée
        verify(operateurRepository, times(1)).findById(1L);
    }


    @Test
    public void testAddOperateur() {
        // Créez un objet Operateur factice pour le test
        Operateur operateurFactice = new Operateur();
        operateurFactice.setNom("John");
        operateurFactice.setPrenom("Doe");

        // Définissez le comportement du mock du repository lorsqu'il est appelé
        when(operateurRepository.save(operateurFactice)).thenReturn(operateurFactice);

        // Appelez la méthode à tester
        Operateur resultat = operateurService.addOperateur(operateurFactice);

        // Vérifiez que le résultat est le même que l'objet passé à la méthode
        assertEquals(operateurFactice, resultat);

        // Vérifiez que la méthode du repository a été appelée
        verify(operateurRepository, times(1)).save(operateurFactice);
    }
    @Test
    public void testUpdateOperateur() {
        Operateur operateurFactice = new Operateur();
        operateurFactice.setIdOperateur(1L);
        operateurFactice.setNom("John");
        operateurFactice.setPrenom("Doe");

        // Appel de la méthode à tester
        Operateur resultat = operateurService.updateOperateur(operateurFactice);

        // Vérifiez que la méthode save du repository a été appelée avec l'opérateur factice en argument
        verify(operateurRepository, times(1)).save(operateurFactice);

        // Vérifiez que le résultat est le même que l'opérateur factice
        assertEquals(operateurFactice, resultat);
    }

}
