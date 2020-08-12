package spring.micro.services.beerservice.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.micro.services.beerservice.domain.Beer;
import spring.micro.services.beerservice.repositories.BeerRepository;

import java.math.BigDecimal;

/*
 * Created by Nibir Hossain on 12.08.20
 */

@Component
@Slf4j
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(this.beerRepository.count() == 0) {
            this.beerRepository.save(Beer.builder()
                    .name("Radler")
                    .style("Pilz")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(12345L)
                    .price(new BigDecimal("12.0"))
                    .build()
            );

            this.beerRepository.save(Beer.builder()
                    .name("Krombacher")
                    .style("Krombacher")
                    .quantityToBrew(200)
                    .minOnHand(11)
                    .upc(12344L)
                    .price(new BigDecimal("14.0"))
                    .build()
            );
        }
       log.info("Loaded Beers: " + this.beerRepository.count());
    }
}
