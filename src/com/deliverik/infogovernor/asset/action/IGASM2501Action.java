/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
import com.deliverik.infogovernor.asset.form.IGASM2501Form;
import com.deliverik.infogovernor.asset.vo.IGASM25011VO;

/**
 * ����: �����¼ͳ�Ʋ�ѯҳ�� 
 * ���������������¼ͳ�Ʋ�ѯҳ��action 
 * �����ˣ����� 
 * ������¼�� 2012-7-12 
 * �޸ļ�¼��
 */
public class IGASM2501Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2101Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// FORMȡ��
		IGASM2501Form form = (IGASM2501Form) actionForm;

		// BLȡ��
		IGASM25BL ctlBL = (IGASM25BL) getBean("igasm25BL");

		// DTO����
		IGASM25DTO dto = new IGASM25DTO();

		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========�����¼ͳ��ҳ���ʼ����ʼ========");
			//��ȡ��ǰϵͳ����
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
			String currentTime = sf.format(cal.getTime());
			//����Ĭ�ϲ�ѯ����
			form.setBeginTime_q(currentTime);
			form.setEndTime_q(currentTime);

			log.debug("========�����¼ͳ��ҳ���ʼ������========");
		}
		if ("SEARCH".equals(mapping.getParameter())) {
			log.debug("========�����¼ͳ��ҳ���ѯ����ʼ========");
			//��ȡ��ѯ����
			dto.setBeginTime_q(form.getBeginTime_q());
			dto.setEndTime_q(form.getEndTime_q());
			dto.setEiname_like(form.getEiname_like());
			//���÷����¼ͳ�Ʒ���
			dto = ctlBL.searchEntityItemRelationVW(dto);
			//�������¼ͳ�Ƽ�������趨��VO��
			IGASM25011VO vo = new IGASM25011VO();
			vo.setHjSumCount(dto.getHjSumCount());
			vo.setPxSumCount(dto.getPxSumCount());
			vo.setSbSumCount(dto.getSbSumCount());
			vo.setYySumCount(dto.getYySumCount());
			//���ò�ѯʱ��
			vo.setBeginTime_q(form.getBeginTime_q());
			vo.setEndTime_q(form.getEndTime_q());
			vo.setEntityItemRelationVWInfoList(dto.getEntityItemRelationVWInfoList());
			super.<IGASM25011VO>setVO(request, vo);
			log.debug("========�����¼ͳ��ҳ���ѯ�������========");
		}
		return mapping.findForward("DISP");
	}

}
