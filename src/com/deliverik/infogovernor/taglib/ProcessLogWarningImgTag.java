package com.deliverik.infogovernor.taglib;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prd.bl.task.IG105BL;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.entity.IG105PK;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * 概述: 流程节点超时标签
 * 功能描述：判断流程节点数据是否超时
 * 创建记录：
 * 修改记录：宋海洋  2010/12/01
 */
@SuppressWarnings("serial")
public class ProcessLogWarningImgTag extends TagSupport {
	// 过期
	public final static String IMG_DEAD = "<img src=\"images/statuswarning.gif\" alt=\"处理超时\" border=\"0\" width=\"16\" height=\"16\"/>";

	// 流程id
	protected Integer prid; 
	
	// 节点进入时间
	protected Date starttime; 
	
	// 节点跃迁时间
	protected Date endtime;
	
	// 是否超时
	protected String expect;
	
	public int doStartTag() throws JspException {
		String retHtml = "";
			try {
				if(WorkFlowConstDefine.RECORDSTATUSLOG_EXPECT_YES.equals(expect)) {
					retHtml = IMG_DEAD;
				} else if(WorkFlowConstDefine.RECORDSTATUSLOG_EXPECT_NO.equals(expect) || checkTimeOut()) {
					return (SKIP_BODY);
				} else{
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
		
		IG500BL ig500BL = (IG500BL) WebApplicationSupport
		.getBean("ig500BL");
		IG500Info bean  = ig500BL.searchIG500InfoByKey(prid);
		// 判断是否存在流程设定,是否超时
		IG105PK pk = new IG105PK();
		// 流程定义类型
		pk.setPdid(bean.getPrpdid());
		// 策略版本号
		pk.setPsdversion(bean.getPrStrategyVersion());
		// 流程紧急度
		pk.setPrurgency(bean.getPrurgency());
		// 流程状态
		pk.setPrstatus(bean.getPrstatus());

		IG105Info psd = ig105BL
				.searchIG105InfoByKey(pk);

		if (psd != null) {
			
			//取得状态的预期时间
			Double excepttime = psd.getExpecttime() * 60;
            if(endtime !=null && endtime.getTime()>0){
            
    			if ((endtime.getTime() - starttime.getTime()) > excepttime.intValue() * 60000) {
    				isAlive = false;
    			}
            }else{
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
	


	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Integer getPrid() {
		return prid;
	}
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	public String getExpect() {
		return expect;
	}
	public void setExpect(String expect) {
		this.expect = expect;
	}
	/**
	 * 释放资源
	 */
	public void release() {
        super.release();
        this.starttime = null;
        this.endtime = null;
        this.prid = null;
        this.expect = null;
    }
	

}