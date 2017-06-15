/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.SOC0507Info;
import com.deliverik.infogovernor.drm.model.condition.SOC0507SearchCond;
import com.deliverik.infogovernor.drm.model.condition.SOC0507SearchCondImpl;
import com.deliverik.infogovernor.drm.model.dao.SOC0507DAO;
import com.deliverik.infogovernor.drm.model.entity.SOC0507TB;

/**
  * 概述: 预案信息表业务逻辑实现
  * 功能描述: 预案信息表业务逻辑实现
  * 创建记录: 2016/07/15
  * 修改记录: 
  */
public class SOC0507BLImpl extends BaseBLImpl implements
		SOC0507BL {

	/** 预案信息表DAO接口 */
	protected SOC0507DAO soc0507DAO;
	

	public void setSoc0507DAO(SOC0507DAO soc0507dao) {
		soc0507DAO = soc0507dao;
	}

	/**
	 * 预案信息表实例取得
	 *
	 * @return 预案信息表实例
	 */
	public SOC0507TB getSOC0507TBInstance() {
		return new SOC0507TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0507Info> searchSOC0507() {
		return soc0507DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0507Info searchSOC0507ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0507SearchCond cond) {
		return soc0507DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0507Info> searchSOC0507(
			SOC0507SearchCond cond) {
		return soc0507DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0507Info> searchSOC0507(
			SOC0507SearchCond cond, int start,
			int count) {
		return soc0507DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0507Info registSOC0507(SOC0507Info instance)
		throws BLException {
		return soc0507DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0507Info updateSOC0507(SOC0507Info instance)
		throws BLException {
		checkExistInstance(instance.getCiid());
		return soc0507DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0507ByPK(Integer pk)
		throws BLException {
		soc0507DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0507(SOC0507Info instance)
		throws BLException {
		soc0507DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0507Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0507Info instance = soc0507DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
	 * 根据预案id和目录id查询指定目录内容
	 * 
	 * @param cid
	 * @param eiid
	 * @return
	 * @throws BLException
	 */
	public SOC0507Info getPlanContent(String cid, Integer eiid) throws BLException {
		SOC0507SearchCondImpl cond = new SOC0507SearchCondImpl();

		cond.setCid(cid);

		cond.setEiid(eiid);

		List<SOC0507Info> soc0507List = this.soc0507DAO.findByCond(cond, 0, 0);

		return soc0507List.size() > 0 ? soc0507List.get(0) : null;

	}

}