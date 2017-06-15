/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.IGLOM05BL;
import com.csebank.lom.dto.IGLOM05DTO;
import com.csebank.lom.form.IGLOM0507Form;
import com.csebank.lom.vo.IGLOM05071VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;

/**
 * ʳ�ýӴ�����Action
 * 
 */
public class IGLOM0507Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0507Action.class);

	/**
	 * ʳ�ýӴ�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@SuppressWarnings("static-access")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORMȡ��
		IGLOM0507Form form = (IGLOM0507Form)actionForm;
		
		//BLȡ��
		IGLOM05BL ctlBL = (IGLOM05BL) getBean("iglom05BL");
		
		//DTO����
		IGLOM05DTO dto = new IGLOM05DTO();
		
		String forward = "";
		
		if ("DETAIL".equals(mapping.getParameter())){
			//�Ӵ�ͳ����ϸ��ѯ
			form = (IGLOM0507Form) req.getSession().getAttribute("IGLOM0507Form");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Calendar c = Calendar.getInstance();
			try{
				c.setTime(sdf.parse(form.getEedate()+"/01"));
			}catch(ParseException e){
				return mapping.findForward("DISP");
			}
			
			c.add(c.MONTH, 1);
			c.add(c.DAY_OF_MONTH, -1);
			form.setEetime_from(form.getEedate()+"/01");
			form.setEetime_to(sdf.format(c.getTime()));
			log.debug("========�Ӵ�ͳ����ϸ��ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGLOM0507");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGLOM0507");
			
			//DTO��������趨
			dto.setEentertainmentSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//ʳ�ýӴ�ͳ����ϸ��Ϣ�����߼�����
			dto = ctlBL.searchEentertainmentAction(dto);
			
			
			//��ʳ�ýӴ�ͳ����ϸ��Ϣ��������趨��VO��
			IGLOM05071VO vo = new IGLOM05071VO();
			vo.setEentertainmentList(dto.getEentertainmentList());
			
			super.<IGLOM05071VO>setVO(req, vo);
			
			log.debug("========�Ӵ�ͳ����ϸ��ѯ��������========");
			
			forward = "DISP";
		}else if( "DISP".equals(mapping.getParameter())){
			
			//ʳ�ýӴ������ѯ���������ʾ����
			log.debug("========ʳ�ýӴ������ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========ʳ�ýӴ������ѯ���������ʾ��������========");
			
			forward = "DISP";
			
		} 	/*
			else if ("DELETE".equals(mapping.getParameter())){
			
			log.debug("========ʳ�ýӴ�����ɾ������ʼ========");
			//DTO��������趨
			dto.setDeleteRid(form.getDeleteRid());
			
			ctlBL.deleteRecptionAction(dto);
			
			log.debug("========�Ӵ���������ɾ����������========");
			
			forward = "DELETE";
			
		} */else if( "REPORT".equals(mapping.getParameter())){
			form = (IGLOM0507Form) req.getSession().getAttribute("IGLOM0507Form");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Calendar c = Calendar.getInstance();
			try{
				c.setTime(sdf.parse(form.getEedate()+"/01"));
			}catch(ParseException e){
				return mapping.findForward("DISP");
			}
			
			c.add(c.MONTH, 1);
			c.add(c.DAY_OF_MONTH, -1);
			form.setEetime_from(form.getEedate()+"/01");
			form.setEetime_to(sdf.format(c.getTime()));
			log.debug("========�Ӵ�ͳ����ϸ��ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGLOM0507");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGLOM0507");
			
			//DTO��������趨
			dto.setEentertainmentSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//ʳ�ýӴ�ͳ����ϸ��Ϣ�����߼�����
			dto = ctlBL.searchEentertainmentAction(dto);
			
			
			//��ʳ�ýӴ�ͳ����ϸ��Ϣ��������趨��VO��
			IGLOM05071VO vo = new IGLOM05071VO();
			vo.setEentertainmentList(dto.getEentertainmentList());
			
			super.<IGLOM05071VO>setVO(req, vo);
			req.setAttribute("form", form);
			req.setAttribute("IGLOM05071VO", vo);
			log.debug("========�Ӵ�ͳ����ϸ��ѯ��������========");
			return mapping.findForward("REPORT");

		}else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//ʳ�ýӴ������ѯ����
			log.debug("========ʳ�ýӴ������ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGLOM0507");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGLOM0507Form) req.getSession().getAttribute("IGLOM0507Form");
				if ( form == null ) {
					form = new IGLOM0507Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			}  else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGLOM0507Form) req.getSession().getAttribute("IGLOM0507Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGLOM0507");
			
			//DTO��������趨
			dto.setEentertainmentSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//ʳ�ýӴ�������Ϣ�����߼�����
			dto = ctlBL.searchEentertainmentAction(dto);
			
			
			//��ʳ�ýӴ�������Ϣ��������趨��VO��
			IGLOM05071VO vo = new IGLOM05071VO();
			vo.setEentertainmentList(dto.getEentertainmentList());
			
			super.<IGLOM05071VO>setVO(req, vo);
			
			log.debug("========ʳ�ýӴ������ѯ��������========");
			
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
