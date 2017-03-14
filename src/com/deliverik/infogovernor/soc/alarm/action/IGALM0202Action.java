/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.alarm.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.alarm.bl.IGALM02BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM02DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0202Form;
import com.deliverik.infogovernor.soc.alarm.model.CRM08Info;
import com.deliverik.infogovernor.soc.alarm.vo.IGALM02021VO;

/**
 * 规则模板管理Action
 * @author zhangnan
 * 2013.08.01
 */
public class IGALM0202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGALM0202Action.class);

	/**
	 * 规则模板管理画面处理
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGALM0202Form form = (IGALM0202Form)actionForm;
		//BL取得
		IGALM02BL ctlBL = (IGALM02BL) getBean("igalm02BL");
		//DTO生成
		IGALM02DTO dto = new IGALM02DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========规则模板管理画面初期显示处理开始========");
			dto=ctlBL.searchMonitorType(dto);
			List<LabelValueBean> monitorTypeList = dto.getMonitorTypeList();
			req.getSession().setAttribute("monitorTypeList", monitorTypeList);
			log.debug("========规则模板管理画面初期显示处理终了========");
		}
		else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========规则模板管理画面查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGALM0202");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGALM0202Form) req.getSession().getAttribute("IGALM0202Form");
				if ( form== null){
					form = new IGALM0202Form();
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
					form = (IGALM0202Form) req.getSession().getAttribute("IGALM0202Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGALM0202");
			//DTO输入参数设定
			dto.setIgalm0202Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto = ctlBL.searchRuleTemp(dto);
			List<CRM08Info> crm08InfoList = dto.getCrm08InfoList();
		
			IGALM02021VO vo=new IGALM02021VO();
			vo.setCrm08InfoList(crm08InfoList);
			super.<IGALM02021VO>setVO(req, vo);
			log.debug("========规则模板管理画面查询处理终了========");
		}
		else if ("DELETE".equals(mapping.getParameter())){
			log.debug("========删除处理开始========");
			dto.setDeleteId(form.getDeleteId());
			ctlBL.deleteRuleTemp(dto);
			log.debug("========删除处理终了========");
		}
		else if ("UPDATE".equals(mapping.getParameter())){
			log.debug("========改变状态处理开始========");
			dto.setIgalm0202Form(form);
			ctlBL.updateRuleTempState(dto);
			log.debug("========改变状态处理终了========");
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
