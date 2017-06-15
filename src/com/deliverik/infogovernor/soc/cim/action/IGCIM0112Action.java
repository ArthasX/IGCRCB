/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0112Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01121VO;

/**
 * 概述: 采集查询之单命令详细查询
 * 功能描述: 采集查询之单命令详细查询
 * 创建记录: yanglongquan 2013/05/31
 * 修改记录: 
 */
public class IGCIM0112Action extends BaseAction{

	//日志对象取得
	Log log = LogFactory.getLog(IGCIM0112Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//BL取得
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		//实例化dto
		IGCIM01DTO dto = new IGCIM01DTO();
		//form取得
		IGCIM0112Form form = (IGCIM0112Form) actionForm;
		
		//dto参数设定
		dto.setIgcim0112Form(form);
		//页面初始化显示操作
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("=============配置原数据显示页面初始化操作开始==============");
			
			//分页用DTO取得
			getPaginDTO(request,"IGCIM0112");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//主机配置查询处理
			log.debug("========主机配置查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGCIM0112Form) request.getSession().getAttribute("IGCIM0112Form");
				if ( form== null){
					form = new IGCIM0112Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGCIM0112Form) request.getSession().getAttribute("IGCIM0112Form");
					if (form !=null) { 
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM0112");
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//取得采集结果
			dto = ctlBL.getCR01InfoListByCommand(dto);
			log.debug("=============配置原数据显示页面初始化操作结束==============");
		}
		
		//实例化vo
		IGCIM01121VO vo = new IGCIM01121VO();
		vo.setCr01List(dto.getCr01List());
		String collecttime = form.getCollecttime();
//		if(StringUtils.isNotEmpty(collecttime)){
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
//			Date time = sdf.parse(collecttime);
//			sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//			collecttime = sdf.format(time);
//		}
		vo.setCollecttime(collecttime);
		vo.setHost(form.getHost());
		vo.setKeys(form.getKeys());
		vo.setTablename(form.getTablename());
		super.<IGCIM01121VO>setVO(request, vo);
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
