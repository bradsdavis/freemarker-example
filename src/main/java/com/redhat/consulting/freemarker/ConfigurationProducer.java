package com.redhat.consulting.freemarker;

import javax.enterprise.inject.Produces;

import freemarker.template.Configuration;

public class ConfigurationProducer {

	@Produces
	public Configuration produceFreemarkerConfiguration() {
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(this.getClass(), "/");
		
		return configuration;
	}
}
