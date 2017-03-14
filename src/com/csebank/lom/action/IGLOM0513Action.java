/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM05BL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0513Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM05081VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.utility.IGStringUtils;



/**
 * ģ�飺���ڹ���-ʳ�ù���
 * ˵����ʳ�ó�����ϸAction
 * ���ߣ�������
 */
public class IGLOM0513Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0513Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORMȡ��
		IGLOM0513Form form = (IGLOM0513Form)actionForm;
		
		//BLȡ��
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		
		//DTO����
		IGLOM05DTO dto = new IGLOM05DTO();
		//�����˵�
		req.setAttribute("gout_consume", LOMHelper.getItemsCodes(CodeUtils.GOUT_CONSUME));
		String forward = "";
		//������ʾ��ת�����Բ�ѯ��ҳ��
		if( "DISP".equals(mapping.getParameter())){
			
			
			log.debug("========ʳ����Ʒ������ϸ��ʼ������ʼ========");
			form.setYear(IGStringUtils.getCurrentYear());
			form.setMonth_to(IGStringUtils.getCurrentDate().substring(5,7));		
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========ʳ����Ʒ������ϸ��ʼ������ʼ========");
			
			forward = "DISP";
	
		
		}else if( "SEARCH".equals(mapping.getParameter())){
			
			log.debug("========ʳ����Ʒ������ϸ��ѯ����ʼ========");
            getPaginDTO(req,"IGLOM0513");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
	
			form = (IGLOM0513Form) req.getSession().getAttribute("IGLOM0513Form");
			//from�е�useType����ת�������useType=1������ͨ���ģ�useType=2�д�����

			dto.setGoutDetailSearchCond(form);
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGLOM0513");
			
			//DTO��������趨
			dto.setGoutDetailSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);			
		
			dto = ctlBL.searchGoutDetailInfo(dto)	;
			
			
			IGLOM05081VO vo = new IGLOM05081VO();
			vo.setGoutDetailInfoList(dto.getGoutDetailInfoList());
			
			super.<IGLOM05081VO>setVO(req, vo);
			
			log.debug("========ʳ����Ʒ������ϸ��ѯ����ʼ========");
			if(StringUtils.isNotEmpty(req.getParameter("report"))) {
				return mapping.findForward("REPORT");
			} else {
				forward = "DISP";
			}
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
