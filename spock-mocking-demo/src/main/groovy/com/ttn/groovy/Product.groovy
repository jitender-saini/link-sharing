package com.ttn.groovy

class Product {
    String name
    BigDecimal price
    DiscountType discountType = DiscountType.NONE
    Boolean isPopular = false


    static List<BigDecimal> getSortedPricesOfAllProducts(List<Product> products) {
        products.collect { it.price }.sort()
    }

    static Map<String, List<Product>> getEmployeesGroupedByPrice(List<Product> products) {
        return products.groupBy {
            if (it.price < 5000) return "Below 5000"
            else if (it.price >= 5000 && it.price < 10000) return "Between 5001 and 10000"
            else (it.price >= 10000); return "Above 10000"
        }
    }

    static List<Product> getProductsSortedByNameAndSalary(List<Product> products) {
        products.sort { a, b -> a.name <=> b.name ?: a.price <=> b.price }
    }

    static List<Product> getCurrentProducts(){
        return [new Product(name: 'p1', price: 100, isPopular: true), new Product(name: 'p2', price: 100), new Product(name: 'p3', price: 100)]
    }
}
