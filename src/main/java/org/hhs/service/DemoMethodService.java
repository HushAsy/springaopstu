package org.hhs.service;

import org.springframework.stereotype.Service;

/**
 * Created by hewater on 2017/9/2.
 */
@Service
public class DemoMethodService {
    public void add(){
        System.out.println("exec: service!");
    }
}
