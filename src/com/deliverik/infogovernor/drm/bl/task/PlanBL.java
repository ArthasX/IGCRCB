/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.PlanInfo;
import com.deliverik.infogovernor.drm.model.condition.PlanSearchCond;

/**
 * 场景资产视图BL
 * @author wym
 *
 * 2015-03-09 下午1:46:00
 */
public interface PlanBL extends BaseBL{
	
	public List<PlanInfo> findByCond(PlanSearchCond cond, int start, int count);

	public Integer getSearchCount(PlanSearchCond cond);
	
	public PlanInfo findByPK(Integer id)throws BLException;

}
