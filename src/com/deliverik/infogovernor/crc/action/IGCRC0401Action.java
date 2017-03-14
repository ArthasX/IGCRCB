/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
import com.deliverik.infogovernor.crc.bl.IGCRC04BL;
import com.deliverik.infogovernor.crc.dto.IGCRC04DTO;
import com.deliverik.infogovernor.crc.form.IGCRC0401Form;
import com.deliverik.infogovernor.crc.vo.IGCRC04011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������������ѯAction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCRC0401Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		IGCRC0401Form form = (IGCRC0401Form)actionForm;
		//��־����ȡ��
		Log log = LogFactory.getLog(IGCRC0401Action.class);
		//BLȡ��
		IGCRC04BL ctlBL = (IGCRC04BL) getBean("igcrc04BL");
		//ʵ����dto
		IGCRC04DTO dto = new IGCRC04DTO();
		//��¼�û�ȡ��
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto�����趨
		dto.setUser(user);
		dto.setForm(actionForm);
		//�жϱ���ѯ�����Ƿ��Ѿ�����
		if(request.getSession().getAttribute("AD_ProcessInfoQueryMap")==null){
			ctlBL.getPivarQueryInfoAction(dto);
			request.getSession().setAttribute("AD_ProcessInfoQueryMap", dto.getProcessInfoQueryMap());
		}
		//ҳ���ʼ������
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("=============������������ѯҳ����ʾ������ʼ==============");
			dto = ctlBL.searchProcessRecords(dto);
			//ʵ����vo
			IGCRC04011VO vo = new IGCRC04011VO();
			vo.setPrList(dto.getProcessList());
			super.<IGCRC04011VO>setVO(request, vo);
			request.setAttribute("IGCRC0401Form", form);
			log.debug("=============������������ѯҳ����ʾ��������==============");
		}
		
		if("GETPARINFO".equals(mapping.getParameter())){
			log.debug("===========ȡ����������Ϣ������ʼ=============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				dto = ctlBL.getParentProcessInfoAction(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========ȡ����������Ϣ��������=============");
			return null;
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
