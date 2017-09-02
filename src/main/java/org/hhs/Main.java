package org.hhs;

import org.hhs.config.AopConfig;
import org.hhs.service.DemoAnnotationService;
import org.hhs.service.DemoMethodService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by hewater on 2017/9/2.
 */
public class Main {
    public static void main(String...args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
        demoAnnotationService.add();
        demoMethodService.add();
        context.close();
    }
}
