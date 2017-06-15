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
import com.deliverik.infogovernor.asset.bl.IGASM22BL;
import com.deliverik.infogovernor.asset.dto.IGASM22DTO;
import com.deliverik.infogovernor.asset.form.IGASM2202Form;
import com.deliverik.infogovernor.asset.vo.IGASM22021VO;

/**
 * @Description: CI变更对比结果查询画面Action处理
 * @Author  
 * @History 2011-5-18     新建
 * @Version V2.0
 */
public class IGASM2202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2202Action.class);

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
		IGASM2202Form form = (IGASM2202Form)actionForm;
		
		//BL取得
		IGASM22BL ctlBL = (IGASM22BL) getBean("igasm22BL");
		
		//DTO生成
		IGASM22DTO dto = new IGASM22DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//CI变更对比结果查询画面初期显示处理
			log.debug("========CI变更对比结果查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========CI变更对比结果查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} 	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//CI变更对比结果查询处理
			log.debug("========CI变更对比结果查询处理开始========");
			
			//DTO输入参数设定
			dto.setCiResultSearchCond(form);
			
			//CI变更对比结果信息检索逻辑调用
			dto = ctlBL.searchCIResultAction(dto);
			
			//将CI变更对比结果信息检索结果设定到VO中
			IGASM22021VO vo = new IGASM22021VO();
			vo.setCiResultList(dto.getCiResultList());
			
			super.<IGASM22021VO>setVO(req, vo);
			
			log.debug("========CI变更对比结果查询处理终了========");
		}
		
		if( "INSERT".equals(mapping.getParameter())){
			
			log.debug("========CI变更对比结果保存处理开始========");
			
			dto.setIgasm2202Form(form);
			dto.setCiResultSearchCond(form);
			// 做合理处理
			ctlBL.updateCIResultAction(dto);
			
			log.debug("========CI变更对比结果保存处理终了========");
			
		}
		
		if( "UPDATE".equals(mapping.getParameter())){
			
			log.debug("========资产更新处理开始========");
			// 更新资产
			ctlBL.updateEntityAction(dto);
			// 升级顶级CI(调用关系及升级bat)
			ctlBL.rootMarkUpdateAction(dto);
			
			log.debug("========资产更新处理终了========");
			
		}
		if("EXPORT".equals(mapping.getParameter())){
			
			//DTO输入参数设定
			dto.setCiResultSearchCond(form);
			
			//CI变更对比结果信息检索逻辑调用
			dto = ctlBL.searchCIResultAction(dto);
			
			//将CI变更对比结果信息检索结果设定到VO中
			IGASM22021VO vo = new IGASM22021VO();
			vo.setCiResultList(dto.getCiResultList());
			
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
