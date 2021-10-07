package wac.hotelapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import wac.hotelapp.entity.Hotel;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private Integer number,floor,size;
    private Integer hotelId;
}
