/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.action;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.deliverik.infogovernor.svc.bl.IGSVC06BL;
import com.deliverik.infogovernor.svc.dto.IGSVC06DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0636Form;
import com.deliverik.infogovernor.svc.vo.IGSVC06361VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ŷ���ͳ��Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGSVC0636Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGSVC0636Action.class);
		//BLȡ��
		IGSVC06BL ctlBL = (IGSVC06BL) getBean("igsvc06BL");
		//ʵ����dto
		IGSVC06DTO dto = new IGSVC06DTO();
		//formȡ��
		IGSVC0636Form form = (IGSVC0636Form) actionForm;
		//dto�����趨
		dto.setIgsvc0636Form(form);
		//ҳ���ʼ��
		if("DISP".equals(mapping.getParameter())){
			log.debug("===============���ŷ���ͳ��ҳ���ʼ��������ʼ===============");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			Date date = new Date();
			String year = sdf.format(date);
			form.setYear(year);
			sdf = new SimpleDateFormat("MM");
			String month = sdf.format(date);
			form.setMonth(month);
			log.debug("===============���ŷ���ͳ��ҳ���ʼ����������===============");
		}
		//���ŷ���ͳ�����ݲ�ѯ����
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("=============���ŷ���ͳ�����ݲ�ѯ������ʼ===========");
			dto = ctlBL.searchOrganizationServiceAction(dto);
			//ʵ����vo
			IGSVC06361VO vo = new IGSVC06361VO();
			vo.setOrganizationServiceList(dto.getOrganizationServiceList());
			vo.setIcount(dto.getIcount());
			vo.setScount(dto.getScount());
			vo.setGcount(dto.getGcount());
			vo.setTotalCount(dto.getTotalCount());
			super.setVO(request, vo);
			log.debug("=============���ŷ���ͳ�����ݲ�ѯ��������===========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
