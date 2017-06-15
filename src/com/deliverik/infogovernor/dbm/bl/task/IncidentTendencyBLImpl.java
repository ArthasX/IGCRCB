/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dbm.model.IncidentTendency;
import com.deliverik.infogovernor.dbm.model.condition.IncidentTendencySearchCond;
import com.deliverik.infogovernor.dbm.model.dao.IncidentTendencyDAO;

/**
 * 
 * @Description:事件趋势统计表BL实现类
 * @Author
 * @History
 * @Version V1.0
 */
public class IncidentTendencyBLImpl extends BaseBLImpl implements IncidentTendencyBL{

	protected IncidentTendencyDAO incidentTendencyDAO;

	public void setIncidentTendencyDAO(IncidentTendencyDAO incidentTendencyDAO) {
		this.incidentTendencyDAO = incidentTendencyDAO;
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<IncidentTendency> findAllIncidentTendency() throws BLException {
		return incidentTendencyDAO.findAll();
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IncidentTendencySearchCond cond) throws BLException {
		return incidentTendencyDAO.getSearchCount(cond);
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
	public List<IncidentTendency> findIncidentTendencyByCond(IncidentTendencySearchCond cond,
			int start, int count) throws BLException {
		return incidentTendencyDAO.findByCond(cond, start, count);
	}

}
