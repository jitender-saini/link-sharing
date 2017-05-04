package com.ttn.linkSharing.enums

enum Seriousness {

    SERIOUS('Serious'),
    VERY_SERIOUS('Very Serious'),
    CASUAL('Casual')

    String seriousness

    Seriousness(String seriousness) {
        this.seriousness = seriousness
    }

    String toString() {
        seriousness
    }
}