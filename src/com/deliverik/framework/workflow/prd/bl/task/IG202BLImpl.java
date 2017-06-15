/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG202Info;
import com.deliverik.framework.workflow.prd.model.condition.IG202SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG202DAO;

/**
 * <p>概述:共通变量业务逻辑接口</p>
 * <p>功能描述：1.条件检索结果件数取得</p>
 * <p>          2.全部检索处理</p>
 * <p>          3.条件检索处理</p>
 * <p>          4.删除处理</p>
 * <p>          5.变更处理</p>
 * <p>          6.流程共同变量存在检查</p>
 * <p>创建记录：
 */
public class IG202BLImpl extends BaseBLImpl implements IG202BL {

	/** ig202DAO DAO */
	protected IG202DAO ig202DAO;
	
	/**
	 * 流程共通变量定义DAO
	 * 
	 * @param ig202DAO流程共通变量定义DAO
	 */
	public void setIg202DAO(
			IG202DAO ig202DAO) {
		this.ig202DAO = ig202DAO;
	}


	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getIG202InfoSearchCount(IG202SearchCond cond){
		
		return ig202DAO.getSearchCount(cond);
	}

	
	/**
	 * 功能：全部检索处理
	 * @param cond 检索条件
	 * @return 全部流程参与者信息
	 */
	public List<IG202Info> searchIG202Info(IG202SearchCond cond){
		
		List<IG202Info> ret = ig202DAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG202Info> searchIG202Info(IG202SearchCond cond, int start, int count){
		
		List<IG202Info> ret = ig202DAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * 功能：插入处理
	 * @param ig202Info
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 * @throws BLException
	 */
	public IG202Info registIG202Info(IG202Info ig202Info) throws BLException{
		
		return ig202DAO.save(ig202Info);
	}

	/**
	 * 功能：删除处理
	 * @param ppdid 删除对象流程参与者主键
	 * @throws BLException
	 */
	public void deleteIG202Info(Integer ppdid) throws BLException{

		IG202Info processInfoDefGeneral = checkExistIG202Info(ppdid);
		
		ig202DAO.delete(processInfoDefGeneral);
	}
	
	/**
	 * 功能：删除处理
	 * @param IG222 流程参与者
	 * @throws BLException
	 */
	public void deleteIG202Info(IG202Info processInfoDefGeneral) throws BLException{
		IG202Info ppd = checkExistIG202Info(processInfoDefGeneral.getPidid());
		
		ig202DAO.delete(ppd);
	}

	/**
	 * 功能：变更处理
	 * @param IG222 变更数据
	 * @return 流程参与者信息
	 * @throws BLException
	 */
	public IG202Info updateIG202Info(IG202Info processInfoDefGeneral) throws BLException{
		
		checkExistIG202Info(processInfoDefGeneral.getPidid());
		
		return ig202DAO.save(processInfoDefGeneral);
	}
	
	/**
	 * 功能：按照主键检索处理
	 * @param pidid
	 * @return processInfoDefGeneral
	 */
	public IG202Info findIG202InfoByPK(Integer pidid) throws BLException{
		return this.checkExistIG202Info(pidid);
	}
	
	/**
	 * 功能：流程共同变量存在检查
	 * @param pidid 流程参与者ID
	 * @return 流程参与者信息
	 * @throws BLException 
	 */
	protected IG202Info checkExistIG202Info(Integer pidid) throws BLException{
		IG202Info info = ig202DAO.findByPK(pidid);
		if( info == null) {
		//	throw new BLException("","");
		}
		return info;
	}
	
	/**
	 * 功能：全部检索处理
	 * @return 全部流程参与者信息
	 */
	public List<IG202Info> searchIG202InfoAll(){
		return ig202DAO.findAll();
	}
	
	/**
	 * 功能：条件检索记录数
	 * @param cond 检索条件
	 * @return 条件检索记录数
	 */
	public int searchIG202InfoCount(final IG202SearchCond cond){
		return ig202DAO.searchIG202InfoCount(cond);
	}
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG202Info> searchIG202InfoFromVW(final IG202SearchCond cond, final int start, final int count){
		return ig202DAO.searchIG202Info(cond,start,count);
	}
}
