/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.PlanInfo;
import com.deliverik.infogovernor.drm.model.condition.PlanSearchCond;

/**
 * �����ʲ���ͼBL
 * @author wym
 *
 * 2015-03-09 ����1:46:00
 */
public interface PlanBL extends BaseBL{
	
	public List<PlanInfo> findByCond(PlanSearchCond cond, int start, int count);

	public Integer getSearchCount(PlanSearchCond cond);
	
	public PlanInfo findByPK(Integer id)throws BLException;

}
