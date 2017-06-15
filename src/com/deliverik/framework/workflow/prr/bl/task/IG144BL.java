/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG019SearchCond;

/**
 * <p>
 * �¼��ͷ����������̻���ͳ��ҵ���߼�
 * </p>
 */
public interface IG144BL extends BaseBL{
	
	/**
	 * �¼����̻���ͳ��
	 * 
	 * @return �¼����̻���ͳ���б�
	 */
	
	public List<IG500Info> searchIG019Info(final IG019SearchCond cond, final int start, final int count);
	
	/**
	 * �¼����̻���ͳ�Ƹ���
	 * 
	 * @return �¼����̻���ͳ�Ƹ���
	 */
	public int getIG019Info(final IG019SearchCond cond);
	
	/**
	 * �����������̻���ͳ��
	 * 
	 * @return �����������̻���ͳ���б�
	 */
	
	public List<IG500Info> searchServiceRequest(final IG019SearchCond cond, final int start, final int count);
	
	/**
	 * �����������̻���ͳ�Ƹ���
	 * 
	 * @return �����������̻���ͳ�Ƹ���
	 */
	public int getServiceRequestSearchCount(final IG019SearchCond cond);
}
