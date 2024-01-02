package com.springboot.ex2.repository;

import com.springboot.ex2.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest // 테스트 클래스로서 항상 붙여야 하는 어노테이션
public class MemoRepositoryTests {

//    JPARepository인터페이스
//
//    - insert : save(엔티티객체)
//    - select : findById(키타입), getOne(키타입)
//    - update : save(엔티티객체)
//    - delete : deleteById(키타입), delete(엔티티객체)

    @Autowired
    private MemoRepository memoRepository;

    @Test
    public void testClass(){ // 부분 실행을 하면 'jdk.proxy3.$Proxy113'가 출력되는 것을 확인할 수 있음
        System.out.println(memoRepository.getClass().getName());
    }

    @Test
    public void testInsertDummies(){
        IntStream.rangeClosed(1, 100).forEach(i->{
            Memo memo = Memo.builder().memoText("Sample.." + i).build(); // new 대신 builder패턴을 사용한 객체 생성 방식
            memoRepository.save(memo);
        });
    }

}
