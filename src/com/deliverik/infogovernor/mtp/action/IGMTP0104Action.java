/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.mtp.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.mtp.bl.IGMTP01BL;
import com.deliverik.infogovernor.mtp.dto.IGMTP03DTO;
import com.deliverik.infogovernor.mtp.form.IGMTP0101Form;
import com.deliverik.infogovernor.mtp.form.IGMTP0103Form;
import com.deliverik.infogovernor.mtp.vo.IGMTP01011VO;
import com.deliverik.infogovernor.mtp.vo.IGMTP01041VO;

/**
 * 
 * �����ƻ�Action
 * 
 */
public class IGMTP0104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGMTP0104Action.class);

	/**
	 * �����ƻ�
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		log.debug("========�����ƻ�������ʾ��ʼ========");
		IGMTP01BL igmtp01BL = (IGMTP01BL) getBean("igmtp01BL");
		IGMTP03DTO dto = new IGMTP03DTO();
		IGMTP0103Form form = (IGMTP0103Form) actionForm;
		if(StringUtils.isNotEmpty(form.getPdid())){
			form.setPdid(form.getPdid().substring(0,5));
		}
		dto.setIgmtp0103Form(form);
		dto.setSelectedCheck((Map<String, String>) req.getSession(true).getAttribute("selectedCheck"));
		dto.setIgmtp01011VO((IGMTP01011VO) req.getAttribute("IGMTP01011VO"));
		// ȡ����ҳ���ύ����
		IGMTP0101Form igmtp0101Form = (IGMTP0101Form) req.getSession().getAttribute("IGMTP0101Form");
		dto = igmtp01BL.initIGMTP0104(dto);
		//��������ת
		String forward = form.getForward();
		
		Integer showYear = form.getShowYear();
		Integer showMonth = form.getShowMonth();
		// �ϸ���
		if ("back".equals(forward)) {
			if (showMonth == 0) {
				showYear = showYear - 1;
				showMonth = 11;
			} else {
				showMonth = showMonth - 1;
			}
		}
		// �¸���
		else if ("next".equals(forward)) {
			if (showMonth > 11) {
				showYear = showYear + 1;
				showMonth = 0;
			}
		}
		//�ύ��һ��
		if ("NEXT".equals(mapping.getParameter())) {
			List<String> selectList = new ArrayList<String>();
			//ת��List����
			for (String key : dto.getSelectedCheck().keySet()) {
				selectList.add(dto.getSelectedCheck().get(key));
			}
			//�����ڽ�������
			Collections.sort(selectList);
			req.getSession(true).setAttribute("selectList", selectList);
			return mapping.findForward(igmtp0101Form.getWorkType());
		}

		int calendarYear = (showYear == null || 0 == showYear) ? dto.getSyear(): showYear;
		int calendarMonth = (showMonth == null) ? dto.getSmonth() : showMonth;
		
		dto.setCalendarYear(calendarYear);
		dto.setCalendarMonth(calendarMonth);
		dto.setIgmtp0103Form(form);
		//ҳ���ʼ�����ݴ���
		dto = igmtp01BL.initIGMTP0104Action(dto);
		
		IGMTP01041VO vo = new IGMTP01041VO();
		vo.setCalendarYear(calendarYear);
		vo.setCalendarMonth(calendarMonth);
		vo.setWeekVOList(dto.getRowList());
		super.<IGMTP01041VO> setVO(req, vo);
		req.getSession(true).setAttribute("selectedCheck", dto.getSelectedCheck());
		log.debug("========�����ƻ�������ʾ����========");
		return mapping.findForward("DISP");
	}

}
