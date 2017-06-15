/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.SOC0154Info;
import com.deliverik.infogovernor.soc.vir.model.condition.SOC0154SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.SOC0154DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.SOC0154PK;
import com.deliverik.infogovernor.soc.vir.model.entity.SOC0154TB;

/**
  * 概述: soc0154业务逻辑实现
  * 功能描述: soc0154业务逻辑实现
  * 创建记录: 2013/12/29
  * 修改记录: 
  */
public class SOC0154BLImpl extends BaseBLImpl implements
		SOC0154BL {

	/** soc0154DAO接口 */
	protected SOC0154DAO soc0154DAO;
	
	/**
	 * soc0154DAO接口设定
	 *
	 * @param soc0154DAO soc0154DAO接口
	 */
	public void setSoc0154DAO(SOC0154DAO soc0154DAO) {
		this.soc0154DAO = soc0154DAO;
	}

	/**
	 * soc0154实例取得
	 *
	 * @return soc0154实例
	 */
	public SOC0154TB getSoc0154TBInstance() {
		return new SOC0154TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0154Info> searchSoc0154() {
		return soc0154DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0154Info searchSoc0154ByPK(SOC0154PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0154SearchCond cond) {
		return soc0154DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0154Info> searchSoc0154(
			SOC0154SearchCond cond) {
		return soc0154DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0154Info> searchSoc0154(
			SOC0154SearchCond cond, int start,
			int count) {
		return soc0154DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0154Info registSoc0154(SOC0154Info instance)
		throws BLException {
		return soc0154DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0154Info updateSoc0154(SOC0154Info instance)
		throws BLException {
		checkExistInstance(new SOC0154PK(instance.getMyid(), instance.getFromid(), instance.getIsellipsis()));
		return soc0154DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSoc0154ByPK(SOC0154PK pk)
		throws BLException {
		soc0154DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSoc0154(SOC0154Info instance)
		throws BLException {
		soc0154DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0154Info checkExistInstance(SOC0154PK pk)
		throws BLException {
		SOC0154Info instance = soc0154DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}