package dev.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.bean.TextBean;
import dev.dao.TextDao;

@Service
@Transactional
public class TextService {
	
	protected static Logger logger = Logger.getLogger("TextService");
	 
	@Autowired
	private TextDao textDao;
 
	public List<TextBean> getAllGreetings() {
		System.out.println(textDao.getAllTexts());
		List<TextBean> values = textDao.getAllTexts();
		return values;		
	}
 
	public void addGreeting(TextBean text) {		
		textDao.addText(text);
	}

}
