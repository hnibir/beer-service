package spring.micro.services.beerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/*
 * Created by Nibir Hossain on 10.08.20
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    private UUID id;
    private Integer version;
    private OffsetDateTime createdDate;
    private String name;
    private BeerStyleEnum beerStyle;
    private Long upc;
    private BigDecimal price;
    private Integer quantityOnHand;
}