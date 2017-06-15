/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.asset.bl.IGASM0422ExcelBL;
import com.deliverik.infogovernor.asset.bl.IGASM04BL;
import com.deliverik.infogovernor.asset.dto.IGASM0422ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM04DTO;
import com.deliverik.infogovernor.asset.form.IGASM0401Form;
import com.deliverik.infogovernor.asset.form.IGASM0422Form;
import com.deliverik.infogovernor.asset.vo.IGASM04221VO;

/**
 * 概述: 合同应付款查询Action
 * 功能描述: 合同应付款查询Action
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
public class IGASM0422Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGASM0422Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm ActionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//获得form
		IGASM0422Form form=(IGASM0422Form)ActionForm;
		
		//获得控制BL
		IGASM04BL ctlBL= (IGASM04BL) getBean("igasm04BL");
		
		//DTO生成
		IGASM04DTO dto = new IGASM04DTO();
		
		//菜单显示
		if("DISP".equals(mapping.getParameter())){
			log.debug("========合同应付款登记菜单显示开始========");
			//当前时间点取得
			form.setDatetime(IGStringUtils.getCurrentDate());
			
			//合同类型下拉菜单取得
			IGASM0401Form new_form = new IGASM0401Form();
			//类型分类(合同)设定
			new_form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT);
			request.setAttribute("IGASM0401Form", form);
			
			User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto = ctlBL.checkEntityItemDomain(dto);
			request.getSession().setAttribute("ADselectList", dto.getSelectList());
			
			log.debug("========合同应付款登记菜单显示终了========");
		}
		
		//分页查询
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========合同应付款登记查询开始========");
			//分页用DTO取得
			getPaginDTO(request,"IGASM0422");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//合同查询处理
			log.debug("========合同应付款登记查询开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM0422Form) request.getSession().getAttribute("IGASM0422Form");
				if ( form== null){
					form = new IGASM0422Form();
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
					form = (IGASM0422Form) request.getSession().getAttribute("IGASM0422Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0422");
			
			//DTO输入参数设定
			dto.setEntityItemCompactVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
		//应付款登记查询处理2(对应应付款查询)
		ctlBL.searchEntityItemCompactVW2Action(dto);
		IGASM04221VO vo=new IGASM04221VO();
		vo.setEntityItemCompactVWList(dto.getEntityItemCompactVWInfoList());
		super.<IGASM04221VO>setVO(request, vo);
		log.debug("========合同应付款登记查询终了========");
		
	}
		if("EXPORT".equals(mapping.getParameter())){
			log.debug("==============合同应付款导出操作开始====================");
			//设置查询条件
			dto.setEntityItemCompactVWSearchCond(form);
			//查询初始化报表数据
			dto=ctlBL.intiIGASM0422Action(dto);

			IGASM0422ExcelDTO excelDto = new IGASM0422ExcelDTO();
			IGASM0422ExcelBL excelBL = (IGASM0422ExcelBL) getBean("igasm0422excelBL");
			//导出报表
			excelDto.setReportDataList(dto.getReportDataList());
			excelDto.setFileid("ASM0422");
			excelDto.setResponse(response);
			excelBL.initExcel(excelDto);
			log.debug("==============合同应付款导出操作结束====================");
			return null;
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
