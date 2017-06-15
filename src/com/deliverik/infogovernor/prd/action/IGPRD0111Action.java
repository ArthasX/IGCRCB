/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����Ϣ������Ϣ�༭����Action����
 *
 */
public class IGPRD0111Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0111Action.class);

	/**
	 * ����Ϣ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGPRD0111Form form = (IGPRD0111Form)actionForm;
		
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		
		//������ת�趨
		String forward = null;
		
		if( "DISP".equals(mapping.getParameter())){
			//����Ϣ�Ǽǻ��������ʾ����
			log.debug("========����Ϣ�Ǽǻ��������ʾ����ʼ========");
			String maxSort = ResourceUtility.getString("MAX_SORT");
			addMessage(req, new ActionMessage("IGCO10000.I001","����Ϣ������Ϣ"));
			req.setAttribute("maxSort", Integer.valueOf(maxSort));
			saveToken(req);
			log.debug("========����Ϣ�Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} else if( "INSERT".equals(mapping.getParameter())){
			if (form.getMode().equals("0")){
				//����Ϣ�ǼǴ���
				log.debug("========����Ϣ�ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgPRD0111Form(form);
				
				//����Ϣ��Ϣ�Ǽ��߼�����
				
				
				if (isTokenValid(req, true)){
					dto = ctlBL.insertProcessInfoDefAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				req.setAttribute("pdid", form.getPdid());
				// ������������
				if(StringUtils.isNotEmpty(form.getPpidid())){
					req.setAttribute("ppidid", form.getPpidid());
				}
				
				log.debug("========����Ϣ�ǼǴ�������========");
				
				forward = "DISP";
				
			} else {
				//����Ϣ�������
				log.debug("========����Ϣ������Ϣ�������ʼ========");
				
				//DTO��������趨
				dto.setIgPRD0111Form(form);
				
				//����Ϣ��Ϣ����߼�����
				dto = ctlBL.updateProcessInfoDefAction(dto);
				
				log.debug("========����Ϣ������Ϣ�����������========");
				req.setAttribute("pdid", form.getPdid());
				forward = "BACK";
			}
		} else if ("EDIT".equals(mapping.getParameter())){
			log.debug("========����Ϣ������Ϣ���������ʾ����ʼ========");
			form.setMode("1");
			dto.setIgPRD0111Form(form);
			dto = ctlBL.initIGPRD0111Action(dto);
			String maxSort = ResourceUtility.getString("MAX_SORT");
			req.setAttribute("maxSort", Integer.valueOf(maxSort));
			log.debug("========����Ϣ������Ϣ���������ʾ��������========");
			forward = "DISP";
		}else if ("DELETE".equals(mapping.getParameter())){
			log.debug("========����Ϣɾ������ʼ========");
			dto.setIgPRD0111Form(form);
			
			ctlBL.deleteProcessInfoDefAction(dto);
			log.debug("========����Ϣɾ����������========");
			
			forward = "DISP";
		}else if ("ORDER".equals(mapping.getParameter())){
			log.debug("========����Ϣ������ʼ========");
			dto.setIgPRD0111Form(form);
			ctlBL.orderProcessInfoDefAction(dto);
			log.debug("========����Ϣ����������========");
			forward = "DISP";
		}
		
		if("AJAX".equals(mapping.getParameter())){
			log.debug("===========��ѯ��ɫ��Ϣ������ʼ=============");
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
			log.debug("===========��ѯ��ɫ��Ϣ��������=============");
			return null;
		}
		
		//ȡ�����̶���
		if("GETPROCESSDEFS".equals(mapping.getParameter())){
			log.debug("=================���̶�����Ϣ��ѯ������ʼ=================");
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
			log.debug("=================���̶�����Ϣ��ѯ��������=================");
			return null;
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
			//��ʷ�汾�µĲ鿴
			return mapping.findForward("VIEWHISTORY");
		}
		return mapping.findForward(forward);
	}
}
