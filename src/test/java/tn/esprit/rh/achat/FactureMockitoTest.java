
package tn.esprit.rh.achat;


import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.esprit.rh.achat.controllers.FactureRestController;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.UUID;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith( SpringRunner.class)
@ContextConfiguration(classes = {FactureServiceImpl.class})
public class FactureMockitoTest {

    private FactureServiceImpl service;
    private FactureRepository repository;

    @Test
    public void getFactureTest(){
        System.out.println(" get test Facture");
        long id = java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;


        List<Facture> FactureList = new ArrayList<>();

        Facture facture1 = new Facture();
        facture1.setIdFacture(id);
        facture1.setMontantRemise(100); // Set the montantRemise to your desired value
        facture1.setMontantFacture(500);

        when(repository.findAll()).thenReturn(FactureList);

    }

}

