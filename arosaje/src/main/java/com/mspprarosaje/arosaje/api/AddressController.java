package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.address.AddressCreateDTO;
import com.mspprarosaje.arosaje.api.dto.address.AddressDTO;
import com.mspprarosaje.arosaje.api.dto.address.AddressUpdateDTO;
import com.mspprarosaje.arosaje.api.mappers.address.AddressCreateMapper;
import com.mspprarosaje.arosaje.api.mappers.address.AddressMapper;
import com.mspprarosaje.arosaje.api.mappers.address.AddressUpdateMapper;
import com.mspprarosaje.arosaje.model.Address;
import com.mspprarosaje.arosaje.model.User;
import com.mspprarosaje.arosaje.services.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
@Slf4j
public class AddressController {
    private final AddressService addressService;
    private final AddressMapper addressMapper;
    private final AddressCreateMapper addressCreateMapper;
    private final AddressUpdateMapper addressUpdateMapper;

    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAddresses(){
        return ResponseEntity.ok(addressMapper.toDtos(addressService.getAddresses()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable() int id) {
        return ResponseEntity.of(this.addressService.getAddressById(id).map(this.addressMapper::toDto));
    }

    @PostMapping()
    public ResponseEntity<AddressCreateDTO> saveAddress(@RequestBody AddressCreateDTO addressCreateDTO) {
        Address createdAddress = addressService.saveAddress(
                this.addressCreateMapper.fromDto(addressCreateDTO),
                addressCreateDTO.getUser().getId()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(this.addressCreateMapper.toDto(createdAddress));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressUpdateDTO> updateAddress(@PathVariable Integer id,
                                                          @RequestBody AddressUpdateDTO addressUpdateDTO){
        if (!id.equals(addressUpdateDTO.getId())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }

        if (!this.addressService.existsById(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        Address updatedAddress = addressService.saveAddress(this.addressUpdateMapper.fromDto(addressUpdateDTO), addressUpdateDTO.getUser().getId());
        return ResponseEntity.ok(this.addressUpdateMapper.toDto(updatedAddress));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable() Integer id){
        if(!this.addressService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.addressService.deleteById(id);
        if(this.addressService.existsById(id)){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
