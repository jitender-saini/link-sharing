package com.ttn.linkSharing.vo

class RatingInfoVO {
    Integer totalVotes
    Integer averageScore
    Integer totalScore

    String toString() {
        return "RatingInfoVO{" +
                "totalVotes=" + totalVotes +
                ", averageScore=" + averageScore +
                ", totalScore=" + totalScore +
                '}'
    }
}
