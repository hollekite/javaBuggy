package cn.thinknovo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OneConfig {

    // <bean name="fourBean01" />
    @Bean(name="threeBean")
    public ThreeBean getThreeBean(){
        return new ThreeBean();
    }
}
