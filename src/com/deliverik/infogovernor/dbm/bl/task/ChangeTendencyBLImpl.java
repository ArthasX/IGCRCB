/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dbm.model.ChangeTendency;
import com.deliverik.infogovernor.dbm.model.condition.ChangeTendencySearchCond;
import com.deliverik.infogovernor.dbm.model.dao.ChangeTendencyDAO;

/**
 * 
 * @Description:变更趋势统计表BL实现类
 * @Author
 * @History
 * @Version V1.0
 */
public class ChangeTendencyBLImpl extends BaseBLImpl implements ChangeTendencyBL{

	protected ChangeTendencyDAO changeTendencyDAO;

	public void setChangeTendencyDAO(ChangeTendencyDAO changeTendencyDAO) {
		this.changeTendencyDAO = changeTendencyDAO;
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<ChangeTendency> findAllChangeTendency() throws BLException {
		return changeTendencyDAO.findAll();
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ChangeTendencySearchCond cond) throws BLException {
		return changeTendencyDAO.getSearchCount(cond);
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
	public List<ChangeTendency> findChangeTendencyByCond(ChangeTendencySearchCond cond,
			int start, int count) throws BLException {
		return changeTendencyDAO.findByCond(cond, start, count);
	}

}
