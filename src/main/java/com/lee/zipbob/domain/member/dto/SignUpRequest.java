package com.lee.zipbob.domain.member.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequest {

    private String email;
    private String name;
    private String password;
    private String phoneNumber;

    private String provider;
    private String providerUid;

}
