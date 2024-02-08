package com.mspprarosaje.arosaje.services;

import com.mspprarosaje.arosaje.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> getAddresses();
    Optional<Address> getAddressById(int id);
    Address saveAddress(Address address, int userId);
    boolean existsById(Integer id);
    void deleteById(Integer id);
}
