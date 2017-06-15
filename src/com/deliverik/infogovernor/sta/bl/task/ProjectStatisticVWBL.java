/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.sta.bl.task;

/**
 * <p>
 * 项目统计业务逻辑接口
 * </p>
 */
import java.util.List;

import com.deliverik.infogovernor.sta.model.ProjectStatistic;
import com.deliverik.infogovernor.sta.model.condition.ProjectStatisticSearchCond;

public interface ProjectStatisticVWBL {

    /**
     * 查询项目流程
     *
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<ProjectStatistic> searchPrjRec(ProjectStatisticSearchCond cond , int start, int count);
    
}
