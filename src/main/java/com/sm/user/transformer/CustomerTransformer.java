package com.sm.user.transformer;

import com.sm.user.document.Customer;
import lombok.Data;

@Data
public class CustomerTransformer {

    public Customer convertCustomer(Customer customer){

        return customer;
    }
}
