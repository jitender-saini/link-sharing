package com.ttn.linkSharing

enum Seriousness {

    SERIOUS('Serious'),
    VERY_SERIOUS('Very Serious'),
    CASUAL('Casual')

    String displayName

    Seriousness(String displayName) {
        this.displayName = displayName
    }

    String toString() {
        displayName
    }

    String getKey() {
        name()
    }

}