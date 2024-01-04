package com.springboot.ex4.controller;

import com.springboot.ex4.dto.SampleDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller // 뷰 정보를 전달하는 용도
@RequestMapping("/sample")
@Log4j2
public class SampleController {
    @GetMapping("/ex4") // sample/ex4.html
    public void ex4() {
        log.info(("ex4...."));
    }

    @GetMapping({"/ex5","/exLink"})
    public void exModel(Model model) {
        List<SampleDTO> list = IntStream.rangeClosed(1, 20).asLongStream().mapToObj(i -> {
            SampleDTO dto = SampleDTO.builder().sno(i).first("First..." + i).last("Last..." + i).regTime(LocalDateTime.now()).build();
            return dto;
        }).collect(Collectors.toList());

        model.addAttribute("list", list);
    }

    @GetMapping("/exInline")
    public String exInline(RedirectAttributes redirectAttributes){
        SampleDTO dto = SampleDTO.builder().sno(100L).first("First...100").last("Last...100").regTime(LocalDateTime.now()).build();
        redirectAttributes.addFlashAttribute("result", "success");
        redirectAttributes.addFlashAttribute("dto", dto);

        return "redirect:/sample/ex6";
    }

    @GetMapping("/ex6")
    public void ex6(){
        log.info("ex6...");
    }

    @GetMapping({"/exLayout1", "/exLayout2", "/exTemplate", "/exSidebar"})
    public void exLayout1(){
        log.info("exLayout.......");
    }





}
