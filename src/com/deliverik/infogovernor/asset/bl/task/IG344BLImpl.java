/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.IG344Info;
import com.deliverik.infogovernor.asset.model.condition.IG344SearchCond;
import com.deliverik.infogovernor.asset.model.dao.IG344DAO;

/**
  * 概述: 业务逻辑实现
  * 功能描述: 业务逻辑实现
  * 创建记录: 2012/07/13
  * 修改记录: 
  */
public class IG344BLImpl extends BaseBLImpl implements
		IG344BL {

	/** ig344dao接口 */
	protected IG344DAO ig344DAO;
	

    /**
     * ig344dao接口设定
     *
     * @param ig344dao ig344DAO
     */
    public void setIg344DAO(IG344DAO ig344dao) {
        ig344DAO = ig344dao;
    }


    /**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
    public List<IG344Info> searchIG344(IG344SearchCond cond, int start, int count) {
        return ig344DAO.findByCond(cond, start, count);
    }
}