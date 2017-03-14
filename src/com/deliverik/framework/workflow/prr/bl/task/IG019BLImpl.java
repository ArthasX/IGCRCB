package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG019Info;
import com.deliverik.framework.workflow.prr.model.condition.IG019SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG019DAO;

/**
 * <p>
 * 事件和服务请求流程汇总统计业务逻辑实现
 * </p>
 */
public class IG019BLImpl extends BaseBLImpl implements IG019BL{
	
	/**事件和服务请求流程汇总统计操作*/
	protected IG019DAO ig019DAO;
	
	/**
	 * 设置事件和服务请求流程汇总统计操作
	 * @param ig019DAO Ig019DAO
	 */
	public void setIg019DAO(IG019DAO ig019DAO) {
		this.ig019DAO = ig019DAO;
	}

	/**
	 * 事件和服务请求流程汇总统计(按机构汇总)
	 * 
	 * @return 事件和服务请求流程汇总统计列表
	 * @throws BLException
	 */
	
	public List<IG019Info> searchIG019Info(final IG019SearchCond cond, final int start, final int count) {
		return ig019DAO.findByCond(cond, start, count);
	}

	/**
	 * 事件和服务请求流程汇总统计个数(按机构汇总)
	 * 
	 * @return 事件和服务请求流程汇总统计个数
	 */
	public int getIG019Info(IG019SearchCond cond) {
		return ig019DAO.getSearchCount(cond);
	}
	
	

}
