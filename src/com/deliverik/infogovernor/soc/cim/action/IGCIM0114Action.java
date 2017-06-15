/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.deliverik.infogovernor.soc.cim.form.IGCIM0114Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01141VO;

/**
 * 概述: 采集查询命令详细对比
 * 功能描述: 采集查询命令详细对比
 * 创建记录: zhangnan 2013-6-6
 * 修改记录: 
 */
public class IGCIM0114Action extends BaseAction{

	//日志对象取得
	Log log = LogFactory.getLog(IGCIM0114Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//BL取得
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		//实例化dto
		IGCIM01DTO dto = new IGCIM01DTO();
		//form取得
		IGCIM0114Form form = (IGCIM0114Form) actionForm;
		
		//dto参数设定
		dto.setIgcim0114Form(form);
		//页面初始化显示操作
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("=============配置原数据显示页面初始化操作开始==============");
			
			//分页用DTO取得
			getPaginDTO(request,"IGCIM0114");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//主机配置查询处理
			log.debug("========主机配置查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGCIM0114Form) request.getSession().getAttribute("IGCIM0114Form");
				if ( form== null){
					form = new IGCIM0114Form();
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
					form = (IGCIM0114Form) request.getSession().getAttribute("IGCIM0114Form");
					if (form !=null) { 
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM0114");
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//取得采集结果
			dto = ctlBL.getCR01InfoListByCommand2(dto);
			log.debug("=============配置原数据显示页面初始化操作结束==============");
		}
		
		//实例化vo
		IGCIM01141VO vo = new IGCIM01141VO();
		vo.setCr01List1(dto.getCr01List1());
		vo.setCr01List2(dto.getCr01List2());
		vo.setCollecttime1(dto.getCollecttime1());
		vo.setCollecttime2(dto.getCollecttime2());
		vo.setHost(form.getHost());
		vo.setKeys(form.getKeys());
		super.<IGCIM01141VO>setVO(request, vo);
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
