package com.lee.zipbob.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignUpResponse {

    private long memberId;
    private String accessToken;
    private String refreshToken;

    public static SignUpResponse of(Long memberId, String accessToken, String refreshToken) {
        return SignUpResponse.builder()
                .memberId(memberId)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
