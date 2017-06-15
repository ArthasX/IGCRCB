/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0168Form;
import com.deliverik.infogovernor.prd.form.IGPRD0169Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01681VO;

/**
 * ����: �Զ�������ҳ������ ��ѯ/����Action
 * ��������: �Զ�������ҳ������ ��ѯ/����Action
 * ������¼: 20121113
 * �޸ļ�¼: 
 */
public class IGPRD0168Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0168Action.class);

	/**
	 * ��ѯ/����/Action 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		// DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		if ("DISP".equals(mapping.getParameter())) {
			// FORMȡ��
			IGPRD0168Form form = (IGPRD0168Form) actionForm;
			String pdname=req.getParameter("pdname");
			String pddesc = req.getParameter("pddesc");
//			if(pddesc!=null){
//				pddesc = new String(pddesc.getBytes("iso-8859-1"),"UTF-8"); 
//				form.setPddesc(pddesc);
//			}
//			if(pdname!=null){
//				pdname = new String(pdname.getBytes("iso-8859-1"),"UTF-8"); 
//				form.setPdname(pdname);
//			}

			dto.setIgPRD0168Form(form);
			log.debug("========�Զ�������ҳ�����ó�ʼ������ʼ========");
			//��ѯig126������
			dto = ctlBL.searchProcessJspInfoAction(dto);
     		IGPRD01681VO vo = new IGPRD01681VO(dto.getProcessJspInfoList());
     		vo.setIg380info(dto.getIg380info());
            super.<IGPRD01681VO>setVO(req, vo);
            /** 2013-3-11 wanglei ҳ�������������Ƽ�����˵����������*/
            // ����˵��
            form.setPddesc(dto.getIg380info().getPddesc());
            // ��������
            form.setPdname(dto.getIg380info().getPdname());
			addMessage(req, new ActionMessage("IGCO10000.I003"));			
			log.debug("========�Զ�������ҳ�����ó�ʼ���������========");
		} if ("INSERT".equals(mapping.getParameter())) {
			log.debug("========�Զ�������ҳ��������������ʼ========");
			IGPRD0169Form form = (IGPRD0169Form) actionForm;
			dto.setIgPRD0169Form(form);
			if (isTokenValid(req, true)){
				dto = ctlBL.insertProcessJspAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�Զ�������ҳ�����������������========");
		} else if ("INIT".equals(mapping.getParameter())) {
			log.debug("========�Զ�������ҳ������������ʼ������ʼ========");
			// FORMȡ��
			IGPRD0168Form form = (IGPRD0168Form) actionForm;
			dto.setIgPRD0168Form(form);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========�Զ�������ҳ������������ʼ���������========");
		}
		// �߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
