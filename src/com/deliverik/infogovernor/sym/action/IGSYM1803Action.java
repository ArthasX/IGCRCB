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
import com.deliverik.infogovernor.sym.bl.IGSYM20BL;
import com.deliverik.infogovernor.sym.dto.IGSYM20DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1803Form;
import com.deliverik.infogovernor.sym.vo.IGSYM18021VO;

public class IGSYM1803Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1803Action.class);

	/**
	 * 修改Action
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		// BL取得
		IGSYM20BL ctlBL = (IGSYM20BL) getBean("igSYM20BL");
		// DTO生成
		IGSYM20DTO dto = new IGSYM20DTO();
		// FORM取得
		IGSYM1803Form form = (IGSYM1803Form)actionForm;
		dto.setIgsym1803form(form);
		
		
		if("SEARCH".equals(mapping.getParameter()))
		{
			if(form.getIsflag().equals("yes"))
			{
				dto.igsym1803form.setDeviceip(null);
			}
			log.debug("========短信IP规则控制页面========");
			//查询记录最大数值
			int maxCnt = getMaxDataCount("IGSYM1803");
			dto.setMaxSearchCount(maxCnt);
			dto.setMaxSearchCount(maxCnt);
			getPaginDTO(req,"IGLOG0102");
			PagingDTO pDto; 
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				
				dto.setIgsym1803form(form);
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			dto.setIgsym1803form(form);
			pDto.setPageDispCount(14);
			dto.setPagingDto(pDto);
			dto = ctlBL.searchIPInfoAction(dto);
			IGSYM18021VO vo = new IGSYM18021VO();
			vo.setIpInfoList(dto.getIpInfoList());
			form.setIsflag("no");
			super.<IGSYM18021VO>setVO(req, vo);
		}
		else if ("UPDATE".equals(mapping.getParameter())) {
	
			if (isTokenValid(req, true)) {
				dto = ctlBL.updateInfo(dto);
			} else {
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
		} else if ("Insert".equals(mapping.getParameter())) {
			
			dto = ctlBL.insertInfo(dto);
			
			
			IGSYM18021VO vo = new IGSYM18021VO();
			vo.setIpInfoList(dto.getIpInfoList());
			super.<IGSYM18021VO>setVO(req, vo);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			
		} else if ("DELETE".equals(mapping.getParameter())) {
			
			if(ctlBL.checkSearchCount(dto)){
				ctlBL.deleteByPK(dto);
			} else {
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
		}
		//状态位改变
		else if("CHANGE_STATUS".equals(mapping.getParameter()))
		{    
			ctlBL.changeTempstate(dto);
			
		}
		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
