package wac.hotelapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wac.hotelapp.entity.Hotel;
import wac.hotelapp.entity.Room;
import wac.hotelapp.payload.ApiResponse;
import wac.hotelapp.payload.RoomDto;
import wac.hotelapp.repository.HotelRepository;
import wac.hotelapp.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    HotelRepository hotelRepository;

    @PostMapping
    public ApiResponse save(@RequestBody RoomDto roomReq) {
        Room room = new Room();
        room.setNumber(roomReq.getNumber());
        room.setFloor(roomReq.getFloor());
        room.setSize(roomReq.getSize());
        Optional<Hotel> hotelOptional = hotelRepository.findById(roomReq.getHotelId());
        if (!hotelOptional.isPresent()) return new ApiResponse("Data is incorrect", false);
        room.setHotel(hotelOptional.get());
        roomRepository.save(room);
        return new ApiResponse("Saved!", true);
    }

    @GetMapping
    public List<Room> getAll(){
        return roomRepository.findAll();
    }

    @GetMapping("/byHotelId/{id}")
    public  List<Room> getByHotelId(@PathVariable Integer id){
        return roomRepository.findAllByHotelId(id);
    }

    @PutMapping("/{id}")
    public ApiResponse save(@PathVariable Integer id, @RequestBody RoomDto roomReq) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()) return new ApiResponse("Data is incorrect", false);
        Room room = optionalRoom.get();
        if (roomReq.getNumber() != null) room.setNumber(roomReq.getNumber());
        if (roomReq.getFloor() != null) room.setFloor(roomReq.getFloor());
        if (roomReq.getSize() != null) room.setSize(roomReq.getSize());
        if (roomReq.getHotelId() != null) {
            Optional<Hotel> hotelOptional = hotelRepository.findById(roomReq.getHotelId());
            if (!hotelOptional.isPresent()) return new ApiResponse("Data is incorrect", false);
            room.setHotel(hotelOptional.get());
        }
        roomRepository.save(room);
        return new ApiResponse("Saved!", true);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id){
        if (roomRepository.existsById(id)) return new ApiResponse("Data is incorrect",false);
        roomRepository.existsById(id);
        return new ApiResponse("Saved!",true);
    }
}
