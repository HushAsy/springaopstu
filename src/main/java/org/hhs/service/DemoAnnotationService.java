package org.hhs.service;

import org.hhs.annotation.Action;
import org.springframework.stereotype.Service;

/**
 * Created by hewater on 2017/9/2.
 */
@Service
public class DemoAnnotationService {
    @Action(name = "注解式拦截的add操作")
    public void add(){

    }
}
