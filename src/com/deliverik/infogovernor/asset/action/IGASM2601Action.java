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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.asset.bl.IGASM26BL;
import com.deliverik.infogovernor.asset.dto.IGASM26DTO;
import com.deliverik.infogovernor.asset.form.IGASM2601Form;
import com.deliverik.infogovernor.asset.vo.IGASM26011VO;

/**
 * ����: ��������Դ��ͳ��ҳ�� 
 * ��������������������Դ��ͳ��ҳ��action 
 * �����ˣ����� 
 * ������¼�� 2012-08-31 
 * �޸ļ�¼��
 */
public class IGASM2601Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2601Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// FORMȡ��
		IGASM2601Form form = (IGASM2601Form) actionForm;

		// BLȡ��
		IGASM26BL ctlBL = (IGASM26BL) getBean("igasm26BL");

		// DTO����
		IGASM26DTO dto = new IGASM26DTO();

		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========��������Դ��ͳ��ҳ���ʼ����ʼ========");
			//��ȡ��ǰϵͳ����
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
			String currentTime = sf.format(cal.getTime());
			int year = cal.get(cal.YEAR);
			//����Ĭ�ϲ�ѯ����
//			form.setBeginTime_q(currentTime);
			//��ѯ�����ڵǼ�ʱ��Ĭ��Ϊ���������ǰ��
			form.setBeginTime_q(String.valueOf(year+"/01/01"));
			form.setEndTime_q(currentTime);
			
			log.debug("========��������Դ��ͳ�����ʼ������========");
		}
		if ("SEARCH".equals(mapping.getParameter())) {
			log.debug("========��������Դ��ͳ�ƴ���ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(request, "IGASM2601");			
			PagingDTO pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//�ж�form�Ƿ�Ϊ��
			if (form == null) {
				//formΪ��ʱ����ʼ��form
				form = new IGASM2601Form();
			} else {
				//���з�ҳ����
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(form.getFromCount());
				} else {
					form.setFromCount(pDto.getFromCount());
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM2601");
			//����ѯ����Ľ������װ��dto��
			dto.setMaxSearchCount(maxCnt);
			//����ҳʵ���װ��dto��
			dto.setPagingDto(pDto);
			//��ȡ��ѯ����
			dto.setIgasm2601Form(form);
			//���÷�������Դ��ͳ�Ʒ���
			dto = ctlBL.searchEntityItemRelationVW(dto);
			//�������¼ͳ�Ƽ�������趨��VO��
			IGASM26011VO vo = new IGASM26011VO();
			//���ò�ѯʱ��
			vo.setEntityItemAndConfigItemVWInfoList(dto.getEntityItemAndConfigItemVWInfoList());
			super.<IGASM26011VO>setVO(request, vo);
			log.debug("========��������Դ��ͳ�ƴ������========");
		}
		return mapping.findForward("DISP");
	}

}
