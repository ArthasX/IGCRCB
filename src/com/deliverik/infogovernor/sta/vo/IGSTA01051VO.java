/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sta.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sta.model.ProjectStatistic;



@SuppressWarnings("serial")
public class IGSTA01051VO extends BaseVO implements Serializable {

  /** ��Ŀ��Ϣ������� */
  protected List<ProjectStatistic> projectInfo;

    /**
     * ��Ŀ��Ϣ�������ȡ��
     *
     * @return projectInfo ��Ŀ��Ϣ�������
     */
    public List<ProjectStatistic> getProjectInfo() {
        return projectInfo;
    }
    
    /**
     * ��Ŀ��Ϣ��������趨
     *
     * @param projectInfo ��Ŀ��Ϣ�������
     */
    public void setProjectInfo(List<ProjectStatistic> projectInfo) {
        this.projectInfo = projectInfo;
    }

}
