/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.sta.bl.task;

/**
 * <p>
 * ��Ŀͳ��ҵ���߼��ӿ�
 * </p>
 */
import java.util.List;

import com.deliverik.infogovernor.sta.model.ProjectStatistic;
import com.deliverik.infogovernor.sta.model.condition.ProjectStatisticSearchCond;

public interface ProjectStatisticVWBL {

    /**
     * ��ѯ��Ŀ����
     *
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<ProjectStatistic> searchPrjRec(ProjectStatisticSearchCond cond , int start, int count);
    
}
