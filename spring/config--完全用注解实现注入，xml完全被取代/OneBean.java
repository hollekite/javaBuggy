package cn.thinknovo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class OneBean {
    private cn.thinknovo.config.ThreeBean ThreeBean;
    public TwoBean twoBeans;  //public和安全无关   如果bean模型存在set、get方法，那么对应的属性或者对象应该遵守规则private约束

    public OneBean() {
        System.out.println("OneBean构造函数1");
    }

    @Autowired
    public OneBean(@Qualifier("threeBean") cn.thinknovo.config.ThreeBean tb) {
        System.out.println("OneBean构造函数2  threeBean=");
    }

    @Autowired
    public OneBean(@Qualifier("threeBean") cn.thinknovo.config.ThreeBean tb, @Qualifier("twoBean")TwoBean tb2) {
        System.out.println("OneBean构造函数3  threeBean=");
    }

    public void setTB(TwoBean twoBean) {
        System.out.println("setTB-----------------");

    }


    public void initMethod() {
        System.out.println("OneBean初始化方法");
    }

    public void destoryMethod() {
        System.out.println("OneBean销毁方法");
    }
}
