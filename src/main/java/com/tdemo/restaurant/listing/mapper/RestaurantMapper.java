package com.tdemo.restaurant.listing.mapper;

import com.tdemo.restaurant.listing.dto.RestaurantDTO;
import com.tdemo.restaurant.listing.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE= Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDTOtoRestaurant(RestaurantDTO restaurantDTO);
    RestaurantDTO mapRestauranttoRestaurantDTO(Restaurant restaurant);
}
