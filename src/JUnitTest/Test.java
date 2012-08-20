import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;



public class Test extends Thread{
	   TestScan ttt;
	   int i=0;
	   public Test(TestScan tt,int q){
		   ttt=tt;
		   i=q;
	   }
       public static void main(String args[]) throws Exception{
    	   Configuration c = new Configuration();
    	   c.configure("hibernate.cfg.xml");
    	   SchemaExport s = new SchemaExport(c);
       }
       @Override
       public void run() {
    	  ttt.sxp(i);
       }
}
