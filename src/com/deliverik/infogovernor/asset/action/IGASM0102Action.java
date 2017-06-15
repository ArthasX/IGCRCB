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

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.asset.bl.IGASM01BL;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.form.IGASM0102Form;
import com.deliverik.infogovernor.asset.vo.IGASM01021VO;

/**
 * 类型基本信息编辑画面Action处理
 *
 */
public class IGASM0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0102Action.class);

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
		IGASM0102Form form = (IGASM0102Form)actionForm;
		
		//BL取得
		IGASM01BL ctlBL = (IGASM01BL) getBean("igasm01BL");
		
		//DTO生成
		IGASM01DTO dto = new IGASM01DTO();
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//类型登记画面初期显示处理
			log.debug("========类型登记画面初期显示处理开始========");
			req.setAttribute("IGASM0102Form", new IGASM0102Form());
			
			addMessage(req, new ActionMessage("IGCO10000.I001","模型基本信息"));
			log.debug("========类型登记画面初期显示处理终了========");
			saveToken(req);
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//类型登记画面再显示处理
			log.debug("========类型登记画面再显示处理开始========");
			
			dto.setIgasm0102Form(form);
			saveToken(req);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========类型登记画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//类型编辑处理
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//类型登记画面按下返回按钮时的返回处理
				if (form.getMode().equals("1")){
					//返回类型查询画面
					return mapping.findForward("BACK");
				}
			}
			
			if (form.getMode().equals("0")){
				//类型登记处理
				log.debug("========类型登记处理开始========");
				
				//DTO输入参数设定
				dto.setEntity(form);
				dto.setIgasm0102Form(form);
				
				if (isTokenValid(req, true)){
				//类型信息登记逻辑调用
					dto = ctlBL.insertEntityAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//将登记完了的类型信息设定到VO中
				IGASM01021VO vo = new IGASM01021VO(dto.getEntity());
				
				super.<IGASM01021VO>setVO(req.getSession(), vo);
				
				log.debug("========类型登记处理终了========");
				
				forward = "DISP";
				
			} else {
				//类型变更处理
				log.debug("========类型基本信息变更处理开始========");
				
				//DTO输入参数设定
				dto.setEntity(form);
				dto.setIgasm0102Form(form);
				
				//类型信息变更逻辑调用
				dto = ctlBL.updateEntityAction(dto);
				
				log.debug("========类型基本信息变更处理终了========");
				
				forward = "BACK";
			}
		}
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========类型基本信息变更初期显示处理开始========");
			dto.setIgasm0102Form(form);
			
			dto = ctlBL.initIGASM0102Action(dto);
			
			log.debug("========类型基本信息变更初期显示处理终了========");

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
