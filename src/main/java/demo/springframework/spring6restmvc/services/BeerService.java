package demo.springframework.spring6restmvc.services;

import demo.springframework.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<Beer> listBeers();

    Beer getBeerByID(UUID uuid);

    Beer saveNewBeer(Beer beer);

    void updateBeerById(UUID beerId, Beer beer);
}
