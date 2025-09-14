package com.project.EcomApp.service;

import com.project.EcomApp.model.Address;
import com.project.EcomApp.model.User;
import com.project.EcomApp.payload.AddressDTO;

import java.util.List;

public interface AddressService {
  AddressDTO createAddress(AddressDTO addressDTO, User user);
  List<AddressDTO>getAddresses();
  AddressDTO getAddressesById(Long addressId);
  List<AddressDTO>getUserAddresses(User user);
  AddressDTO updateAddress(Long addressId, AddressDTO addressDTO);
  String deleteAddress(Long addressId);
}
