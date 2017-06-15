/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0111Form;

/**
 * 表单信息基本信息编辑画面Action处理
 *
 */
public class IGPRD0111Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0111Action.class);

	/**
	 * 表单信息处理
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
		IGPRD0111Form form = (IGPRD0111Form)actionForm;
		
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		
		//画面跳转设定
		String forward = null;
		
		if( "DISP".equals(mapping.getParameter())){
			//表单信息登记画面初期显示处理
			log.debug("========表单信息登记画面初期显示处理开始========");
			String maxSort = ResourceUtility.getString("MAX_SORT");
			addMessage(req, new ActionMessage("IGCO10000.I001","表单信息基本信息"));
			req.setAttribute("maxSort", Integer.valueOf(maxSort));
			saveToken(req);
			log.debug("========表单信息登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				//表单信息登记处理
				log.debug("========表单信息登记处理开始========");
				
				//DTO输入参数设定
				dto.setIgPRD0111Form(form);
				
				//表单信息信息登记逻辑调用
				
				
				if (isTokenValid(req, true)){
					dto = ctlBL.insertProcessInfoDefAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				req.setAttribute("pdid", form.getPdid());
				// 父表单定义主键
				if(StringUtils.isNotEmpty(form.getPpidid())){
					req.setAttribute("ppidid", form.getPpidid());
				}
				
				log.debug("========表单信息登记处理终了========");
				
				forward = "DISP";
				
			} else {
				//表单信息变更处理
				log.debug("========表单信息基本信息变更处理开始========");
				
				//DTO输入参数设定
				dto.setIgPRD0111Form(form);
				
				//表单信息信息变更逻辑调用
				dto = ctlBL.updateProcessInfoDefAction(dto);
				
				log.debug("========表单信息基本信息变更处理终了========");
				req.setAttribute("pdid", form.getPdid());
				forward = "BACK";
			}
		} else if ("EDIT".equals(mapping.getParameter())){
			log.debug("========表单信息基本信息变更初期显示处理开始========");
			form.setMode("1");
			dto.setIgPRD0111Form(form);
			dto = ctlBL.initIGPRD0111Action(dto);
			String maxSort = ResourceUtility.getString("MAX_SORT");
			req.setAttribute("maxSort", Integer.valueOf(maxSort));
			log.debug("========表单信息基本信息变更初期显示处理终了========");
			forward = "DISP";
		}else if ("DELETE".equals(mapping.getParameter())){
			log.debug("========表单信息删除处理开始========");
			dto.setIgPRD0111Form(form);
			
			ctlBL.deleteProcessInfoDefAction(dto);
			log.debug("========表单信息删除处理终了========");
			
			forward = "DISP";
		}else if ("ORDER".equals(mapping.getParameter())){
			log.debug("========表单信息排序处理开始========");
			dto.setIgPRD0111Form(form);
			ctlBL.orderProcessInfoDefAction(dto);
			log.debug("========表单信息排序处理终了========");
			forward = "DISP";
		}
		
		if("AJAX".equals(mapping.getParameter())){
			log.debug("===========查询角色信息操作开始=============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				
				String roletype = req.getParameter("roletype");
				RoleBL roleBL = (RoleBL) getBean("roleBL");
				List<Role> list = roleBL.getRoleByType(roletype);
				if(list != null){
					StringBuffer info = new StringBuffer();
					for(int i=0;i<list.size();i++){
						if(i>0){
							info.append("_#_");
						}
						Role role = list.get(i);
						info.append(role.getRolename()).append("_sp_").append(role.getRoleid());
					}
					out.print(info.toString());
				}
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========查询角色信息操作结束=============");
			return null;
		}
		
		//取得流程定义
		if("GETPROCESSDEFS".equals(mapping.getParameter())){
			log.debug("=================流程定义信息查询操作开始=================");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				dto.setPdid(form.getPdid());
				dto = ctlBL.searchProcessDefinitonsAction(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("=================流程定义信息查询操作结束=================");
			return null;
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
			//历史版本下的查看
			return mapping.findForward("VIEWHISTORY");
		}
		return mapping.findForward(forward);
	}
}
