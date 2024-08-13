package com.mis.education.Education.MIS;

import com.mis.education.Education.MIS.captcha.CaptchaDetailsSource;
import com.mis.education.Education.MIS.captcha.CaptchaGenServlet;
import com.mis.education.Education.MIS.fileStorage.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableConfigurationProperties({FileStorageProperties.class})
public class FlowChakraApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowChakraApplication.class, args);
	}

	@Bean
	ServletRegistrationBean captchaServletRegistration () {
		ServletRegistrationBean srb = new ServletRegistrationBean();
		srb.setName("CaptchaServlet");
		srb.setServlet(new CaptchaGenServlet());
		srb.addUrlMappings("/captcha.jpg");
		return srb;
	}

	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return new ServletContextInitializer() {
			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {
				//servletContext.setSessionTrackingModes(Collections.singleton(SessionTrackingMode.COOKIE));
				//SessionCookieConfig sessionCookieConfig = servletContext.getSessionCookieConfig();
				//sessionCookieConfig.setHttpOnly(true);
				//sessionCookieConfig.setSecure(true);
			}
		};
	}


	@Bean
	public CaptchaDetailsSource getCaptchaDetailsSource() {
		return new CaptchaDetailsSource();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
