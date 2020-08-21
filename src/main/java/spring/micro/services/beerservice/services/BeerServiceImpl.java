package spring.micro.services.beerservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.micro.services.beerservice.domain.Beer;
import spring.micro.services.beerservice.repositories.BeerRepository;
import spring.micro.services.beerservice.web.controller.NotFoundException;
import spring.micro.services.beerservice.web.mappers.BeerMapper;
import spring.micro.services.beerservice.web.model.BeerDto;

import java.util.UUID;

/*
 * Created by Nibir Hossain on 21.08.20
 */

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return this.beerMapper.beerToBeerDto(this.beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setName(beerDto.getName());
        beer.setBeerStyle(beerDto.getBeerStyle());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
