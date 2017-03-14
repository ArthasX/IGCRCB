/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.mtp.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.mtp.bl.IGMTP01BL;
import com.deliverik.infogovernor.mtp.dto.IGMTP03DTO;
import com.deliverik.infogovernor.mtp.form.IGMTP0107Form;
import com.deliverik.infogovernor.mtp.vo.IGMTP01041VO;
import com.deliverik.infogovernor.mtp.vo.IGMTP01061VO;

/**
 * 
 * �����ƻ�Action
 * 
 */
public class IGMTP0107Action extends BaseAction {

	static Log log = LogFactory.getLog(IGMTP0107Action.class);

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
		IGMTP01061VO vo61= (IGMTP01061VO)req.getAttribute("IGMTP01061VO");
		IGMTP01BL igmtp01BL = (IGMTP01BL) getBean("igmtp01BL");
		IGMTP03DTO dto = new IGMTP03DTO();
		IGMTP0107Form form = (IGMTP0107Form) actionForm;
		//������һҳ�淢������ѡ������,�ύʱ��Ҫ�õ�
		dto.setDateList((List<String>) req.getSession(true).getAttribute("dateList"));
		dto.setIgmtp01061VO(vo61);
		dto.setIgmtp0107Form(form);
		dto.setSelectedCheck((Map<String, String>)req.getSession(true).getAttribute("selectedCheck"));

		//���ݳ�ʼ��
		dto = igmtp01BL.initIGMTP0107(dto);
		
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
			//��һ��Ҫת��������
			List<String> selectList = new ArrayList<String>();
			//Ϊ������Щ����ѡ������ڶ�����
			Map<String,String> init = new HashMap<String,String>();
			//��ʼ��ֵ
			for(int i=0;i<dto.getDateList().size();i++){
				init.put(dto.getDateList().get(i).split("_")[0], dto.getDateList().get(i).split("_")[2]);
			}
			//ת��List����
			for (String key : dto.getSelectedCheck().keySet()) {
				if(init.get(key) != null){//ѡ�������Ѵ���,������ԭ��ID
					selectList.add(dto.getSelectedCheck().get(key)+"_"+init.get(key));
				}else{//ѡ������Ϊ��ѡ��,��ID��Ϊ0
					selectList.add(dto.getSelectedCheck().get(key)+"_0");
				}
				
			}
			//�����ڽ�������
			Collections.sort(selectList);
			//����
			req.getSession(true).setAttribute("selectList", selectList);
			return mapping.findForward("DISP");
		}


		
		int calendarYear = (showYear == null || 0 == showYear) ? dto.getSyear(): showYear;
		int calendarMonth = (showMonth == null) ? dto.getSmonth() : showMonth;
		
		dto.setCalendarYear(calendarYear);
		dto.setCalendarMonth(calendarMonth);
		//ҳ���ʼ�����ݴ���
		dto = igmtp01BL.initIGMTP0107Action(dto);
		
		IGMTP01041VO vo = new IGMTP01041VO();
		vo.setCalendarYear(calendarYear);
		vo.setCalendarMonth(calendarMonth);
		vo.setWeekVOList(dto.getRowList());
		super.<IGMTP01041VO> setVO(req, vo);
		req.getSession(true).setAttribute("todayYMD", dto.getTodayYMD());
		req.getSession(true).setAttribute("dateList", dto.getDateList());
		req.getSession(true).setAttribute("selectedCheck", dto.getSelectedCheck());
		req.getSession(true).setAttribute("begin_time", dto.getIgmtp0107Form().getBegin_time());
		req.getSession(true).setAttribute("end_time", dto.getIgmtp0107Form().getEnd_time());
		log.debug("========�����ƻ�������ʾ����========");
		return mapping.findForward("DISP");
	}

}
