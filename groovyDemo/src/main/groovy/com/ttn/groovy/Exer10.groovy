package com.ttn.groovy


file = new File("../../../demo3.txt")
file.createNewFile()
new File("../../../resources/file1.txt").eachLine {
    line ->
        line = line.replace(" ", "")
        line = line.replace("\n", "")
        line = line.replace("\t", "")
        file.append(line)
}