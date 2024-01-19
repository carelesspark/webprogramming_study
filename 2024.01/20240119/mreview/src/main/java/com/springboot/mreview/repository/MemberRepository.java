package com.springboot.mreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.mreview.entity.Member;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
