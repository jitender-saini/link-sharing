package com.ttn.collection

def url = "http://www.google.com?name=johny&age=20&hobby=cricket"

def values = url.substring(url.indexOf("?") + 1  ,url.length());
println values

def mapString = values.split("&")
Map map = [:]
mapString.each {
    string ->
        map[string.substring(0,string.indexOf("="))] = string.substring(string.indexOf("=")+1,string.length())
}

println map