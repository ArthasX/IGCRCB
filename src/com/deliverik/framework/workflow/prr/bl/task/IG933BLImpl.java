/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.IG933SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG933DAO;

/**
 * 
 * 服务工单业务逻辑接口
 *
 */
public class IG933BLImpl extends BaseBLImpl implements IG933BL {
	
	protected IG933DAO ig933DAO;
	
	public void setIg933DAO(IG933DAO ig933DAO) {
		this.ig933DAO = ig933DAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(IG933SearchCond cond){
		
		return ig933DAO.getSearchCount(cond);
		
	}

	/**
	 * 主键检索处理
	 * 
	 * @param sfid 服务工单ID
	 * @return 服务工单
	 */
	public IG933Info searchIG933InfoByKey(Integer sfid) throws BLException{
		
		return checkExistServiceForm(sfid);
		
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部服务工单信息
	 */
	public List<IG933Info> searchIG933InfoAll(){
		
		return ig933DAO.findAll();
		
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部服务工单信息时间升序
	 */
	public List<IG933Info> searchIG933InfoAllAsc(){
		
		return ig933DAO.findAllAsc();
		
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG933Info> searchIG933Info(IG933SearchCond cond, int start, int count){
		
		return ig933DAO.findByCond(cond, start, count);
		
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表时间升序
	 */
	public List<IG933Info> searchIG933InfoAsc(IG933SearchCond cond, int start, int count){
		
		return ig933DAO.findByCondAsc(cond, start, count);
		
	}
	
	/**
	 * 登记处理
	 * 
	 * @param ig933Info 数据
	 * @return 服务工单
	 */
	public IG933Info registIG933Info(IG933Info ig933Info) throws BLException{

		return ig933DAO.save(ig933Info);
		
	}


	/**
	 * 变更处理
	 * 
	 * @param ig933Info 变更数据
	 * @return 服务工单
	 */
	public IG933Info updateIG933Info(IG933Info ig933Info) throws BLException{

		return ig933DAO.save(ig933Info);
		
	}

	/**
	 * 服务工单存在检查
	 * 
	 * @param sfid 服务工单ID
	 * @return 服务工单
	 * @throws BLException 
	 */
	protected IG933Info checkExistServiceForm(Integer sfid) throws BLException{
		
		IG933Info serviceForm = ig933DAO.findByPK(sfid);
		
		if(serviceForm == null) {
			
			throw new BLException("IGCO10000.E004","服务工单基本");
			
		}
		
		return serviceForm;
	}

	 /**
	 * 获取服务工单编号最大值
	 * 
	 * @param code 服务工单编码类型
	 * @return 服务工单编号最大值
	 */
	public String searchMaxID(String code) {
		
		String maxid = ig933DAO.searchMaxID(code);

		return maxid;
	}
}
