package dev.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.bean.TextBean;

@Repository
public class TextDao {
	
	protected static Logger logger = Logger.getLogger("TextDao");
	 
	@Autowired
	private SessionFactory sessionFactory;
	 @Transactional
	public List<TextBean> getAllTexts() {
		try{
			Session session = sessionFactory.openSession();		
			Query q = session.createQuery("from TextBean order by addedDate desc");
			List<TextBean> textList = q.list(); 			
		    return textList;	
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
				
	}
	 @Transactional
	public void addText(TextBean textBean) {
		 Session session = sessionFactory.getCurrentSession();	
		try {
			//session.getTransaction().begin();
			Query q = session.createQuery("from TextBean where textName = :textName");
			q.setParameter("textName", textBean.getTextName());
			System.out.println(q.list().size() +textBean.getTextName() );
				session.saveOrUpdate(textBean);
				/*if (!session.getTransaction().wasCommitted())
					session.getTransaction().commit();
				*/
				
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}
}
