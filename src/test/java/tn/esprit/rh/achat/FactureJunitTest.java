package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tn.esprit.rh.achat.entities.Facture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Date;

public class FactureJunitTest {
    private Facture facture;

    @BeforeEach
    public void setUp() {
        facture = new Facture();
        facture.setIdFacture(1L);
        facture.setMontantRemise(100.0f);
        facture.setMontantFacture(1000.0f);
        facture.setDateCreationFacture(new Date());
        facture.setDateDerniereModificationFacture(new Date());
        facture.setArchivee(false);
    }

    @Test
    public void testFactureId() {
        assertEquals(1L, facture.getIdFacture());
    }

    @Test
    public void testMontantRemise() {
        assertEquals(100.0f, facture.getMontantRemise(), 0.001);
    }
//comm
    //mmmmmmmmmmmmmmmmmmmmmmmmmmm
    @Test
    public void testMontantFacture() {
        assertEquals(1000.0f, facture.getMontantFacture(), 0.001);
    }

    @Test
    public void testDateCreationFacture() {
        assertNotNull(facture.getDateCreationFacture());
    }

    @Test
    public void testDateDerniereModificationFacture() {
        assertNotNull(facture.getDateDerniereModificationFacture());
    }

    @Test
    public void testArchivee() {
        assertEquals(false, facture.getArchivee());
    }
}
