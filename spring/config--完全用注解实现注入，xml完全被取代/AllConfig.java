package cn.thinknovo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({OneConfig.class, TwoConfig.class})
public class AllConfig {
}
