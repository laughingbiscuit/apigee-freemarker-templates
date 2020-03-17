package com.callout.api;

import com.apigee.flow.execution.ExecutionContext;
import com.apigee.flow.execution.ExecutionResult;
import com.apigee.flow.execution.spi.Execution;
import com.apigee.flow.message.MessageContext;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App implements Execution
{
	public ExecutionResult execute(MessageContext messageContext, ExecutionContext executionContext) {

		try {

                  Configuration cfg = new Configuration(new Version("2.3.23"));

                  cfg.setClassForTemplateLoading(App.class, "/");
                  cfg.setDefaultEncoding("UTF-8");

                  Template template = cfg.getTemplate("test.ftl");

                  Map<String, Object> templateData = new HashMap<>();
                  templateData.put("msg", "Today is a beautiful day");

                  StringWriter out = new StringWriter();
            
                  template.process(templateData, out);

                  messageContext.setVariable("response.content", out.getBuffer().toString());
                  out.flush();


		  return ExecutionResult.SUCCESS;

		} catch (Exception e) {
	  	  return ExecutionResult.ABORT;
		}
	}

}
