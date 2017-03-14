/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.condition.IG480SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG480DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG480TB;

/**
  * 概述: 流程组定义表业务逻辑实现
  * 功能描述: 流程组定义表业务逻辑实现
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public class IG480BLImpl extends BaseBLImpl implements IG480BL {

	/** 流程组定义表DAO接口 */
	protected IG480DAO ig480DAO;
	
	/**
	 * 流程组定义表DAO接口设定
	 *
	 * @param ig480DAO 流程组定义表DAO接口
	 */
	public void setIg480DAO(IG480DAO ig480DAO) {
		this.ig480DAO = ig480DAO;
	}

	/**
	 * 流程组定义表实例取得
	 *
	 * @return 流程组定义表实例
	 */
	public IG480TB getIG480TBInstance() {
		return new IG480TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG480Info> searchIG480() {
		return ig480DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG480Info searchIG480ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG480SearchCond cond) {
		return ig480DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG480Info> searchIG480(
			IG480SearchCond cond) {
		return ig480DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG480Info> searchIG480(
			IG480SearchCond cond, int start,
			int count) {
		return ig480DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG480Info registIG480(IG480Info instance)
		throws BLException {
		return ig480DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG480Info updateIG480(IG480Info instance)
		throws BLException {
		checkExistInstance(instance.getPgdid());
		return ig480DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG480ByPK(String pk)
		throws BLException {
		ig480DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG480(IG480Info instance)
		throws BLException {
		ig480DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG480Info checkExistInstance(String pk)
		throws BLException {
		IG480Info instance = ig480DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	/**
	 * 流程组定义主键值取得
	 * @param firstsite 主键首位标识
	 * @param pdsequence 序列名称
	 * @return PDID主键值
	 */
	public String getPdidNextValue(String firstsite,String pdsequence){
		return ig480DAO.getPgdidSequenceNextValue(firstsite, pdsequence);
	}
	
	/**
	 * 流程组定义升版处理
	 * 
	 * @param pdid 流程定义ID
	 */
	public void upgradeGroupProcessDefVersion(String pgdid) throws BLException {
		if(StringUtils.isEmpty(pgdid)) {
			throw new BLException("IGCO10000.E004","流程组定义基本");
		}
		ig480DAO.upgradeGroupProcessDefVersion(pgdid);
	}
	/**
	 * 流程组定义复制处理
	 * 
	 * @param pgdid 流程组定义ID
	 * @param pdsequence 序列定义
	 */
	public String copyGroupProcessDefVersion(String pgdid,String pdsequence) throws BLException {
		if(StringUtils.isEmpty(pgdid)) {
			throw new BLException("IGCO10000.E004","流程组定义基本");
		}
		return ig480DAO.copyGroupProcessDefVersion(pgdid,pdsequence);
	}
}