package com.lee.zipbob.domain.auth.repository;


import com.lee.zipbob.domain.auth.entity.Token;
import com.lee.zipbob.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByMember(Member member);

}
