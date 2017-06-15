/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00009Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00009SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00009DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00009TB;

/**
  * 概述: mss00009业务逻辑实现
  * 功能描述: mss00009业务逻辑实现
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public class Mss00009BLImpl extends BaseBLImpl implements
		Mss00009BL {

	/** mss00009DAO接口 */
	protected Mss00009DAO mss00009DAO;
	
	/**
	 * mss00009DAO接口设定
	 *
	 * @param mss00009DAO mss00009DAO接口
	 */
	public void setMss00009DAO(Mss00009DAO mss00009DAO) {
		this.mss00009DAO = mss00009DAO;
	}

	/**
	 * mss00009实例取得
	 *
	 * @return mss00009实例
	 */
	public Mss00009TB getMss00009TBInstance() {
		return new Mss00009TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00009Info> searchMss00009() {
		return mss00009DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00009Info searchMss00009ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Mss00009SearchCond cond) throws Exception{
		return mss00009DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Mss00009Info> searchMss00009(
			Mss00009SearchCond cond) throws Exception{
		return mss00009DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Mss00009Info> searchMss00009(
			Mss00009SearchCond cond, int start,
			int count) throws Exception{
		return mss00009DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Mss00009Info registMss00009(Mss00009Info instance)
		throws BLException {
		int maxid = mss00009DAO.getMaxID();
		Mss00009TB bean = (Mss00009TB) SerializationUtils.clone(instance);
		bean.setId(maxid+1);
		return mss00009DAO.save(bean);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Mss00009Info updateMss00009(Mss00009Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return mss00009DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMss00009ByPK(Integer pk)
		throws BLException {
		mss00009DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMss00009(Mss00009Info instance)
		throws BLException {
		mss00009DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public Mss00009Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00009Info instance = mss00009DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}