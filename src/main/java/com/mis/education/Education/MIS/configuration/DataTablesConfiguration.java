package com.mis.education.Education.MIS.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class,basePackages = "com.mis.education.Education.MIS.repositories")
public class DataTablesConfiguration {}
