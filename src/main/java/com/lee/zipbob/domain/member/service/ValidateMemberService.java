package com.lee.zipbob.domain.member.service;

import com.lee.zipbob.domain.member.entity.Member;
import com.lee.zipbob.domain.member.enums.Provider;
import com.lee.zipbob.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ValidateMemberService {

    private final MemberRepository memberRepository;

    public Member validateRegisteredMemberByEmail(String email, Provider provider) {
        return memberRepository.findAllByEmail(email).stream()
                .filter(member -> member.getSocialAccounts().stream()
                        .anyMatch(socialAccount -> socialAccount.getProvider() == provider))
                .findFirst()
                .orElse(null);
    }


}
