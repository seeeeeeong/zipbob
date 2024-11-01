package com.lee.zipbob.domain.auth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lee.zipbob.domain.auth.dto.LoginResponse;
import com.lee.zipbob.domain.auth.service.AuthService;
import com.lee.zipbob.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login/oauth2/callback/google")
    public ApiResponse<LoginResponse> googleLogin(@RequestParam(name = "code") String code) throws JsonProcessingException {
        return ApiResponse.success(authService.googleLogin(code));
    }

    @GetMapping("/login/oauth2/callback/kakao")
    public ApiResponse<LoginResponse> kakaoLogin(@RequestParam(name = "code") String code) throws JsonProcessingException {
        return ApiResponse.success(authService.kakaoLogin(code));
    }





}
