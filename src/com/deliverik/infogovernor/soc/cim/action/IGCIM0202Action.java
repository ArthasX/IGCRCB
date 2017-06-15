/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
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
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM02BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0202Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM02021VO;

/**
 * ����: �ʲ�����Action����
 * ��������: �ʲ�����Action����
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
public class IGCIM0202Action extends BaseAction {
	static Log log = LogFactory.getLog(IGCIM0202Action.class);

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
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORMȡ��
		IGCIM0202Form form = (IGCIM0202Form) actionForm;
		// BLȡ��
		 IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		// DTO����
		IGCIM02DTO dto = new IGCIM02DTO();
		dto.setLocale(this.getLocale(req));
		// ������ת�趨
		String forward = null;

		if ("DISP".equals(mapping.getParameter())) {
			// �ʲ�����Ǽǻ��������ʾ����
			log.debug("========�ʲ�����Ǽǻ��������ʾ����========");
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I001", "�ʲ����������Ϣ"));
			log.debug("========�ʲ�����Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		}else if("REDISP".equals(mapping.getParameter())){
			//�ʲ�����Ǽǻ�������ʾ����
			log.debug("========�ʲ�����Ǽǻ�������ʾ����ʼ========");
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�ʲ�����Ǽǻ�������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		if( "INSERT".equals(mapping.getParameter())){
			//�ʲ�����༭����
			if (form.getMode().equals("0")){
				//�ʲ�����ǼǴ���
				log.debug("========�ʲ�����ǼǴ���ʼ========");
				String date = IGStringUtils.getCurrentDateTime();
				form.setCreatetime(date);
				form.setUpdatetime(date);
				//DTO��������趨
				dto.setIgcim0202Form(form);
				if (isTokenValid(req, true)){
				//�ʲ�������Ϣ�Ǽ��߼�����
				dto = ctlBL.insertEiDomainDefAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//���Ǽ����˵��ʲ�������Ϣ�趨��VO��
				IGCIM02021VO vo = new IGCIM02021VO(dto.getIgcim0202Form());
				super.<IGCIM02021VO>setVO(req.getSession(), vo);
				log.debug("========�ʲ�����ǼǴ�������========");
				forward = "DISP";
			}else{
				//�ʲ�����������
				log.debug("========�ʲ������޸Ĵ���ʼ========");
				String date=IGStringUtils.getCurrentDateTime();
				form.setUpdatetime(date);
				dto.setIgcim0202Form(form);
				dto = ctlBL.updateEiDomainDefAction(dto);
				log.debug("========�ʲ�����ǼǴ�������========");
				forward = "DETAIL";
			}
		}
		//���ҳ���ʼ��
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========�ʲ����������ʾ����ʼ========");
			dto.setIgcim0202Form(form);
			dto = ctlBL.initIGCIM0202Action(dto);
			log.debug("========�ʲ����������ʾ��������========");
			forward = "DISP";
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
