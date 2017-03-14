/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.action;

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
import com.deliverik.infogovernor.sdl.bl.IGSDL03BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL03DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0301Form;
import com.deliverik.infogovernor.sdl.vo.IGSDL03011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_标准查询删除ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSDL0301Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0301Action.class);
	
	/**
	 * <p>
	 * Description:标准查询删除ACTION处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author sunkaiyu@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGSDL0301Form form = (IGSDL0301Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========标准查询画面初期显示处理开始========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========标准查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	
		//获取BL接口实例
		IGSDL03BL ctlBL = (IGSDL03BL) getBean("igSDL03BL");
		//实例化DTO
		IGSDL03DTO dto = new IGSDL03DTO();
		//标准查询
		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========标准查询处理开始========");
			//获取分页Bean
			getPaginDTO(request,"IGSDL0301");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGSDL0301Form) request.getSession().getAttribute("IGSDL0301Form");
				if ( form == null ) {
					form = new IGSDL0301Form();
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
					form = (IGSDL0301Form) request.getSession().getAttribute("IGSDL0301Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//pDto.setFromCount(form.getFromCount());
			
			int maxCnt = getMaxDataCount("IGSDL0301");
			
			dto.setSdlDefineInfoSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchSdlDefineInfoAction(dto);
			
			//构造VO
			IGSDL03011VO vo = new IGSDL03011VO(dto.getSdlDefineInfoList());
			
			super.<IGSDL03011VO>setVO(request, vo);
			
			log.debug("========标准查询处理终了========");
		}
		//删除
		if ("DELETE".equals(mapping.getParameter())){
			log.debug("========标准删除处理开始========");
			dto.setDeleteSdlDefineInfoid(form.getDeleteSdlDefineInfoid());
			ctlBL.deleteSdlDefineInfoAction(dto);
			log.debug("========标准删除处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
