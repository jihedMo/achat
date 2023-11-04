package tn.esprit.rh.spring.service;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;




@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StockTest {

    @Autowired
    IStockService stcok;

    @Test
    @Order(1)
    public void testRetreiveAllOp(){
        List<Stock> ops = stcok.retrieveAllStocks();
        Assertions.assertEquals(0, ops.size());
    }
}
