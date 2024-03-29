package com.springboot.mreview.controller;


import com.springboot.mreview.dto.MovieDTO;
import com.springboot.mreview.dto.PageRequestDTO;
import com.springboot.mreview.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/movie")
@Log4j2
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("register")
    public void register(){

    }

    @PostMapping("/register")
    public String register(MovieDTO movieDTO, RedirectAttributes redirectAttributes){

        log.info("movieDTO : " + movieDTO);
        Long mno = movieService.register(movieDTO);

        redirectAttributes.addFlashAttribute("msg", mno);

        return "redirect:/movie/list";
    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        log.info("list....");

        model.addAttribute("result", movieService.getList(pageRequestDTO));
    }

    @GetMapping("/read")
    public void read(Long mno, PageRequestDTO pageRequestDTO, Model model){
        log.info("mno : " + mno);
        log.info("page : " + pageRequestDTO.getPage());
        log.info("read page.....");

        MovieDTO movieDTO = movieService.getMovie(mno);

        model.addAttribute("read", movieDTO);
        model.addAttribute("page", pageRequestDTO.getPage());

    }


}
