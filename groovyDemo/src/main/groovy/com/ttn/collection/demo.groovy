package com.ttn.collection
////
////List firstList = [1,2,3,4,5]
////
////List secondList = ["abc", "def"]
////
////List thirdList = firstList + secondList
////
////println thirdList
////
////List fourthList = thirdList - secondList
////
////println fourthList
////
////firstList.push(3)
////
////println firstList
////println firstList.unique()
////println firstList
//
//
//List list = [14,12, 11,10, 16, 15,12, 10, 99, 90, 14, 16, 35]
//list.unique()
//println list
//list.sort{a,b ->
//    b <=> a
//}
//println list

//List employeeList
//
//employeeList.each {
//    if (it.getSalary() < 5000) {
//        list1.add(it)
//    }
//}
//println("List of Employees having Salary less than 5000 : "+list1)
//
//employeeList.sort({ a, b -> a.getAge() - b.getAge() })
//println("Youngest Employee Details : " + employeeList.first())
//println("Oldest Employee Details : " + employeeList.last())
//
//}
//}
//


def list = [0,1,2,3,4,5,6,7,8,9,10]
def list2 = []
for (int j = 0; j <list.size() ; j+=2) {
    list2.add(list[j])
}

list = list2
println list


