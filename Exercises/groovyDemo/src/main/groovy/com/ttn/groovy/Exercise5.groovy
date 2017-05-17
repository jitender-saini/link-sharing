package com.ttn.groovy

class Exercise5 {

    static void main(String[] args) {
        if(null){
            println "testing null"
        }
         if('null'){
            println "testing 'null' "
        }
         if("Test"){
            println "testing string Test"
        }
         if(100){
            println "testing 100"
        }
         if(0){
            println "testing 0"
        }
        List list = new ArrayList()

         if(list){
            println "testing empty list"
        }
        list.add(null)
        list.add(null)
        list.add(null)

        if(list){
            println "testing list with all values as null"
        }

        list.add(12)
        list.add("dfs")
        if(list){
            println "testing list after adding 12 in list"
        }

        if(-1){
            println "Testing Negative int"
        }

    }
}
