package com.ttn.linkSharing.co

import grails.validation.Validateable

class ResourceSearchCo extends SearchCO implements Validateable{
    long topicId
    String visibility
}
