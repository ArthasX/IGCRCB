/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.condition.IG893SearchCond;

/**
 * <p>
 * ���̲����߱���Ȩ����ͼҵ���߼�
 * </p>
 */
public interface IG893BL extends BaseBL{
	
	/**
	 * ��ȡ���̲����߱���Ȩ��
	 * @param cond ��������
	 * @return ���̲����߱���Ȩ���б�
	 */
	public List<IG893Info> searchIG893Info(final IG893SearchCond cond);
}
