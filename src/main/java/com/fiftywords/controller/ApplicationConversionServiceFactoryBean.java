package com.fiftywords.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		registry.addConverter(getStringToDateConverter());
	}

	public Converter<String, Date> getStringToDateConverter() {
		return new Converter<String, Date>() {

			@Override
			public Date convert(String source) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				try {
					return sdf.parse(source);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		};
	}
}
