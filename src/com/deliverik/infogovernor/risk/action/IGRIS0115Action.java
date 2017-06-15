package com.deliverik.infogovernor.risk.action;

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
import com.deliverik.infogovernor.risk.bl.IGRIS01BL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0115Form;
import com.deliverik.infogovernor.risk.vo.IGRIS01151VO;

/**
 * 风险检查查询画面Action处理
 *
 */
public class IGRIS0115Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0115Action.class);

	/**
	 * 风险检查查询处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGRIS0115Form form = (IGRIS0115Form)actionForm;
		
		//BL取得
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		
		//DTO生成
		IGRIS01DTO dto = new IGRIS01DTO();
		
		if( "SEARCH".equals(mapping.getParameter())){
			
			dto.setIgRIS0115Form(form);

			//类型信息检索逻辑调用
			dto = ctlBL.searchRiskCheckAction(dto);
	
			//将类型信息检索结果设定到VO中
			IGRIS01151VO vo = new IGRIS01151VO(dto.getRiskCheckList());
			super.<IGRIS01151VO>setVO(req, vo);
			
			log.debug("========风险检查查询处理终了========");
		}
		if( "SEARCH1".equals(mapping.getParameter())){
			
			dto.setIgRIS0115Form(form);

			//类型信息检索逻辑调用
			dto = ctlBL.searchRiskCheckResultAction(dto);
	
			//将类型信息检索结果设定到VO中
			IGRIS01151VO vo = new IGRIS01151VO();
			vo.setAttachmentMap(dto.getAttachmentMap());
			super.<IGRIS01151VO>setVO(req, vo);
			
			log.debug("========风险检查查询处理终了========");
		}
		if( "DETAIL".equals(mapping.getParameter())){
			
			dto.setIgRIS0115Form(form);

			//类型信息检索逻辑调用
			dto = ctlBL.initRiskCheckAction(dto);
	
			//将类型信息检索结果设定到VO中
			IGRIS01151VO vo = new IGRIS01151VO();
			vo.setRiskCheck(dto.getRiskCheck());
			vo.setAttachmentList(dto.getAttachmentList());
			vo.setCronInfo(dto.getCronInfo());
			super.<IGRIS01151VO>setVO(req, vo);
			
			log.debug("========风险检查查询处理终了========");
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
