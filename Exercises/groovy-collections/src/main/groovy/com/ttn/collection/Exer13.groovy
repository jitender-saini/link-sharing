package com.ttn.collection

String s = "hello z friends this program will find the number of occurrence of a character in this string"

println "Count of e in string is : "+s.count("e")


Map map = [:]

def i=0
1.upto(s.length(), {
    if(map.containsKey(s.charAt(i)))
    map << [(s.charAt(i)):map.get(s.charAt(i))+1]
    else
        map << [(s.charAt(i)):1]
    i++
})
println map
println "Count of h in string is : "+map.get('h' as char)