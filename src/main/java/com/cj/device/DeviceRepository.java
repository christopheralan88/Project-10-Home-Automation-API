package com.cj.device;

import com.cj.control.Control;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;


public interface DeviceRepository extends PagingAndSortingRepository<Device, Long> {

    //Must use Device field "name" in method name "findByNameContaining" in order for Spring to wire correctly.
    @RestResource(rel = "name-contains", path = "containsName")
    Page<Device> findByNameContaining(@Param("name") String name, Pageable page);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Device save(Device entity);

}
