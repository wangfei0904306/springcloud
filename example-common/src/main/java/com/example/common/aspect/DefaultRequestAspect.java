package com.example.common.aspect;

import com.example.common.constant.HeaderConstants;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author wangfei
 */
@Aspect
@Order(85)
@Component
public class DefaultRequestAspect {

	@Pointcut("(@target(org.springframework.web.bind.annotation.RestController)) && (execution(public * com.example..*.*(..)))")
	public void executionService() {
	}

	/**
	 * 方法调用之前调用
	 */
	@Before("executionService()")
	public void doBefore(){
		SysContext.init();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();


		// 通用用户信息
		String userInfo = request.getHeader("x-user");
		try {
			if (userInfo != null) {
				userInfo = URLDecoder.decode(userInfo, "UTF-8");//解码
			}
		} catch (UnsupportedEncodingException e) {
			userInfo = "{}";
		}
		if(StringUtils.isNotEmpty(userInfo)){
			SysContext.putUser(userInfo);
		}

		// 客户端版本
		String version = request.getHeader(HeaderConstants.X_VERSION);
		if(StringUtils.isNotEmpty(version)){
			SysContext.putVersion(version);
		}
	}

	/**
	 * 方法之后调用
	 */
	@AfterReturning(pointcut = "executionService()")
	public void  doAfterReturning(){
		SysContext.remove();
	}
	
}
