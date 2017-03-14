package com.deliverik.infogovernor.asset.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.asset.bl.IGASM21BL;
import com.deliverik.infogovernor.asset.dto.IGASM21DTO;
import com.deliverik.infogovernor.asset.form.IGASM2102Form;
import com.deliverik.infogovernor.asset.vo.IGASM21021VO;

/**
 * @Description: 审计对比结果查询画面Action处理
 * @Author  
 * @History 2011-5-18     新建
 * @Version V2.0
 */
public class IGASM2102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2102Action.class);

	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.asset.asmResources"); 
	
	/**
	 * 处理
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
		IGASM2102Form form = (IGASM2102Form)actionForm;
		
		//BL取得
		IGASM21BL ctlBL = (IGASM21BL) getBean("igasm21BL");
		
		//DTO生成
		IGASM21DTO dto = new IGASM21DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//审计对比结果查询画面初期显示处理
			log.debug("========审计对比结果查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========审计对比结果查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} 	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//审计对比结果查询处理
			log.debug("========审计对比结果查询处理开始========");
			
			//DTO输入参数设定
			dto.setAuditResultSearchCond(form);
			
			//审计对比结果信息检索逻辑调用
			dto = ctlBL.searchAuditResultAction(dto);
			
			//将审计对比结果信息检索结果设定到VO中
			IGASM21021VO vo = new IGASM21021VO();
			vo.setAuditResultList(dto.getAuditResultList());
			
			super.<IGASM21021VO>setVO(req, vo);
			
			log.debug("========审计对比结果查询处理终了========");
		}
		
		if( "INSERT".equals(mapping.getParameter())){
			
			log.debug("========审计对比结果保存处理开始========");
			
			dto.setIgasm2102Form(form);
			dto.setAuditResultSearchCond(form);
			// 做合理处理
			ctlBL.updateAuditResultAction(dto);
			
			log.debug("========审计对比结果保存处理终了========");
			
		}
		
		if( "UPDATE".equals(mapping.getParameter())){
			
			log.debug("========资产更新处理开始========");
			dto.setIgasm2102Form(form);
			// 更新资产
			ctlBL.updateEntityAction(dto);
			// 升级顶级CI(调用关系及升级bat)
//			ctlBL.rootMarkUpdateAction(dto);
			
			log.debug("========资产更新处理终了========");
			
		}
		if("EXPORT".equals(mapping.getParameter())){
			
			//DTO输入参数设定
			dto.setAuditResultSearchCond(form);
			
			//审计对比结果信息检索逻辑调用
			dto = ctlBL.searchAuditResultAction(dto);
			
			//将审计对比结果信息检索结果设定到VO中
			IGASM21021VO vo = new IGASM21021VO();
			vo.setAuditResultList(dto.getAuditResultList());
			
			req.setAttribute("vo", vo);
			req.setAttribute("form", form);
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
