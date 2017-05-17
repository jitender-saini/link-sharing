package com.ttn.groovy

file=new File("../../../resources/images/copyImage.JPG")
file.createNewFile()
file.setBytes(new File("../../../resources/images/image.JPG").getBytes())