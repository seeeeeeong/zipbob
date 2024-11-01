package com.lee.zipbob.domain.member.service;

import com.lee.zipbob.domain.member.dto.SignUpRequest;
import com.lee.zipbob.domain.member.dto.SignUpResponse;
import com.lee.zipbob.domain.member.entity.Member;
import com.lee.zipbob.domain.member.entity.SocialAccount;
import com.lee.zipbob.domain.member.enums.Provider;
import com.lee.zipbob.domain.member.repository.MemberRepository;
import com.lee.zipbob.domain.member.repository.SocialAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.Random;

import static org.hibernate.annotations.UuidGenerator.Style.RANDOM;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final SocialAccountRepository socialAccountRepository;

    @Transactional
    public Member registerMember(String email, Provider provider, String providerUid) {
        String nickname = getNickname();
        Member member = memberRepository.save(Member.create(email, nickname));
        socialAccountRepository.save(SocialAccount.create(member, provider, providerUid));
        return member;
    }



    private String getNickname() {

        Random random = new Random();
        String nickname;

        do {
            String noun = "유저";
            String randomInt = String.valueOf(random.nextInt(999));
            nickname = MessageFormat.format("{0} {1}", noun, randomInt);
        } while (memberRepository.findByNickname(nickname).isPresent());

        return nickname;

    }




}
