package com.example.mymapperscan.business.config;

import com.example.mymapperscan.business.myspring.MyMapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MyMapperScan("com.example.mymapperscan.business.mapper")
public class AppConfig {
}
