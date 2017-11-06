package org.pre.web;

import java.util.List;

import org.pre.util.parsing.TistoryParsingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

	@Autowired
	private TistoryParsingUtil tistoryParser;
	
	@GetMapping("/")
	public String indexPage(Model model) {
		
		List<String> titleList=tistoryParser.getPostingTitles();
		List<String> contentsList=tistoryParser.getPostingContents();
		List<String> urlList=tistoryParser.getPostingUrls();
		
		titleList.add("DDD에 대한 짧은 생각 끄적이기");
		contentsList.add("국내에 DDD 관련 책을 다양하게 있는 것도 아니고 \r\n" + 
				"에릭 에반스 개발자 분의 책은 정말 어렵다 .. \r\n" + 
				"번역체 문제 같은 것들이 아니라   내용이 매우 추상적이고   \r\n" + 
				"개발 경험이 적은 나로써는  그 내용들을 받아들이기 매우 어려웠다.\r\n" + 
				"DDD start 라는 최범균 개발자님이 쓰신 책으로 DDD를 다시 읽는데 \r\n" + 
				"역시 소스코드를 직접 보는게 제일 좋은 방법인듯 싶다.\r\n" + 
				"소스코드 품질 관리 측면에서 DDD는 매우 좋은 방법론이다.\r\n" 
				);
		
		model.addAttribute("tList", titleList);
		model.addAttribute("cList", contentsList);
		model.addAttribute("urlList",urlList);
		
		return "index";
	}
}
