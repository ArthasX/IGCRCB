/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Eatery;
import com.csebank.lom.model.condition.EaterySearchCond;
import com.csebank.lom.model.dao.EateryDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 食堂成本信息业务逻辑接口实现
 */
public class EateryBLImpl extends BaseBLImpl implements EateryBL {
	
	/** Eatery DAO */
	protected EateryDAO eateryDAO;
	
	public void setEateryDAO(
			EateryDAO eateryDAO) {
		this.eateryDAO = eateryDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(EaterySearchCond cond){
		
		return eateryDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param eid 食堂成本ID
	 * @return 食堂成本ID
	 */
	public Eatery searchEateryByKey(Integer eid) throws BLException{
		Eatery ret = eateryDAO.findByPK(eid);
		return ret;
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部食堂成本信息
	 */
	public List<Eatery> searchEateryAll(){
		
		return eateryDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Eatery> searchEatery(EaterySearchCond cond, int start, int count){
		
		return eateryDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param eatery 登录数据
	 * @return 食堂成本信息
	 */
	public Eatery registEatery(Eatery eatery) throws BLException{
		
		return eateryDAO.save(eatery);
	}

	/**
	 * 变更处理
	 * 
	 * @param eatery 变更数据
	 * @return 食堂成本信息
	 */
	public Eatery updateEatery(Eatery eatery) throws BLException{
		
		checkExistEatery(eatery.getEid());
		return eateryDAO.save(eatery);
	}

	/**
	 * 食堂成本信息存在检查
	 * 
	 * @param eid 食堂成本ID
	 * @return 食堂成本信息
	 * @throws BLException 
	 */
	protected Eatery checkExistEatery(Integer eid) throws BLException{
		Eatery info = eateryDAO.findByPK(eid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","食堂成本");
		}
		return info;
	}

}
