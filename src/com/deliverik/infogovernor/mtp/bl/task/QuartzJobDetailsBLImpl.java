/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.mtp.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.mtp.model.QuartzJobDetails;
import com.deliverik.infogovernor.mtp.model.condition.QuartzJobDetailsSearchCond;
import com.deliverik.infogovernor.mtp.model.condition.QuartzJobDetailsSearchCondImpl;
import com.deliverik.infogovernor.mtp.model.dao.QuartzJobDetailsTBDAO;
import com.deliverik.infogovernor.mtp.model.entity.QuartzJobDetailsTB;

/**
 * <p>
 * 日常运维计划信息业务逻辑实现
 * </p>
 */
public class QuartzJobDetailsBLImpl extends BaseBLImpl implements QuartzJobDetailsBL {

	protected QuartzJobDetailsTBDAO quartzJobDetailsTBDAO;

	
	public void setQuartzJobDetailsTBDAO(QuartzJobDetailsTBDAO quartzJobDetailsTBDAO) {
		this.quartzJobDetailsTBDAO = quartzJobDetailsTBDAO;
	}

	/**
	 * 保存日常运维计划信息
	 * @param qjdList
	 * @return
	 * @throws BLException
	 */
	public List<QuartzJobDetails> saveOrUpdQuartzJobDetails(List<QuartzJobDetails> qjdList)
			throws BLException {
		List<QuartzJobDetails> newList = new ArrayList<QuartzJobDetails>();
		for(QuartzJobDetails qjd:qjdList){
			QuartzJobDetails QuartzJobDetails = quartzJobDetailsTBDAO.save(qjd);
			
			newList.add(QuartzJobDetails);
		}
		
		return newList;
	}

	/**
	 * 保存日常运维计划信息
	 * @param qjdInfo
	 * @return
	 * @throws BLException
	 */
	public QuartzJobDetails saveQuartzJobDetails(QuartzJobDetails qjdInfo)throws BLException {
		return quartzJobDetailsTBDAO.save(qjdInfo);
	}


	/**
	 * 保存日常运维计划信息
	 * @param quartzJobDetailsList
	 * @throws BLException
	 */
	public void registQuartzJobDetails(List<QuartzJobDetails> quartzJobDetailsList) throws BLException{
		quartzJobDetailsTBDAO.saveOrUpdateAll(quartzJobDetailsList);
	}
	

	/**
	 * 更新日常运维计划信息
	 * @param qjd
	 * @throws BLException
	 */
	public QuartzJobDetails updateQuartzJobDetails(QuartzJobDetails qjd) throws BLException{
		return quartzJobDetailsTBDAO.save(qjd);
	}
	

	/**
	 * 更新日常运维计划信息
	 * @param quartzJobDetailsList
	 * @throws BLException
	 */
	public void updateQuartzJobDetails(List<QuartzJobDetails> quartzJobDetailsList) throws BLException{
		quartzJobDetailsTBDAO.saveOrUpdateAll(quartzJobDetailsList);
	}
	

	/**
	 * 根据日常运维计划任务ID查询日常运维计划详细信息
	 * @param qjid
	 * @return
	 */
	public List<QuartzJobDetails> searchQuartzJobDetailsByKey(Integer qjid){
		QuartzJobDetailsSearchCondImpl cond = new QuartzJobDetailsSearchCondImpl();
		cond.setQjid(qjid);
		List<QuartzJobDetails> qjdInfoList = quartzJobDetailsTBDAO.findByCond(cond, 0, 0);
		return qjdInfoList;
	}
	

	/**
	 * 根据检索条件查询日常运维计划详细信息
	 * @param cond
	 * @return
	 */
	public List<QuartzJobDetails> searchQuartzJobDetailsByCond(QuartzJobDetailsSearchCond cond,final int start, final int count){
		List<QuartzJobDetails> qjdInfoList = quartzJobDetailsTBDAO.findByCond(cond, start, count);
		return qjdInfoList;
	}
	
	/**
	 * 根据检索条件取得结果条数
	 * @param cond
	 * @return
	 */
	public int getSearchCount(QuartzJobDetailsSearchCond cond){
		return quartzJobDetailsTBDAO.getSearchCount(cond);
	}
	

	/**
	 * 根据主键ID查询日常运维计划详细信息
	 * @param piid
	 * @return
	 * @throws BLException
	 */
	public QuartzJobDetails searchQuartzJobDetailsByQjdid(Integer qjdid) throws BLException{
		return checkExistQuartzJobDetails(qjdid);
	}
	
	/**
	 * 获取实例
	 * 
	 * @return QuartzJobDetailsTB
	 * @throws BLException
	 */
	
	public QuartzJobDetailsTB getQuartzJobDetailsTBInstance(){
		return new QuartzJobDetailsTB();
	}
	
	/**
	 * 根据主键删除运维计划详细信息
	 * @param qjdid
	 * @throws BLException
	 */
	public void deleteQuartzJobDetails(Integer qjdid) throws BLException {
		QuartzJobDetails quartzJobDetails = checkExistQuartzJobDetails(qjdid);
		quartzJobDetailsTBDAO.delete(quartzJobDetails);
		
	}
	
	
	
	/**
	 * 实体存在检查
	 * 
	 * @param piid 流程变量ID
	 * @return 流程变量参数值信息
	 * @throws BLException 
	 */
	private QuartzJobDetails checkExistQuartzJobDetails(Integer qjdid) throws BLException{
		QuartzJobDetails info = quartzJobDetailsTBDAO.findByPK(qjdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","日常运维计划");
		}
		
		return info;
	}
}
