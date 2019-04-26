package com.myproject.restfulwebservices.helloworld;


import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	//private static final ApiInfo DEFAULT_API_INFO = null;
	/*public static final Contact DEFAULT_CONTACT = new Contact("FDS", "FDS", "");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(

			"Awesome API Title", "Awesome API Description", "1.0",

			"urn:tos", DEFAULT_CONTACT, 

			"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
*/
	@Bean
	public Docket forSwagger() {
		return new Docket(DocumentationType.SWAGGER_2);
		
		
	}
	
	
}
