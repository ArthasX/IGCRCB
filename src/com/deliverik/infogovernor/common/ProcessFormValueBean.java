package com.deliverik.infogovernor.common;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;

public class ProcessFormValueBean {
	/** 获取表单值 */
	private static Log log = LogFactory.getLog(ProcessFormValueBean.class);
	
	private static IG599BL ig599BL = (IG599BL) WebApplicationSupport.getBean("ig599BL");

	/**
	 * 通过流程id和表单名称获取表单值
	 * 
	 * @param prid 流程ID
	 * @return 当前状态显示名称
	 */
	public static String getFormValue(Integer prid,String formValueName) {
		try {
			IG599SearchCondImpl ig599cond = new IG599SearchCondImpl();
			ig599cond.setPrid(prid);
			ig599cond.setPivarname(formValueName);
			List<IG599Info> infoList = ig599BL.searchIG599InfosByCond(ig599cond);
			if(infoList!=null&&infoList.size()>0){
				return infoList.get(0).getPivarvalue() == null ? "" : infoList.get(0).getPivarvalue();
			}
		} catch (Exception e) {
			log.error("表单值获取异常", e);
			return "";
		}
		return "";
	}

}
