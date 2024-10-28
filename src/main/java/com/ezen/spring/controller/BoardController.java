package com.ezen.spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.spring.domain.BoardVO;
import com.ezen.spring.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/board/*") 
@Slf4j 
@RequiredArgsConstructor 
@Controller
public class BoardController {
	private final BoardService bsv;
	// 생성자 주입이 있기 때문에 따로 생성자를 만들어주지 않아도 됨! 객체도 생성되어있음!
	// ServiceImpl 클래스를 만들어 implements 해주고, @service 해주면 연결되있는ㄱ..?
	
	@GetMapping("/register")
	public String register() {
		// return은 이동하는 JSP 위치를 가리킴! (Servlet의 destPage)
		return "/board/register"; // WEB-INF/views/board/register.jsp로 연결
		// 여기서 return의 위치와 컨트롤러의 경로가 같으면 void로 생략할 수 있다.
	}
	
//	위의 메서드와 같은 의미
//	@GetMapping("/register")
//	public void register() { //... }
	
	@PostMapping("/insert")
	public String insert(BoardVO bvo) {
		log.info(">>>> insert boardVO > {}", bvo);
		// >>>> insert boardVO > BoardVO(bno=0, title=test1, writer=test2, content=test3, isDel=null, regDate=null, modDate=null)
		int isOk = bsv.register(bvo);
		log.info(">>>> register > {}", (isOk>0? "OK" : "FAIL"));
		
		// 내부 컨트롤러를 다시 접근할 경우 redirect:/경로명
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list(Model m) {
		// request.serAttribute 역할을 하는 객체 => Model 객체
		List<BoardVO> list = bsv.getList();
		log.info(">>>> list > {}", list);
		m.addAttribute("list", list);

		return "/board/list";
	}
	
	// 두개의 경로를 하나의 메서드에서 처리함.
	@GetMapping({"/detail","/modify"}) 
	public void detail(Model m, @RequestParam("bno") int bno) {
		log.info(">>>> param bno > {}", bno);
		BoardVO bvo = bsv.getDetail(bno);
		m.addAttribute("bvo",bvo);
		// void로 바꾸고 온 경로로 다시 가도록 유도함!
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bno") int bno) {
		log.info(">>>> param bno > {}", bno);
		int isOk = bsv.delete(bno); 
		log.info(">>>> delete > {}", (isOk>0? "OK" : "FAIL"));
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/update")
	public String update(BoardVO bvo) {
		int isOk = bsv.update(bvo);
		log.info(">>>> update > {}", (isOk>0? "OK" : "FAIL"));
		
		return "redirect:/board/detail?bno=" + bvo.getBno();
	}
	
	
	
}
