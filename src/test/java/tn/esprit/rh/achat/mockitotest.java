package tn.esprit.rh.achat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class mockitotest {
    @InjectMocks
    private OperateurServiceImpl operateurService;

    @Mock
    private OperateurRepository operateurRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddOperateur() {
        // Créer un objet Operateur simulé
        Operateur operateur = new Operateur();
        operateur.setNom("John");
        operateur.setPrenom("Doe");

        // Simuler le comportement de operateurRepository.save
        when(operateurRepository.save(operateur)).thenReturn(operateur);

        // Appeler la méthode que vous voulez tester
        Operateur result = operateurService.addOperateur(operateur);

        // Vérifier que operateurRepository.save a été appelé une fois
        verify(operateurRepository).save(operateur);

        // Vérifier que le résultat de la méthode est le même que l'objet simulé
        assertEquals(operateur, result);
    }

}
