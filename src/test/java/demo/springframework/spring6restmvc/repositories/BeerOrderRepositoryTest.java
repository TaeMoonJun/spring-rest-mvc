package demo.springframework.spring6restmvc.repositories;

import demo.springframework.spring6restmvc.bootstrap.BootstrapData;
import demo.springframework.spring6restmvc.entities.Beer;
import demo.springframework.spring6restmvc.entities.BeerOrder;
import demo.springframework.spring6restmvc.entities.BeerOrderShipment;
import demo.springframework.spring6restmvc.entities.Customer;
import demo.springframework.spring6restmvc.services.BeerCsvServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({BootstrapData.class, BeerCsvServiceImpl.class})
class BeerOrderRepositoryTest {

    @Autowired
    BeerOrderRepository beerOrderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BeerRepository beerRepository;

    Customer testCustomer;
    Beer testBeer;

    @BeforeEach
    void setUp() {
        testCustomer = customerRepository.findAll().get(0);
        testBeer = beerRepository.findAll().get(0);
    }

    @Transactional
    @Test
    void beerOrders() {
        BeerOrder beerOrder = BeerOrder.builder()
                .customerRef("Test order")
                .customer(testCustomer)
                .beerOrderShipment(BeerOrderShipment.builder()
                        .trackingNumber("track123")
                        .build())
                .build();

        BeerOrder savedBeerOrder = beerOrderRepository.save(beerOrder);

        assertThat(savedBeerOrder).isEqualTo(testCustomer.getBeerOrders().toArray()[0]);
        assertThat(savedBeerOrder).isEqualTo(savedBeerOrder.getBeerOrderShipment().getBeerOrder());
    }
}