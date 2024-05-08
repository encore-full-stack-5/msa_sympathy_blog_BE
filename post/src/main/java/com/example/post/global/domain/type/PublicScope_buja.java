package com.example.post.global.domain.type;

public enum PublicScope_buja {
//    변수명 변경 필요 임시로 작성함 NEIGHBOR == 이웃 FRIEND == 서로이웃
    FULL(1),NEIGHBOR(2),FRIEND(3);
    final int value;

    PublicScope_buja(int value) {
        this.value = value;
    }
}
