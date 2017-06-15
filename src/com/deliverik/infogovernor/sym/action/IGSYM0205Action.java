/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM02BL;
import com.deliverik.infogovernor.sym.dto.IGSYM02DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0204Form;
import com.deliverik.infogovernor.sym.vo.IGSYM02011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_用户管理_查询删除ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0205Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0205Action.class);
	
	/**
	 * <p>
	 * Description: 用户action处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGSYM0204Form form = (IGSYM0204Form)actionForm;
		//获取BL接口实例
		IGSYM02BL ctlBL = (IGSYM02BL) getBean("igsym02BL");
		//实例化DTO
		IGSYM02DTO dto = new IGSYM02DTO();

		if( "DISP".equals(mapping.getParameter())){
			log.debug("========用户查询画面初期显示处理开始========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========用户查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	
		//用户查询
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========用户查询处理开始========");
			//获取分页Bean
			getPaginDTO(request,"IGSYM0201");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGSYM0204Form) request.getSession().getAttribute("IGSYM0204Form");
				if ( form== null){
					form = new IGSYM0204Form();
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
					form = (IGSYM0204Form) request.getSession().getAttribute("IGSYM0204Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGSYM0201");
			
			dto.setUserSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchUserAction(dto);
			//构造VO
			IGSYM02011VO vo = new IGSYM02011VO(dto.getUserList());
			
			super.<IGSYM02011VO>setVO(request, vo);
			
			log.debug("========用户查询处理终了========");
		}
		
		if("DISPCB".equals(mapping.getParameter())){
			log.debug("========用户查询(checkBox)选择页面处理开始========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========用户查询(checkBox)选择页面处理结束========");
			return mapping.findForward("DISP");
		}
		if("SEARCH_NOPAGE".equals(mapping.getParameter())) {
			log.debug("========用户查询(无分页)处理开始========");
			int maxCnt = getMaxDataCount("IGSYM0201");
			dto.setIgsym0204Form(form);
			dto.setMaxSearchCount(maxCnt);
			//调用BL查询
			dto = ctlBL.searchUserActionNoPage(dto);
			//构造VO
			IGSYM02011VO vo = new IGSYM02011VO(dto.getUserList());
			super.<IGSYM02011VO>setVO(request, vo);
			log.debug("========用户查询(无分页)处理结束========");
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
