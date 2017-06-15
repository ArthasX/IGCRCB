/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.mtp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.mtp.model.QuartzJobDetails;
import com.deliverik.infogovernor.mtp.model.condition.QuartzJobDetailsSearchCond;
import com.deliverik.infogovernor.mtp.model.entity.QuartzJobDetailsTB;

/**
 * <p>
 * 流程变量信息业务逻辑
 * </p>
 */

public interface QuartzJobDetailsBL extends BaseBL {


	/**
	 * 保存日常运维计划信息
	 * @param qjdList
	 * @return
	 * @throws BLException
	 */
	public List<QuartzJobDetails> saveOrUpdQuartzJobDetails(List<QuartzJobDetails> qjdList) throws BLException;

	/**
	 * 保存日常运维计划信息
	 * @param qjdInfo
	 * @return
	 * @throws BLException
	 */
	public QuartzJobDetails saveQuartzJobDetails(QuartzJobDetails qjdInfo) throws BLException;
	

	/**
	 * 保存日常运维计划信息
	 * @param quartzJobDetailsList
	 * @throws BLException
	 */
	public void registQuartzJobDetails(List<QuartzJobDetails> quartzJobDetailsList) throws BLException;
	

	/**
	 * 更新日常运维计划信息
	 * @param qjd
	 * @throws BLException
	 */
	public QuartzJobDetails updateQuartzJobDetails(QuartzJobDetails qjd) throws BLException;
	

	/**
	 * 更新日常运维计划信息
	 * @param quartzJobDetailsList
	 * @throws BLException
	 */
	public void updateQuartzJobDetails(List<QuartzJobDetails> quartzJobDetailsList) throws BLException;
	

	/**
	 * 根据日常运维计划任务ID查询日常运维计划详细信息
	 * @param qjid
	 * @return
	 */
	public List<QuartzJobDetails> searchQuartzJobDetailsByKey(Integer qjid);
	

	/**
	 * 根据检索条件查询日常运维计划详细信息
	 * @param cond
	 * @return
	 */
	public List<QuartzJobDetails> searchQuartzJobDetailsByCond(QuartzJobDetailsSearchCond cond,final int start, final int count);
	
	/**
	 * 根据检索条件取得结果条数
	 * @param cond
	 * @return
	 */
	public int getSearchCount(QuartzJobDetailsSearchCond cond);

	/**
	 * 根据主键ID查询日常运维计划详细信息
	 * @param piid
	 * @return
	 * @throws BLException
	 */
	public QuartzJobDetails searchQuartzJobDetailsByQjdid(Integer qjdid) throws BLException;
	
	/**
	 * 获取实例
	 * 
	 * @return QuartzJobDetailsTB
	 * @throws BLException
	 */
	
	public QuartzJobDetailsTB getQuartzJobDetailsTBInstance();
	
	/**
	 * 根据主键删除运维计划详细信息
	 * @param qjdid
	 * @throws BLException
	 */
	public void deleteQuartzJobDetails(Integer qjdid) throws BLException;
}
