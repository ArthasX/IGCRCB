package com.deliverik.infogovernor.sta.bl.task;
/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sta.model.ProjectStatistic;
import com.deliverik.infogovernor.sta.model.condition.ProjectStatisticSearchCond;
import com.deliverik.infogovernor.sta.model.dao.ProjectStatisticVWDAO;

/**
 * <p>
 * 项目统计业务逻辑实现
 * </p>
 */

public class ProjectStatisticVWBLImpl  extends BaseBLImpl implements ProjectStatisticVWBL{
	
	
	protected ProjectStatisticVWDAO projectStatisticVWDAO;
	
	
    /**
     * projectStatisticVWDAO设定
     *
     * @param projectStatisticVWDAO projectStatisticVWDAO
     */
    public void setProjectStatisticVWDAO(ProjectStatisticVWDAO projectStatisticVWDAO) {
        this.projectStatisticVWDAO = projectStatisticVWDAO;
    }



    /**
     * 查询项目流程
     *
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<ProjectStatistic> searchPrjRec(ProjectStatisticSearchCond cond , int start, int count) {
        return projectStatisticVWDAO.searchPrjRec(cond, start, count);
    }

}
