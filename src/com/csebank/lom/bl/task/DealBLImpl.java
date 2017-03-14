/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Deal;
import com.csebank.lom.model.condition.DealSearchCond;
import com.csebank.lom.model.dao.DealDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 接待管理业务逻辑接口实现
 */
public class DealBLImpl extends BaseBLImpl implements DealBL {
	
	/** Recption DAO */
	protected DealDAO dealDAO;
	//protected RecptionGuestInfoDAO recptionguestinfoDAO;
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Deal> searchDeal(DealSearchCond cond, int start, int count){
		
		return dealDAO.findByCond(cond,start,count);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部接待信息
	 */
	public List<Deal> searchDealAll(){
		
		return dealDAO.findAll();
	}
    
	
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(DealSearchCond cond){
		
		return dealDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param rid 接待ID
	 * @return 接待ID
	 */
	public Deal searchDealByKey(Integer rid) throws BLException{
		
		return checkExistDeal(rid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部接待信息
	 */
	public List<Deal> searchRecptionAll(){
		
		return dealDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Deal> searchRecption(DealSearchCond cond, int start, int count){
		
		return dealDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 这个登录save处理方法也封装好了
	 * @param recption 登录数据
	 * @return 接待信息
	 */
	public Deal insertDealInfo(Deal recption) throws BLException{
		
		return dealDAO.save(recption);
	}

	/**
	 * 删除处理
	 * 
	 * @param rid 接待ID
	 * @return
	 */
	public void deleteDeal(Integer rid) throws BLException{
		
		Deal deal = checkExistDeal(rid);
		
		dealDAO.delete(deal);
	}

	/**
	 * 变更处理
	 * 
	 * @param recption 变更数据
	 * @return 接待信息
	 */
	public Deal updateDeal(Deal deal) throws BLException{
		
		checkExistDeal(deal.getRid());
		return dealDAO.save(deal);
	}

	/**
	 * 接待信息存在检查
	 * 
	 * @param rid 接待ID
	 * @return 接待信息
	 * @throws BLException 
	 */
	protected Deal checkExistDeal(Integer rid) throws BLException{
		Deal info = dealDAO.findByPK(rid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","外出就餐基本");
		}
		return info;
	}

	


	public void setDealDAO(DealDAO dealDAO) {
		this.dealDAO = dealDAO;
	}

}
