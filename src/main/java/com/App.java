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
    public MyOrder getSettings() {
		return settings;
	}

	public void setSettings(MyOrder settings) {
		this.settings = settings;
	}

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
}
