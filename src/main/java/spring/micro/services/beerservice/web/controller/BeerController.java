package spring.micro.services.beerservice.web.controller;

/*
 * Created by Nibir Hossain on 10.08.20
 */

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.micro.services.beerservice.services.BeerService;
import spring.micro.services.beerservice.web.model.BeerDto;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = {"/api/v1/beer"})
public class BeerController {

    private final BeerService beerService;

    @GetMapping(value = {"/{beerId}"})
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(this.beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody @Validated BeerDto beerDto) {
        return new ResponseEntity(this.beerService.saveBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping(value = {"/{beerId}"})
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @Validated @RequestBody BeerDto beerDto) {
        return new ResponseEntity(this.beerService.updateBeer(beerId,  beerDto), HttpStatus.NO_CONTENT);
    }
}
