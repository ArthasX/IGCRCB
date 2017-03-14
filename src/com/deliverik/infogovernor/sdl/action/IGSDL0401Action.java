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
import com.deliverik.infogovernor.sdl.bl.IGSDL04BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL04DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0401Form;
import com.deliverik.infogovernor.sdl.vo.IGSDL04011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_信息查询删除ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSDL0401Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0401Action.class);
	
	/**
	 * <p>
	 * Description:信息查询删除ACTION处理
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
		IGSDL0401Form form = (IGSDL0401Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========信息查询画面初期显示处理开始========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========信息查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	
		//获取BL接口实例
		IGSDL04BL ctlBL = (IGSDL04BL) getBean("igSDL04BL");
		//实例化DTO
		IGSDL04DTO dto = new IGSDL04DTO();
		//信息查询
		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========信息查询处理开始========");
			//获取分页Bean
			getPaginDTO(request,"IGSDL0401");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGSDL0401Form) request.getSession().getAttribute("IGSDL0401Form");
				if ( form == null ) {
					form = new IGSDL0401Form();
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
					form = (IGSDL0401Form) request.getSession().getAttribute("IGSDL0401Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//pDto.setFromCount(form.getFromCount());
			
			int maxCnt = getMaxDataCount("IGSDL0401");
			
			dto.setSdlInfoSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchSdlInfoAction(dto);
			
			//构造VO
			IGSDL04011VO vo = new IGSDL04011VO(dto.getSdlInfoList());
			
			super.<IGSDL04011VO>setVO(request, vo);
			
			log.debug("========信息查询处理终了========");
		}
		//删除
		if ("DELETE".equals(mapping.getParameter())){
			log.debug("========信息删除处理开始========");
			dto.setDeleteSdlInfoid(form.getDeleteSdlInfoid());
			ctlBL.deleteSdlInfoAction(dto);
			log.debug("========信息删除处理终了========");
		}
		//详细信息
		if ("DETAIL".equals(mapping.getParameter())){
			log.debug("========信息详细信息处理开始========");
			dto.setSiid(form.getSiid());
			dto = ctlBL.searchSdlInfoDetailAction(dto);
			IGSDL04011VO vo = new IGSDL04011VO();
			vo.setSdlInfo(dto.getSdlInfo());
			vo.setAttachmentList(dto.getAttachmentList());
			super.<IGSDL04011VO>setVO(request, vo);
			log.debug("========信息详细信息处理终了========");
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
