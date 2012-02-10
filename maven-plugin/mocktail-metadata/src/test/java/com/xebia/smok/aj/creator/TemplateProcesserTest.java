package com.xebia.smok.aj.creator;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.junit.Test;

public class TemplateProcesserTest {

	@Test
	public void shouldCreateClassAspect() throws Exception {
		Map<String, Object> contextMap = new HashMap<String, Object>();
		contextMap.put("className", "TemplateProcesserTest");
		contextMap.put("fqcn", "com.xebia.smok.aj.creator.TemplateProcesserTest");

		String templatedString = TemplateProcesser.TEMPLATE_PROCESSER
				.processTemplate(
						contextMap,
						new ClasspathResourceLoader()
								.getResourceStream("com/xebia/smok/aj/creator/class/recording/template.vm"));

		String expectedpointcut = "pointcut callPointcut() : call(* com.xebia.smok.aj.creator.TemplateProcesserTest.*(..));";
		//TODO Check why containsString is not working
		assertTrue(templatedString.contains(expectedpointcut));
		assertTrue(templatedString.contains("String fqcn = \"com.xebia.smok.aj.creator.TemplateProcesserTest\";"));
	}

	@Test
	public void shouldCreateMethodAspect() throws Exception {
		Map<String, Object> contextMap = new HashMap<String, Object>();
		String []methods = {"method1", "method2"};
		contextMap.put("className", "TemplateProcesserTest");
		contextMap.put("fqcn", "com.xebia.smok.aj.creator.TemplateProcesserTest");
		contextMap.put("methods", methods);

		String templatedString = TemplateProcesser.TEMPLATE_PROCESSER
				.processTemplate(
						contextMap,
						new ClasspathResourceLoader()
								.getResourceStream("com/xebia/smok/aj/creator/methods/recording/template.vm"));

		String expectedpointcut = "pointcut callPointcutmethod1() : call(* com.xebia.smok.aj.creator.TemplateProcesserTest.method1(..));";
		//TODO Check why containsString is not working
		assertTrue(templatedString.contains(expectedpointcut));

		expectedpointcut = "pointcut callPointcutmethod2() : call(* com.xebia.smok.aj.creator.TemplateProcesserTest.method2(..));";
		assertTrue(templatedString.contains(expectedpointcut));
		assertTrue(templatedString.contains("String fqcn = \"com.xebia.smok.aj.creator.TemplateProcesserTest\";"));
	}
}