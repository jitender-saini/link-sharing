package com.ttn.linkSharing

import com.ttn.linkSharing.co.ResourceSearchCO
import grails.transaction.Transactional

@Transactional
class ResourceService {

    def serviceMethod() {

    }

    List<Resource> search(ResourceSearchCO resourceSearchCO) {
        if (resourceSearchCO) {
            List<Resource> resources = Resource.search(resourceSearchCO).list()
            return resources
        }
    }
}
