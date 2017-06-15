/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.dao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 字段类型注解标识
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.FIELD)
public @interface FieldType {

	/** 字段类型 */
	String value() default "";
	
	/** 非空标识 */
	boolean notNull() default false;
}
