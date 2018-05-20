package cn.thinknovo.config;

import cn.thinknovo.autowire.OneBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringConsole {
    /*
          xml被注解完全取代，企业不一定会用，除非约定大于配置
          @Configuration 代表beans标签
          @Bean  代表bean标签  在其中只需要加入一个name属性设定一个唯一值

          如果多个config整合需要生成一个新的类，并且添加@Configuration头文件，然后基于@Import方法引入所有的config.class
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AllConfig.class);
        ThreeBean threeBean = applicationContext.getBean("threeBean", ThreeBean.class);
        System.out.println(threeBean);
        TwoBean twoBean = applicationContext.getBean("twoBean", TwoBean.class);
        System.out.println(twoBean);
//        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
