package com.ttn.groovy

demofile = new File("../../../demo.txt")
demofile.createNewFile()
(new File("../../../resources/").listFiles()).each {
    key ->
        file = new File("${key}")

        if (file.isFile()) {
            file.eachLine { line -> demofile.append("$line  \n") }
        }
}