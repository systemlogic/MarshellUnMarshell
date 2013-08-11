<html>
<head>
<link href="/menu_assets/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="Header.jsp" %>
<%@ include file="Menu.jsp" %>
<table>
 <tr >
        <td valign="top" height="10px" width="222">
            <%@ include file="springCoreContainerMenu.jsp" %>
        </td>
        <td></td>
        <td align="left" bordercolor="c41200">
        	<h2>Core Container </h2>
        	<p><b>Core : </b> is the core implementation of framework using Inversion of Control aka IoC which is also coined the term Dependency Injuction.</p>
        	<p><b>Inversion of Control : </b> Inversion of control means now we have inverted the control of creating the object from our own using new operator to container or 
        	framework. Now it's the responsibility of container to create object as required. We maintain one xml file OR annotation where we configure our components, services, all the 
        	classes and their property. We just need to mention which service is needed by which component and container will create the object for us. This concept is known as 
        	<b>Dependency Injection</b> because all object dependency (resources) is injected into it by framework.</p>
        	<p><b>Bean : </b>The objects that form the backbone of your spring application and that are managed by the Spring IoC container are called beans. A bean is an object that is 
        	instantiated, assembled, and otherwise managed by a Spring IoC container</p>

<p>Bean which is interest of xml and annotation based example of Hello World.</p>        	
<pre style="background-color:F0F7FE; border: 1px solid #CCCCCC; display: block; margin: 12px 10px; padding: 12px 10px 16px; overflow-x: auto;">
package com.bean;

public class HelloBean {
	String msg = "Default message";
	int	count = 10;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}</pre>
<p>I think upto this point no problem. Let us define xml file say <b>services.xml</b> to be used By xml based example.</p>
<pre style="background-color:F0F7FE; border: 1px solid #CCCCCC; display: block; margin: 12px 10px; padding: 12px 10px 16px; overflow-x: auto;">
&lt;?xml version="1.0" encoding="UTF-8"?&gt;
&lt;beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans-3.0.xsd"&gt;

  &lt;!-- services --&gt;

  &lt;bean id="xmlHelloID" class="com.bean.HelloBean" &gt;
    &lt;property name="msg" value="Hello World"/&gt;
    &lt;property name="count" value="12"/&gt;
    &lt;!-- additional collaborators and configuration for this bean go here --&gt;
  &lt;/bean&gt;

  &lt;!-- more bean definitions for services go here --&gt;

&lt;/beans&gt;</pre>
<p>Above piece of code is suffice to explain the xml example how ever we will see annotation based code here as well. </p>
<p>By default xml configuration file is searched in resources folder of spring Maven project</p>
<pre style="background-color:F0F7FE; border: 1px solid #CCCCCC; display: block; margin: 12px 10px; padding: 12px 10px 16px; overflow-x: auto;">
package com.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public HelloBean myService(){
		return new HelloBean();
	}
}</pre>
<p>Here's the show begins.</p>

<pre style="background-color:F0F7FE; border: 1px solid #CCCCCC; display: block; margin: 12px 10px; padding: 12px 10px 16px; overflow-x: auto;">
package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bean.AppConfig;
import com.bean.HelloBean;

public class HelloWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// xml example
		ApplicationContext context =
			    new ClassPathXmlApplicationContext(new String[] {"services.xml"});
			HelloBean xmlBean = (HelloBean)context.getBean("xmlHelloID");
			System.out.println(xmlBean.getMsg() + " called " + xmlBean.getCount() + " times.");
			
		//	Annotation example
			ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
			  HelloBean annotationBean = ctx.getBean(HelloBean.class);
			  System.out.println(annotationBean.getMsg() + " called " + annotationBean.getCount() + " times.");
	}

}</pre>
<p>In above example Same bean is used in two different way to show the difference. It's a developer choice how s/he want to code it.</p>
<p>It is believe you are having good command over maven in case not just showing pom.xml for this example only.</p>
<pre style="background-color:F0F7FE; border: 1px solid #CCCCCC; display: block; margin: 12px 10px; padding: 12px 10px 16px; overflow-x: auto;">
&lt;project xmlns="http://maven.apache.org/POM/4.0.0" 
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
 http://maven.apache.org/xsd/maven-4.0.0.xsd"&gt;
  &lt;modelVersion&gt;4.0.0&lt;/modelVersion&gt;
  &lt;groupId&gt;org.springframework.samples&lt;/groupId&gt;
  &lt;artifactId&gt;HelloWorld&lt;/artifactId&gt;
  &lt;version&gt;0.0.1-SNAPSHOT&lt;/version&gt;
  
  &lt;properties&gt;

		&lt;!-- Generic properties --&gt;
		&lt;java.version&gt;1.6&lt;/java.version&gt;
		&lt;project.build.sourceEncoding&gt;UTF-8&lt;/project.build.sourceEncoding&gt;
		&lt;project.reporting.outputEncoding&gt;UTF-8&lt;/project.reporting.outputEncoding&gt;

		&lt;!-- Spring --&gt;
		&lt;spring-framework.version&gt;3.2.3.RELEASE&lt;/spring-framework.version&gt;

		&lt;!-- Hibernate / JPA --&gt;
		&lt;hibernate.version&gt;4.2.1.Final&lt;/hibernate.version&gt;

		&lt;!-- Logging --&gt;
		&lt;logback.version&gt;1.0.13&lt;/logback.version&gt;
		&lt;slf4j.version&gt;1.7.5&lt;/slf4j.version&gt;

		&lt;!-- Test --&gt;
		&lt;junit.version&gt;4.11&lt;/junit.version&gt;

	&lt;/properties&gt;
	
	&lt;dependencies&gt;
		&lt;!-- Spring and Transactions --&gt;
		&lt;dependency&gt;
			&lt;groupId&gt;org.springframework&lt;/groupId&gt;
			&lt;artifactId&gt;spring-context&lt;/artifactId&gt;
			&lt;version&gt;${spring-framework.version}&lt;/version&gt;
		&lt;/dependency&gt;
		&lt;dependency&gt;
			&lt;groupId&gt;org.springframework&lt;/groupId&gt;
			&lt;artifactId&gt;spring-tx&lt;/artifactId&gt;
			&lt;version&gt;${spring-framework.version}&lt;/version&gt;
		&lt;/dependency&gt;

		&lt;!-- Logging with SLF4J & LogBack --&gt;
		&lt;dependency&gt;
			&lt;groupId&gt;org.slf4j&lt;/groupId&gt;
			&lt;artifactId&gt;slf4j-api&lt;/artifactId&gt;
			&lt;version&gt;${slf4j.version}&lt;/version&gt;
			&lt;scope&gt;compile&lt;/scope&gt;
		&lt;/dependency&gt;
		&lt;dependency&gt;
			&lt;groupId&gt;ch.qos.logback&lt;/groupId&gt;
			&lt;artifactId&gt;logback-classic&lt;/artifactId&gt;
			&lt;version&gt;${logback.version}&lt;/version&gt;
			&lt;scope&gt;runtime&lt;/scope&gt;
		&lt;/dependency&gt;

		&lt;!-- Hibernate --&gt;
		&lt;dependency&gt;
			&lt;groupId&gt;org.hibernate&lt;/groupId&gt;
			&lt;artifactId&gt;hibernate-entitymanager&lt;/artifactId&gt;
			&lt;version&gt;${hibernate.version}&lt;/version&gt;
		&lt;/dependency&gt;

		
		&lt;!-- Test Artifacts --&gt;
		&lt;dependency&gt;
			&lt;groupId&gt;org.springframework&lt;/groupId&gt;
			&lt;artifactId&gt;spring-test&lt;/artifactId&gt;
			&lt;version&gt;${spring-framework.version}&lt;/version&gt;
			&lt;scope&gt;test&lt;/scope&gt;
		&lt;/dependency&gt;
		&lt;dependency&gt;
			&lt;groupId&gt;junit&lt;/groupId&gt;
			&lt;artifactId&gt;junit&lt;/artifactId&gt;
			&lt;version&gt;${junit.version}&lt;/version&gt;
			&lt;scope&gt;test&lt;/scope&gt;
		&lt;/dependency&gt;

	&lt;/dependencies&gt;	
&lt;/project&gt;</pre>
<p><a href='https://github.com/systemlogic/springhelloworld/archive/master.zip'><span>Download this Example</span></a></p>
   </td>
        <%@ include file="rightPane.jsp" %>
    </tr>
</table>
<%@ include file="FooterLink.jsp" %>
<%@ include file="Footer.jsp" %>
</body>
</html>