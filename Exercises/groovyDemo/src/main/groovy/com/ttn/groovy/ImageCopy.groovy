package com.ttn.groovy;

File file = new File("data.txt").getBytes()
println "The file ${file.absolutePath} has ${file.length()} bytes"
println file.text