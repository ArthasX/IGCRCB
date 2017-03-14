/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG156Info;
import com.deliverik.framework.workflow.prd.model.IG900Info;

/**
 * 前后处理tianjia信息检索结果ＶＯ
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGPRD0141VO extends BaseVO implements Serializable{
	
	protected List<IG156Info> processStatusButtonDefList;

	public List<IG156Info> getProcessStatusButtonDefList() {
		return processStatusButtonDefList;
	}

	public void setProcessStatusButtonDefList(
			List<IG156Info> processStatusButtonDefList) {
		this.processStatusButtonDefList = processStatusButtonDefList;
	}
	
	public List<LabelValueBean> processButtonDefList;
	
    /**
     * @return the processButtonDefList
     */
    public List<LabelValueBean> getProcessButtonDefList() {
        return processButtonDefList;
    }

    /**
     * @param processButtonDefList the processButtonDefList to set
     */
    public void setProcessButtonDefList(List<LabelValueBean> processButtonDefList) {
        this.processButtonDefList = processButtonDefList;
    }
    
//    public List<IG900Info> processButtonDefList;
//	
//	public List<IG900Info> getProcessButtonDefList() {
//		return processButtonDefList;
//	}
//	
//	public void setProcessButtonDefList(
//			List<IG900Info> processButtonDefList) {
//		this.processButtonDefList = processButtonDefList;
//	}

}


