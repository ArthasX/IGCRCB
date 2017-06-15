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
import com.deliverik.infogovernor.soc.cim.form.IGCIM0402Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM04021VO;

/**
 * 类型基本信息编辑画面Action处理
 *
 */
public class IGCIM0402Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0402Action.class);

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
		IGCIM0402Form form = (IGCIM0402Form)actionForm;
		
		//BL取得
		IGCIM04BL ctlBL = (IGCIM04BL) getBean("igcim04BL");
		
		//DTO生成
		IGCIM04DTO dto = new IGCIM04DTO();
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//类型登记画面初期显示处理
			log.debug("========类型登记画面初期显示处理开始========");
			req.setAttribute("IGCIM0402Form", new IGCIM0402Form());
			
			//资产分类查询处理
			dto = ctlBL.searchEntityTypesNums(dto);
			IGCIM04021VO vo = new IGCIM04021VO();
			//资产大分类
			vo.setTypes1(dto.getTypes1());
			//资产小分类
			vo.setTypes2(dto.getTypes2());
			super.<IGCIM04021VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","模型基本信息"));
			log.debug("========类型登记画面初期显示处理终了========");
			saveToken(req);
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//类型登记画面再显示处理
			log.debug("========类型登记画面再显示处理开始========");
			
			dto.setIgcim0402Form(form);
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
				dto.setIgcim0402Form(form);
				
				if (isTokenValid(req, true)){
				//类型信息登记逻辑调用
					dto = ctlBL.insertEntityAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//将登记完了的类型信息设定到VO中
				IGCIM04021VO vo = new IGCIM04021VO(dto.getEntity());
				
				super.<IGCIM04021VO>setVO(req.getSession(), vo);
				
				log.debug("========类型登记处理终了========");
				
				forward = "DISP";
				
			} else {
				//类型变更处理
				log.debug("========类型基本信息变更处理开始========");
				
				//DTO输入参数设定
				dto.setEntity(form);
				dto.setIgcim0402Form(form);
				
				//类型信息变更逻辑调用
				dto = ctlBL.updateEntityAction(dto);
				
				log.debug("========类型基本信息变更处理终了========");
				
//				forward = "BACK";
				return null;
			}
		}
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========类型基本信息变更初期显示处理开始========");
			req.getSession().setAttribute("eid", form.getEidStr());
			dto.setIgcim0402Form(form);
			
			dto = ctlBL.initIGCIM0402Action(dto);
			
			//资产分类查询处理
			dto = ctlBL.searchEntityTypesNums(dto);
			IGCIM04021VO vo = new IGCIM04021VO();
			//资产大分类
			vo.setTypes1(dto.getTypes1());
			//资产小分类
			vo.setTypes2(dto.getTypes2());
			super.<IGCIM04021VO>setVO(req.getSession(), vo);
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
