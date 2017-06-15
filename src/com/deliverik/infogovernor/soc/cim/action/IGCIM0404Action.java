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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM04BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM04DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0404Form;

/**
 * 类型配置信息编辑画面Action处理
 *
 */
public class IGCIM0404Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0404Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGCIM0404Form form = (IGCIM0404Form)actionForm;
		
		//BL取得
		IGCIM04BL ctlBL = (IGCIM04BL) getBean("igcim04BL");
		
		//DTO生成
		IGCIM04DTO dto = new IGCIM04DTO();
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//类型配置信息登记画面初期显示处理
			log.debug("========类型配置信息登记画面初期显示处理开始========");
			req.setAttribute("IGCIM0404Form", form);
			if("1".equals(String.valueOf(req.getAttribute("route")))){
				form.setRoute(String.valueOf(req.getAttribute("route")));
			}
			addMessage(req, new ActionMessage("IGCO10000.I001","模型配置信息"));
			log.debug("========类型配置信息登记画面初期显示处理终了========");
			saveToken(req);
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//类型配置信息登记画面再显示处理
			log.debug("========类型配置信息登记画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========类型配置信息登记画面再显示处理终了========");
			saveToken(req);
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//类型配置信息编辑处理
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//类型配置信息编辑画面按下返回按钮时的返回处理
				if (form.getRoute().equals("0")){
					//返回类型登记画面
					return mapping.findForward("BACK1");
				} else {
					//返回类型详细 画面
					return mapping.findForward("BACK2");
				}
			}
			if (form.getMode().equals("0")){
				//类型配置信息登记处理
				log.debug("========类型配置信息登记处理开始========");
				
				form.setCstatus("1");
				//属性关联模型
				if("4".equals(form.getCattach())){
					form.setCoption(form.getCesyscoding());
				}
				//DTO输入参数设定
				dto.setConfiguration(form);
				
				if (isTokenValid(req, true)){
					//类型配置信息登记逻辑调用
					dto = ctlBL.insertConfigurationAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				log.debug("========类型配置信息登记处理终了========");
				
				forward = "DISP";

			} else {
				//类型配置信息变更处理
				log.debug("========类型配置信息变更处理开始========");
				
				//属性关联模型
				if("4".equals(form.getCattach())){
					form.setCoption(form.getCesyscoding());
				}

				//DTO输入参数设定
				dto.setConfiguration(form);
				
				//类型配置信息变更逻辑调用
				dto = ctlBL.updateConfigurationAction(dto);
				
				log.debug("========类型配置信息变更处理终了========");

				forward = "DETAIL";
			}
		}
		
		if ("EDIT".equals(mapping.getParameter())){
			//类型配置信息编辑画面初期处理
			log.debug("========类型配置信息编辑画面初期处理开始========");

			//DTO输入参数设定
			dto.setIgcim0404Form(form);
			
			//类型配置信息编辑画面初期处理逻辑调用
			dto = ctlBL.initIGASM0104Action(dto);
			
			log.debug("========类型配置信息变更处理终了========");

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
