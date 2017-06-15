/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.ItemsCodesSt;
import com.csebank.lom.model.condition.LunchCardSearchCond;
import com.csebank.lom.model.dao.LunchCardDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 餐卡信息业务逻辑接口实现
 */
public class LunchCardBLImpl extends BaseBLImpl implements LunchCardBL {
	
	/** LunchCard DAO */
	protected LunchCardDAO lunchCardDAO;
	
	public void setLunchCardDAO(
			LunchCardDAO lunchCardDAO) {
		this.lunchCardDAO = lunchCardDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(LunchCardSearchCond cond){
		
		return lunchCardDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param typecode 餐卡ID
	 * @return 餐卡ID
	 */
	public ItemsCodesSt searchLunchCardByKey(Integer icid) throws BLException{
		ItemsCodesSt ret = lunchCardDAO.findByPK(icid);
		return ret;
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部餐卡信息
	 */
	public List<ItemsCodesSt> searchLunchCardAll(){
		
		return lunchCardDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ItemsCodesSt> searchLunchCard(LunchCardSearchCond cond, int start, int count){
		
		return lunchCardDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param eatery 登录数据
	 * @return 餐卡信息
	 */
	public ItemsCodesSt registLunchCard(ItemsCodesSt lunchCard) throws BLException{
		
		return lunchCardDAO.save(lunchCard);
	}

	/**
	 * 变更处理
	 * 
	 * @param eatery 变更数据
	 * @return 餐卡信息
	 */
	public ItemsCodesSt updateLunchCard(ItemsCodesSt lunchCard) throws BLException{
		
		checkExistEatery(lunchCard.getIcid());
		return lunchCardDAO.save(lunchCard);
	}

	/**
	 * 餐卡信息存在检查
	 * 
	 * @param typecode 餐卡ID
	 * @return 餐卡信息
	 * @throws BLException 
	 */
	protected ItemsCodesSt checkExistEatery(Integer icid) throws BLException{
		ItemsCodesSt info = lunchCardDAO.findByPK(icid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","餐卡");
		}
		return info;
	}

}
