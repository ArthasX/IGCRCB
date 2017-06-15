/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sta.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sta.model.ProjectStatistic;



@SuppressWarnings("serial")
public class IGSTA01051VO extends BaseVO implements Serializable {

  /** 项目信息检索结果 */
  protected List<ProjectStatistic> projectInfo;

    /**
     * 项目信息检索结果取得
     *
     * @return projectInfo 项目信息检索结果
     */
    public List<ProjectStatistic> getProjectInfo() {
        return projectInfo;
    }
    
    /**
     * 项目信息检索结果设定
     *
     * @param projectInfo 项目信息检索结果
     */
    public void setProjectInfo(List<ProjectStatistic> projectInfo) {
        this.projectInfo = projectInfo;
    }

}
