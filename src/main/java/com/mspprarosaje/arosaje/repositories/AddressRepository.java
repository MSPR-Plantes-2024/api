package com.mspprarosaje.arosaje.repositories;

import com.mspprarosaje.arosaje.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	List<Address> findByUserId(int id);
}
