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
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0127Form;

/**
 * 应用关系编辑画面Action处理
 *
 * @author
 */
public class IGCIM0127Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0127Action.class);

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
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGCIM0127Form form = (IGCIM0127Form)actionForm;
		
		//BL取得
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO生成
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setLocale(this.getLocale(req));
		dto = ctlBL.searchRelationListActionApp(dto);
		//增加过滤条件
		List<LabelValueBean> ADrelationList=dto.getRelationList();
		if(ADrelationList!=null&&ADrelationList.size()>0){
			if(form!=null){
				String eid=form.getPareid();
				
				StringBuffer flag= new StringBuffer();
				if("CM03010001".equals(eid)){
					flag.append("CR030100010010#003-003,");
					flag.append("CR010100010019#001-003,");
					flag.append("CR010100010024#001-002,");
					flag.append("CR030100050001#003-002,");
					flag.append("CR010100450001#001-003");
					flag.append("CR010100450002#001-003");
					flag.append("CR010100460001#001-003");
					flag.append("CR010100460002#001-003");
					flag.append("CR010100470001#001-003");
					
				}
				if("133".equals(eid)){
					//flag="242#003-001";
					flag.append("");
				}
				for (int i = 0; i < ADrelationList.size(); i++) {
					LabelValueBean lvb=ADrelationList.get(i);
					if(lvb.getValue()!=null&&!"".equals(lvb.getValue())){
						if(flag.toString().contains(lvb.getValue())){
							ADrelationList.remove(lvb);
							i=i-1;
						}
					}
				}
			}
		}
		req.getSession().setAttribute("ADrelationList", ADrelationList);
		
		//画面跳转设定
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//应用关系登记画面初期显示处理
			log.debug("========应用关系登记画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I001","应用关系信息"));
			
			req.getSession().setAttribute("IGCIM0127Form", form);
			
			log.debug("========应用关系登记画面初期显示处理终了========");
			
			saveToken(req);
			
			forward = "DISP";
		}

		if( "EDIT".equals(mapping.getParameter())){
			//应用关系编辑处理
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)) {
				//按下返回按钮时的返回处理
				return mapping.findForward("BACK");
			}
			
			if (form.getMode().equals("0")){
				//产项关系登记处理
				log.debug("========应用关系登记处理开始========");
				
				//DTO输入参数设定
				dto.setIgasm0807Form(form);
				if (isTokenValid(req, true)){
					//应用关系登记逻辑调用
					dto = ctlBL.insertEntityItemRelationActionApp(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========应用关系登记处理终了========");
				forward = "BACK";

			} else {
				//应用关系变更处理
				log.debug("========应用关系变更处理开始========");

				//DTO输入参数设定
				dto.setIgasm0807Form(form);
				
				//应用关系变更逻辑调用
				dto = ctlBL.updateEntityItemRelationActionApp(dto);
				
				log.debug("========应用关系变更处理终了========");
				forward = "BACK";
			}
		}
		
		if ("EDIT_DISP".equals(mapping.getParameter())){
			//应用关系变更画面初期显示处理
			log.debug("========应用关系变更初期显示处理开始========");
			
			//DTO输入参数设定
			dto.setIgasm0807Form(form);
			
			//应用关系变更画面初期显示逻辑调用
			dto = ctlBL.initIGCIM0127Action(dto);
			
			log.debug("========应用关系变更初期显示处理终了========");

			saveToken(req);
			
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
