package com.ttn.collection

String s = "this string needs to be split"
println s
println s.tokenize(" ")
println s.tokenize()
println s.tokenize(/\s/)

String s2 = "this string needs to be split"
println s2.split(" ")
println s2.split(/\s/) //(Try Same Parameter with tokenize)

String s3 = "are.you.trying.to.split.me.mister?"
println s3.tokenize(".")
println s3.split(".")