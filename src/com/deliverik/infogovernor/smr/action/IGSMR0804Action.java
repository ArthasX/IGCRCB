/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.smr.bl.IGSMR08BL;
import com.deliverik.infogovernor.smr.dto.IGSMR08DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0804Form;
import com.deliverik.infogovernor.smr.vo.IGSMR08041VO;

/**
 * 概述:核心网络系统运行情况统计查询action
 * 功能描述：核心网络系统运行情况统计查询action
 * 创建记录： 2013/09/13
 * 修改记录：
 */
public class IGSMR0804Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0804Action.class);
	
	/**
	 * 核心网络系统运行情况统计查询
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//跳转页面标识
		String forward = "DISP";
		//获取Form
		IGSMR0804Form form = (IGSMR0804Form) actionForm;
		//controlBL取得
		IGSMR08BL ctlBL = (IGSMR08BL) getBean("igSMR08BL");
		
		//实例化dto
		IGSMR08DTO dto = new IGSMR08DTO();
		
		//核心网络系统运行情况统计查询初始化
		if("DISP".equals(mapping.getParameter())){
			log.debug("======核心网络系统运行情况统计查询初始化处理开始======");
			form.setPagesize(0);
			dto.setIgsmr0804Form(form);
			dto = ctlBL.searchIGSMR0804Action(dto);
			
			form.setCountall(dto.getCountall());
			
			IGSMR08041VO vo = new IGSMR08041VO();
			vo.setMap_report(dto.getMap_report());
			super.<IGSMR08041VO>setVO(request, vo);
			
			log.debug("======核心网络系统运行情况统计查询初始化处理结束======");
		}
		//核心网络系统运行情况统计查询初始化
		if("SEARCH".equals(mapping.getParameter())){
			dto.setIgsmr0804Form(form);
			dto = ctlBL.searchIGSMR0804Action(dto);
			form.setYear_flag(form.getYear());
			form.setCountall(dto.getCountall());
			
			IGSMR08041VO vo = new IGSMR08041VO();
			vo.setMap_report(dto.getMap_report());
			super.<IGSMR08041VO>setVO(request, vo);
		}
		return mapping.findForward(forward);
	}
}
