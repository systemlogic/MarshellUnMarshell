package com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import com.bean.ClientData;
import com.bean.Item;
import com.bean.MyOrder;
public class App {
	private static final String FILE_NAME = "order.xml";
    private MyOrder settings = new MyOrder();
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public void saveSettings() throws IOException {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(FILE_NAME);
            this.marshaller.marshal(settings, new StreamResult(os));
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }

    public MyOrder loadSettings() throws IOException {
        FileInputStream is = null;
        try {
            is = new FileInputStream(FILE_NAME);
            this.settings = (MyOrder) this.unmarshaller.unmarshal(new StreamSource(is));
            return this.settings;
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext appContext =
            new ClassPathXmlApplicationContext("services.xml");
        App application = (App) appContext.getBean("XMLConverter");
        application.settings.setTotal(100);
        application.settings.setReference("hello");
        ClientData client = new ClientData();
        client.setName("Pranshi Dhingra");
        client.setAddress("Bangalore");
        application.settings.setClientData(client);
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
        item._unitPrice = 36;
        items.add(item);
        application.settings.setItemsList(items);
        application.saveSettings();
        MyOrder order = application.loadSettings();
        System.out.println(order.getTotal());
    }
}