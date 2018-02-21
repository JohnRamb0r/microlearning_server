package application;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import application.util.FolderFunctions;
import application.util.TestDatenGenerator;

@SpringBootApplication
public class Application implements CommandLineRunner {
/*
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
*/


	    private static final Logger log = LoggerFactory.getLogger(Application.class);

	    @Autowired
	    TestDatenGenerator testDatenGenerator;
	    
	    public static void main(String[] args) {
	    	
	    	
	        SpringApplication.run(Application.class);
	    }

	    @Override
	    public void run(String... strings) throws Exception {
	    	log.info("Hello World!"); 
	    	
	    	FolderFunctions ff = new FolderFunctions();
	    	
	    	ff.createFolder("PENIS");
	    	
	    	log.info(ff.fullPath("hey"));
	    	log.info(ff.doesFolderExist(ff.fullPath("hey"))+"");
	    	
	    	testDatenGenerator.generateTestData();
	    	
	    	
	    	
		
	    }

	

}