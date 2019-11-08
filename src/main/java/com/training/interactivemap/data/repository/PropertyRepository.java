package com.training.interactivemap.data.repository;

import com.training.interactivemap.data.entity.Property;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends PagingAndSortingRepository<Property, Integer> {
    @Query(value = "SELECT count(p) FROM property p", nativeQuery = true)
    int numberOfRows();
}