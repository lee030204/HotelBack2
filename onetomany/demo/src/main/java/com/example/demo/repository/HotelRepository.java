package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer>{

    @Query("SELECT h FROM Hotel h WHERE hotelName=?1")
     List<Hotel> findByHotelName(String hotelName);

     
}