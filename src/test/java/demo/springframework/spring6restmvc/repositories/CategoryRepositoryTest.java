package demo.springframework.spring6restmvc.repositories;

import demo.springframework.spring6restmvc.entities.Beer;
import demo.springframework.spring6restmvc.entities.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BeerRepository beerRepository;

    Beer testBeer;

    @BeforeEach
    void setUp() {
        testBeer = beerRepository.findAll().get(0);
    }

    @Transactional
    @Test
    void addCategory() {
        Category savedCategory1 = categoryRepository.save(Category.builder()
                .description("Ales")
                .build());

        Category savedCategory2 = categoryRepository.save(Category.builder()
                .description("Lagers")
                .build());

        Beer testBeer2 = beerRepository.findAll().get(1);

        testBeer.addCategory(savedCategory1);
        testBeer.addCategory(savedCategory2);
        Beer savedBeer1 = beerRepository.save(testBeer);

        testBeer2.addCategory(savedCategory1);
        Beer savedBeer2 = beerRepository.save(testBeer2);

        System.out.println(savedBeer1.getCategories().size());
        System.out.println(savedBeer2.getCategories().size());
        System.out.println(savedCategory1.getBeers().size());
        System.out.println(savedCategory2.getBeers().size());

    }
}