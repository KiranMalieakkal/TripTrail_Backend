package com.kiran.triptrail.country.repository;

import com.kiran.triptrail.country.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface JpaCountryRepository extends CrudRepository<Country,Long> {
}
