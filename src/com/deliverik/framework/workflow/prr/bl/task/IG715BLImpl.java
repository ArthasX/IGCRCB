/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.framework.workflow.prr.model.condition.IG715SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG715DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG715TB;

/**
 * 
 * 服务工单关联流程业务逻辑实现
 *
 */
public class IG715BLImpl extends BaseBLImpl implements IG715BL {
	
	protected IG715DAO ig715DAO;
	
	public void setIg715DAO (IG715DAO ig715DAO) {
		this.ig715DAO = ig715DAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(IG715SearchCond cond){
		
		return ig715DAO.getSearchCount(cond);
		
	}

	/**
	 * 主键检索处理
	 * 
	 * @param sfid 服务工单关联流程ID
	 * @return 服务工单
	 */
	public IG715Info searchIG715InfoByKey(Integer sfid) throws BLException{
		
		return checkExistServiceProcessRecordRelation(sfid);
		
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部服务服务工单关联流程
	 */
	public List<IG715Info> searchIG715InfoAll(){
		
		return ig715DAO.findAll();
		
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG715Info> searchIG715Info(IG715SearchCond cond, int start, int count){
		
		return ig715DAO.findByCond(cond, start, count);
		
	}

	/**
	 * 保存处理
	 * 
	 * @param ServiceProcessRecordRelation 服务工单关联流程
	 * @return 服务工单关联流程
	 */
	public IG715Info registIG715Info(IG715Info ServiceProcessRecordRelation) throws BLException{

		return ig715DAO.save(ServiceProcessRecordRelation);
		
	}


	/**
	 * 变更处理
	 * 
	 * @param ServiceProcessRecordRelation 变更数据
	 * @return 服务工单
	 */
	public IG715Info updateIG715Info(IG715Info ServiceProcessRecordRelation) throws BLException{

		return ig715DAO.save(ServiceProcessRecordRelation);
		
	}

	/**
	 * 服务工单关联流程存在检查
	 * 
	 * @param sfid 服务工单ID
	 * @return 服务工单关联流程
	 * @throws BLException 
	 */
	protected IG715Info checkExistServiceProcessRecordRelation(Integer sfid) throws BLException{
		
		IG715Info ig715Info = ig715DAO.findByPK(sfid);
		
		if(ig715Info == null) {
			
			throw new BLException("IGCO10000.E004","服务工单基本");
			
		}
		
		return ig715Info;
	}


	/**
	 * 获取实体对象
	 * @return 实体对象
	 */
	public IG715TB getIG715TBInstance() {

		return ig715DAO.getIG715TBInstance();
		
	}
}
