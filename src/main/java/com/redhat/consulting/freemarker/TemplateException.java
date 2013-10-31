package com.redhat.consulting.freemarker;

public class TemplateException extends RuntimeException {

	public TemplateException(String message, Throwable t) {
		super(message, t);
	}
}
