package com.ttn.linkSharing.enums

enum Seriousness {

    SERIOUS,
    VERY_SERIOUS,
    CASUAL

    static Seriousness toEnum(String seriousness) {
        if(seriousness.equalsIgnoreCase("SERIOUS")){
            SERIOUS
        }
        else if(seriousness.equalsIgnoreCase("VERY_SERIOUS")){
            VERY_SERIOUS
        }
        else CASUAL
    }
}