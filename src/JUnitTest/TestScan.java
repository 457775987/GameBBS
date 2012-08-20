import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bbs.bean.GameElement;


public class TestScan {
       public static void main(String args[]) throws Exception{
    	   //ClassPathXmlApplicationContext c1 = SpringContext.getContext();
//    	   Configuration configuration = new Configuration();
//    	   configuration.configure("/hibernate.cfg.xml");
//    	   SessionFactory factory = configuration.buildSessionFactory();
//    	   Session session1 = factory.openSession();
//    	   Transaction t1 = session1.beginTransaction();
//    	   List<GameElement> list= session1.createCriteria(GameElement.class).list();
//    	   for(GameElement g:list){
//    		   System.out.println(g.getName());
//    	   }
//    	   t1.commit();
//    	   session1.close();
//    	   System.out.println("----------------------------------------------------------------");
//    	   Session session2 = factory.openSession();
//    	   Transaction t2 = session2.beginTransaction();
//    	   GameElement g2 = (GameElement)session2.get(GameElement.class, 1);
//    	   System.out.println(g2.getName());
//    	   t2.commit();

       }
       public void sxp(int q){
    	try {
    		System.out.println(Thread.currentThread().getName()+"½øÈëË¯Ãß:"+q);
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":"+q);
    	   
       }
}
