package org.hhs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by hewater on 2017/9/2.
 */
@Configuration
@ComponentScan(basePackages = {"org.hhs"})
@EnableAspectJAutoProxy
public class AopConfig {
}
