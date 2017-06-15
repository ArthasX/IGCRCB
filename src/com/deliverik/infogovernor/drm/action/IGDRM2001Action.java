package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM20BL;
import com.deliverik.infogovernor.drm.dto.IGDRM20DTO;
import com.deliverik.infogovernor.drm.form.IGDRM2001Form;
import com.deliverik.infogovernor.drm.vo.IGDRM20011VO;

/**
 * 预案类型新增处理Action
 *
 */
public class IGDRM2001Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM2001Action.class);

	/**
	 * 预案类型新增
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
		IGDRM2001Form form = (IGDRM2001Form)actionForm;
		
		//BL取得
		IGDRM20BL ctlBL = (IGDRM20BL) getBean("igdrm20BL");
		
		//DTO生成
		IGDRM20DTO dto = new IGDRM20DTO();
		
		//画面跳转设定
		String forward = null;
		
		dto.setForm(form);

		if( "DISP".equals(mapping.getParameter())){
			//类型登记画面初期显示处理
			log.debug("========类型登记画面初期显示处理开始========");
			saveToken(req);
			log.debug("========类型登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========类型基本信息变更初期显示处理开始========");
			
			dto = ctlBL.initS0C0117EditInfo(dto);

			log.debug("========类型基本信息变更初期显示处理终了========");

			forward = "DISP";
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
				
				if (isTokenValid(req, true)){
				//类型信息登记逻辑调用
					dto = ctlBL.insertEntityAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//将登记完了的类型信息设定到VO中
				IGDRM20011VO vo = new IGDRM20011VO(dto.getEntity());
				
				super.<IGDRM20011VO>setVO(req.getSession(), vo);
				
				log.debug("========类型登记处理终了========");
				req.setAttribute("btn1Val", "新增模板大纲");
				req.setAttribute("btn1Url", "IGDRM2002_Disp.do");
				req.setAttribute("btn2Val", "返回");
				req.setAttribute("btn2Url", "IGDRM2001_Disp.do");
				
				forward = "DISP";
				
			} else {
				//类型变更处理
				log.debug("========类型基本信息变更处理开始========");
				
				//类型信息变更逻辑调用
				dto = ctlBL.updateEntityAction(dto);
				
				log.debug("========类型基本信息变更处理终了========");
				
				forward = "BACK";
			}
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
