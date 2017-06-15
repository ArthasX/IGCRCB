package com.deliverik.infogovernor.asset.action;

import java.util.Date;
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
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.asset.bl.IGASM28BL;
import com.deliverik.infogovernor.asset.dto.IGASM28DTO;
import com.deliverik.infogovernor.asset.form.IGASM2802Form;
import com.deliverik.infogovernor.asset.vo.IGASM28021VO;
import com.deliverik.infogovernor.asset.vo.IGASM28071VO;

/**
 * 检查项编辑画面Action处理
 *
 * @author
 */
public class IGASM2802Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2802Action.class);

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
		IGASM2802Form form = (IGASM2802Form)actionForm;
		
		//BL取得
		IGASM28BL ctlBL = (IGASM28BL) getBean("igasm28BL");
		
		//DTO生成
		IGASM28DTO dto = new IGASM28DTO();
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//检查项登记画面初期显示处理
			log.debug("========检查项登记画面初期显示处理开始========");
			form = new IGASM2802Form();
			//获取当前用户
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			//向form 设置用户
			form.setEiuserid(user.getUserid());
			form.setEiusername(user.getUsername());
			form.setMguserid(user.getUserid());
			form.setMgusername(user.getUsername());
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);
			
			dto.setIgasm2802Form(form);
			
			//获取建议检查频度 集合
			ctlBL.searchRiskPropertyActioin(dto);
			//获取编号
			dto = ctlBL.searchEntityItemLableAction(dto);
			
			req.setAttribute("IGASM2802Form", form);
			saveToken(req);
			IGASM28071VO vo = new IGASM28071VO();
			vo.setCheckfrequencyList(dto.getCheckfrequencyList());
			vo.setSoc0109List(dto.getSoc0109List());
			super.setVO(req, vo);
			addMessage(req, new ActionMessage("IGCO10000.I001","检查项基本信息"));
			log.debug("========检查项登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//检查项登记画面再显示处理
			log.debug("========检查项登记画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========检查项登记画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//检查项编辑处理
			if (form.getMode().equals("0")){
				//检查项登记处理
				log.debug("========检查项登记处理开始========");

				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setEiorgsyscoding(user.getOrgid());
				form.setEiuserid(user.getUserid());
				form.setEiusername(user.getUsername());
				form.setEiname(form.getCivalue()[0]);
				form.setEidesc(form.getCivalue()[6]);
				
				
				//DTO输入参数设定
				dto.setIgasm2802Form(form);
				if (isTokenValid(req, true)) {
					
					//检查项信息登记逻辑调用
					dto = ctlBL.insertEntityItemAction(dto);
					
					//将登记完了的检查项信息设定到VO中
					IGASM28021VO vo = new IGASM28021VO(dto.getIgasm2802Form());
					//编号
					req.getSession().setAttribute("eilabel", dto.getIgasm2802Form().getEilabel());
					//检查项ID
					req.getSession().setAttribute("eiiddd",dto.getEiid()+"");
					super.<IGASM28021VO>setVO(req.getSession(), vo);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
				}
				
				
				log.debug("========检查项登记处理终了========");
				
				forward = "DISP";

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
