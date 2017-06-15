/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT01BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT01DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0104Form;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT01041VO;
/**
 * ����:��ض������Action
 * ����������1.��ض����ѯ
 * ������¼�����    2012/02/09
 */
public class IGMNT0104Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGMNT0104Action.class);

	/**
	 * ��ض������
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
		//formȡ��
		IGMNT0104Form form=(IGMNT0104Form)actionForm;
		//BLȡ��
		IGMNT01BL ctlBL = (IGMNT01BL) getBean("igmnt01BL");
		//DTO����
		IGMNT01DTO dto=new IGMNT01DTO();
		dto.setIgmnt0104Form(form);
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============��ض�������ʼ����ʼ===============");
			dto=ctlBL.searchMonitorTypeAction(dto);
			List<LabelValueBean> monitorTypeList = dto.getMonitorTypeList();
			req.getSession().setAttribute("monitorTypeList", monitorTypeList);
			log.debug("==============��ض�������ʼ������===============");
		}
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("==============��ض����ѯ��ʼ===============");
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGMNT0104");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGMNT0104Form) req.getSession().getAttribute("IGMNT0104Form");
				if ( form== null){
					form = new IGMNT0104Form();
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
					form = (IGMNT0104Form) req.getSession().getAttribute("IGMNT0104Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGMNT0104");
			
			//DTO��������趨
			dto.setIgmnt0104Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto = ctlBL.searchMonitorObjectAction(dto);
			List<MonitorObjectInfo> monitorObjectList = dto.getMonitorObjectList();
		
			IGMNT01041VO vo=new IGMNT01041VO(monitorObjectList);
			super.<IGMNT01041VO>setVO(req, vo);
			log.debug("==============��ض����ѯ����===============");
		}
		if("CHANGE".equals(mapping.getParameter())){
			log.debug("==============��ض���״̬�ı俪ʼ===============");
			ctlBL.updateMonitorObjectStatusAction(dto);
			log.debug("==============��ض���״̬�ı����===============");
		}
		if("DELETE".equals(mapping.getParameter())){
			log.debug("==============��ض���ɾ����ʼ===============");
			//�洢������Ϣɾ���߼�����
			dto=ctlBL.deleteSymmOtherInfoAction(dto);
			//�洢������Ϣɾ���߼�����
			dto=ctlBL.deleteSymmInfoAction(dto);
			//ɾ����ض���
			dto=ctlBL.deleteMonitorObject(dto);
			//��ȡUser��Ϣ
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			req.getSession().setAttribute(user.getUserid()+"host1","");
			req.getSession().setAttribute(user.getUserid()+"host2","");
			log.debug("==============��ض���ɾ������===============");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
