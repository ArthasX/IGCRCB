/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.infogovernor.drm.model.condition.SpecialPlanSearchCond;
import com.deliverik.infogovernor.drm.model.dao.SpecialPlanDAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 专项预案BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class SpecialPlanBLImpl extends BaseBLImpl implements SpecialPlanBL{

	/** 专项预案DAO */
	protected SpecialPlanDAO specialPlanDAO;

	/**
	 * 专项预案DAO设定
	 * @param specialPlanDAO 专项预案DAO
	 */
	public void setSpecialPlanDAO(SpecialPlanDAO specialPlanDAO) {
		this.specialPlanDAO = specialPlanDAO;
	}
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SpecialPlanSearchCond cond) {
		return specialPlanDAO.getSearchCount(cond);
	}
	
	/**
	 * 条件检索
	 * @param cond 检索条件
	 * @param start 起始条数
	 * @param count 显示数量
	 * @return 检索结果
	 */
	public List<SOC0118VWInfo> search(SpecialPlanSearchCond cond,int start,int count){
		return specialPlanDAO.search(cond, start, count);
	}
}
