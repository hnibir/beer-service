package spring.micro.services.beerservice.services.inventory;

import java.util.UUID;

/*
 * Created by Nibir Hossain on 21.08.20
 */
public interface BeerInventoryService {
    Integer getOnHandInventory(UUID beerId);
}
