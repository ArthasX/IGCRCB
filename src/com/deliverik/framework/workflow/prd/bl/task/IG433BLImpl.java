/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG433Info;
import com.deliverik.framework.workflow.prd.model.IG567Info;
import com.deliverik.framework.workflow.prd.model.condition.IG433SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG433DAO;
import com.deliverik.framework.workflow.prd.model.dao.IG567DAO;

/**
 * <p>概述:流程缺省参与者动作权限操作业务逻辑实现</p>
 * <p>功能描述：1.关闭或终止流程取得</p>
 * <p>创建记录：</p>
 */
public class IG433BLImpl extends BaseBLImpl implements IG433BL {

	/** ig567 DAO */
	protected IG567DAO ig567DAO;
	
	/** ig433 DAO */
	protected IG433DAO ig433DAO;
	
	/**
	 * 功能：流程评审DAO
	 * @param ig567DAO 流程评审dao
	 */
	public void setIg567DAO(
			IG567DAO ig567DAO) {
		this.ig567DAO = ig567DAO;
	}

	/**
	 * 功能：流程评审DAO
	 * @param ig433DAO 流程评审dao
	 */
	public void setIg433DAO(IG433DAO ig433DAO) {
		this.ig433DAO = ig433DAO;
	}



	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG567Info> searchIG567Info(IG433SearchCond cond, int start, int count){
		
		List<IG567Info> ret = ig567DAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * 功能：持久化处理
	 * 
	 * @param IncomeAdjust实体类
	 * @return IncomeAdjust实体类
	 */
	public IG433Info saveIG567Info(
			IG433Info processAssessment) throws BLException {
		return ig433DAO.save(processAssessment);
	}

	public IG433Info findIG567Info(
			IG433SearchCond cond, int start, int count) {
		if(ig433DAO.findByCond_Entity(cond, 0, 0)!=null && ig433DAO.findByCond_Entity(cond, 0, 0).size()>0){
		return ig433DAO.findByCond_Entity(cond, 0, 0).get(0);
		}else{
			return null;
		}
	}

}
