/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.syslog.model.Mss00012Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00012SearchCond;
import com.deliverik.infogovernor.syslog.model.dao.Mss00012DAO;
import com.deliverik.infogovernor.syslog.model.entity.Mss00012TB;

/**
  * 概述: MSS00012业务逻辑实现
  * 功能描述: MSS00012业务逻辑实现
  * 创建记录: 2013/04/25
  * 修改记录: 
  */
public class Mss00012BLImpl extends BaseBLImpl implements
		Mss00012BL {

	/** MSS00012DAO接口 */
	protected Mss00012DAO Mss00012DAO;
	

	/**
	 * MSS00012实例取得
	 *
	 * @return MSS00012实例
	 */
	public Mss00012TB getMSS00012TBInstance() {
		return new Mss00012TB();
	}

	public Mss00012DAO getMss00012DAO() {
		return Mss00012DAO;
	}

	public void setMss00012DAO(Mss00012DAO mss00012DAO) {
		Mss00012DAO = mss00012DAO;
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Mss00012Info> searchMSS00012() {
		return Mss00012DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Mss00012Info searchMSS00012ByPK(Integer id)
		throws BLException {
		return checkExistInstance(id);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Mss00012SearchCond cond) throws Exception{
		return Mss00012DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Mss00012Info> searchMSS00012 (
			Mss00012SearchCond cond) throws Exception{
		return Mss00012DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Mss00012Info> searchMSS00012(
			Mss00012SearchCond cond, int start,
			int count) throws Exception{
		return Mss00012DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Mss00012Info registMSS00012(Mss00012Info instance)
		throws BLException {
		return Mss00012DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Mss00012Info updateMSS00012(Mss00012Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return Mss00012DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMSS00012ByPK(Integer pk)
		throws BLException {
		Mss00012DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMSS00012(Mss00012Info instance)
		throws BLException {
		Mss00012DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public Mss00012Info checkExistInstance(Integer pk)
		throws BLException {
		Mss00012Info instance = Mss00012DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}