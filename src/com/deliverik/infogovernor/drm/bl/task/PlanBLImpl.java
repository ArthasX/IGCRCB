/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.PlanInfo;
import com.deliverik.infogovernor.drm.model.condition.PlanSearchCond;
import com.deliverik.infogovernor.drm.model.condition.PlanSearchCondImpl;
import com.deliverik.infogovernor.drm.model.dao.PlanDAO;

/**
 * 场景资产视图BL实现
 * @author wym
 *
 * 2015-03-09 下午1:46:00
 */
public class PlanBLImpl extends BaseBLImpl implements PlanBL {
	
	private PlanDAO planDao;

	public void setPlanDao(PlanDAO planDao) {
		this.planDao = planDao;
	}
	
	public List<PlanInfo> findByCond(PlanSearchCond cond, int start, int count) {
	
		return planDao.findByCond(cond, start, count);
	}

	public Integer getSearchCount(PlanSearchCond cond) {
		
		return planDao.getSearchCount(cond);
	}
	public PlanInfo findByPK(Integer id)throws BLException{
		PlanSearchCondImpl cond = new PlanSearchCondImpl();
		cond.setEiid(id);
		
		return planDao.findByCond(cond, 0, 0).get(0);
	}

}
