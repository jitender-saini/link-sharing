package com.ttn.linkSharing.enums

enum Visibility {

    PUBLIC('Public'),
    PRIVATE('Private')

    String displayName

    Visibility(String displayName) {
        this.displayName = displayName

    }

    String toString() {
        displayName
    }

    String getKey() {
        name()
    }

}