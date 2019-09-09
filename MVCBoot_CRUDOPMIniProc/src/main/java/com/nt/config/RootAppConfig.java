package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistanceConfig.class,WebAppConfig.class,ServiceConfig.class})
public class RootAppConfig {

}
