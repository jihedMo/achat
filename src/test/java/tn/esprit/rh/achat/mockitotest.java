package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class mockitotest {
    @InjectMocks
    private OperateurServiceImpl operateurService;

    @Mock
    private OperateurRepository operateurRepository;

    @Test
    public void testCreateOperateur() {
        Operateur operateur = new Operateur();
        operateur.setNom("John");
        operateur.setPrenom("Doe");
        operateur.setPassword("password");

        when(operateurRepository.save(operateur)).thenReturn(operateur);

        Operateur savedOperateur = operateurService.addOperateur(operateur);

        assertNotNull(savedOperateur);
        assertEquals("John", savedOperateur.getNom());
        assertEquals("Doe", savedOperateur.getPrenom());

        verify(operateurRepository, times(1)).save(operateur);
    }

    @Test
    public void testRetrieveOperateur() {
        Long operateurId = 1L;
        Operateur operateur = new Operateur();
        operateur.setIdOperateur(operateurId);
        operateur.setNom("John");

        when(operateurRepository.findById(operateurId)).thenReturn(java.util.Optional.of(operateur));

        Operateur retrievedOperateur = operateurService.retrieveOperateur(operateurId);

        assertNotNull(retrievedOperateur);
        assertEquals(operateurId, retrievedOperateur.getIdOperateur());
        assertEquals("John", retrievedOperateur.getNom());

        verify(operateurRepository, times(1)).findById(operateurId);
    }



    @Test
    public void testDeleteOperateur() {
        // Identifiant de l'opérateur à supprimer
        Long operateurId = 1L;

        // Appelez la méthode à tester
        operateurService.deleteOperateur(operateurId);

        // Vérifiez que la méthode deleteById a été appelée avec l'identifiant de l'opérateur
        verify(operateurRepository, times(1)).deleteById(operateurId);
    }

}
