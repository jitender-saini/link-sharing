package com.ttn.groovy

class Exercise3 {
    static void main(String[] args) {
        for(int i = 0;i<4;i++){
            for (int j = 1; j <= 2**i; j++) {
                print "*"
            }
            println ""
        }
    }
}
