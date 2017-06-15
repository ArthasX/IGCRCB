/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD06Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD06SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VCD06DAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: vCloud组织与平台机构对照实体BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class VCD06BLImpl extends BaseBLImpl implements VCD06BL {

	/** vCloud组织与平台机构对照实体DAO接口 */
	protected VCD06DAO vcd06DAO;

	/**
	 * vCloud组织与平台机构对照实体DAO接口设定
	 * @param vcd05DAO vCloud组织与平台机构对照实体DAO接口
	 */
	public void setVcd06DAO(VCD06DAO vcd06dao) {
		vcd06DAO = vcd06dao;
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VCD06Info searchVCD06ByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(VCD06SearchCond cond) {
		return vcd06DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VCD06Info> searchVCD06(VCD06SearchCond cond) {
		return vcd06DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VCD06Info> searchVCD06(VCD06SearchCond cond, int start,int count) {
		return vcd06DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public VCD06Info registVCD06(VCD06Info instance) throws BLException {
		return vcd06DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public VCD06Info updateVCD06(VCD06Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return vcd06DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteVCD06ByPK(Integer pk) throws BLException {
		vcd06DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteVCD06(VCD06Info instance) throws BLException {
		vcd06DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public VCD06Info checkExistInstance(Integer pk)
		throws BLException {
		VCD06Info instance = vcd06DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}