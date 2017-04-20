package com.ttn.groovy

class HourMinute {
    int hours
    int minutes

    HourMinute plus(HourMinute hm){
        return new HourMinute(hours: hours + hm.hours, minutes: minutes+hm.minutes)
    }
    HourMinute minus(HourMinute hm){
        return new HourMinute(hours: hours - hm.hours, minutes: minutes - hm.minutes)
    }

    static void main(String[] args) {
        HourMinute hourMinute1 =new HourMinute(hours: 10,minutes: 45)
        HourMinute hourMinute2 =new HourMinute(hours: 5,minutes: 15)

        HourMinute hourMinute3 = hourMinute1+hourMinute2
        println "Hours : " +hourMinute3.hours +" Minutes : "+ hourMinute3.minutes
        hourMinute3 = hourMinute1-hourMinute2
        println "Hours : " +hourMinute3.hours +" Minutes : "+ hourMinute3.minutes

    }
}
