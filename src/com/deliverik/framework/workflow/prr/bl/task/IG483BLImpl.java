/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowGroupSerialnumGeneratorBL;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG483SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG483DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG483TB;

/**
  * 概述: 流程组实例表业务逻辑实现
  * 功能描述: 流程组实例表业务逻辑实现
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public class IG483BLImpl extends BaseBLImpl implements
		IG483BL {

	/** 流程组实例表DAO接口 */
	protected IG483DAO ig483DAO;

	
	/** 流程组定义BL */
	protected IG480BL ig480BL;
	
	/**
	 * 流程组实例表DAO接口设定
	 *
	 * @param ig483DAO 流程组实例表DAO接口
	 */
	public void setIg483DAO(IG483DAO ig483DAO) {
		this.ig483DAO = ig483DAO;
	}
	

	/**
	 * 流程组定义BL设定
	 * @param ig480BL 流程组定义BL
	 */
	public void setIg480BL(IG480BL ig480BL) {
		this.ig480BL = ig480BL;
	}
	/**
	 * 流程组实例表实例取得
	 *
	 * @return 流程组实例表实例
	 */
	public IG483TB getIG483TBInstance() {
		return new IG483TB();
	}
	
	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG483Info> searchIG483() {
		return ig483DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG483Info searchIG483ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG483SearchCond cond) {
		return ig483DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG483Info> searchIG483(
			IG483SearchCond cond) {
		return ig483DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG483Info> searchIG483(
			IG483SearchCond cond, int start,
			int count) {
		return ig483DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public synchronized IG483Info registIG483(IG483Info instance)
		throws BLException {
		//流程组定义
				IG480Info ig480 = this.ig480BL.searchIG480ByPK(instance.getPgdid());
				
				//生成工单号
				if(ig480 != null && StringUtils.isNotEmpty(ig480.getSerialGenerator())) {
					WorkFlowGroupSerialnumGeneratorBL bl = null;
					try {
						bl = (WorkFlowGroupSerialnumGeneratorBL)WebApplicationSupport.getBean(ig480.getSerialGenerator());
					} catch (Exception e) {
						throw new BLException("IGCO10000.E004", "工单号生成器定义");
					}
					((IG483TB)instance).setPgrserialnum(bl.serialnumGenerator(instance.getPgdid()));//自定义规则
				} else {
					((IG483TB)instance).setPgrserialnum(this.getSerialNum(instance.getPttype()));//默认规则
				}
				
				return ig483DAO.save(instance);
	}

	/**
	 * 流水号（WG+2位年+6位流水）
	 * @param ptType 流程模版类型
	 * @return 流水号
	 */
	protected String getSerialNum(String ptType){
		String pgrserialnum = "";
		Calendar c = Calendar.getInstance();
		pgrserialnum = ptType + String.valueOf(c.get(Calendar.YEAR)).substring(2);
		String maxSerialNum =  ig483DAO.getMaxPgrserialnum(pgrserialnum);
		if(null == maxSerialNum){
			return pgrserialnum + StringUtils.leftPad("1", 6 ,"0");
		}
		//组合场景编号为WDP+年+流水号，修改截取长度为pgrserialnum.length()
		int maxNumber = Integer.valueOf(maxSerialNum.substring(pgrserialnum.length())) + 1;
		pgrserialnum = pgrserialnum + StringUtils.leftPad(String.valueOf(maxNumber), 6,"0");
		return pgrserialnum;
	}
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG483Info updateIG483(IG483Info instance)
		throws BLException {
		checkExistInstance(instance.getPgrid());
		return ig483DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG483ByPK(Integer pk)
		throws BLException {
		ig483DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG483(IG483Info instance)
		throws BLException {
		ig483DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG483Info checkExistInstance(Integer pk)
		throws BLException {
		IG483Info instance = ig483DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * 查询流程组成员列表
	 * @param pgrid 流程组ID
	 * @return 流程组成员列表
	 */
	public List<IG500Info> searchProcess(Integer pgrid) {
		return ig483DAO.searchProcess(pgrid);
	}
	
	/**
	 * 查询流程组外发起的流程prid
	 * @param pgrid 检索条件-流程组实例ID
	 */
	public List<Map<String,Object>> searchProcessInfoByCond(final int pgrid) {
		return ig483DAO.searchProcessInfoByCond(pgrid);
    }

}