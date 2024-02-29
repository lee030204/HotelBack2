package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Hotel;
import com.example.demo.repository.HotelRepository;

@Service
public class HotelService 
{
    @Autowired
    private HotelRepository hotelRepository;

    public Hotel saveHotel(Hotel hotel)
    {
        return hotelRepository.save(hotel);
    }

    public Hotel getingHotel(int id)
    {
        return hotelRepository.findById(id).orElse(null);
    }


    public List<Hotel> getHotel()
    {
        return hotelRepository.findAll();
    }


    public List<Hotel> getPaginationHotels(int offset,int size)
    {
        return hotelRepository.findAll(PageRequest.of(offset, size)).getContent();                        
    }
    public List<Hotel> getSortedHotels(String field)
    {
        return hotelRepository.findAll(Sort.by(field));
        // return hotelRepository.findAll(Sort.by(Sort.Direction.DESC,field));
    }

    public List<Hotel> getByhotelName(String hotelName)
    {
        return hotelRepository.findByHotelName(hotelName);
    }



    public List<Hotel> allHotels()
    {
        return hotelRepository.findAll();
    }
}
