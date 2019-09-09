package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ServiceConfig.class,WebAppConfig.class,PersistanceConfig.class})
public class RootAppConfig {

}
