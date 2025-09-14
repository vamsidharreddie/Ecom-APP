package com.project.EcomApp.service;

import com.project.EcomApp.exceptions.ResourceNotFoundException;
import com.project.EcomApp.model.Address;
import com.project.EcomApp.model.User;
import com.project.EcomApp.payload.AddressDTO;
import com.project.EcomApp.repositories.AddressRepository;
import com.project.EcomApp.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    UserRepository userRepository;


    @Override
    public AddressDTO createAddress(AddressDTO addressDTO, User user) {
        Address address=modelMapper.map(addressDTO, Address.class);
        address.setUser(user);
        List<Address>addressesList=user.getAddresses();
        addressesList.add(address);
        user.setAddresses(addressesList);
        Address savedAddress=addressRepository.save(address);
       return  modelMapper.map(savedAddress, AddressDTO.class);
    }

    @Override
    public List<AddressDTO> getAddresses() {
        List<Address>addresses=addressRepository.findAll();
        return addresses.stream()
                .map(address -> modelMapper.map(address, AddressDTO.class))
                .toList();
    }

    @Override
    public AddressDTO getAddressesById(Long addressId) {
        Address address=addressRepository.findById(addressId)
                .orElseThrow(()->new ResourceNotFoundException("Address","addressId",addressId));
        return modelMapper.map(address, AddressDTO.class);
        }


    @Override
    public List<AddressDTO> getUserAddresses(User user) {
       List<Address>addresses=user.getAddresses();
       return addresses.stream().map(address -> modelMapper.map(address,AddressDTO.class)).toList();
    }

    @Override
    public AddressDTO updateAddress(Long addressId, AddressDTO addressDTO) {
        Address address=addressRepository.findById(addressId)
                .orElseThrow(()->new ResourceNotFoundException("Address","addressId",addressId));
        address.setCity(addressDTO.getCity());
        address.setPincode(addressDTO.getPincode());
        address.setState(addressDTO.getState());
        address.setCountry(addressDTO.getCountry());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingName(addressDTO.getBuildingName());
        Address savedAddress=addressRepository.save(address);
        return modelMapper.map(savedAddress,AddressDTO.class);

    }

    @Override
    public String deleteAddress(Long addressId) {
if(!addressRepository.existsById(addressId)){
    throw new ResourceNotFoundException("AddressId","addressId",addressId);
}
      addressRepository.deleteById(addressId);
      return "Address with address Id "+addressId+" deleted successfully";
    }
}
