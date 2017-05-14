package com.ttn.linkSharing

import com.ttn.linkSharing.co.ResourceSearchCO
import grails.transaction.Transactional

@Transactional
class ResourceService {

    def serviceMethod() {

    }
    List<Resource> search(ResourceSearchCO resourceSearchCO){

        List<Resource> resources = Resource.search(resourceSearchCO).list(offset:resourceSearchCO.offset,max:resourceSearchCO.max)

        return resources
    }
}
