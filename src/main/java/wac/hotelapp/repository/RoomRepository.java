package wac.hotelapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wac.hotelapp.entity.Room;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
    List<Room> findAllByHotelId(Integer id);
}
