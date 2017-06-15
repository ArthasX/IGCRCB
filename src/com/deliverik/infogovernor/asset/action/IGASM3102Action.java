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
import com.deliverik.infogovernor.asset.bl.IGASM31BL;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.form.IGASM3102Form;
import com.deliverik.infogovernor.asset.vo.IGASM31021VO;

/**
 * 风险指标编辑画面Action处理
 *
 * @author
 */
public class IGASM3102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM3102Action.class);

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
		IGASM3102Form form = (IGASM3102Form)actionForm;
		
		//BL取得
		IGASM31BL ctlBL = (IGASM31BL) getBean("igasm31BL");
		
		//DTO生成
		IGASM31DTO dto = new IGASM31DTO();
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//风险指标登记画面初期显示处理
			log.debug("========风险指标登记画面初期显示处理开始========");
			form = new IGASM3102Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);
			//获取当前用户
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			//设定默认表单用户名为登录人name
			form.setMguserid(user.getUserid());
			form.setMgusername(user.getUsername());
			dto.setIgasm3102Form(form);
			
			//获取属性下拉列表值*
			ctlBL.searchRiskPropertyActioin(dto);
			
			dto = ctlBL.searchEntityItemLableAction(dto);			
			
			req.setAttribute("IGASM3102Form", form);
			
			//将登记完了的风险指标信息设定到VO中
			IGASM31021VO vo = new IGASM31021VO(dto.getIgasm3102Form());
			//风险指标--阀值下拉
			vo.setThresholdList(dto.getThresholdList());
			//风险指标--指标模板下拉
			vo.setTitList(dto.getTitList());
			//风险指标--是否关键指标下拉
			vo.setKeyIndexList(dto.getKeyIndexList());
			//风险点 属性集合
			vo.setSoc0109List(dto.getSoc0109List());
			
			super.<IGASM31021VO>setVO(req.getSession(), vo);
			addMessage(req, new ActionMessage("IGCO10000.I001","风险指标基本信息"));
			
			saveToken(req);
			log.debug("========风险指标登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
			
		} else if("REDISP".equals(mapping.getParameter())){
			//风险指标登记画面再显示处理
			log.debug("========风险指标登记画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========风险指标登记画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//风险指标编辑处理
			if (form.getMode().equals("0")){
				//风险指标登记处理
				log.debug("========风险指标登记处理开始========");

				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setEiorgsyscoding(user.getOrgid());
				form.setEiuserid(user.getUserid());
				form.setEiusername(user.getUsername());
				form.setEiname(form.getCivalue()[0]);
				form.setEidesc(form.getCivalue()[9]);
				
				//DTO输入参数设定
				dto.setIgasm3102Form(form);
				//避免重复提交
				if (isTokenValid(req, true)) {
					//风险指标信息登记逻辑调用
					dto = ctlBL.insertEntityItemAction(dto);
				} else {
					addMessage(req, new ActionMessage("IGCO00000.E007"));
				}
				
				//将登记完了的风险指标信息设定到VO中
				IGASM31021VO vo = new IGASM31021VO(dto.getIgasm3102Form());
				//风险指标--阀值下拉
				vo.setThresholdList(dto.getThresholdList());
				//风险指标--指标模板下拉
				vo.setTitList(dto.getTitList());
				//风险指标--是否关键指标下拉
				vo.setKeyIndexList(dto.getKeyIndexList());
				//风险点 属性集合
				vo.setSoc0109List(dto.getSoc0109List());
				//编号
				req.getSession().setAttribute("eilabel", dto.getIgasm3102Form().getEilabel());
				String eiiddd= dto.getEiid()+"";
				req.getSession().setAttribute("eiiddd",eiiddd);
				
				super.<IGASM31021VO>setVO(req.getSession(), vo);
				
				log.debug("========风险指标登记处理终了========");
				
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
