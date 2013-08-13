package jaxb2;

import java.io.File;
import java.util.Vector;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.App;
import com.bank.account.Details;
import com.bean.ClientData;
import com.bean.Item;
import com.bean.MyOrder;

public class JAXB2Test {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testjaxb2Marshaller() throws Exception{
		ApplicationContext appContext =
	            new ClassPathXmlApplicationContext("services-jaxb2Marshaller.xml");
		 Jaxb2Marshaller jax = (Jaxb2Marshaller)appContext.getBean("jaxb2Marshaller") ;
		 File file = new File("out/input.xml");
		 Source source = new StreamSource(file);
		 Details detail = (Details)jax.unmarshal(source);
		 System.out.println(
				 detail.getPerson().getName().getFirstName().getTitile() + " " +
				 detail.getPerson().getName().getFirstName().getValue() + " " + 
				 detail.getPerson().getName().getLastName());	 
	}
	
	@Test
	public void testCastorMarshaller() throws Exception{
		 ApplicationContext appContext =
		            new ClassPathXmlApplicationContext("services-castorMarshaller.xml");
		        App application = (App) appContext.getBean("CASTOR");
		        application.getSettings().setTotal(100);
		        application.getSettings().setReference("hello");
		        ClientData client = new ClientData();
		        client.setName("Pranshi Dhingra");
		        client.setAddress("Bangalore");
		        application.getSettings().setClientData(client);
		        Vector<Item> items = new Vector<Item>();
		        Item item = new Item();
		        item._description = "Bread";
		        item._quantity = 1 ;
		        item._reference = "ITEM_CODE-209";
		        item._unitPrice = 29;
		        items.add(item);
		        item = new Item();
		        item._description = "Milk";
		        item._quantity = 2 ;
		        item._reference = "ITEM_CODE-293";
		        item._unitPrice = 16;
		        items.add(item);
		        application.getSettings().setItemsList(items);
		        application.getSettings().getTotal();
		        System.out.println(application.getSettings().getTotalPrice());
		        application.saveSettings(); // Writing to file
		        
		        
		        MyOrder order = application.loadSettings(); //Reading from file
		        System.out.println(order.getTotal());	 
	}
}
