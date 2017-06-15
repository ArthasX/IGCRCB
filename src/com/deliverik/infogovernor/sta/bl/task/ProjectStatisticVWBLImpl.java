package com.deliverik.infogovernor.sta.bl.task;
/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sta.model.ProjectStatistic;
import com.deliverik.infogovernor.sta.model.condition.ProjectStatisticSearchCond;
import com.deliverik.infogovernor.sta.model.dao.ProjectStatisticVWDAO;

/**
 * <p>
 * ��Ŀͳ��ҵ���߼�ʵ��
 * </p>
 */

public class ProjectStatisticVWBLImpl  extends BaseBLImpl implements ProjectStatisticVWBL{
	
	
	protected ProjectStatisticVWDAO projectStatisticVWDAO;
	
	
    /**
     * projectStatisticVWDAO�趨
     *
     * @param projectStatisticVWDAO projectStatisticVWDAO
     */
    public void setProjectStatisticVWDAO(ProjectStatisticVWDAO projectStatisticVWDAO) {
        this.projectStatisticVWDAO = projectStatisticVWDAO;
    }



    /**
     * ��ѯ��Ŀ����
     *
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<ProjectStatistic> searchPrjRec(ProjectStatisticSearchCond cond , int start, int count) {
        return projectStatisticVWDAO.searchPrjRec(cond, start, count);
    }

}
