/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.AdvanCescost;
import com.csebank.lom.model.condition.AdvanCescostSearchCond;
import com.csebank.lom.model.dao.AdvanCescostDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 预支费用业务逻辑接口实现
 */
public class AdvanCescostBLImpl extends BaseBLImpl implements AdvanCescostBL {
	
	/** AdvanCescost DAO */
	protected AdvanCescostDAO advanCescostDAO;
	
	public void setAdvanCescostDAO(
			AdvanCescostDAO advanCescostDAO) {
		this.advanCescostDAO = advanCescostDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(AdvanCescostSearchCond cond){
		
		return advanCescostDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param acid 预支费用ID
	 * @return 预支费用ID
	 */
	public AdvanCescost searchAdvanCescostByKey(Integer acid) throws BLException{
		
		return checkExistAdvanCescost(acid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部预支费用信息
	 */
	public List<AdvanCescost> searchAdvanCescostAll(){
		
		return advanCescostDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AdvanCescost> searchAdvanCescost(AdvanCescostSearchCond cond, int start, int count){
		
		return advanCescostDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param advanCescost 登录数据
	 * @return 预支费用信息
	 */
	public AdvanCescost registAdvanCescost(AdvanCescost advanCescost) throws BLException{
		
		return advanCescostDAO.save(advanCescost);
	}

	/**
	 * 删除处理
	 * 
	 * @param acid 预支费用ID
	 * @return
	 */
	public void deleteAdvanCescost(Integer acid) throws BLException{
		
		AdvanCescost advanCescost = checkExistAdvanCescost(acid);
		
		advanCescostDAO.delete(advanCescost);
	}

	/**
	 * 变更处理
	 * 
	 * @param advanCescost 变更数据
	 * @return 预支费用信息
	 */
	public AdvanCescost updateAdvanCescost(AdvanCescost advanCescost) throws BLException{
		
		checkExistAdvanCescost(advanCescost.getAcid());
		return advanCescostDAO.save(advanCescost);
	}

	/**
	 * 预支费用信息存在检查
	 * 
	 * @param acid 预支费用ID
	 * @return 预支费用信息
	 * @throws BLException 
	 */
	protected AdvanCescost checkExistAdvanCescost(Integer acid) throws BLException{
		AdvanCescost info = advanCescostDAO.findByPK(acid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","预支费用基本");
		}
		return info;
	}

}
