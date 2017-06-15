/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.model.CR01VWInfo;
import com.deliverik.infogovernor.soc.model.condition.CR01SearchCond;
import com.deliverik.infogovernor.soc.model.dao.CR01DAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 采集结BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class CR01BLImpl extends BaseBLImpl implements CR01BL{

	/** 采集结果dao */
	protected CR01DAO cr01DAO;

	/**
	 * 采集结果dao设定
	 * @param cr01dao 采集结果dao
	 */
	public void setCr01DAO(CR01DAO cr01dao) {
		cr01DAO = cr01dao;
	}
	
	/**
	 * 采集结果查询
	 * @param cond 查询条件
	 * @param start 起始页码
	 * @param length 显示条数
	 * @return 查询结果
	 */
	public List<CR01VWInfo> searchCR01VWInfoList(CR01SearchCond cond , int start,int length){
		return cr01DAO.searchCR01VWInfoList(cond, start, length);
	}
}
