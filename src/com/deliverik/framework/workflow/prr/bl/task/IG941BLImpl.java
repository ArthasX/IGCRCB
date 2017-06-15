/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG941Info;
import com.deliverik.framework.workflow.prr.model.condition.IG941SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG941DAO;

/**
 * 
 * 服务工单日志业务逻辑接口
 *
 */
public class IG941BLImpl extends BaseBLImpl implements IG941BL {
	
	protected IG941DAO ig941DAO;
	
	public void setIg941DAO(IG941DAO ig941DAO) {
		this.ig941DAO = ig941DAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(IG941SearchCond cond){
		
		return ig941DAO.getSearchCount(cond);
		
	}

	/**
	 * 主键检索处理
	 * 
	 * @param sflid 服务工单日志ID
	 * @return 服务工单日志
	 */
	public IG941Info searchIG941InfoByKey(Integer sflid) throws BLException{
		
		return checkExistServiceFormLog(sflid);
		
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部服务工单日志信息
	 */
	public List<IG941Info> searchIG941InfoAll(){
		
		return ig941DAO.findAll();
		
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG941Info> searchIG941Info(IG941SearchCond cond, int start, int count){
		
		return ig941DAO.findByCond(cond, start, count);
		
	}

	/**
	 * 登记处理
	 * 
	 * @param ig941Info 数据
	 * @return 服务工单日志
	 */
	public IG941Info registIG941Info(IG941Info ig941Info) throws BLException{

		return ig941DAO.save(ig941Info);
		
	}


	/**
	 * 变更处理
	 * 
	 * @param ig941Info 变更数据
	 * @return 服务工单日志
	 */
	public IG941Info updateIG941Info(IG941Info ig941Info) throws BLException{

		return ig941DAO.save(ig941Info);
		
	}

	/**
	 * 服务工单日志存在检查
	 * 
	 * @param sflid 服务工单日志ID
	 * @return 服务工单日志
	 * @throws BLException 
	 */
	protected IG941Info checkExistServiceFormLog(Integer sflid) throws BLException{
		
		IG941Info serviceFormLog = ig941DAO.findByPK(sflid);
		
		if(serviceFormLog == null) {
			
			throw new BLException("IGCO10000.E004","服务工单日志基本");
			
		}
		
		return serviceFormLog;
	}

}
