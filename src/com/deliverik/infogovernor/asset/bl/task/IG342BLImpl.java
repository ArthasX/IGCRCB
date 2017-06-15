/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.IG342Info;
import com.deliverik.infogovernor.asset.model.condition.IG342SearchCond;
import com.deliverik.infogovernor.asset.model.dao.IG342DAO;
import com.deliverik.infogovernor.asset.model.entity.IG342VW;

/**
  * 概述: 业务逻辑实现
  * 功能描述: 业务逻辑实现
  * 创建记录: 2012/08/03
  * 修改记录: 
  */
public class IG342BLImpl extends BaseBLImpl implements
		IG342BL {

	/** ig342DAO接口 */
	protected IG342DAO ig342DAO;
	

    /**
     * ig342DAO接口设定
     *
     * @param ig342dao ig342DAO接口
     */
    public void setIg342DAO(IG342DAO ig342dao) {
        ig342DAO = ig342dao;
    }

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG342SearchCond cond) {
		return ig342DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG342Info> searchIG342(
			IG342SearchCond cond) {
		return ig342DAO.findByCond(cond, 0, 0);
	}


    public IG342VW getIG342() {
        return new IG342VW();
    }

    public List<IG342Info> searchIG342(IG342SearchCond cond, int start, int count) {
        return ig342DAO.findByCond(cond, start, count);
    }

}