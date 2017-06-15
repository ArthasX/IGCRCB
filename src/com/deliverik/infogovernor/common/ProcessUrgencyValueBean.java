package com.deliverik.infogovernor.common;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;

public class ProcessUrgencyValueBean {
	
	/** 记录日志 */
	private static Log log = LogFactory.getLog(ProcessUrgencyValueBean.class);
	
	/**
	 * <p>
	 * Description:构造函数
	 * </p>
	 */
	private ProcessUrgencyValueBean() {

	}

	/**
	 * <p>
	 * Description: 根据流程id查询相关流程状态
	 * </p>
	 * 
	 * @param key
	 * @return String
	 */
	public static String getProcessUrgencyImg(String prid,String pdid) {
		log.debug("根据流程id查询流程紧急度开始");
		
		String img="";
		
		WorkFlowOperationBL workFlowOperationBL = (WorkFlowOperationBL) WebApplicationSupport.getBean("workFlowOperationBL");
		
		if(pdid.equals("0100301")){
			img="<img src='images/emergency.gif'>";
		}else if(pdid.equals("0100101")){
			IG599SearchCondImpl cond = new IG599SearchCondImpl();
			cond.setPrid(Integer.valueOf(prid));
			List<IG599Info> processInfoList = workFlowOperationBL.searchProcessInfoByCond(cond);
			for (IG599Info info : processInfoList) {
				if(info.getPivarname().equals("故障等级")){
					String pivarvalue = info.getPivarvalue();
					if("Blocking".equals(pivarvalue)){
						img="<img src='images/emergency.gif'>";
					}
				}
			}
		}
		log.debug("根据流程id查询流程紧急度结束");
		
		return img;
	}
}
