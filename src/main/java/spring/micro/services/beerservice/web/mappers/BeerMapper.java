package spring.micro.services.beerservice.web.mappers;

/*
 * Created by Nibir Hossain on 14.08.20
 */

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import spring.micro.services.beerservice.domain.Beer;
import spring.micro.services.beerservice.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    BeerDto beerToBeerDtoWithInventory(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
