package com.ttn.linkSharing

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