package com.ttn.mocking

import com.ttn.groovy.CustomerService
import com.ttn.groovy.DiscountType
import com.ttn.groovy.EmailService
import com.ttn.groovy.Product
import com.ttn.groovy.Transaction
import com.ttn.groovy.User
import spock.lang.Specification

class TransactionSpec extends Specification {

//todo
    void "We are able to cancel a sale"() {
        given: "A product"
        Product product = new Product(name: 'p1', price: 100)
        and: "A customer"
        User user = new User(balance: 100)
        and: "A sale"
        Transaction transaction = new Transaction()
        
        and: "An email service mock"
        def emailService = Mock(EmailService)
        transaction.emailService = emailService
        
        when: "When Cancel is called"
        transaction.cancelSale(product, user)
        
        then:
        1 * emailService.sendCancellationEmail(user, _ as String)
     //   user.balance==200
    }
    
    //todo
    def "Customer discount is calculated for a product"() {
        given: "A product"
        Product product = new Product(name: 'p1', price: 100, discountType: DiscountType.PRIVILEGE_ONLY)
        and: "A customer"
        User user = new User(balance: 100, isPrivellegedCustomer: true)
        and: "A sale"
        Transaction transaction = new Transaction()
        
        and: "An email service mock"
        def customerService = Mock(CustomerService)
        transaction.customerService = customerService
        
        when: "When Cancel is called"
        transaction.calculateDiscount(product, user)
        
        then:
        1 * customerService.isPrivellegedDiscountApplicable(user, product) >> true
        
    }
}
