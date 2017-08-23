package com.deliverik.infogovernor.crc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.crc.bl.IGCRC02BL;
import com.deliverik.infogovernor.crc.dto.IGCRC02DTO;
import com.deliverik.infogovernor.crc.form.IGCRC4001Form;
import com.deliverik.infogovernor.crc.vo.IGCRC4001VO;
/**	
 * ����: �¼����������ϲ�ѯaction
 * ������¼��zhaoziting    2017/08/02
 * �޸ļ�¼��null
 */	
public class IGCRC4001Action extends BaseAction {

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ʵ����FORM
		IGCRC4001Form form = (IGCRC4001Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGCRC02BL bl = (IGCRC02BL) getBean("igcrc02bl");
		IGCRC02DTO dto = new IGCRC02DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		if( "SEARCHEVentandProblem".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			getPaginDTO(req,"IGCRC4001");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGCRC4001Form) req.getSession().getAttribute("IGCRC4001Form");
				if ( form == null ) {
					form = new IGCRC4001Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {

				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGCRC4001Form) req.getSession().getAttribute("IGCRC4001Form");
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}
			
			//pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGCRC4001");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setIgCRC4001Form(form);
			dto = bl.getEventAndProblem(dto);
			//�¼���Դ
			dto = bl.getEventSource(dto);
			//�¼�Ӱ�췶Χ
			dto = bl.getEventAffect(dto);
			//�¼�״̬
			dto = bl.getEventStatus(dto);
			//����״̬
			dto = bl.getProblemStatus(dto);
			//����VO
			IGCRC4001VO vo = new IGCRC4001VO();
			vo.setListep(dto.getListep());
			vo.setAffectlist(dto.getAffectlist());
			vo.setEslist(dto.getEslist());
			vo.setSourcelist(dto.getSourcelist());
			vo.setPslist(dto.getPslist());			
			super.<IGCRC4001VO>setVO(req, vo);			
			req.setAttribute("vo", vo);
		}
		if("EXCEL".equals(mapping.getParameter())){
			dto.setIgCRC4001Form(form);		
			res.reset();// ��������
			res.setHeader("Content-disposition", "attachment; filename=" + new String("�����¼�������Ϣ".getBytes("gb2312"), "8859_1") + ".xls");// �趨����ļ�ͷ
			res.setContentType("application/msexcel");
			dto.setOps(res.getOutputStream());
			bl.exportEventAndProblem(dto);
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		//��ת������JSP
		return mapping.findForward("DISP");
	}

}
