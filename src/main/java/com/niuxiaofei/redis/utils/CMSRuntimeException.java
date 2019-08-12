package com.niuxiaofei.redis.utils;
/**
 * 
 * @ClassName: CMSRuntimeException 
 * @Description:自定义运行时异常类
 * @author:nxf 
 * @date: 2019年7月15日 上午8:44:36
 */
public class CMSRuntimeException extends RuntimeException{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @Title:CMSRuntimeException
	 * @Description:无参构造方法调用父类方法
	 */
	public CMSRuntimeException() {
		super();
	}
	
	/**
	 * 
	 * @Title:CMSRuntimeException
	 * @Description:有参构造方法调用父类方法
	 * @param message 异常信息
	 */
	public CMSRuntimeException(String message) {
		super(message);
	}
}
