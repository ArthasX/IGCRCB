/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM01BL;
import com.csebank.lom.dto.IGLOM01DTO;
import com.csebank.lom.form.IGLOM0104Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM01041VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * 接待客人管理Action
 * 
 */
public class IGLOM0104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0104Action.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGLOM0104Form form = (IGLOM0104Form)actionForm;
		
		//BL取得
		IGLOM01BL ctlBL = (IGLOM01BL) getBean("iglom01BL");
		
		//DTO生成
		IGLOM01DTO dto = new IGLOM01DTO();
		
		// 下拉菜单
		req.setAttribute("recption_rscale", LOMHelper.getItemsCodes(CodeUtils.RECPTION_RSCALE));
		req.setAttribute("recption_status", LOMHelper.getItemsCodes(CodeUtils.RECPTION_STATUS));
		req.setAttribute("recption_rstandard", LOMHelper.getItemsCodes(CodeUtils.RECPTION_RSTANDARD));
		
		String forward = "";
		
		if ("DELETE".equals(mapping.getParameter())){
			
			log.debug("========接待客人管理删除处理开始========");
			//DTO输入参数设定
			dto.setDeleteRgid(form.getDeleteRgid());
			


			if (isTokenValid(req, true)) {
				ctlBL.deleteRecptionGuestAction(dto);
			} else {
				
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========接待客人管理删除处理终了========");
			
			forward = "DELETE";
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//接待客人管理查询处理
			log.debug("========接待客人管理查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGLOM0104");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGLOM0104Form) req.getSession().getAttribute("IGLOM0104Form");
				if ( form == null ) {
					form = new IGLOM0104Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGLOM0104Form) req.getSession().getAttribute("IGLOM0104Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大数取得
			int maxCnt = getMaxDataCount("IGLOM0104");
			
			//DTO输入参数设定
			dto.setRecptionGuestSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//接待客人管理信息检索逻辑调用
			dto = ctlBL.searchRecptionGuestAction(dto);
			
			
			//将接待客人管理信息检索结果设定到VO中
			IGLOM01041VO vo = new IGLOM01041VO();
			vo.setRecptionGuestList(dto.getRecptionGuestList());
			vo.setRecptionData(dto.getRecptionData());
			
			super.<IGLOM01041VO>setVO(req, vo);

			saveToken(req);
			log.debug("========接待客人管理查询处理终了========");
			
			forward = "DISP";
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}

}
