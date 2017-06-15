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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM03BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM03DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0307Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM03071VO;

/**
 * 概述: 审计任务信息检索Action处理
 * 功能描述: 审计任务信息检索Action处理
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
public class IGCIM0307Action extends BaseAction{
	static Log log = LogFactory.getLog(IGCIM0307Action.class);


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
		IGCIM0307Form form = (IGCIM0307Form)actionForm;
		
		//BL取得
		IGCIM03BL ctlBL = (IGCIM03BL) getBean("igcim03BL");
		
		//DTO生成
		IGCIM03DTO dto = new IGCIM03DTO();
		dto.setLocale(this.getLocale(req));
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGCIM0307");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGCIM0307Form) req.getSession().getAttribute("IGCIM0307Form");
				if ( form== null){
					form = new IGCIM0307Form();
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
					form = (IGCIM0307Form) req.getSession().getAttribute("IGCIM0307Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//审计任务查询处理
			log.debug("========审计任务查询处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM0307");
			
			//DTO输入参数设定
			dto.setAuditTaskSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//审计任务检索逻辑调用
			dto = ctlBL.searchAuditTaskAction(dto);
			
			//审计任务信息检索结果设定到VO中
			IGCIM03071VO vo = new IGCIM03071VO(dto.getAuditTaskInfoList());
			
			super.<IGCIM03071VO>setVO(req,vo);
			
			log.debug("========审计任务查询处理终了========");
		}
		
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		
	 return mapping.findForward("DISP");
	}
}
