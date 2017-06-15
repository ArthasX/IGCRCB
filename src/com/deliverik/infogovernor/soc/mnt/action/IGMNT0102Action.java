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
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT01BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT01DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0102Form;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeDefInfo;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT01021VO;
/**
 * ����:������ͷ�ֵ��ϢAction
 * ����������1.������ͷ�ֵ��Ϣ��ѯ
 *           2.������ͷ�ֵ��Ϣ�޸�
 * ������¼�����    2012/02/09
 */
public class IGMNT0102Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGMNT0102Action.class);

	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.soc.mnt.mntResources"); 
	
	/**
	 * ������ͷ�ֵ��Ϣ����
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
		IGMNT0102Form form=(IGMNT0102Form)actionForm;
		//BLȡ��
		IGMNT01BL ctlBL = (IGMNT01BL) getBean("igmnt01BL");
		//DTO����
		IGMNT01DTO dto=new IGMNT01DTO();
		dto.setIgmnt0102Form(form);
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============������ͷ�ֵ��Ϣ��ʼ����ʼ===============");
			req.getSession().removeAttribute("mtId");
			req.getSession().removeAttribute("mtName");
			log.debug("==============������ͷ�ֵ��Ϣ��ʼ������===============");
		}
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("==============������ͷ�ֵ��Ϣ��ѯ��ʼ===============");
			dto = ctlBL.searchMonitorTypeDefAction(dto);
			List<MonitorTypeDefInfo> monitorTypeDefInfoList = dto.getMonitorTypeDefInfoList();
			Integer mtId = form.getMtId();
			req.setAttribute("mtId", mtId);
			if(monitorTypeDefInfoList!=null&&monitorTypeDefInfoList.size()>0){
				IGMNT01021VO vo=new IGMNT01021VO(monitorTypeDefInfoList);
				super.<IGMNT01021VO>setVO(req, vo);
			}
			log.debug("==============������ͷ�ֵ��Ϣ��ѯ����===============");
		}
		if("UPDATE".equals(mapping.getParameter())){
			log.debug("==============������ͷ�ֵ��Ϣ�޸Ŀ�ʼ===============");
			ctlBL.updateMonitorTypeDefAction(dto);
			//����������ֵ
			ctlBL.updateCapacityObject(dto);
			addMessage(req, new ActionMessage("IGCO10000.I005", resources.getMessage(getLocale(req),"message.IGMNT01BLImpl.002")));
			log.debug("==============������ͷ�ֵ��Ϣ�޸Ľ���===============");
		}
		return mapping.findForward("DISP");
	}
}
