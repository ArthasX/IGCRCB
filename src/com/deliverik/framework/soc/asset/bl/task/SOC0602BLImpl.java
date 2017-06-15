/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0602Info;
import com.deliverik.framework.soc.asset.model.SOC0604Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0602SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0604SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0602DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0604DAO;


/**
 * 机房设备信息业务逻辑实现
 * 
 */
public class SOC0602BLImpl extends BaseBLImpl implements SOC0602BL {

	/** ComputerDeviceVW DAO */
	protected SOC0602DAO soc0602DAO;
	
	/** 具体实现设备存量统计分析查询的DAO*/
	protected SOC0604DAO soc0604DAO;

	public void setSoc0602DAO(SOC0602DAO soc0602dao) {
		soc0602DAO = soc0602dao;
	}

	public void setSoc0604DAO(SOC0604DAO soc0604dao) {
		soc0604DAO = soc0604dao;
	}

	/**
	 * 根据机房信息主键取得资产模型信息
	 * 
	 * @param eiid 机房ID
	 * @return 机房设备信息
	 */
	public SOC0602Info searchSOC0602InfoByKey(String eiid){

		SOC0602Info ret = soc0602DAO.findByPK(eiid);
		return ret;
	}
	

	/**
	 * 根据检索条件取得机房设备信息结果条数
	 * 
	 * @param cond 机房设备信息检索条件
	 * @return 机房设备信息结果条数
	 */
	public int getSOC0602InfoSearchCount(SOC0602SearchCond cond){

		return soc0602DAO.getSearchCount(cond);
	}
	
	/**
	 * 根据检索条件取得机房设备信息列表
	 * 
	 * @param cond 机房设备信息检索条件
	 * @return 机房设备信息检索结果列表
	 */
	public List<SOC0602Info> searchSOC0602Info(SOC0602SearchCond cond){

		List<SOC0602Info> ret = soc0602DAO.findByCond(cond,0,0);
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
	public List<SOC0602Info> searchSOC0602Info(SOC0602SearchCond cond, int start, int count){

		List<SOC0602Info> ret = soc0602DAO.findByCond(cond,start,count);
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
	public List<SOC0604Info> searchSOC0604Info(SOC0604SearchCond cond,int start,int count) throws BLException {
		
		List<SOC0604Info> ecList = soc0604DAO.findByCond(cond, start, count);
		
		return ecList;
	}
	
	/**
	 * 根据检索条件取得机房设备信息结果条数
	 * 
	 * @param cond 机房设备信息检索条件
	 * @return 机房设备信息结果条数
	 */
	public int getSOC0604InfoSearchCount(SOC0604SearchCond cond) throws BLException {

		List<SOC0604Info> ecList = soc0604DAO.findByCond(cond, 0, 0);
		
		return ecList.size();
	}
	
	/**
     * 条件检索处理：模糊查询设备名，返回设备所在机柜，机房
     * 
     * @param cond
     * @param start
     * @param count
     * @return
     */
    public List<Object[]> findZhiJiLocation(SOC0602SearchCond cond){
        List<Object[]> list = soc0602DAO.findZhiJiLocation(cond);
        return list;
    }
  
	
}
