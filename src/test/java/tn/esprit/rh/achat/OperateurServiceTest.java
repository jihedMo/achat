
package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class OperateurServiceTest {

    @Autowired
    private OperateurServiceImpl operateurService;

    @Test
    public void testAddOperateur() {
        Operateur operateur = new Operateur();
        operateur.setNom("NomTest");
        operateur.setPrenom("PrenomTest");
        operateur.setPassword("PasswordTest");

        Operateur addedOperateur = operateurService.addOperateur(operateur);

        assertNotNull(addedOperateur);
        assertNotNull(addedOperateur.getIdOperateur());
        assertEquals("NomTest", addedOperateur.getNom());
    }

    @Test
    public void testRetrieveOperateur() {
        Operateur operateur = new Operateur();
        operateur.setNom("NomTest");
        operateur.setPrenom("PrenomTest");
        operateur.setPassword("PasswordTest");

        Operateur addedOperateur = operateurService.addOperateur(operateur);

        Operateur retrievedOperateur = operateurService.retrieveOperateur(addedOperateur.getIdOperateur());

        assertNotNull(retrievedOperateur);
        assertEquals("NomTest", retrievedOperateur.getNom());
    }

    @Test
    public void testUpdateOperateur() {
        Operateur operateur = new Operateur();
        operateur.setNom("NomTest");
        operateur.setPrenom("PrenomTest");
        operateur.setPassword("PasswordTest");

        Operateur addedOperateur = operateurService.addOperateur(operateur);
        addedOperateur.setNom("NouveauNom");

        Operateur updatedOperateur = operateurService.updateOperateur(addedOperateur);

        assertNotNull(updatedOperateur);
        assertEquals("NouveauNom", updatedOperateur.getNom());
    }

    @Test
    public void testDeleteOperateur() {
        Operateur operateur = new Operateur();
        operateur.setNom("NomTest");
        operateur.setPrenom("PrenomTest");
        operateur.setPassword("PasswordTest");

        Operateur addedOperateur = operateurService.addOperateur(operateur);

        operateurService.deleteOperateur(addedOperateur.getIdOperateur());

        Operateur deletedOperateur = operateurService.retrieveOperateur(addedOperateur.getIdOperateur());

        assertNull(deletedOperateur);
    }
}
