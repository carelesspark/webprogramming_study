package org.springboot.guestbook.service;

import org.junit.jupiter.api.Test;
import org.springboot.guestbook.dto.GuestbookDTO;
import org.springboot.guestbook.dto.PageRequestDTO;
import org.springboot.guestbook.dto.PageResultDTO;
import org.springboot.guestbook.entity.Guestbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 테스트 클래스 사용 시 꼭 이 어노테이션 붙이기
public class GuestbookServiceTests {

    @Autowired
    private GuestbookService service;

    @Test
    public void testRegister(){

        GuestbookDTO guestbookDTO = GuestbookDTO.builder().title("Sample Title...")
                .content("Sample Content....").writer("user0").build();

//       System.out.println(service.register(guestbookDTO));

        service.register(guestbookDTO);

    }

//    @Test
//    public void testList(){
//        PageRequestDTO pageResultDTO = PageRequestDTO.builder()
//                .page(1).size(10).build();
//        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageResultDTO);
//
//        for(GuestbookDTO guestbookDTO : resultDTO.getDtoList()){
//            System.out.println(guestbookDTO);
//        }
//    }

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();
        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = service.getList(pageRequestDTO);

        System.out.println("PREV : " + resultDTO.isPrev());
        System.out.println("NEXT : " + resultDTO.isNext());
        System.out.println("TOTAL : " + resultDTO.getTotalPage());

        for(GuestbookDTO guestbookDTO : resultDTO.getDtoList()){
            System.out.println(guestbookDTO);
        }

        System.out.println("=====================================");

        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }
}
