/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */

package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dut.model.DutyResultVWInfo;
import com.deliverik.infogovernor.dut.model.condition.DutyResultVWSearchCond;
import com.deliverik.infogovernor.dut.model.dao.DutyResultVWDAO;


/**
 * 
 * 值班日报业务逻辑接口
 *
 */
public class DutyResultVWBLImpl extends BaseBLImpl implements DutyResultVWBL{
	
	/** DutyResultVWInfo DAO */
	protected DutyResultVWDAO dutyResultVWDAO;
	
	
	/**
	 * @param dutyResultVWDAO the dutyResultVWDAO to set
	 */
	public void setDutyResultVWDAO(DutyResultVWDAO dutyResultVWDAO) {
		this.dutyResultVWDAO = dutyResultVWDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(DutyResultVWSearchCond cond){
		
		return dutyResultVWDAO.getSearchCount(cond);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部值班检查内容
	 */
	public List<DutyResultVWInfo> searchDutyResultVWAll(){
		
		return dutyResultVWDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DutyResultVWInfo> searchDutyResultVW(DutyResultVWSearchCond cond, int start, int count){
		
		return dutyResultVWDAO.findByCond(cond,start,count);
	}

	
}
