/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.EworkingLunch;
import com.csebank.lom.model.condition.EworkingLunchSearchCond;
import com.csebank.lom.model.dao.EworkingLunchDAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 食堂工作餐信息业务逻辑接口实现
 */
public class EworkingLunchBLImpl extends BaseBLImpl implements EworkingLunchBL {
	
	/** EworkingLunch DAO */
	protected EworkingLunchDAO eworkingLunchDAO;
	
	public void setEworkingLunchDAO(
			EworkingLunchDAO eworkingLunchDAO) {
		this.eworkingLunchDAO = eworkingLunchDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(EworkingLunchSearchCond cond){
		
		return eworkingLunchDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param eid 食堂成本ID
	 * @return 食堂工作餐ID
	 */
	public EworkingLunch searchEworkingLunchByKey(Integer ewlid) throws BLException{
		EworkingLunch ret = eworkingLunchDAO.findByPK(ewlid);
		return ret;
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部食堂工作餐信息
	 */
	public List<EworkingLunch> searchEworkingLunchAll(){
		
		return eworkingLunchDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EworkingLunch> searchEworkingLunch(EworkingLunchSearchCond cond, int start, int count){
		
		return eworkingLunchDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param eatery 登录数据
	 * @return 食堂工作餐信息
	 */
	public EworkingLunch registEworkingLunch(EworkingLunch EworkingLunch) throws BLException{
		
		return eworkingLunchDAO.save(EworkingLunch);
	}

	/**
	 * 变更处理
	 * 
	 * @param eatery 变更数据
	 * @return 食堂成本信息
	 */
	public EworkingLunch updateEworkingLunch(EworkingLunch EworkingLunch) throws BLException{
		
		checkExistEworkingLunch(EworkingLunch.getEwlid());
		return eworkingLunchDAO.save(EworkingLunch);
	}

	/**
	 * 食堂工作餐信息存在检查
	 * 
	 * @param ewlid 食堂工作餐ID
	 * @return 食堂工作餐信息
	 * @throws BLException 
	 */
	protected EworkingLunch checkExistEworkingLunch(Integer ewlid) throws BLException{
		EworkingLunch info = eworkingLunchDAO.findByPK(ewlid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","食堂工作餐");
		}
		return info;
	}

}
