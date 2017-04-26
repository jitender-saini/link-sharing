package com.ttn.linkSharing

class DocumentResource extends Resource{

    String filePath

    static constraints = {
        filePath blank: false, nullable: false
    }
}
