package com.lee.zipbob.domain.member.entity;

import com.lee.zipbob.domain.common.BaseTimeEntity;
import com.lee.zipbob.domain.member.enums.Provider;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SocialAccount extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "social_id")
    private Long socialId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(name = "provider", nullable = false)
    private Provider provider;

    @Column(name = "provider_uid", updatable = false)
    private String providerUid;

    @Builder
    private SocialAccount(Member member, Provider provider, String providerUid) {
        this.member = member;
        this.provider = provider;
        this.providerUid = providerUid;
    }

    public static SocialAccount create(Member member, Provider provider ,String providerUid) {
        return SocialAccount.builder()
                .member(member)
                .provider(provider)
                .providerUid(providerUid)
                .build();
    }
}
