/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */

package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dut.model.DutyResult;
import com.deliverik.infogovernor.dut.model.condition.DutyResultSearchCond;
import com.deliverik.infogovernor.dut.model.dao.DutyResultDAO;

/**
 * 
 * 值班检查内容业务逻辑接口
 *
 */
public class DutyResultBLImpl extends BaseBLImpl implements DutyResultBL{
	
	/** DutyResult DAO */
	protected DutyResultDAO dutyResultDAO;
	
	public void setDutyResultDAO(
			DutyResultDAO dutyResultDAO) {
		this.dutyResultDAO = dutyResultDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(DutyResultSearchCond cond){
		
		return dutyResultDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param drid 值班检查内容ID
	 * @return 值班检查内容
	 */
	public DutyResult searchDutyResultByKey(Integer drid) throws BLException{
		
		return checkExistDutyResult(drid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部值班检查内容
	 */
	public List<DutyResult> searchDutyResultAll(){
		
		return dutyResultDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DutyResult> searchDutyResult(DutyResultSearchCond cond, int start, int count){
		
		return dutyResultDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param dutyResult 登录数据
	 * @return 值班检查内容
	 */
	public DutyResult registDutyResult(DutyResult dutyResult) throws BLException{
		
		return dutyResultDAO.save(dutyResult);
	}

	/**
	 * 删除处理
	 * 
	 * @param drid 值班检查内容ID
	 * @return
	 */
	public void deleteDutyResult(Integer drid) throws BLException{
		
		DutyResult dutyResult = checkExistDutyResult(drid);
		
		dutyResultDAO.delete(dutyResult);
	}

	/**
	 * 变更处理
	 * 
	 * @param dutyResult 变更数据
	 * @return 值班检查内容
	 */
	public DutyResult updateDutyResult(DutyResult dutyResult) throws BLException{
		
		checkExistDutyResult(dutyResult.getDrid());
		return dutyResultDAO.save(dutyResult);
	}

	/**
	 * 值班检查内容存在检查
	 * 
	 * @param drid 值班检查内容ID
	 * @return 值班检查内容
	 * @throws BLException 
	 */
	protected DutyResult checkExistDutyResult(Integer drid) throws BLException{
		DutyResult info = dutyResultDAO.findByPK(drid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","值班检查内容基本");
		}
		return info;
	}
}
