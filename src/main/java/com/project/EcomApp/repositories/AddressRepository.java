package com.project.EcomApp.repositories;

import com.project.EcomApp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
