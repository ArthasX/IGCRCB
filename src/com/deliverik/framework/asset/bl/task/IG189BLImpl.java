package com.deliverik.framework.asset.bl.task;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.asset.model.IG445Info;
import com.deliverik.framework.asset.model.IG011Info;
import com.deliverik.framework.asset.model.condition.IG445SearchCond;
import com.deliverik.framework.asset.model.condition.IG011SearchCond;
import com.deliverik.framework.asset.model.dao.IG445DAO;
import com.deliverik.framework.asset.model.dao.IG011DAO;
import com.deliverik.framework.base.BLException;
/**
 * <p>
 * 资产统计业务逻辑实现
 * </p>
 */
public class IG189BLImpl implements IG189BL {

	static Log log = LogFactory.getLog(IG189BLImpl.class);

	/** 具体实现设备存量统计分析查询的DAO*/
	protected IG011DAO ig011DAO;
	
	/** 具体实现设备存量分布式统计分析查询的DAO*/
	protected IG445DAO ig445DAO;
	
	public void setIg011DAO(IG011DAO ig011DAO) {
		this.ig011DAO = ig011DAO;
	}

	
	public void setIg445DAO(
			IG445DAO ig445DAO) {
		this.ig445DAO = ig445DAO;
	}


	/**
	 * 进行统计分析处理
	 */
	public List<IG011Info> searchIG011Info(IG011SearchCond cond) throws BLException {

		List<IG011Info> ecList = findEquimentCountByCondition(cond);
		
		
		return ecList;
	}
	
	/**
	 * 进行分布式统计分析处理
	 */
	public List<IG445Info> searchIG445Info(IG445SearchCond cond) throws BLException {
		

		List<IG445Info> edList = findEquDistributingCountByCondition(cond);
		
		return edList;
	}
	
	
	
	
	/**
	 * 根据统计条件查询结果,返回符合条件的结果总数
	 */
	public int getIG011InfoSearchCount(IG011SearchCond cond) throws BLException {
		
		if("0".equals(cond.getOrgType())){
			//所属机构
			List<IG011Info> ecList = ig011DAO.findByCond(cond, 0, 0);
			return ecList.size();
		}else{
			//使用机构
			List<IG011Info> ecList = ig011DAO.findIG011InfoCondByUseOrg(cond, 0, 0);
			return ecList.size();
		}
	
	}
	
	/**
	 * 根据统计条件查询结果,返回符合条件的结果总数
	 */
	public int getIG445InfoSearchCount(IG445SearchCond cond) throws BLException {
		
		//所属机构
		List<IG445Info> edList = ig445DAO.findByCond(cond, 0, 0);
		return edList.size();
	
	}
	/**
	 * 根据统计条件查询结果,将符合条件的结果数返回
	 */
	public List<IG011Info> findEquimentCountByCondition(IG011SearchCond cond) throws BLException {
		
		//List<EntityCount> ecList = ig011DAO.findByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());
		if("0".equals(cond.getOrgType())){
			//所属机构
			List<IG011Info> ecList = ig011DAO.findByCond(cond, 0, 0);
			return ecList;
		}else{
			//使用机构
			List<IG011Info> ecList = ig011DAO.findIG011InfoCondByUseOrg(cond, 0, 0);
			return ecList;
		}

	}
	
	/**
	 * 根据统计条件查询结果,将符合条件的结果数返回
	 */
	public List<IG445Info> findEquDistributingCountByCondition(IG445SearchCond cond) throws BLException {
		
		//所属机构
		List<IG445Info> edList = ig445DAO.findByCond(cond, 0, 0);
		return edList;
		
	}
	
	
	/**
	 * 根据检索条件检索指定资产模型下的资产结果列表
	 * @param cond 检索条件
	 * @return 资产结果列表
	 */
	public List<IG011Info> searchIG011InfoByEcatory(IG011SearchCond cond) throws BLException {
		//所属机构
		List<IG011Info> ecList = ig011DAO.findByCond(cond);
		return ecList;

	}
}
