package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG912Info;
import com.deliverik.framework.asset.model.IG790Info;
import com.deliverik.framework.asset.model.condition.IG912SearchCond;
import com.deliverik.framework.asset.model.condition.IG790SearchCond;
import com.deliverik.framework.asset.model.dao.IG912DAO;
import com.deliverik.framework.asset.model.dao.IG790DAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;


/**
 * 机房设备信息业务逻辑实现
 * 
 */
public class IG912BLImpl extends BaseBLImpl implements IG912BL {

	/** ComputerDeviceVW DAO */
	protected IG912DAO ig912DAO;
	
	/** 具体实现设备存量统计分析查询的DAO*/
	protected IG790DAO ig790DAO;

	public void setIg912DAO(IG912DAO ig912DAO) {
		this.ig912DAO = ig912DAO;
	}
	
	public void setIg790DAO(
			IG790DAO ig790DAO) {
		this.ig790DAO = ig790DAO;
	}

	/**
	 * 根据机房信息主键取得资产模型信息
	 * 
	 * @param eiid 机房ID
	 * @return 机房设备信息
	 */
	public IG912Info searchIG912InfoByKey(String eiid){

		IG912Info ret = ig912DAO.findByPK(eiid);
		return ret;
	}
	

	/**
	 * 根据检索条件取得机房设备信息结果条数
	 * 
	 * @param cond 机房设备信息检索条件
	 * @return 机房设备信息结果条数
	 */
	public int getIG912InfoSearchCount(IG912SearchCond cond){

		return ig912DAO.getSearchCount(cond);
	}
	
	/**
	 * 根据检索条件取得机房设备信息列表
	 * 
	 * @param cond 机房设备信息检索条件
	 * @return 机房设备信息检索结果列表
	 */
	public List<IG912Info> searchIG912Info(IG912SearchCond cond){

		List<IG912Info> ret = ig912DAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 根据检索条件取得机房设备信息列表
	 * 
	 * @param cond 机房设备信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 机房设备信息检索结果列表
	 */
	public List<IG912Info> searchIG912Info(IG912SearchCond cond, int start, int count){

		List<IG912Info> ret = ig912DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * 根据检索条件取得机房设备信息列表
	 * 
	 * @param cond 机房机柜统计分析信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 机房设备信息检索结果列表
	 */
	public List<IG790Info> searchIG790Info(IG790SearchCond cond,int start,int count) throws BLException {
		
		List<IG790Info> ecList = ig790DAO.findByCond(cond, start, count);
		
		return ecList;
	}
	
	/**
	 * 根据检索条件取得机房设备信息结果条数
	 * 
	 * @param cond 机房设备信息检索条件
	 * @return 机房设备信息结果条数
	 */
	public int getIG790InfoSearchCount(IG790SearchCond cond) throws BLException {

		List<IG790Info> ecList = ig790DAO.findByCond(cond, 0, 0);
		
		return ecList.size();
	}
	
	
}
