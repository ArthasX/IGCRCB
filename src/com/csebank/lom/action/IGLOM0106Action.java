/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.action;

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

import com.csebank.lom.bl.IGLOM01BL;
import com.csebank.lom.dto.IGLOM01DTO;
import com.csebank.lom.form.IGLOM0106Form;
import com.csebank.lom.vo.IGLOM01061VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * �Ӵ�ͳ�ƹ���Action
 * 
 */
public class IGLOM0106Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0106Action.class);

	/**
	 * �¼�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORMȡ��
		IGLOM0106Form form = (IGLOM0106Form)actionForm;
		
		//BLȡ��
		IGLOM01BL ctlBL = (IGLOM01BL) getBean("iglom01BL");
		
		//DTO����
		IGLOM01DTO dto = new IGLOM01DTO();
		
		String forward = "";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//�Ӵ�ͳ�ƹ����ѯ���������ʾ����
			log.debug("========�Ӵ�ͳ�ƹ����ѯ���������ʾ����ʼ========");
			form.setYear(IGStringUtils.getCurrentYear());
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�Ӵ�ͳ�ƹ����ѯ���������ʾ��������========");
			
			forward = "DISP";
			
			
		} else if("REDISP".equals(mapping.getParameter())){
			
			//�Ӵ�ͳ�ƹ����ѯ��������ʾ����
			log.debug("========�Ӵ�ͳ�ƹ����ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�Ӵ�ͳ�ƹ����ѯ��������ʾ��������========");
			
			forward = "DISP";
			
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//�Ӵ�ͳ�ƹ����ѯ����
			log.debug("========�Ӵ�ͳ�ƹ����ѯ����ʼ========");
	
			form = (IGLOM0106Form) req.getSession().getAttribute("IGLOM0106Form");
			//DTO��������趨
			dto.setRecptionVWSearchCond(form);
			
			
			//�Ӵ�ͳ�ƹ�����Ϣ�����߼�����
			dto = ctlBL.searchRecptionVWAction(dto);
			
			
			//���Ӵ�ͳ�ƹ�����Ϣ��������趨��VO��
			IGLOM01061VO vo = new IGLOM01061VO();
			vo.setRecptionVWList(dto.getRecptionVWList());
			
			super.<IGLOM01061VO>setVO(req, vo);
			
			log.debug("========�Ӵ�ͳ�ƹ����ѯ��������========");
			if(StringUtils.isNotEmpty(req.getParameter("report"))) {
				return mapping.findForward("REPORT");
			} else {
				forward = "DISP";
			}
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}

}
