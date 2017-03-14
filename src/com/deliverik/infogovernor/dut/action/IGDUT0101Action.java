/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.dut.bl.IGDUT01BL;
import com.deliverik.infogovernor.dut.bl.task.DutyAuditTimeBL;
import com.deliverik.infogovernor.dut.dto.IGDUT01DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0101Form;
import com.deliverik.infogovernor.dut.model.DutyAuditTime;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditTimeSearchCondImpl;



/**
 * ֵ�����趨����Action
 * 
 */
public class IGDUT0101Action extends BaseAction {
	static Log log = LogFactory.getLog(IGDUT0101Action.class);

	/**
	 * ֵ�����趨����
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORMȡ��
		IGDUT0101Form form = (IGDUT0101Form) actionForm;
		// BLȡ��
		IGDUT01BL ctlBL = (IGDUT01BL) getBean("igdut01BL");
		// DTO����
		IGDUT01DTO dto = new IGDUT01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		if ("DISP".equals(mapping.getParameter())) {
			// ֵ�����趨������ʾ����
			log.debug("========ֵ�����趨���������ʾ����ʼ========");
			form.setDadtype("");
			form.setDadname("");
			form.setDattimes(null);
			form.setDadlimtime("");
			form.setDadcontent("");
			form.setDadinfo("");
			form.setDadorderby(null);

			req.getSession().setAttribute("ADtimelist", new ArrayList<LabelValueBean>());
			addMessage(req, new ActionMessage("IGCO10000.I001", "ֵ�����趨������Ϣ"));
			log.debug("========ֵ�����趨���������ʾ��������========");
			saveToken(req);
			return mapping.findForward("DISP");
		} 
		
		String forward = "";
		//��������
		if( "INSERT".equals(mapping.getParameter())){
			if((form.getMode().equals("0"))){
				// ���͵ǼǴ���
				log.debug("========ֵ�����趨����ʼ========");
				// DTO��������趨
				dto.setDutyAuditDef(form);
				dto.setIgDUT0101Form(form);

				if (isTokenValid(req, true)) {
					// ������Ϣ�Ǽ��߼�����
					dto = ctlBL.insertDutyAuditDefAction(dto);
				} else {
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				
				log.debug("========ֵ�����趨��������========");

				forward = "DISP";
				
			}else {
				//ֵ������Ϣ�������
				log.debug("========ֵ������Ϣ�������ʼ========");
				
				//DTO��������趨
				dto.setDutyAuditDef(form);
				dto.setIgDUT0101Form(form);
				
				//ֵ������Ϣ����߼�����
				dto = ctlBL.updateDutyAuditDefAction(dto);
				
				log.debug("========ֵ������Ϣ�����������========");
				
				forward = "DISP1";

			}
		}
		//���ҳ���ʼ��
		if("EDIT".equals(mapping.getParameter())){
			log.debug("========ֵ������Ϣ���������ʾ����ʼ========");
			form.setMode("1");
			//��ʼ�����ʱ��
			DutyAuditTimeBL dutyAuditTimeBL = (DutyAuditTimeBL) getBean("dutyAuditTimeBL");
			DutyAuditTimeSearchCondImpl cond  = new DutyAuditTimeSearchCondImpl();
			cond.setDadid(form.getDadid());
			List<DutyAuditTime> ret = dutyAuditTimeBL.searchDutyAuditTime(cond, 0, 0);
			List<LabelValueBean> list = new ArrayList<LabelValueBean>();
			for(DutyAuditTime dat : ret){
				list.add(new LabelValueBean(dat.getDattime(), dat.getDattime()));
			}       
			
			req.getSession().setAttribute("ADtimelist", list);
			
			dto.setIgDUT0101Form(form);
					
			dto = ctlBL.initDutyAuditDef(dto);
			
			forward = "DISP";
			log.debug("========ֵ������Ϣ���������ʾ��������========");
		
		}

		// �߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}

		}

		return mapping.findForward(forward);
	}
}
