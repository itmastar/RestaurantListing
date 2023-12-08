package com.tdemo.restaurant.listing.controller;

import com.tdemo.restaurant.listing.dto.RestaurantDTO;
import com.tdemo.restaurant.listing.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/findAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> findAllRestaurants(){
        return new ResponseEntity<>(restaurantService.findAllRestaurants(), HttpStatus.OK);
    }

    @GetMapping("/fetchRestaurantById/{id}")
    public ResponseEntity<RestaurantDTO> findRestaurantById(@PathVariable int id){
        return restaurantService.findRestaurantById(id);
    }

    @PostMapping("saveRestaurant")
    public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        RestaurantDTO restaurantAdded=restaurantService.addRestaurantInDB(restaurantDTO);
        return new ResponseEntity<>(restaurantAdded,HttpStatus.CREATED);
    }
}
