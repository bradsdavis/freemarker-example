package com.redhat.consulting.freemarker;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerTest {

	@Test
	public void testFreemarker() throws Exception {
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(this.getClass(), "/");
		Template template = configuration.getTemplate("/email/email-example.ftl");
		Writer writer = new StringWriter();
		
		Map<String, Object> templateMap = new HashMap<String, Object>();
		templateMap.put("name", "Sal");
		templateMap.put("total", "200.00");
		
		template.process(templateMap, writer);
		
		System.out.println(writer.toString());
	}
}
