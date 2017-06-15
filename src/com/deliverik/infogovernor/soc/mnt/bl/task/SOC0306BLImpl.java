/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.SOC0306Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0306SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.SOC0306DAO;

/**
 * 
 * @Description:软件部署信息视图BL实现类
 * @Author
 * @History
 * @Version V1.0
 */
public class SOC0306BLImpl extends BaseBLImpl implements
		SOC0306BL {

	protected SOC0306DAO soc0306DAO;
	/**
	 * soc0306DAO设定
	 *
	 * @param soc0306DAO soc0306DAO
	 */
	public void setSoc0306DAO(SOC0306DAO soc0306DAO) {
		this.soc0306DAO = soc0306DAO;
	}

	/**
	 * 持久化处理
	 * 
	 * @param Soc0306实体类
	 * @return Soc0306实体类
	 */
	public SOC0306Info saveSoc0306(
			SOC0306Info soc0306Info) throws BLException {
		return soc0306DAO.save(soc0306Info);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param id
	 *            主键
	 * @return 检索结果
	 */
	public SOC0306Info findSoc0306ByPK(Integer id)
			throws BLException {
		return soc0306DAO.findByPK(id);
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<SOC0306Info> findAllSoc0306()
			throws BLException {
		return soc0306DAO.findAll();
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0306SearchCond cond)
			throws BLException {
		return soc0306DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond
	 *            检索条件
	 * @param start
	 *            检索记录起始行号
	 * @param count
	 *            检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0306Info> findSoc0306ByCond(
			SOC0306SearchCond cond, int start, int count)
			throws BLException {
		return soc0306DAO.findByCond(cond, start, count);
	}

	/**
	 * 删除处理
	 * 
	 * @param Soc0306实体类
	 */
	public void deleteSoc0306(SOC0306Info natureIuportAlarm)
			throws BLException {
		soc0306DAO.delete(natureIuportAlarm);
	}

	/**
	 * 查询缺失的性能导入数据
	 * 
	 * @param yestoday
	 *            昨天的日期
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List searchSymmetrixAlarm(String yestoday) {
		return soc0306DAO.searchSymmetrixAlarm(yestoday);
	}
}
