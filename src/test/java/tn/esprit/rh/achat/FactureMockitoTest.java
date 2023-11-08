package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.controllers.FactureRestController;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.services.IFactureService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactureMockitoTest {

    @InjectMocks
    private FactureRestController factureController;

    @Mock
    private IFactureService factureService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetFactures() {
        List<Facture> factures = new ArrayList<>();
        // Add some sample factures to the list

        Mockito.when(factureService.retrieveAllFactures()).thenReturn(factures);

        List<Facture> result = factureController.getFactures();

        assertEquals(factures, result);
    }

    @Test
    public void testRetrieveFacture() {
        Long factureId = 1L;
        Facture facture = new Facture();
        // Set properties for the facture

        Mockito.when(factureService.retrieveFacture(factureId)).thenReturn(facture);

        Facture result = factureController.retrieveFacture(factureId);

        assertEquals(facture, result);
    }

    @Test
    public void testAddFacture() {
        Facture factureToAdd = new Facture();
        // Set properties for the facture to add

        Mockito.when(factureService.addFacture(factureToAdd)).thenReturn(factureToAdd);

        Facture result = factureController.addFacture(factureToAdd);

        assertEquals(factureToAdd, result);
    }
}
