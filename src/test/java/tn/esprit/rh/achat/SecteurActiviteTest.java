package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {SecteurActiviteServiceImpl.class})
@ExtendWith(SpringExtension.class)
class SecteurActiviteTest {

    @MockBean
    private SecteurActiviteRepository secteurActiviteRepository;

    @InjectMocks
    @Autowired
    private SecteurActiviteServiceImpl secteurActiviteService;

    @Test
    void testAddSecteurActivite() {

        SecteurActivite secteurActiviteToAdd = new SecteurActivite();
        secteurActiviteToAdd.setCodeSecteurActivite("NouveauCode");
        secteurActiviteToAdd.setLibelleSecteurActivite("NouveauLibelle");
        when(secteurActiviteRepository.save(secteurActiviteToAdd)).thenReturn(secteurActiviteToAdd);
        SecteurActivite addedSecteurActivite = secteurActiviteService.addSecteurActivite(secteurActiviteToAdd);
        verify(secteurActiviteRepository).save(secteurActiviteToAdd);

    }

    @Test
    void testRetrieveAllSecteurActivity() {
        List<SecteurActivite> secteurActiviteList = new ArrayList<>();
        when(secteurActiviteRepository.findAll()).thenReturn(secteurActiviteList);

        List<SecteurActivite> actualRetrieveAllSecteurActiviteResult = secteurActiviteService.retrieveAllSecteurActivite();

        assertEquals(secteurActiviteList, actualRetrieveAllSecteurActiviteResult);
        assertEquals(0, actualRetrieveAllSecteurActiviteResult.size());

        verify(secteurActiviteRepository).findAll();
    }
    @Test
    void testRetrieveSecteurActivite() {
        Long secteurActiviteId = 1L;
        SecteurActivite secteurActiviteToRetrieve = new SecteurActivite();
        secteurActiviteToRetrieve.setIdSecteurActivite(secteurActiviteId);
        when(secteurActiviteRepository.findById(secteurActiviteId)).thenReturn(Optional.of(secteurActiviteToRetrieve));
        SecteurActivite retrievedSecteurActivite = secteurActiviteService.retrieveSecteurActivite(secteurActiviteId);
        assertEquals(secteurActiviteToRetrieve, retrievedSecteurActivite);
        verify(secteurActiviteRepository).findById(secteurActiviteId);
    }

    @Test
    void testUpdateSecteurActivite() {
        SecteurActivite secteurActiviteToUpdate = new SecteurActivite();
        secteurActiviteToUpdate.setIdSecteurActivite(1L);
        secteurActiviteToUpdate.setCodeSecteurActivite("NouveauCode");
        secteurActiviteToUpdate.setLibelleSecteurActivite("NouveauLibelle");
        when(secteurActiviteRepository.save(secteurActiviteToUpdate)).thenReturn(secteurActiviteToUpdate);
        SecteurActivite updatedSecteurActivite = secteurActiviteService.updateSecteurActivite(secteurActiviteToUpdate);
        verify(secteurActiviteRepository).save(secteurActiviteToUpdate);

    }

    @Test
    void testDeleteSecateursActivity() {
        long idToDelete = 123L;
        secteurActiviteService.deleteSecteurActivite(idToDelete);

        verify(secteurActiviteRepository).deleteById(idToDelete);
    }
}
