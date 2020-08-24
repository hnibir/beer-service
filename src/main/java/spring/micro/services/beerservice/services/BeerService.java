package spring.micro.services.beerservice.services;

import org.springframework.data.domain.PageRequest;
import spring.micro.services.beerservice.web.model.BeerDto;
import spring.micro.services.beerservice.web.model.BeerPagedList;
import spring.micro.services.beerservice.web.model.BeerStyleEnum;

import java.util.UUID;

/*
 * Created by Nibir Hossain on 21.08.20
 */
public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest of, Boolean showInventoryOnHand);
}
