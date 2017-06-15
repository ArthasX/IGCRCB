package com.deliverik.infogovernor.taglib;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.IG105BL;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.entity.IG105PK;

/**
 * 概述: 流程查询列表超时标签
 * 功能描述：判断流程查询列表数据是否超时
 * 创建记录：
 * 修改记录：杨盛楠  2010/11/30
 */
@SuppressWarnings("serial")
public class ProcessWarningImgTag extends TagSupport {
	// 过期
	public final static String IMG_DEAD = "<img src=\"images/processwarning.gif\" alt=\"流程超时\" border=\"0\" width=\"16\" height=\"16\"/>";
	// 将要过期
	public final static String IMG_URGENCY = "<img src=\"images/processurgency.gif\" alt=\"将要过期\" border=\"0\" width=\"16\" height=\"16\"/>";
	// 正常
	public final static String IMG_ALIVE = "<img src=\"images/processalive.gif\" alt=\"正常\" border=\"0\" width=\"16\" height=\"16\"/>";
	// 预期时间
	protected String beginTime;
	// 截止时间
	protected String endTime;
	// 流程类型
	protected String processType;
	// 策略版本
	protected Integer prStrategyVersion; 
	// 紧急度
	protected String prUrgency; 
	// 流程定义类型
	protected String prPdid; 
	
	public int doStartTag() throws JspException {
		String retHtml = "";
		if (StringUtils.isNotEmpty(beginTime)) {
			// 截止时间默认为当前时间
			if (StringUtils.isEmpty(endTime)) {
				endTime = IGStringUtils.getCurrentDateTime();
			}
			try {
				int num = getBetweenTimeNumber(endTime, beginTime);
				String img = getHtml(processType, num, prStrategyVersion, prUrgency, prPdid);
				if("1".equals(img)){
					retHtml = IMG_DEAD;
				}else{
					return (SKIP_BODY);
				}
				
			} catch (Exception e) {
				//retHtml = IMG_ALIVE;
				return (SKIP_BODY);
			}
		}else{
			return (SKIP_BODY);
		}
		TagUtils.getInstance().write(pageContext, retHtml);
		return (EVAL_BODY_INCLUDE);
	}

	private String getHtml(String processType, int num, int prStrategyVersion, String prUrgency, String prPdid)throws BLException {
		double default_num = 0;
		String img = "0";
		 
		//try {
			//--------------------- 2010-11-30 10:16:18 yangsn start
			IG105BL ig105BL = (IG105BL)WebApplicationSupport.getBean("ig105BL");
			
			IG105PK pk = new IG105PK();
			//流程定义类型
			pk.setPdid(prPdid);
			//策略版本号
			pk.setPsdversion(prStrategyVersion);
			//流程紧急度
			pk.setPrurgency(prUrgency);
			//流程状态(总的预期时间存在关闭状态上)
			pk.setPrstatus(IGPRDCONSTANTS.PROCESS_END_STATUS);
			IG105Info psd = ig105BL.searchIG105InfoByKey(pk);
			if(psd != null){
				default_num = psd.getExpecttime() * 60000;
			}else{
				default_num = 0;
			}
			
			
			// 只处理一种情况：超时的情况
			//对流程策略预期解决事件进行了设定（default_num>0）,并且处理时间大于预期解决时间。
			
			if(default_num != 0 && num>default_num){
				img = "1"; 
			}
			//--------------------- 2010-11-30 10:16:18 yangsn end
//			//开始时间+预期时间
//			SimpleDateFormat df = new SimpleDateFormat(CommonDefineUtils.DATETIME_FORMAT.getPattern());
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(df.parse(beginTime));
//			calendar.add(Calendar.HOUR, psd.getExpecttime().intValue());
//			calendar.getTimeInMillis();
//			default_num = Double.parseDouble(ResourceUtility
//					.getString("PROCESS_WARNING_HOUR_" + processType)) * 60;
		//} catch (Exception e) {
			//default_num = 0;
		//}
//		String img = "";// 图片名
//		if (num <= 0) {
//			img = IMG_DEAD;
//		} else if (0 < num && num <= default_num) {
//			img = IMG_URGENCY;
//		} else {
//			img = IMG_ALIVE;
//		}
		return img;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
        beginTime = null;
        endTime = null;
        processType = null;
        prStrategyVersion = null;
        prUrgency = null;
        prPdid = null;
    }
	
	/**
	 * 比较时间
	 * 
	 * @param timeA
	 * @param timeB
	 * @return int
	 */
	public static int getBetweenTimeNumber(String timeA, String timeB) throws Exception {
		long timeNumber = 0;
		// 1小时=60分钟=3600秒=3600000
		//long mins = 60L * 1000L;
		// long time= 24L * 60L * 60L * 1000L;计算天数之差
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date d1 = df.parse(timeA);
		Date d2 = df.parse(timeB);
		timeNumber = (d1.getTime() - d2.getTime()) ;
		return (int) timeNumber;
	}

}