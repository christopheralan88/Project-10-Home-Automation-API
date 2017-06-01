package com.cj.control;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ControlRepository extends PagingAndSortingRepository<Control, Long> {
}
