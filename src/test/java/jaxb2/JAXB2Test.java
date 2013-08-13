package jaxb2;

import java.io.File;
import java.util.Properties;
import java.util.Vector;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import noNamespace.DetailsDocument;
import org.apache.xmlbeans.impl.tool.SchemaCompiler;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.oxm.xmlbeans.XmlBeansMarshaller;

import com.App;
import com.bank.account.Details;
import com.bean.ClientData;
import com.bean.Item;
import com.bean.MyOrder;

public class JAXB2Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//String[] params = new String[]{"scomp", "out/Details.xsd"};		
		//SchemaCompiler.main(params);
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

	@Test
	public void testxmlBeanMarshaller() throws Exception{
		//This is quite tricky. when xmltypes.jar is not present comment the main code and let if condition to 
		//run which genrate the jar file. Once jar is created uncomment the main code and put xmltypes.jar in class path.
		if(!(new File("xmltypes.jar").exists())){
			String[] params = new String[]{"scomp", "out/Details.xsd"};		
			SchemaCompiler.main(params);
			// This will cause exit the code totally. Nothing will be executed after this.
			
		}
		String jarFile = "xmltypes.jar";

		Properties sysProp = System.getProperties();
		sysProp.list(System.out);
		String sep = sysProp.getProperty("path.separator");
		String javaClassPath = System.getProperty("java.class.path");
		if (javaClassPath == null || javaClassPath.trim().length() == 0) {
			javaClassPath = jarFile;
		}else {
			System.out.println(javaClassPath);
			javaClassPath = javaClassPath + sep + jarFile;
		}
		System.setProperty("java.class.path", javaClassPath);
		sysProp = System.getProperties();
		System.out.println(sysProp.getProperty("java.class.path"));
		
		//								Main Code here 
		
		ApplicationContext appContext =
				new ClassPathXmlApplicationContext("services-xmlBeanMarshaller.xml");
		XmlBeansMarshaller xml = (XmlBeansMarshaller)appContext.getBean("xmlBean2") ;
		File file = new File("out/input.xml");
		
		DetailsDocument detail =
			     DetailsDocument.Factory.parse(file);
						 System.out.println(
								 detail.getDetails().getPerson().getName().getFirstName().getTitile() + " " +
								 detail.getDetails().getPerson().getName().getFirstName().getStringValue() + " " + 
								 detail.getDetails().getPerson().getName().getLastName());	 	 
	}

}
