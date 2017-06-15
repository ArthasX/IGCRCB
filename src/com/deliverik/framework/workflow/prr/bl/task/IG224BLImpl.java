/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG224DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG224TB;

/**
 * 流程状态日志业务逻辑实现
 * 
 */
public class IG224BLImpl extends BaseBLImpl implements IG224BL{
	
	/** 流程状态日志实体DAO*/
	protected IG224DAO ig224DAO;
	
	/**
	 * 流程状态日志实体DAO设定
	 * @param ig224DAO 流程状态日志实体DAO
	 */
	public void setIg224DAO(
			IG224DAO ig224DAO) {
		this.ig224DAO = ig224DAO;
	}
	
	/**
	 * 获取流程状态日志实例
	 * @return RecordStatusLogTB
	 */
	public IG224TB getIG224TBInstance(){
		return new IG224TB();
	}
	
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(IG224SearchCond cond){
		
		return ig224DAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param rslid 流程状态日志ID
	 * @return 流程状态日志
	 */
	public IG224Info searchIG224InfoByKey(Integer rslid) throws BLException{
		
		return checkExistRecordStatusLog(rslid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部流程状态日志信息
	 */
	public List<IG224Info> searchIG224InfoAll(){
		
		return ig224DAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG224Info> searchIG224Info(IG224SearchCond cond, int start, int count){
		
		return ig224DAO.findByCond(cond,start,count);
	}
	
	/**
	 * 当前流程状态日志信息取得
	 * 
	 * @param prid 流程ID
	 * @param prstatus 流程状态
	 * @return 当前流程状态日志信息
	 * @throws BLException 
	 */
	public List<IG224Info> searchCurrentIG224Info(Integer prid, String prstatus) throws BLException{
		IG224SearchCondImpl cond = new IG224SearchCondImpl();
		cond.setPrid(prid);
		if(StringUtils.isNotEmpty(prstatus)){//应急合版
			if(prstatus.length() > 3){
				if(prstatus.indexOf("_") > 0){
					cond.setPsdid(prstatus.split("_")[0]);
					cond.setPsdnum(Integer.valueOf(prstatus.split("_")[1]));
				}else{
					cond.setPsdid(prstatus);
				}
			}else{
				cond.setPrstatus(prstatus);
			}
		}
		cond.setNowstatus("Y");
		cond.setCurrentPrstatus(true);
		return ig224DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 当前流程状态日志信息取得
	 * 
	 * @param prid 流程ID
	 * @param prstatus 流程状态
	 * @return 当前流程状态日志信息
	 * @throws BLException 
	 */
	public List<IG224Info> searchCurrentIG224InfoByPsdid(Integer prid, String psdid) throws BLException{
		IG224SearchCondImpl cond = new IG224SearchCondImpl();
		cond.setPrid(prid);
		if (psdid.indexOf("_") > -1) {
			cond.setPsdid(psdid.split("_")[0]);
			cond.setPsdnum(Integer.parseInt(psdid.split("_")[1]));
		} else {
			cond.setPsdid(psdid);
		}
		cond.setCurrentPrstatus(true);
		return ig224DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 登录处理
	 * 
	 * @param ig224Info 登录数据
	 * @return 流程状态日志
	 */
	public IG224Info registIG224Info(IG224Info ig224Info) throws BLException{
		
		return ig224DAO.save(ig224Info);
	}

	/**
	 * 删除处理
	 * 
	 * @param rslid 流程状态日志ID
	 * @return
	 */
	public void deleteIG224Info(Integer rslid) throws BLException{
		
		IG224Info recordStatusLog = checkExistRecordStatusLog(rslid);
		
		ig224DAO.delete(recordStatusLog);
	}

	/**
	 * 变更处理
	 * 
	 * @param ig224Info 变更数据
	 * @return 流程状态日志
	 */
	public IG224Info updateIG224Info(IG224Info ig224Info) throws BLException{
		
		checkExistRecordStatusLog(ig224Info.getRslid());
		return ig224DAO.save(ig224Info);
	}

	/**
	 * 流程状态日志存在检查
	 * 
	 * @param rslid 流程状态日志ID
	 * @return 流程状态日志
	 * @throws BLException 
	 */
	protected IG224Info checkExistRecordStatusLog(Integer rslid) throws BLException{
		IG224Info info = ig224DAO.findByPK(rslid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","流程状态日志基本");
		}
		return info;
	}
	/**
	 * 条件检索处理 dashboard 数据初始化专用
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG224Info> findByCondOrderByRslopentime(final IG224SearchCond cond){
		
		return ig224DAO.findByCondOrderByRslopentime(cond);
		
	}
}
