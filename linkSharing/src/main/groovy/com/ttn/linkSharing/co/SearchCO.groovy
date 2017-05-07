package com.ttn.linkSharing.co

import grails.validation.Validateable

class SearchCO implements Validateable{
    String q
    Integer max
    Integer offset
    String order
    String sort
}