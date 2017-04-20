package com.ttn.groovy

class MultipleOfThree {

    static void main(String[] args) {
        //method1
        (1..10).each {
            println "3 * ${it} = ${it*3}"
        }

        //method2
        10.times {
            println "3 * ${it} = ${it*3}"
        }

        //method3
        1.upto(10,{
            println "3 * ${it} = ${it*3}"
        })

        //method4
        def num ={
            println "3 * ${it} = ${it*3}"
        }
        1.upto(10,num)

        //method5
        1.step 11, 1,{
            println "3 * ${it} = ${it*3}"
        }

        //method6
        for(it in 1..10)
            println "3 * ${it} = ${it*3}"
        }
}
