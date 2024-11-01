package com.lee.zipbob.domain.member.enums;

import com.lee.zipbob.global.mapper.EnumMapperType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Provider implements EnumMapperType {

    GOOGLE("GOOGLE"),
    KAKAO("KAKAO"),
    APPLE("APPLE");

    private final String description; // Enum 설명

    @Override
    public String getCode() {
        return name();
    }
}
