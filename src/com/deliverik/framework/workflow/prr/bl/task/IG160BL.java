/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.condition.IG160SearchCond;

/**
 * <p>
 * ���������Ա����ͳ��ҵ���߼�
 * </p>
 */
public interface IG160BL extends BaseBL{
	
	/**
	 * ���������Ա����ͳ��
	 * 
	 * @return ���������Ա����ͳ���б�
	 */
	
	public List<IG160Info> searchIG160Info(final IG160SearchCond cond, final int start, final int count);
}
