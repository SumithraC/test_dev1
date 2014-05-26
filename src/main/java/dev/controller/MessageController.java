package dev.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.bean.TextBean;
import dev.service.TextService;
 
@Controller
@RequestMapping("/")
public class MessageController {
	
	protected static Logger logger = Logger.getLogger("GreetingController");
	 
	private TextService textService;
	 
	@Autowired 
	public MessageController(TextService textService) {
		this.textService = textService;
	}
	
	@RequestMapping(value="/myText", method = RequestMethod.GET)
	public String welcome(Model model) {
 
		logger.info("entering showAllGreetings");
		
		System.out.println("trial 1");
		
			TextBean bean = new TextBean();
			bean.setDescription("Test1");
			bean.setTextName("Test1 desc");
			bean.setAddedDate(new Date());
			System.out.println("trial 2");
			textService.addGreeting(bean);
			TextBean bean1 = new TextBean();
			bean1.setDescription("Test12");
			bean1.setTextName("Test12 desc");
			bean1.setAddedDate(new Date());
			System.out.println("trial 3");
			textService.addGreeting(bean1);
		return "getText";
 
	}
	
	@RequestMapping(value="/getText", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public @ResponseBody String getBeans() throws JsonGenerationException, JsonMappingException, IOException{
		List<TextBean> beans = textService.getAllGreetings();
		System.out.println(beans.size());
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(beans);
	}
 
	@RequestMapping(value="/editText", method = RequestMethod.POST,  produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public @ResponseBody String welcomeName(@RequestBody TextBean data) {
		
		TextBean bean = new TextBean();
		bean.setDescription(data.getDescription());
		bean.setTextName(data.getTextName());
		bean.setAddedDate(new Date());
		textService.addGreeting(bean);
		System.out.println(bean.getDescription());
		logger.info("entering addGreetingAndShowAll()");
	    return "success";
	}

}
