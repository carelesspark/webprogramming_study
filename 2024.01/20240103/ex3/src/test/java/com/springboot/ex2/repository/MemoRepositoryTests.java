package com.springboot.ex2.repository;

import com.springboot.ex2.entity.Memo;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

import java.util.List;
import java.util.Optional;
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
    public void testClass() { // 부분 실행을 하면 'jdk.proxy3.$Proxy113'가 출력되는 것을 확인할 수 있음
        System.out.println(memoRepository.getClass().getName());
    }

    @Test
    public void testInsertDummies() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample.." + i).build(); // new 대신 builder패턴을 사용한 객체 생성 방식
            memoRepository.save(memo);
        });
    }

    @Test
    public void testSelect() { // 엔티티객체에 @ToString을 추가하고 실행해본 결과 정상적으로 'Memo(mno=100, memoText=Sample..100)'가 출력됨

        Long mno = 100L;
        Optional<Memo> result = memoRepository.findById(mno);

        System.out.println("=============================");

        if (result.isPresent()) {
            Memo memo = result.get();
            System.out.println(memo);
        } else {
            System.out.println("select된 값이 없습니다.");
        }

    }

    @Test
    public void testUpdate(){
        Memo memo = Memo.builder().mno(100L).memoText("Update Text 100").build();
        System.out.println(memoRepository.save(memo));
    }


    @Test
    public void testDelete(){
        Long mno = 100L;
        memoRepository.deleteById(mno);
    }

    @Test
    public void testPageDefault(){
       Pageable pageable =  PageRequest.of(0, 10);
       Page<Memo> result = memoRepository.findAll(pageable);
        System.out.println(result);

        System.out.println("=====================================================");

        System.out.println("Total Pages : " + result.getTotalPages()); // 총 페이지 수

        System.out.println("Page Count : " + result.getTotalElements()); // 전체 개수

        System.out.println("Page Number : " + result.getNumber()); // 현재 페이지 번호 0부터 시작

        System.out.println("Page Size : " + result.getSize()); // 페이지 당 데이터 개수

        System.out.println("has next page? : " + result.hasNext()); // 다음 페이지 존재 여부

        System.out.println("first page? : " + result.isFirst()); // 시작 페이지(0) 여부

        // getContent(), getContent()의 반환 타입은 List<T>

        for(Memo memo : result.getContent()){
            System.out.println(memo);
        }
    }

    @Test
    public void testSort(){
        Sort sort1 = Sort.by("mno").descending();

        Pageable pageable = PageRequest.of(0, 10, sort1);
        Page<Memo> result = memoRepository.findAll(pageable);

        result.get().forEach(memo -> {
            System.out.println(memo);
        });

    }

    @Test
    public void testQueryMethods(){
        List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(70L, 80L);

        for(Memo memo : list){
            System.out.println(memo);
        }
    }

    @Test
    public void testQueryMethodWithPageable(){

        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
        Page<Memo> result = memoRepository.findByMnoBetween(10L, 50L, pageable);

        result.get().forEach(memo -> {
            System.out.println(memo);
        });
    }

    // 수정/삭제 관련된 쿼리문의 경우에는 @Commit&@Transcational를 같이 사용해야 함
    @Commit
    @Transactional
    @Test
    public void testDeleteQueryMethod(){
        memoRepository.deleteMemoByMnoLessThan(10L);
    }


}
