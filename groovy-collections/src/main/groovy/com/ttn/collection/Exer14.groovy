package com.ttn.collection

List list = 1..100
//int i =0
println list
for (int i = 0; i <list.size(); i++) {
    if((list[i]%3)==0&&(list[i])%5==0) {
        println "FizzBuzz"
        i++
    }
    else if((list[i]%3)==0)
        println "Fizz"
    else if((list[i])%5==0)
        println "Buzz"
    else println list[i]
}