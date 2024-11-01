package com.lee.zipbob.domain.member.repository;


import com.lee.zipbob.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllByEmail(String email);

    Optional<Member> findByNickname(String nickname);


}
