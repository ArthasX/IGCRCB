/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.dbs.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.dbs.bl.IGDBS01BL;
import com.deliverik.infogovernor.soc.dbs.dto.IGDBS01DTO;

/**
 * @概述SOC EMC运维管理存储管理平台首页action
 * @功能描述 1. 左IOPS/吞吐量
 *			2. 左主机信息
 *			3. 左读写比率、缓存命中率
 *			4. 右IOPS/吞吐量
 *			5. 右主机信息
 * 			6. 右读写比率、缓存命中率
 *			7. 业务运行情况       
 *			8. 流程KPI(已删除)
 *			9. 运维日历显示(已删除)
 *			10.存储饼图全查
 *			11.告警查询
 * @创建记录：李旭峙    2010/12/09
 * @version 1.0
 */

public class IGDBS0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBS0101Action.class);
	
	/**
	 * iops吞吐量
	 */
	protected String iopsThroughput = "AD_PN1RETURN";
	
	/**
	 * 主机详细信息
	 */
	protected String hostInfo = "AD_PN2RETURN";
	
	/**
	 * 读写命中率
	 */
	protected String readperWriteperHitper = "AD_PN3RETURN"; 
	
	/**
	 * iops吞吐量
	 */
	protected String iopsThroughput2 = "AD_PN4RETURN";
	
	/**
	 * 主机详细信息
	 */
	protected String hostInfo2 = "AD_PN5RETURN";
	
	/**
	 * 读写命中率
	 */
	protected String readperWriteperHitper2 = "AD_PN6RETURN"; 
	
	/**
	 * 业务运行
	 */
	protected String businessRus = "AD_PN7RETURN";
	
//	/**
//	 * 流程KPI
//	 */
//	protected String processKPI = "AD_PN8RETURN";
//	/**
//	 * 运维管理
//	 */
//	protected String operationManagement = "AD_PN9RETURN";
	/**
	 * 获得存储饼图all
	 */	
	protected String getpieall ="AD_PN10RETURN";
	/**
	 * 获得告警list
	 */
	protected String getwarninglist ="AD_PN11RETURN";
	
	
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDBS01BL ctlBL = (IGDBS01BL) getBean("igDBS01BL");
		
		//画面跳转设定
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========设置EMC运维管理存储管理平台初期显示处理开始========");
			Locale currentLocale = (Locale)req.getSession().getAttribute(Globals.LOCALE_KEY);  
			IGDBS01DTO dto = new IGDBS01DTO();
			if("en".equals(currentLocale.getLanguage())){
				dto.setLanguage("en");
			}		
			dto = ctlBL.getBusinessRus(dto);
    		req.setAttribute(businessRus, dto.getBusinessRus());                 //业务运行
			//获取User信息
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
    		//dto = ctlBL.getOperationManagement(dto);
    		//req.setAttribute(operationManagement, dto.getOperationManagement()); //运维管理
    		
    		//dto = ctlBL.getProcessKPI(dto);
    		//req.setAttribute(processKPI, dto.getProcessKPI()); //流程KPI
    		
    		String host1 = (String)req.getSession().getAttribute(user.getUserid()+"host1");
    		String type1 = (String)req.getSession().getAttribute(user.getUserid()+"type1");
    		dto.setSymmid(host1);
    		dto.setHostchoose(type1);
    		
    		ctlBL.getIOPSandThroughput1(dto);
    		req.setAttribute(this.iopsThroughput, dto.getIopsThroughput()); //IOPS吞吐量
    		//判断是否是CX类型的存储
    		if(StringUtils.isNotEmpty(dto.getSymm_type())){
    			if("CX".equalsIgnoreCase(dto.getSymm_type())){
    				ctlBL.getIOPSandThroughputCX(dto);
    			}else{
    				ctlBL.getReadperWriteperHitper1(dto);
    			}
    		}else{
    			ctlBL.getReadperWriteperHitper1(dto);
    		}
    		req.setAttribute(readperWriteperHitper, dto.getReadperWriteperHitper());//读写命中率
    		
    		
    		ctlBL.getHostInfo1(dto);
    		req.setAttribute(this.hostInfo, dto.getHostInfo());//主机命中率
    		
    		String host2 = (String)req.getSession().getAttribute(user.getUserid()+"host2");
    		String type2 = (String)req.getSession().getAttribute(user.getUserid()+"type2");
    		dto.setSymmid(host2);
    		dto.setHostchoose(type2);
    		
    		ctlBL.getIOPSandThroughput2(dto);
    		req.setAttribute(this.iopsThroughput2, dto.getIopsThroughput()); //IOPS吞吐量2
    		
    		ctlBL.getReadperWriteperHitper2(dto);
    		req.setAttribute(this.readperWriteperHitper2, dto.getReadperWriteperHitper());//读写命中率2
    		
    		ctlBL.getHostInfo2(dto);
    		req.setAttribute(this.hostInfo2, dto.getHostInfo());//主机命中率2
    		
    		//20120716 add 容量
    		ctlBL.getPieAll(dto);
    		req.setAttribute(this.getpieall, dto.getPieall());
    		
    		ctlBL.getWarningList(dto);
    		req.setAttribute(this.getwarninglist, dto.getWarninglist());
    		//20120716 add 容量
    		
			log.debug("========设置EMC运维管理存储管理平台初期显示处理终了========");
			
//			if("en".equals(currentLocale.getLanguage())){
//				return mapping.findForward("DISP_EN");
//			}
			return mapping.findForward("DISP");//20120718改DISP_EN为DISP 因flash已经国际化
		}
		return mapping.findForward(forward);
	}

	public static void main(String[] args) {
//		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy/MM/dd HH:mm");
//		Date d = new Date();    
//		String lastdate = sdfTime.format(d);	
//		String nowdate = sdfTime.format(new Date(d.getTime()-1*60*60*1000));
//		System.out.println(lastdate);
//		System.out.println(nowdate);
//		System.out.println(d.getHours());
//		//System.out.println(df.format(date.getTime()-8*60*60*1000,""));
//		String date1="2010/01/23 12:30";
//		System.out.println(sdfTime.format(new Date(date1)));
	}
}
