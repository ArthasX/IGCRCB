/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG003Info;
import com.deliverik.framework.workflow.prr.model.condition.IG003SearchCond;

/**
 * <p>
 * ������Ȼ���ͳ��ҵ���߼�
 * </p>
 */
public interface IG003BL extends BaseBL{
	
	/**
	 * ������Ȼ���ͳ��
	 * 
	 * @return ������Ȼ���ͳ���б�
	 */
	
	public List<IG003Info> searchIG003Info(final IG003SearchCond cond, final int start, final int count);
}
