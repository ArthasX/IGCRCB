/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.dao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ע������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.FIELD)
public @interface Fk {
	
	/** �������� */
	String tablename() default "";
	
	/** ����key */
	String fkfield() default "";
	
	/** ����ɾ����ʶ */
	boolean deleteCascade() default true;
	
	/** �������±�ʶ */
	boolean updateCascade() default true;
}
