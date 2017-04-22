package com.ttn.groovy

class CustomerService {

    Boolean isPrivellegedDiscountApplicable(User user, Product product){
        return (product.discountType == DiscountType.PRIVELLEGE_ONLY && user.isPrivellegedCustomer)
    }

}
