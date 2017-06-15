/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0201Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0201SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0201DAO;

/**
 * 
 * @Description:自动报表生成表BL实现类
 * @Author
 * @History
 * @Version V1.0
 * 修改记录：2012/08/09 将REPORT_GDATA_ITEMBLImpl表名改为SOC0201BLImpl
 */
public class SOC0201BLImpl extends BaseBLImpl implements
		SOC0201BL {

	protected SOC0201DAO soc0201DAO;
	
	

	public void setSoc0201DAO(SOC0201DAO soc0201DAO) {
		this.soc0201DAO = soc0201DAO;
	}

	/**
	 * 持久化处理
	 * 
	 * @param SOC0201实体类
	 * @return SOC0201实体类
	 */
	public SOC0201Info saveSOC0201(
			SOC0201Info soc0201) throws BLException {
		return soc0201DAO.save(soc0201);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param id
	 *            主键
	 * @return 检索结果
	 */
	public SOC0201Info findSOC0201ByPK(Integer id)
			throws BLException {
		return soc0201DAO.findByPK(id);
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<SOC0201Info> findAllSOC0201()
			throws BLException {
		return soc0201DAO.findAll();
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0201SearchCond cond)
			throws BLException {
		return soc0201DAO.getSearchCount(cond);
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
	public List<SOC0201Info> findSOC0201ByCond(
			SOC0201SearchCond cond, int start, int count)
			throws BLException {
		return soc0201DAO.findByCond(cond, start, count);
	}

	/**
	 * 删除处理
	 * 
	 * @param SOC0201实体类
	 */
	public void deleteSOC0201(SOC0201Info soc0201)
			throws BLException {
		soc0201DAO.delete(soc0201);
	}

}
