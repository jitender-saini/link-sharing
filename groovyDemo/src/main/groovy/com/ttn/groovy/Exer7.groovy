package com.ttn.groovy
def valueInList= {list,element->
    list.contains(element)
}

println valueInList([2,4,5,67,12,22,33,44,12],2)