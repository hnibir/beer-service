package spring.micro.services.beerservice.web.controller;

/*
 * Created by Nibir Hossain on 10.08.20
 */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.micro.services.beerservice.web.model.BeerDto;

import java.util.UUID;

@RestController
@RequestMapping(value = {"/api/v1/beer"})
public class BeerController {

    @GetMapping(value = {"/{beerId}"})
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
        // TODO implementation
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto) {
        // TODO implementation
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(value = {"/{beerId}"})
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
        // TODO implementation
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
