package com.ttn.collection

List list1 =  [1, 2, 3, "element1", 0.3, [2, 4, 6], 0..10 ]
int i =0;

println list1
println list1.get(6).get(9)

List list = list1.flatten()

println list

list.each{
    println list[i].class
    i++
}