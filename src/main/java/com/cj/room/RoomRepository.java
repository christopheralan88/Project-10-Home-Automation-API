package com.cj.room;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoomRepository extends PagingAndSortingRepository<Room, Long> {

}
