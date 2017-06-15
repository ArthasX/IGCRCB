/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.action;

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
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.dut.bl.IGDUT03BL;
import com.deliverik.infogovernor.dut.dto.IGDUT03DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0304Form;
import com.deliverik.infogovernor.dut.vo.IGDUT03041VO;

/**
 * ����: �ճ�ά�ޱ����&����action 
 * ��������: �ճ�ά�ޱ����&����action 
 * ������¼: 2012/04/01 �޸ļ�¼:
 */
public class IGDUT0304Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0304Action.class);

	/**
	 * �ճ�ά�ޱ����&����actions
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// ��ñ�
		IGDUT0304Form igdut0304Form = (IGDUT0304Form) form;
		// ���bean
		IGDUT03BL ctlBL = (IGDUT03BL) getBean("igdut03BL");
		// ����DTO
		IGDUT03DTO dto = new IGDUT03DTO();
		if("DISP".equals(mapping.getParameter())){
			log.debug("========��ʾ���ܿ�ʼ========");
			igdut0304Form.setOdprctime(IGStringUtils.getCurrentDateTime());
			igdut0304Form.setOdprinserttime(IGStringUtils.getCurrentDate());
			log.debug("========��ʾ��������========");
		}

		// ���&!!!����!!!����
		if ("INSERT".equals(mapping.getParameter())) {
			log.debug("========��ӹ��ܿ�ʼ========");
			// ��ʵ¼���趨
			igdut0304Form.setOdprmodtime(IGStringUtils.getCurrentDateTime());
			if (request.getSession().getAttribute(SESSION_KEY_LOGIN_USER) != null) {
				User user = (User) request.getSession().getAttribute(
						SESSION_KEY_LOGIN_USER);
				// ¼�����趨
				igdut0304Form.setOdprusername(user.getUserid());
			}
			//dto����form
			dto.setIgDUT0304Form(igdut0304Form);
			ctlBL.registOnDutyPersonRecordAction(dto);

			log.debug("========��ӹ��ܽ���========");
			//����ģʽΪ��� 0���� 1����
			igdut0304Form.setMode(0);
		}

		// ��������ȡ��
		if ("TOUPDATE".equals(mapping.getParameter())) {
			Integer id = null;
			log.debug("========��������ȡ�ÿ�ʼ========");
			if (request.getParameter("odprid") != null) {
				// ��������ȡ��
				id = Integer.parseInt(request.getParameter("odprid"));
				igdut0304Form.setOdprid(id);
				dto.setIgDUT0304Form(igdut0304Form);
				// ��ʼ������ҳ��
				ctlBL.initIGDUT0304Action(dto);
				log.debug("========��������ȡ�ý���========");
				// ����action����ģʽ 1Ϊ����ģʽ
				igdut0304Form.setMode(1);
			}
		}

		// ��ʼ��0304VO
		IGDUT03041VO vo = new IGDUT03041VO();
		// �����¼�б�vo
		vo.setOnDutyPersonRecordInfoList(dto.getOnDutyPersonRecordList());
		// ��ѯ��checkbox��������
		ctlBL.searchOnDutyPersonRecordArea(dto);
		// ����������ݵ�vo
		vo.setCodeDetailList(dto.getCodeDetailList());
		// vo���浽request��Χ
		super.<IGDUT03041VO> setVO(request, vo);

		// �߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}

		}

		return mapping.findForward("DISP");
	}

}
