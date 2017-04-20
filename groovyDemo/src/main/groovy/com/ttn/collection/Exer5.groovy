package com.ttn.collection

def list = [1,2,3,4,5,6,7,8,9,10]
int i=0
0.step list.size(), 2,{
    i++
    list.remove(i)
}
println list



def list1 = [0,1,2,3,4,5,6,7,8,9,10]
def list2 = []
for (int j = 0; j <list1.size() ; j+=2) {
    list2.add(list1[j])
}

list1 = list2
println list1

