package spring.micro.services.beerservice.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import spring.micro.services.beerservice.domain.Beer;

import java.util.UUID;

/*
 * Created by Nibir Hossain on 12.08.20
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
