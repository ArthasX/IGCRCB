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
 * Description: 外键注解声明
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.FIELD)
public @interface Fk {
	
	/** 主表名称 */
	String tablename() default "";
	
	/** 主表key */
	String fkfield() default "";
	
	/** 级联删除标识 */
	boolean deleteCascade() default true;
	
	/** 级联更新标识 */
	boolean updateCascade() default true;
}
