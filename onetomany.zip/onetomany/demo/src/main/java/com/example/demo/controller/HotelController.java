package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Hotel;
import com.example.demo.service.HotelService;

@RestController
public class HotelController
{
    @Autowired
    private HotelService hotelService;

    @PostMapping("/hotel")
    public Hotel create(@RequestBody Hotel hotel)
    {
        return hotelService.saveHotel(hotel);
    }

    @GetMapping("/hotel/{id}")
    public Hotel gettingHotel(@PathVariable int id)
    {
        return hotelService.getingHotel(id);
    }

    @GetMapping("/get")
    public List<Hotel> getHotel()
    {
        return hotelService.getHotel();
    }

    @GetMapping("/api/hotel/{offset}/{pagesize}")
    public ResponseEntity<List<Hotel>> getMethodName(@PathVariable("offset") int offset,@PathVariable("pagesize") int size) {
        List<Hotel> list = hotelService.getPaginationHotels(offset,size);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


    @GetMapping("/api/hotel/sortBy/{field}")
    public ResponseEntity<List<Hotel>> getMethodName(@PathVariable("field") String field) {
        List<Hotel> list = hotelService.getSortedHotels(field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/api/hoteel/hotelName{hotelName}")
    public ResponseEntity<List<Hotel>> getpropertyType(@PathVariable("hotelName") String hotelName)
     {
        List<Hotel> list=hotelService.getByhotelName(hotelName);
        if(list.size() == 0)
            return new ResponseEntity<>(list,HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/getall")
    public List<Hotel> getHotels()
    {
        return hotelService.allHotels();
    }
    
}
