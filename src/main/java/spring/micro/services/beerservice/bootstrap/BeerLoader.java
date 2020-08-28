package spring.micro.services.beerservice.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.micro.services.beerservice.domain.Beer;
import spring.micro.services.beerservice.repositories.BeerRepository;
import spring.micro.services.beerservice.web.model.BeerStyleEnum;

import java.math.BigDecimal;

/*
 * Created by Nibir Hossain on 12.08.20
 */

@Component
@Slf4j
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) {
        if(this.beerRepository.count() == 0) {
            loadBeerObjects();
        }
    }

    private void loadBeerObjects() {
        if(this.beerRepository.count() == 0) {
            this.beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle(BeerStyleEnum.IPA.name())
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal("12.0"))
                    .build()
            );

            this.beerRepository.save(Beer.builder()
                    .beerName("Krombacher")
                    .beerStyle(BeerStyleEnum.PORTER.name())
                    .quantityToBrew(200)
                    .minOnHand(11)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("14.0"))
                    .build()
            );

            this.beerRepository.save(Beer.builder()
                    .beerName("Radler")
                    .beerStyle(BeerStyleEnum.PALE_ALE.name())
                    .quantityToBrew(200)
                    .minOnHand(11)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal("14.0"))
                    .build()
            );
        }
       log.info("Loaded Beers: " + this.beerRepository.count());
    }
}
