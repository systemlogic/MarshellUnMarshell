package com.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.annotation.AppConfig;
import com.annotation.bean.UIDA;
import com.xml.bean.UID;

public class UIDTest {

	UID uid;

	@Before
	public void setUp() throws Exception {
		uid = new UID();
	}

	@Test
	public void testAutoWireByName() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("services-xml-ByName.xml");
		uid = (UID)ctx.getBean("uidBEAN");
		System.out.println("Autowiring by Name");
		System.out.println(uid.getName() + uid.getAddress());
		System.out.println(uid.getName() + uid.getOfficeAddress());
		assertTrue(true);
	}

	@Test
	public void testAutoWireByType() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("services-xml-ByType.xml");
		uid = (UID)ctx.getBean("uidBEAN");
		System.out.println("Autowiring by Type");
		System.out.println(uid.getName() + uid.getAddress());
		System.out.println(uid.getName() + uid.getOfficeAddress());
		assertTrue(true);
	}

	@Test
	public void testAutoWireDefault() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("services-xml-no.xml");
		uid = (UID)ctx.getBean("uidBEAN");
		System.out.println("Autowiring by No/Default");
		System.out.println(uid.getName() + uid.getAddress());
		System.out.println(uid.getName() + uid.getOfficeAddress());
		assertTrue(true);
	}
	@Test
	public void testAutoWireConstructor() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("services-xml-Constructor.xml");
		uid = (UID)ctx.getBean("uidBEAN");
		System.out.println("Autowiring by Constructor");
		System.out.println(uid.getName() + uid.getAddress());
		System.out.println(uid.getName() + uid.getOfficeAddress());
		assertTrue(true);
	}
	
	@Test
	public void testAutoWireAnnotation() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		UIDA uid = ctx.getBean(UIDA.class);
		System.out.println("Autowiring by Annotation");
		System.out.println(uid.getName() + uid.getAddress());
		System.out.println(uid.getName() + uid.getOfficeAddress());
		assertTrue(true);
	}
}
