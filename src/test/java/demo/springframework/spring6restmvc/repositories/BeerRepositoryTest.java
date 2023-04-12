package demo.springframework.spring6restmvc.repositories;

import demo.springframework.spring6restmvc.entities.Beer;
import demo.springframework.spring6restmvc.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void saveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                .beerName("New Saved Beer")
                .beerStyle(BeerStyle.ALE)
                .upc("hihi")
                .price(new BigDecimal("11"))
                .build());

        beerRepository.flush(); // to write immediately

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}