package com.dave.lombok;

import com.dave.model.Address;
import lombok.Builder;

public class AddressBuilders {


    @Builder(builderMethodName = "address")
    private Address createAddress(String city, int houseNumber, String postcode) {
        Address address = new Address();
        address.setCity(city);
        address.setHouseNumber(houseNumber);
        address.setPostcode(postcode);
        return address;
    }

}
