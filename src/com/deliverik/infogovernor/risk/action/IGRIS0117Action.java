/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.action;

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
import com.deliverik.infogovernor.risk.bl.IGRIS01BL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0117Form;
import com.deliverik.infogovernor.risk.vo.IGRIS01171VO;

/**
 * ��Ʊ����ѯAction����
 *
 * @author liupeng@deliverik.com
 */
public class IGRIS0117Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0117Action.class);

	/**
	 * ��Ʊ����ѯ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGRIS0117Form form = (IGRIS0117Form)actionForm;
		
		//BLȡ��
		IGRIS01BL ctlBL = (IGRIS01BL) getBean("igRIS01BL");
		
		//DTO����
		IGRIS01DTO dto = new IGRIS01DTO();
		
		//��ȡ��Ʊ�������б�
		ctlBL.searchRiskAuditInsLabelInUse(dto);
		req.setAttribute("labelList", dto.getLabelList());
		
		if( "DISP".equals(mapping.getParameter())){
			//��Ʊ����ѯ���������ʾ����
			log.debug("========��Ʊ����ѯ���������ʾ����ʼ========");
			log.debug("========��Ʊ����ѯ���������ʾ��������========");
		} else if ( "SEARCH".equals(mapping.getParameter())){
			//��Ʊ����ѯ����
			log.debug("========��Ʊ����ѯ����ʼ========");
			
			dto.setIgRIS0117Form(form);
			
			//��Ʊ�����Ϣ�����߼�����
			dto = ctlBL.searchRiskAuditReportAction(dto);
			
			//����Ʊ�����Ϣ��������趨��VO��
			IGRIS01171VO vo = new IGRIS01171VO();
			
			vo.setRadMaxLevel(dto.getRadMaxLevel());
			vo.setRadMaxLevelList(dto.getRadMaxLevelList());
			vo.setRiskAuditDefResultVWInfoList(dto.getRiskAuditDefResultVWInfoList());
			vo.setRadrisklevelList(dto.getRadrisklevelList());
			vo.setRadfrequencyList(dto.getRadfrequencyList());
			vo.setRadmodeList(dto.getRadmodeList());
			vo.setRadtypeList(dto.getRadtypeList());
			vo.setRarplanscoreList(dto.getRarplanscoreList());
			vo.setRarexecscoreList(dto.getRarexecscoreList());
			vo.setRaroverallscoreList(dto.getRaroverallscoreList());
			vo.setRiskAuditIns(dto.getRiskAuditIns());
			//vo.setChildCountMap(dto.getChildCountMap());
			
			super.<IGRIS01171VO>setVO(req, vo);
			
			log.debug("========��Ʊ����ѯ��������========");
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		String forwardName = "DISP";
		String report = req.getParameter("report");
		if(null != report && "1".equals(report)){
			forwardName = "REPORT";
		}
	
		return mapping.findForward(forwardName);
	}
}
