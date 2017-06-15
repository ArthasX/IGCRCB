/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.IG482BL;
import com.deliverik.framework.workflow.prd.model.IG482Info;
import com.deliverik.framework.workflow.prd.model.condition.IG482SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.IG485Info;
import com.deliverik.framework.workflow.prr.model.condition.IG485SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG485DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG224VW;
import com.deliverik.framework.workflow.prr.model.entity.IG485PK;
import com.deliverik.framework.workflow.prr.model.entity.IG485TB;
import com.deliverik.framework.workflow.prr.model.entity.IG485VW;

/**
  * 概述: 流程组关联关系实例表业务逻辑实现
  * 功能描述: 流程组关联关系实例表业务逻辑实现
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public class IG485BLImpl extends BaseBLImpl implements
		IG485BL {

	/** 流程组关联关系实例表DAO接口 */
	protected IG485DAO ig485DAO;
	
	/** 流程组关联关系定义BL */
	protected IG482BL ig482BL;
	
	/**
	 * 流程组关联关系实例表DAO接口设定
	 *
	 * @param ig485DAO 流程组关联关系实例表DAO接口
	 */
	public void setIg485DAO(IG485DAO ig485DAO) {
		this.ig485DAO = ig485DAO;
	}
	
	/**
	 * 流程组关联关系定义BL设定
	 * @param ig482BL 流程组关联关系定义BL
	 */
	public void setIg482BL(IG482BL ig482BL) {
		this.ig482BL = ig482BL;
	}

	/**
	 * 流程组关联关系实例表实例取得
	 *
	 * @return 流程组关联关系实例表实例
	 */
	public IG485TB getIG485TBInstance() {
		return new IG485TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG485Info> searchIG485() {
		return ig485DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG485Info searchIG485ByPK(IG485PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG485SearchCond cond) {
		return ig485DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG485Info> searchIG485(
			IG485SearchCond cond) {
		return ig485DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG485Info> searchIG485(
			IG485SearchCond cond, int start,
			int count) {
		return ig485DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG485Info registIG485(IG485Info instance)
		throws BLException {
		return ig485DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG485Info updateIG485(IG485Info instance)
		throws BLException {
		checkExistInstance(new IG485PK(instance.getPgreid(), instance.getPgrid(), instance.getPrid()));
		return ig485DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG485ByPK(IG485PK pk)
		throws BLException {
		ig485DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG485(IG485Info instance)
		throws BLException {
		ig485DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG485Info checkExistInstance(IG485PK pk)
		throws BLException {
		IG485Info instance = ig485DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * 判断指定状态是否需要挂起
	 * @param prid 影响流程ID
	 * @param pgrid 流程组实例ID
	 * @param pgdid 流程组定义ID
	 * @param ipsdid 影响状态ID
	 * @return 是否需要挂起
	 */
	public boolean checkPend(Integer pgrid, String pgdid, String ipsdid) {
		//查询流程组实例中影响流程状态相关联的参考状态的处理完成记录
		List<Object[]> lst_Object = ig485DAO.checkPend(pgrid, pgdid, ipsdid);
		if(lst_Object.isEmpty()) {
			return false; 
		}
		Set<String> set_NotDone = new HashSet<String>();//未完成关系实例中的参考状态ID
		Set<String> set_Done = new HashSet<String>();//已完成关系实例中的参考状态ID
		for(Object[] obj : lst_Object) {
			if(obj[1] == null || "0".equals(obj[1].toString())) {//即pgrrstatus=0 or null，未完成
				set_NotDone.add(obj[0].toString());
			}
			if("1".equals(obj[1].toString())) {//即pgrrstatus=1，已完成
				set_Done.add(obj[0].toString());
			}
		}
		//同一参考状态可能有多个关系实例，取或关系
		for(String notDone : set_NotDone) {
			if(!set_Done.contains(notDone)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断指定参考状态处理完成时，其对应的影响状态相关流程是否跃迁
	 * @param prid 影响流程ID
	 * @param pgrid 流程组实例ID
	 * @param pgdid 流程组定义ID
	 * @param rpsdid 参考状态ID
	 * @param rtpsdid 参考流程目的状态ID集合
	 * @return 跃迁流程ID集合
	 */
	public List<IG224VW> searchTriggerPrid(Integer prid, Integer pgrid,
			String pgdid, String rpsdid, List<String> rtpsdids) {
		List<IG224VW> lst_TriggerPrid = new ArrayList<IG224VW>();
		//根据参考状态查询其影响的状态ID，会有多个
		IG482SearchCondImpl cond = new IG482SearchCondImpl();
		cond.setPgdid(pgdid);
		cond.setRpsdid(rpsdid);
		List<IG482Info> lst_ig482 = ig482BL.searchIG482(cond);
		//过滤重复的影响状态ID
		Set<String> lst_ipsdid = new HashSet<String>();
		for(IG482Info ig482 : lst_ig482) {
			//如果关联关系没有定义触发规则，则认为任何规则都能触发关联流程，否则匹配目的状态
			if(StringUtils.isEmpty(ig482.getRtpsdid()) || rtpsdids.contains(ig482.getRtpsdid())){
				lst_ipsdid.add(ig482.getIpsdid());
			}
		}
		
		//根据影响状态ID，查询流程组实例中的流程实例
		for(String ipsdid : lst_ipsdid) {
			List<IG224VW> lst_prid = ig485DAO.searchPendPrid(pgrid, ipsdid);
			for(IG224VW obj : lst_prid) {
				//根据得到的流程实例ID，和该流程对应的影响状态ID，判断该流程是否挂起
				boolean isPend = checkPend(pgrid, pgdid, ipsdid);
				//如果未挂起，则触发影响流程跃迁
				if(!isPend) {
					lst_TriggerPrid.add(obj);
				}
			}
		}
		return lst_TriggerPrid;
	}
	
	/**
	 * 查询关联关系实例未处理记录
	 * @param prid 参考流程ID
	 * @param rpsdid 参考流程状态ID
	 * @return 未处理记录
	 */
	public List<IG485VW> searchNotDone(Integer prid, String rpsdid) {
		return this.ig485DAO.searchNotDone(prid, rpsdid);
	}

}