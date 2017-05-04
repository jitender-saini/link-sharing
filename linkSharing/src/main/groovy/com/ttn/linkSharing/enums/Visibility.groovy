package com.ttn.linkSharing.enums

enum Visibility {

    PUBLIC('Public'),
    PRIVATE('Private')

    String visibility

    Visibility(String visibility) {
        this.visibility = visibility

    }

    String toString() {
        visibility
    }

}