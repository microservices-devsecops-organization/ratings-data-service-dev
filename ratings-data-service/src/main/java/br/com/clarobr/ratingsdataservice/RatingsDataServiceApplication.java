package br.com.clarobr.ratingsdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import java.util.Arrays;
import org.springframework.context.annotation.Bean;

import br.com.clarobr.ratingsdataservice.correlation.CorrelationHeaderFilter;

@SpringBootApplication
public class RatingsDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingsDataServiceApplication.class, args);
	}
	
	@Bean
    public FilterRegistrationBean<CorrelationHeaderFilter> correlationHeaderFilter() {
        FilterRegistrationBean<CorrelationHeaderFilter> filterRegBean = new FilterRegistrationBean<CorrelationHeaderFilter>();
        filterRegBean.setFilter(new CorrelationHeaderFilter());
        filterRegBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegBean;
    }

}

