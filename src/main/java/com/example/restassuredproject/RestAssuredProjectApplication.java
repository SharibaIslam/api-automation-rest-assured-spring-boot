package com.example.restassuredproject;


import com.example.restassuredproject.utility.ReadFromPropertiesFile;
import com.example.restassuredproject.utility.UTIL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


@SpringBootApplication()
@Configuration
public class RestAssuredProjectApplication {

	@Autowired
	static
	ResourceLoader resourceLoader;

	

	public RestAssuredProjectApplication() throws IOException {
	}

	public static void main(String[] args) throws IOException {
		/*Resource resource=resourceLoader.getResource("classpath:testng.xml");
		//File file = resource.getFile();
		String jrxmlFilePath = resource.getFile().getPath();*/


		ApplicationContext c = SpringApplication.run(RestAssuredProjectApplication.class, args);
		ReadFromPropertiesFile readFromPropertiesFile=new ReadFromPropertiesFile();

		/*File resource = new ClassPathResource("testng.xml").getFile();
		String text = new String(String.valueOf(resource.toPath()));*/

		/*ClassPath.ClassFile resource = new ClassPath("/data").getClassFile("testng.xml");
		String text = new String(String.valueOf(resource.getPath()));*/

		/*Resource sourceFile = new ClassPathResource("testng.xml");
		String jrxmlFilePath = sourceFile.getFile().getPath();*/

		/*Resource resource=resourceLoader.getResource("classpath:testng.xml");

		String jrxmlFilePath = resource.getFile().getPath();*/

		//String file = RestAssuredProjectApplication.class.getClassLoader().getResource("testng.xml").getPath();


		UTIL util = new UTIL();
		Properties prop = util.readPropData();
		String testng_path= prop.getProperty("spring.config.import");
		System.out.println(readFromPropertiesFile.getPropertyKeyVariable());
		//System.out.println("file location is:" +readFromPropertiesFile.getPropertyKeyVariable());
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add(readFromPropertiesFile.getPropertyKeyVariable());//path to xml..
		testng.setTestSuites(suites);
		testng.run();



	}

}
