package com.ttn.groovy

class PasswordEncrypterService {

    //Todo
    String encrypt(String password){
       return aVeryComplexProcess(password)
   }

    String aVeryComplexProcess(String password){
        Thread.sleep(5000)
        return password.bytes.encodeBase64().toString()
    }
}
