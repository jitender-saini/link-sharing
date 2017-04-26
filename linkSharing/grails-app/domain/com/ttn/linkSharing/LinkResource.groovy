package com.ttn.linkSharing

class LinkResource extends Resource {

    String url

    static constraints = {
        link nullable: false, blank: false, url: true
    }
}
