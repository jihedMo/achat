
package tn.esprit.rh.achat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith( SpringRunner.class)
@ContextConfiguration(classes = {StockServiceImpl.class})
public class StockMockitoTest {

    private StockServiceImpl service;
    private StockRepository repository;


    @Test
    public void getStockTest(){
        System.out.println(" get test stock");
        long id = java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        long id2 = java.util.UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

        repository = mock(StockRepository.class);
        service = new StockServiceImpl(repository);

        List<Stock> stockList = new ArrayList<>();
        stockList.add(new Stock(id,"alimentaire",100,5));
        stockList.add(new Stock(id2,"vest",50,10));
        when(repository.findAll()).thenReturn(stockList);

    }

}

