/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG555Info;
import com.deliverik.framework.workflow.prr.model.condition.IG555SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG555DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG555TB;

/**
  * 概述: 流程处理页返回配置信息业务逻辑实现
  * 功能描述: 流程处理页返回配置信息业务逻辑实现
  * 创建记录: 2013/08/29
  * 修改记录: 
  */
public class IG555BLImpl extends BaseBLImpl implements
		IG555BL {

	/** 流程处理页返回配置信息DAO接口 */
	protected IG555DAO ig555DAO;
	
	/**
	 * 流程处理页返回配置信息DAO接口设定
	 *
	 * @param ig555DAO 流程处理页返回配置信息DAO接口
	 */
	public void setIg555DAO(IG555DAO ig555DAO) {
		this.ig555DAO = ig555DAO;
	}

	/**
	 * 流程处理页返回配置信息实例取得
	 *
	 * @return 流程处理页返回配置信息实例
	 */
	public IG555TB getIG555TBInstance() {
		return new IG555TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG555Info> searchIG555Info() {
		return ig555DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG555Info searchIG555InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG555SearchCond cond) {
		return ig555DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG555Info> searchIG555Info(
			IG555SearchCond cond) {
		return ig555DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG555Info> searchIG555Info(
			IG555SearchCond cond, int start,
			int count) {
		return ig555DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG555Info registIG555Info(IG555Info instance)
		throws BLException {
		return ig555DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG555Info updateIG555Info(IG555Info instance)
		throws BLException {
		checkExistInstance(instance.getJump());
		return ig555DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG555InfoByPK(String pk)
		throws BLException {
		ig555DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG555Info(IG555Info instance)
		throws BLException {
		ig555DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG555Info checkExistInstance(String pk)
		throws BLException {
		IG555Info instance = ig555DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}