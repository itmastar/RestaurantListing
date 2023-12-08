package com.tdemo.restaurant.listing.service;

import com.tdemo.restaurant.listing.mapper.RestaurantMapper;
import com.tdemo.restaurant.listing.dto.RestaurantDTO;
import com.tdemo.restaurant.listing.entity.Restaurant;
import com.tdemo.restaurant.listing.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;
    public List<RestaurantDTO> findAllRestaurants() {
    List<Restaurant> restaurants= restaurantRepo.findAll();

        return restaurants.stream().map(RestaurantMapper.INSTANCE::mapRestauranttoRestaurantDTO).toList();
    }

    public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
       Restaurant restaurantAdded= restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOtoRestaurant(restaurantDTO));
        return RestaurantMapper.INSTANCE.mapRestauranttoRestaurantDTO(restaurantAdded);
    }

    public ResponseEntity<RestaurantDTO> findRestaurantById(int id) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        return restaurant.map(value -> new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestauranttoRestaurantDTO(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }
}
