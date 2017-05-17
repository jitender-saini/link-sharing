package com.ttn.collection

Scanner sc =new Scanner(System.in)
println "Enter number"
int num = sc.nextInt()
println num

1.upto(10,{
    println "$num * ${it} = ${it*num}"
})