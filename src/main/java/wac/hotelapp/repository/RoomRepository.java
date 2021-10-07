package wac.hotelapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wac.hotelapp.entity.Hotel;
import wac.hotelapp.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
}
