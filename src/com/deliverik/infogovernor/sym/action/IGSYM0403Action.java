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
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0403Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04031VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_菜单授权查询ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0403Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0403Action.class);
	
	/**
	 * <p>
	 * Description: 角色action处理
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
		IGSYM0403Form form = (IGSYM0403Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========角色查询画面初期显示处理开始========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========角色查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	
		//获取BL接口实例
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		//实例化DTO
		IGSYM04DTO dto = new IGSYM04DTO();
		//角色查询
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========角色查询处理开始========");
			//获取分页Bean
			getPaginDTO(request,"IGSYM0403");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGSYM0403Form) request.getSession().getAttribute("IGSYM0403Form");
				if ( form== null){
					form = new IGSYM0403Form();
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
					form = (IGSYM0403Form) request.getSession().getAttribute("IGSYM0403Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGSYM0403");
			
			dto.setRoleSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchRoleAction(dto);
			//构造VO
			IGSYM04031VO vo = new IGSYM04031VO(dto.getRoleList());
			
			super.<IGSYM04031VO>setVO(request, vo);
			
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			log.debug("========角色查询处理终了========");
		}
		return mapping.findForward("DISP");
	}

}
