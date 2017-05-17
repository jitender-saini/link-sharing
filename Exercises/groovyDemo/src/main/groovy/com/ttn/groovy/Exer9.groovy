package com.ttn.groovy

it = 0;
file = new File("../../../resources/demo1.txt")
file.createNewFile()
new File("../../../demo.txt").eachLine {
    line ->
        if (++it % 2 != 0) {
            file.append("$it : $line \n")
        }
}