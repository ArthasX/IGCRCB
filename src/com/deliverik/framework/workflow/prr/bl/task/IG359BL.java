/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG359Info;
import com.deliverik.framework.workflow.prr.model.condition.IG359SearchCond;

/**
 * <p>
 * ����ʲ�����ͳ�ƻ���ͳ��ҵ���߼�
 * </p>
 */
public interface IG359BL extends BaseBL{
	
	/**
	 * ����ʲ�����ͳ�ƻ���ͳ��
	 * 
	 * @return ����ʲ�����ͳ�ƻ���ͳ���б�
	 */
	
	public List<IG359Info> searchIG359Info(final IG359SearchCond cond, final int start, final int count);
}
