package org.springboot.guestbook.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class PageResultDTO<DTO, EN> { // Guestbook(EN) -> GuestbookDTO(DTO)
    private List<DTO> dtoList;

    private int totalPage;

    private int page;

    private int size; // getter/setter

    private int start, end;

    private boolean prev, next; // boolean타입의 경우 isPrev(), isNext()와 같이 만들어짐

    private List<Integer> pageList;

    public PageResultDTO(Page<EN> result, Function<EN,DTO> fn){
        dtoList = result.stream().map(fn).collect(Collectors.toList());
        totalPage = result.getTotalPages();
        makePageList(result.getPageable());
    }

    private void makePageList(Pageable pageable){
        this.page = pageable.getPageNumber() + 1; // 0페이지부터 시작하니까 + 1 해주기
        this.size = pageable.getPageSize();
        
        // 페이지 블럭의 마지막 끝 번호 구하기
        int tempEnd = (int)(Math.ceil(page/10.0)) * 10; // 바로 end에 넣지 않는 이유는 맨 마지막이 10단위로 끝이 안날 수도 있기 때문이다
        // 페이지의 시작 번호와 끝 번호
        this.start = tempEnd - 9;
        this.prev = start > 1;
        this.end = totalPage > tempEnd ? tempEnd : totalPage;
        this.next = totalPage > tempEnd;

        // boxed() : IntStream -> Integer -> List<Integer>
        this.pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }
}
