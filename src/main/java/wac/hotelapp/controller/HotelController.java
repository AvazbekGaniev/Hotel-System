package wac.hotelapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wac.hotelapp.entity.Hotel;
import wac.hotelapp.payload.ApiResponse;
import wac.hotelapp.repository.HotelRepository;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelRepository hotelRepository;

    @PostMapping
    public ApiResponse save(@RequestBody Hotel hotel){
        hotelRepository.save(hotel);
        return new ApiResponse("Saved!",true);
    }

    @GetMapping
    public List<Hotel> gatAll(){
        return hotelRepository.findAll();
    }

    @PutMapping("/{id}")
    public ApiResponse edit(@PathVariable Integer id,@RequestBody Hotel hotel){
        if (!hotel.getName().isEmpty()) hotelRepository.save(hotel);
        return new ApiResponse("Saved!",true);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        if (hotelRepository.existsById(id)) return new ApiResponse("Data is incorrect",false);
        hotelRepository.existsById(id);
        return new ApiResponse("Saved!",true);
    }

}
