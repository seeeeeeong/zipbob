package com.lee.zipbob.global.jwt;

import com.lee.zipbob.global.mapper.EnumMapperType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GrantType implements EnumMapperType {

    BEARER("Bearer");

    private final String description; // Enum 설명

    @Override
    public String getCode() {
        return null;
    }
}
