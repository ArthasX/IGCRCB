/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG019Info;
import com.deliverik.framework.workflow.prr.model.condition.IG019SearchCond;

/**
 * <p>
 * �¼��ͷ����������̻���ͳ��ҵ���߼�
 * </p>
 */
public interface IG019BL extends BaseBL{
	
	/**
	 * �¼��ͷ����������̻���ͳ��(����������)
	 * 
	 * @return �¼��ͷ����������̻���ͳ���б�
	 */
	
	public List<IG019Info> searchIG019Info(final IG019SearchCond cond, final int start, final int count);
	
	/**
	 * �¼��ͷ����������̻���ͳ�Ƹ���(����������)
	 * 
	 * @return �¼��ͷ����������̻���ͳ�Ƹ���
	 */
	public int getIG019Info(final IG019SearchCond cond);
}
