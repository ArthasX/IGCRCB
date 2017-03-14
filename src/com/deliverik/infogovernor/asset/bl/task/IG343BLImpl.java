/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.IG343Info;
import com.deliverik.infogovernor.asset.model.condition.IG343SearchCond;
import com.deliverik.infogovernor.asset.model.dao.IG343DAO;
import com.deliverik.infogovernor.asset.model.entity.IG343VW;

/**
  * 概述: 业务逻辑实现
  * 功能描述: 业务逻辑实现
  * 创建记录: 2012/07/12
  * 修改记录: 
  */
public class IG343BLImpl extends BaseBLImpl implements
		IG343BL {

	/** ig343dao接口 */
	protected IG343DAO ig343DAO;
	

    /**
     * ig343dao接口设定
     *
     * @param ig343dao ig343DAO
     */
    public void setIg343DAO(IG343DAO ig343dao) {
        ig343DAO = ig343dao;
    }

    /**
	 * IG343VW实例取得
	 *
	 * @return IG343VW实例
	 */
	public IG343VW getIG343() {
		return new IG343VW();
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
    public List<IG343Info> searchIG343(IG343SearchCond cond, int start, int count) {
        return ig343DAO.findByCond(cond, start, count);
    }

}