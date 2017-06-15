/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.asset.bl.IGASM25BL;
import com.deliverik.infogovernor.asset.dto.IGASM25DTO;
import com.deliverik.infogovernor.asset.form.IGASM2502Form;
import com.deliverik.infogovernor.asset.vo.IGASM25011VO;

/**
 * ����: �����¼��ϸҳ���ѯ
 * ���������������¼��ϸҳ���ѯaction 
 * �����ˣ����� 
 * ������¼�� 2012-7-13 
 * �޸ļ�¼��
 */
public class IGASM2502Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2101Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// FORMȡ��
		IGASM2502Form form = (IGASM2502Form) actionForm;
		String eiid = request.getParameter("eiid");
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("endTime");
		form.setEiid_q(eiid);
		form.setBeginTime(beginTime);
		form.setEndTime(endTime);
		// BLȡ��
		IGASM25BL ctlBL = (IGASM25BL) getBean("igasm25BL");

		// DTO����
		IGASM25DTO dto = new IGASM25DTO();

		log.debug("========�����¼��ϸҳ���ѯ����ʼ========");
		dto.setIgasm2502Form(form);
		//���÷����¼ͳ�Ʒ���
		dto = ctlBL.searchEntityItemRelationDetailVW(dto);
		//�������¼ͳ�Ƽ�������趨��VO��
		IGASM25011VO vo = new IGASM25011VO();
		vo.setFwcsSumCount(dto.getFwcsSumCount());
		vo.setFwpjfSumStore(dto.getFwpjfSumStore());
		vo.setEntityItemRelationDetailVWInfo(dto.getEntityItemRelationDetailVWInfo());
		vo.setBeginTime_q(form.getBeginTime());
		vo.setEndTime_q(form.getEndTime());
		vo.setEiname_like(dto.getEiname_like());
		super.<IGASM25011VO>setVO(request, vo);
		log.debug("========�����¼��ϸҳ���ѯ�������========");

		return mapping.findForward("DISP");
	}

}
