package com.mspprarosaje.arosaje.services.impl;

import com.mspprarosaje.arosaje.model.Address;
import com.mspprarosaje.arosaje.repositories.AddressRepository;
import com.mspprarosaje.arosaje.services.AddressService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> getAddressById(Integer id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address saveAddress(Address address, int userId) {
        return this.addressRepository.save(address);
    }

    @Override
    public boolean existsById(Integer id) {
        return this.addressRepository.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        this.addressRepository.deleteById(id);
    }
}
