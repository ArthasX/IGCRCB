/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.IG611Info;
import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.asset.model.condition.IG611SearchCond;
import com.deliverik.framework.asset.model.dao.IG611DAO;
import com.deliverik.framework.asset.model.entity.IG611PK;
import com.deliverik.framework.asset.model.entity.IG611TB;

/**
  * 概述: 资产模型属性缺省值业务逻辑实现
  * 功能描述: 资产模型属性缺省值业务逻辑实现
  * 创建记录: 2012/07/20
  * 修改记录: 
  */
public class IG611BLImpl extends BaseBLImpl implements
		IG611BL {

	/** 资产模型属性缺省值DAO接口 */
	protected IG611DAO ig611DAO;
	
	/**
	 * 资产模型属性缺省值DAO接口设定
	 *
	 * @param ig611DAO 资产模型属性缺省值DAO接口
	 */
	public void setIg611DAO(IG611DAO ig611DAO) {
		this.ig611DAO = ig611DAO;
	}

	/**
	 * 资产模型属性缺省值实例取得
	 *
	 * @return 资产模型属性缺省值实例
	 */
	public IG611TB getIG611TBInstance() {
		return new IG611TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG611Info> searchIG611Info() {
		return ig611DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG611Info searchIG611InfoByPK(IG611PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG611SearchCond cond) {
		return ig611DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG611Info> searchIG611Info(
			IG611SearchCond cond) {
		return ig611DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG611Info> searchIG611Info(
			IG611SearchCond cond, int start,
			int count) {
		return ig611DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG611Info registIG611Info(IG611Info instance)
		throws BLException {
		return ig611DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG611Info updateIG611Info(IG611Info instance)
		throws BLException {
		checkExistInstance(new IG611PK(instance.getEid(), instance.getCid()));
		return ig611DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG611InfoByPK(IG611PK pk)
		throws BLException {
		ig611DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG611Info(IG611Info instance)
		throws BLException {
		ig611DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG611Info checkExistInstance(IG611PK pk)
		throws BLException {
		IG611Info instance = ig611DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * 资产属性默认值取得
	 * 
	 * @param cond 检索条件
	 * @return 资产属性默认值
	 */
	public  List<IG612Info> searchDefaultValue(IG611SearchCond cond) {
		return ig611DAO.searchDefaultValue(cond);
	}
	
	/**
	 * 资产属性初期化查询
	 * 
	 * @param cond 检索条件
	 * @return 资产属性
	 */
	public  List<IG612Info> searchDefaultLabel(IG611SearchCond cond) {
		return ig611DAO.searchDefaultLabel(cond);
	}

}