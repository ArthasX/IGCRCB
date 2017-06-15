package com.deliverik.infogovernor.taglib;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prd.bl.task.IG105BL;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.entity.IG105PK;
import com.deliverik.framework.workflow.prr.bl.task.IG224BL;
import com.deliverik.framework.workflow.prr.model.IG224Info;

/**
 * 概述: 流程节点超时标签
 * 功能描述：判断流程节点数据是否超时
 * 创建记录：
 * 修改记录：宋海洋  2010/12/01
 */
@SuppressWarnings("serial")
public class ProcessStatusWarningImgTag extends TagSupport {
	// 过期
	public final static String IMG_DEAD = "<img src=\"images/statuswarning.gif\" alt=\"处理超时\" border=\"0\" width=\"16\" height=\"16\"/>";

	// 流程类型
	protected String processType;
	// 策略版本
	protected Integer prStrategyVersion; 
	// 紧急度
	protected String prUrgency; 
	// 流程定义类型
	protected String prPdid; 
	
	// 流程状态
	protected String prStatus; 
	
	// 流程id
	protected Integer prid; 
	
	public int doStartTag() throws JspException {
		String retHtml = "";
	
			
			try {
				if(checkTimeOut()){
				
					return (SKIP_BODY);
				}else{
					retHtml = IMG_DEAD;
				}
			} catch (Exception e) {

				return (SKIP_BODY);
			}
		
		TagUtils.getInstance().write(pageContext, retHtml);
		return (EVAL_BODY_INCLUDE);
	}
	/**
	 * 判断流程在当前状态是否超时
	 * @param list
	 * @return
	 * @throws BLException
	 */
	public boolean checkTimeOut() throws BLException {
		boolean isAlive = true;
		IG105BL ig105BL = (IG105BL) WebApplicationSupport
				.getBean("ig105BL");
		IG224BL ig224BL = (IG224BL) WebApplicationSupport
				.getBean("ig224BL");

		// 判断是否存在流程设定,是否超时
		IG105PK pk = new IG105PK();
		// 流程定义类型
		pk.setPdid(prPdid);
		// 策略版本号
		pk.setPsdversion(prStrategyVersion);
		// 流程紧急度
		pk.setPrurgency(prUrgency);
		// 流程状态
		pk.setPrstatus(prStatus);

		IG105Info psd = ig105BL
				.searchIG105InfoByKey(pk);

		if (psd != null) {
	
			//取得状态的开始时间
			IG224Info recordStatusLog = ig224BL
					.searchCurrentIG224Info(prid, null).get(0);
			Date starttime = recordStatusLog.getRslOpenTime();
			Date endtime = recordStatusLog.getRslCloseTime();
			
			Double excepttime = psd.getExpecttime() * 60;
            if(endtime !=null && endtime.getTime()>0){//已经结束的节点
            
    			if ((endtime.getTime() - starttime.getTime()) > excepttime.intValue() * 60000) {
    				isAlive = false;
    			}
            }else{//未结束的节点
            	Calendar calendar = Calendar.getInstance();
    			calendar.getTime();
    			
    			// 当前时间 - 预期时间 -开始时间 >0 则节点 超时
    			calendar.add(Calendar.MINUTE, 0 - excepttime.intValue());
    			if ((calendar.getTimeInMillis() - starttime.getTime()) > 0) {
    				isAlive = false;
    			}
            }
		}
		return isAlive;
	}
	

	public String getPrStatus() {
		return prStatus;
	}
	public void setPrStatus(String prStatus) {
		this.prStatus = prStatus;
	}
	public Integer getPrid() {
		return prid;
	}
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	public String getProcessType() {
		return processType;
	}

	public void setProcessType(String processType) {
		this.processType = processType;
	}

	public Integer getPrStrategyVersion() {
		return prStrategyVersion;
	}

	public void setPrStrategyVersion(Integer prStrategyVersion) {
		this.prStrategyVersion = prStrategyVersion;
	}

	public String getPrPdid() {
		return prPdid;
	}

	public void setPrPdid(String prPdid) {
		this.prPdid = prPdid;
	}

	public void setPrUrgency(String prUrgency) {
		this.prUrgency = prUrgency;
	}

	public String getPrUrgency() {
		return prUrgency;
	}
	/**
	 * 释放资源
	 */
	public void release() {
        super.release();
        processType = null;
        prStrategyVersion = null;
        prUrgency = null;
        prPdid = null;
        prStatus = null;
        prid = null;
    }
	

}