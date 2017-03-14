/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM07DTO;
import com.deliverik.infogovernor.soc.alarm.model.CRMVW01Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM10SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.dao.CRM01DAO;



public class CRM01BLImpl extends BaseBLImpl implements CRM01BL{

	/** 采集结果dao */
	protected CRM01DAO crm01DAO;

	/**
	 * 采集结果dao设定
	 * @param cr01dao 采集结果dao
	 */
	public void setCrm01DAO(CRM01DAO crm01dao) {
		crm01DAO = crm01dao;
	}
	
	/**
	 * 采集结果查询
	 * @param cond 查询条件
	 * @param start 起始页码
	 * @param length 显示条数
	 * @return 查询结果
	 */
	public List<CRMVW01Info> searchCRM01VWInfoList(CRM10SearchCond cond , int start,int length){
		return crm01DAO.searchCRM01VWInfoList(cond, start, length);
	}

	public Integer getSearchCount(CRM10SearchCond cond) {
		return  (Integer) crm01DAO.getSearchCount(cond);
	}

	public IGALM07DTO getRefreshRate(IGALM07DTO dto) throws BLException {
		// TODO Auto-generated method stub
		return crm01DAO.getRefreshRate(dto);
	}
	public String searchTable(final CRM10SearchCond cond)
	{
		return crm01DAO.searchTable(cond);
	}
	
}
