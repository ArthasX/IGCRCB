/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.entity.IG499VW;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.asset.bl.IGASM04BL;
import com.deliverik.infogovernor.asset.dto.IGASM04DTO;
import com.deliverik.infogovernor.asset.form.IGASM0424Form;
import com.deliverik.infogovernor.asset.vo.IGASM04241VO;

/**
 * 概述: 合同统计Action
 * 功能描述: 合同统计Action
 * 创建记录: 2013/06/22
 * 修改记录: 
 */
public class IGASM0424Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGASM0424Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm ActionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//获得form
		IGASM0424Form form=(IGASM0424Form)ActionForm;
		
		//获得控制BL
		IGASM04BL ctlBL= (IGASM04BL) getBean("igasm04BL");
		
		//DTO生成
		IGASM04DTO dto = new IGASM04DTO();
		
		//菜单显示
		if("DISP".equals(mapping.getParameter())){
			log.debug("========合同统计显示开始========");
		
			log.debug("========合同统计显示终了========");
		}
		
		//分页查询
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========合同统计查询开始========");
			//分页用DTO取得
			getPaginDTO(request,"IGASM0424");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//合同查询处理
			log.debug("========合同应付款登记查询开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM0424Form) request.getSession().getAttribute("IGASM0424Form");
				if ( form== null){
					form = new IGASM0424Form();
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
					form = (IGASM0424Form) request.getSession().getAttribute("IGASM0424Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0401");
			
			//DTO输入参数设定
			dto.setEntityItemCompactVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//调用查询方法
			ctlBL.searchStatics(dto);
			
			IGASM04241VO vo=new IGASM04241VO();
			//合同统计list到jsp
			List<IG499Info> entityItemCompactVWInfoList = dto.getEntityItemCompactVWInfoList();
			List<IG499Info> dataList = new ArrayList<IG499Info>();
			if(entityItemCompactVWInfoList!=null&&entityItemCompactVWInfoList.size()>0){
				for(IG499Info ei:entityItemCompactVWInfoList){
					IG499VW eivw = (IG499VW) SerializationUtils.clone(ei);
					if(StringUtils.isNotEmpty(eivw.getFacilitator())){
						int temp = eivw.getFacilitator().indexOf("(");
						if(temp<0){
							temp = eivw.getFacilitator().length();
						}
						eivw.setFacilitator(eivw.getFacilitator().substring(0,temp));
					}
					dataList.add(eivw);
				}
			}
			vo.setEntityItemCompactVWList(dataList);
			super.<IGASM04241VO>setVO(request, vo);
			log.debug("========合同应付款登记查询终了========");
			
		}
		
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
