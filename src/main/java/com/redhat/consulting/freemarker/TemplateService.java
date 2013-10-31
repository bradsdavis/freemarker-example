package com.redhat.consulting.freemarker;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import freemarker.template.Configuration;
import freemarker.template.Template;

@ApplicationScoped
public class TemplateService {

	@Inject
	private Configuration configuration;
	
	public void produce(String templateName, Map<String, Object> context, Writer writer) {
		try {
			Template template = configuration.getTemplate(templateName);
			template.process(templateName, writer);
		}
		catch(Exception e) {
			throw new TemplateException("Exception executing template: "+templateName, e);
		}
	}

	public void produce(String templateName, Map<String, Object> context, OutputStream output) {
		//create writer
		OutputStreamWriter writer = new OutputStreamWriter(output);
		
		//call produce.
		produce(templateName, context, writer);
	}
	
	public String produce(String templateName, Map<String, Object> context) {
		//create writer
		Writer writer = new StringWriter();
		
		//call produce.
		produce(templateName, context, writer);
		
		//return string.
		return writer.toString();
	}
	
	
}
