package com.deliverik.infogovernor.risk.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.crc.vo.IGCRC04021VO;
import com.deliverik.infogovernor.crc.vo.IGCRC04031VO;
import com.deliverik.infogovernor.risk.bl.IGRIS02BL;
import com.deliverik.infogovernor.risk.bl.IGRISCONSTANTS;
import com.deliverik.infogovernor.risk.dto.IGRIS02DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0201Form;
import com.deliverik.infogovernor.risk.form.IGRIS0203Form;
import com.deliverik.infogovernor.risk.vo.IGRIS02011VO;

/**
 * 风险检查结果查询画面Action处理
 *
 */
public class IGRIS0203Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0203Action.class);

	/**
	 * 风险检查结果查询处理
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
		IGRIS0203Form form = (IGRIS0203Form)actionForm;
		
		//BL取得
		IGRIS02BL ctlBL = (IGRIS02BL) getBean("igris02BL");
		
		//DTO生成
		IGRIS02DTO dto = new IGRIS02DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		if( "DISP".equals(mapping.getParameter())){
			//类型查询画面初期显示处理
			log.debug("========风险检查结果查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========风险检查结果查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//类型查询处理
			log.debug("========风险检查结果查询处理开始========");
			
			// 结果
			if(StringUtils.isNotEmpty(form.getRcrresult())){
				form.setRcrresult(null);
			}
			// 说明
			if(StringUtils.isNotEmpty(form.getRcrcomment())){
				form.setRcrcomment(null);
			}
			dto.setIgRIS0203Form(form);
			
			dto.setUser(user);
			
			//信息检索逻辑调用
			dto = ctlBL.searchRiskCheckResultAction(dto);
			
			//将类型信息检索结果设定到VO中
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheckResultDataList(dto.getRiskCheckResultDataList());

			super.<IGRIS02011VO>setVO(req, vo);
			
			log.debug("========风险检查结果查询处理终了========");
		}else if ("READ".equals(mapping.getParameter())){
			log.debug("========风险检查查看处理开始========");
			IGRIS0201Form form1 = new IGRIS0201Form();
			form1.setRcid(form.getRcid());
			dto.setIgRIS0201Form(form1);
			dto = ctlBL.readRiskCheckAction(dto);
			
			IGRIS02011VO vo = new IGRIS02011VO();
			vo.setRiskCheck(dto.getRiskCheck());
			vo.setAttachmentDataList(dto.getAttachmentList());
			vo.setCronInfo(dto.getCronInfo());
			super.<IGRIS02011VO>setVO(req, vo);
			log.debug("========风险检查查看处理终了========");
		}else if ("INSERT".equals(mapping.getParameter())){
			log.debug("========风险检查结果保存处理开始========");
			
			dto.setIgRIS0203Form(form);
			dto.setUser(user);
			dto = ctlBL.insertRiskCheckResultAction(dto);
			
			if(IGRISCONSTANTS.RISKCHECKRESULT_SUBMIT_ERROR.equals(dto.getGoToError())){
				//页面提交的记录已经被其他用户提交过
				return mapping.findForward("ERROR");//返回错误提示信息页
			}		
			
			req.setAttribute("cwrid", form.getCwrid());
			log.debug("========风险检查结果保存处理终了========");
		}else if("BATCH".equals(mapping.getParameter())){
			
			log.debug("========检查工作指派批量发起处理开始========");
			dto.setIgRIS0203Form(form);
			dto.setUser(user);
			//if(isTokenValid(req,true)){
				dto = ctlBL.batchFlowAction(dto);
			//}else{
			//	addMessage(req, new ActionMessage("IGCO00000.E007"));
			//	return mapping.findForward("/error1");
			//}
			
			log.debug("========检查工作指派批量发起处理终了========");
			return mapping.findForward("ASSIGN");
		}else if("BATCH_DISP".equals(mapping.getParameter())){
			log.debug("===========检查工作指派批量页面初始化操作开始===============");
			dto.setIgRIS0203Form(form);
			dto.setUser(user);
			dto = ctlBL.initIGRIS0402Action(dto);
			
			//实例化vo
			IGCRC04031VO vo = new IGCRC04031VO();
			vo.setAssignInfo(dto.getAssignInfo());
			vo.setPrids(dto.getIgRIS0203Form().getPrids());
			req.getSession().setAttribute("prids", dto.getIgRIS0203Form().getPrids());
			req.setAttribute("prids", dto.getIgRIS0203Form().getPrids());
			super.<IGCRC04031VO>setVO(req, vo);
			saveToken(req);
			log.debug("===========检查工作指派批量处理页面初始化操作结束===============");
		}else if("ASSIGN".equals(mapping.getParameter())){
			dto.setIgRIS0203Form(form);
			dto.setUser(user);
			log.debug("=============检查工作指派批量分派操作开始===============");
			if (isTokenValid(req, true)){
				dto = ctlBL.assignAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("=============检查工作指派批量分派操作结束===============");
			
			
			
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
