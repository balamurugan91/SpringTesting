package com.spring.test.advice;

import org.owasp.encoder.Encode;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class XSSFilterAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {

		if(body instanceof String)
		{
			body = cleanXSS((String)body);
			System.out.println("cleanxss:"+body);
		}
		return body;
	}
	
	private String cleanXSS(String value) {
		// You'll need to remove the spaces from the html entities below
		
		//value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
		//value = value.replaceAll("'", "&#39;");
		//value = value.replaceAll("'", "''");
		/*value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		value = value.replaceAll("(?i)<script.*?>.*?<script.*?>", "");
		value = value.replaceAll("(?i)<script.*?>.*?</script.*?>", "");
		value = value.replaceAll("(?i)<.*?javascript:.*?>.*?</.*?>", "");
		value = value.replaceAll("(?i)<.*?\\s+on.*?>.*?</.*?>", "");
		value = value.replaceAll("<script>", "");
		value = value.replaceAll("</script>", "");
		
		value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		*/
		return Encode.forHtmlContent(value);
	}
	
	
	
}