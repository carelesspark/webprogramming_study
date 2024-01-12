package com.springboot.board.controller;

import com.springboot.board.dto.BoardDTO;
import com.springboot.board.dto.PageRequestDTO;
import com.springboot.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("list....." + pageRequestDTO);

        model.addAttribute("result", boardService.getList(pageRequestDTO));
    }

    @GetMapping("/register")
    public void register() {
        log.info("register get...");
    }

    @PostMapping("/register")
    public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes) {

        log.info("dto..." + dto);

        Long bno = boardService.register(dto);

        log.info(bno);

        redirectAttributes.addFlashAttribute("msg", bno);


        return "redirect:/board/list";
    }

    @GetMapping("/read")
    public void read(Long bno, Model model, @ModelAttribute("pageRequestDTO") PageRequestDTO pageRequestDTO){
        log.info("bno..." + bno);
        BoardDTO boardDTO = boardService.get(bno);
        log.info(boardDTO);
        model.addAttribute("dto", boardDTO);

    }

    @GetMapping("/modify")
    public void modify(Long bno, Model model, @ModelAttribute("pageRequestDTO") PageRequestDTO pageRequestDTO){
        BoardDTO boardDTO = boardService.get(bno);
        model.addAttribute("dto", boardDTO);

    }

    @PostMapping("/modify")
    public String modifyPost(BoardDTO boardDTO, RedirectAttributes redirectAttributes, @ModelAttribute("pageRequestDTO") PageRequestDTO pageRequestDTO){

        log.info("boardDTO..." + boardDTO);

        boardService.modify(boardDTO);

        log.info("page... " + pageRequestDTO.getPage());

        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("bno", boardDTO.getBno());
        redirectAttributes.addAttribute("type", pageRequestDTO.getType());
        redirectAttributes.addAttribute("keyword", pageRequestDTO.getKeyword());

        return "redirect:/board/read";
    }

    @PostMapping("/remove")
    public String remove(Long bno, RedirectAttributes redirectAttributes){
        log.info("bno..." + bno);
        boardService.removeWithReplies(bno);
        redirectAttributes.addFlashAttribute("msg2", bno);

        return "redirect:/board/list";
    }

}
