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
import com.deliverik.infogovernor.asset.bl.IGASM27BL;
import com.deliverik.infogovernor.asset.dto.IGASM27DTO;
import com.deliverik.infogovernor.asset.form.IGASM2702Form;
import com.deliverik.infogovernor.asset.vo.IGASM27021VO;

/**
 * 风险点编辑画面Action处理
 *
 * @author
 */
public class IGASM2702Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2702Action.class);

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
		IGASM2702Form form = (IGASM2702Form)actionForm;
		
		//BL取得
		IGASM27BL ctlBL = (IGASM27BL) getBean("igasm27BL");
		
		
		//DTO生成
		IGASM27DTO dto = new IGASM27DTO();
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//风险点登记画面初期显示处理
			log.debug("========风险点登记画面初期显示处理开始========");
			form = new IGASM2702Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			//获取当前用户
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			//设置日期
			form.setEiinsdate(date);
			//设定默认表单用户ID为登录人ID
			form.setEiuserid(user.getUserid());
			//设定默认表单用户名为登录人name
			form.setEiusername(user.getUsername());
			form.setMguserid(user.getUserid());
			form.setMgusername(user.getUsername());
			
			dto.setIgasm2702Form(form);
			//获取属性下拉列表值*
			ctlBL.searchRiskPropertyActioin(dto);
			
			//查询编号
			dto = ctlBL.searchEntityItemLableAction(dto);
			//设定token
			saveToken(req);
			
			req.setAttribute("IGASM2702Form", form);
			IGASM27021VO vo = new IGASM27021VO(dto.getIgasm2702Form());
			//属性 严重等级集合
			vo.setGradeList(dto.getGradeList());
			//属性 级别集合
			vo.setLevelList(dto.getLevelList());
			//属性 可能性集合
			vo.setPossibleList(dto.getPossibleList());
			//属性  标志集合
			vo.setSignList(dto.getSignList());
			//风险点 属性集合
			vo.setSoc0109List(dto.getSoc0109List());
			super.<IGASM27021VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","风险点基本信息"));
			log.debug("========风险点登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//风险点登记画面再显示处理
			log.debug("========风险点登记画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========风险点登记画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//风险点编辑处理
			if (form.getMode().equals("0")){
				//风险点登记处理
				log.debug("========风险点登记处理开始========");

				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				form.setEiorgsyscoding(user.getOrgid());
				form.setEiuserid(user.getUserid());
				form.setEiusername(user.getUsername());
				form.setEiname(form.getCivalue()[0]);
				form.setEidesc(form.getCivalue()[6]);
				
				//DTO输入参数设定
				dto.setIgasm2702Form(form);
				
				if (isTokenValid(req, true)) {
					//风险点信息登记逻辑调用
					dto = ctlBL.insertEntityItemAction(dto);
					//将登记完了的风险点信息设定到VO中
					IGASM27021VO vo = new IGASM27021VO(dto.getIgasm2702Form());
					//编号
					req.getSession().setAttribute("eilabel", dto.getIgasm2702Form().getEilabel());
					//风险点ID
					req.getSession().setAttribute("eiiddd",dto.getEiid()+"");
					super.<IGASM27021VO>setVO(req.getSession(), vo);
				} else {
					addMessage(req, new ActionMessage("IGCO10000.I001"));

				}
				
				
				
				
				log.debug("========风险点登记处理终了========");
				
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
