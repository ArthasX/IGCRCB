/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.condition.HWorkVWSearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.HWorkVWDAO;
import com.deliverik.framework.workflow.prd.model.entity.HWorkVW;

/**
 * 历史工作统计业务逻辑接口实现
 */
public class HWorkBLImpl extends BaseBLImpl implements HWorkBL {
	protected HWorkVWDAO hworkVWDAO;
	
	public void setHworkVWDAO(HWorkVWDAO hworkVWDAO) {
		this.hworkVWDAO = hworkVWDAO;
	}

	public List<HWorkVW> searchHistoryCount(String dto,String pruserid) {
		HWorkVWSearchCondImpl cond=new HWorkVWSearchCondImpl();
		cond.setPropentime(dto);
		cond.setPruserid(pruserid);
		 List<HWorkVW> list = hworkVWDAO.findByCond(cond);
		return list;
	}

}
