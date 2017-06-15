/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG484Info;
import com.deliverik.framework.workflow.prr.model.condition.IG484SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG484SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG484DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG484PK;
import com.deliverik.framework.workflow.prr.model.entity.IG484TB;

/**
  * 概述: 流程组成员实例业务逻辑实现
  * 功能描述: 流程组成员实例业务逻辑实现
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public class IG484BLImpl extends BaseBLImpl implements
		IG484BL {

	/** 流程组成员实例DAO接口 */
	protected IG484DAO ig484DAO;
	
	/**
	 * 流程组成员实例DAO接口设定
	 *
	 * @param ig484DAO 流程组成员实例DAO接口
	 */
	public void setIg484DAO(IG484DAO ig484DAO) {
		this.ig484DAO = ig484DAO;
	}

	/**
	 * 流程组成员实例实例取得
	 *
	 * @return 流程组成员实例实例
	 */
	public IG484TB getIG484TBInstance() {
		return new IG484TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG484Info> searchIG484() {
		return ig484DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG484Info searchIG484ByPK(IG484PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG484SearchCond cond) {
		return ig484DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG484Info> searchIG484(
			IG484SearchCond cond) {
		return ig484DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG484Info> searchIG484(
			IG484SearchCond cond, int start,
			int count) {
		return ig484DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG484Info registIG484(IG484Info instance)
		throws BLException {
		return ig484DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG484Info updateIG484(IG484Info instance)
		throws BLException {
		checkExistInstance(new IG484PK(instance.getPgrid(), instance.getPrid()));
		return ig484DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG484ByPK(IG484PK pk)
		throws BLException {
		ig484DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG484(IG484Info instance)
		throws BLException {
		ig484DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG484Info checkExistInstance(IG484PK pk)
		throws BLException {
		IG484Info instance = ig484DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * 通过单一流程查询组合流程实例pgrid
	 *
	 * @param prid 流程id
	 * @return 检索结果pgrid 如果返回空则当前流程不在流程组中运行
	 */
	public Integer searchIG484PgridByPrid(Integer prid){
		Integer pgrid = null;
		IG484SearchCondImpl ig484cond = new IG484SearchCondImpl();
		ig484cond.setPrid(prid);
		List<IG484Info> ig484Lst = ig484DAO.findByCond(ig484cond, 0, 1);
		if(null!=ig484Lst&&ig484Lst.size()>0){
			pgrid = ig484Lst.get(0).getPgrid();
		}
		return pgrid;
	}

}