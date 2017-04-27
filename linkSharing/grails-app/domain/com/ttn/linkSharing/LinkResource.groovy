package com.ttn.linkSharing

class LinkResource extends Resource {

    String url

    static constraints = {
        url nullable: false, blank: false, url: true
    }
}
