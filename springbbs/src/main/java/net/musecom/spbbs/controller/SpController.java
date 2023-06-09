package net.musecom.spbbs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.musecom.spbbs.command.SpCommand;
import net.musecom.spbbs.command.SpDeleteCommand;
import net.musecom.spbbs.command.SpDetailCommand;
import net.musecom.spbbs.command.SpListCommand;
import net.musecom.spbbs.command.SpReplyCommand;
import net.musecom.spbbs.command.SpReplyOkCommand;
import net.musecom.spbbs.command.SpUpdateCommand;
import net.musecom.spbbs.command.SpUpdateOkCommand;
import net.musecom.spbbs.command.SpWriteCommand;

@Controller 
public class SpController {
	
	//모든 command가 갖고 있는 인터페이스 타입을 선언
	SpCommand command;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()실행");
		
		command = new SpListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/detail")
	public String detail(HttpServletRequest request, Model model) {
		System.out.println("detail()");
		
		model.addAttribute("request", request);
		command = new SpDetailCommand();
		command.execute(model);
		return "detail";
	}
	
	@RequestMapping("/write")
	public String write(Model model) {
		System.out.println("write()");
		return "write";
	}
	
	@RequestMapping(value = "/writeOk", method = RequestMethod.POST)
	public String writeOk(HttpServletRequest request, Model model) {
		System.out.println("wirteOk()");
		
		model.addAttribute("request", request);
		command = new SpWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		
		System.out.println("reply()");
		model.addAttribute("request", request);
		command = new SpReplyCommand();
		command.execute(model);
		
		return "reply";
	}
	
	@RequestMapping(value = "/replyok", method=RequestMethod.POST)
	public String replyok(HttpServletRequest request, Model model) {
		System.out.println("replyok()");
		
		model.addAttribute("request", request);
		command = new SpReplyOkCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		System.out.println("update()");
		
		model.addAttribute("request", request);
		command = new SpUpdateCommand();
		command.execute(model);
		
		return "update";
	}
	@RequestMapping("/updateok")
	public String updateok(HttpServletRequest request, Model model) {
		System.out.println("updateok()");
		
		model.addAttribute("request", request);
		command = new SpUpdateOkCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new SpDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	
}
