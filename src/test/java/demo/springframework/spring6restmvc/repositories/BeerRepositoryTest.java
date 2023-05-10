package demo.springframework.spring6restmvc.repositories;

import demo.springframework.spring6restmvc.bootstrap.BootstrapData;
import demo.springframework.spring6restmvc.entities.Beer;
import demo.springframework.spring6restmvc.model.BeerStyle;
import demo.springframework.spring6restmvc.services.BeerCsvServiceImpl;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({BootstrapData.class, BeerCsvServiceImpl.class})
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void getBeerListByName() {
        List<Beer> list = beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%");

        assertThat(list.size()).isEqualTo(336);
    }

    @Test
    void saveBeerTooLong() {

        assertThrows(ConstraintViolationException.class, () -> {
            beerRepository.save(Beer.builder()
                    .beerName("New Saved Beeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeer")
                    .beerStyle(BeerStyle.ALE)
                    .upc("12345")
                    .price(new BigDecimal("11"))
                    .build());

            beerRepository.flush(); // to write immediately
        });

    }

    @Test
    void saveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                .beerName("New Saved Beer")
                .beerStyle(BeerStyle.ALE)
                .upc("12345")
                .price(new BigDecimal("11"))
                .build());

        beerRepository.flush(); // to write immediately

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}