package cn.thinknovo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwoConfig {

    @Bean(name="twoBean")
    public TwoBean getTwoBean(){
        return new TwoBean();
    }
}
