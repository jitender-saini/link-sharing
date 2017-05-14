package com.ttn.linkSharing.dto

import grails.validation.Validateable

class EmailDTO implements Validateable{
    String to
    String subject
    String view
    String content
    Map model
}