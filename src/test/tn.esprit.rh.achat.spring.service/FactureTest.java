import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.services.IFactureService;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FactureTest {

    @Autowired
    IFactureService facture;

    @Test
    @Order(1)
    public void testRetreiveAllOp(){
        List<facture> ops = facture.retrieveAllFactures();
        Assertions.assertEquals(0, ops.size());
    }
}