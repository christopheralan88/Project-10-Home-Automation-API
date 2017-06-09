package com.cj.control;


import com.cj.room.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;

public interface ControlRepository extends PagingAndSortingRepository<Control, Long> {

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Control entity);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Control save(Control entity);

}
