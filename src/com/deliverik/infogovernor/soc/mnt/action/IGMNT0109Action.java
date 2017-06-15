/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.mnt.action;

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
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT01BL;
import com.deliverik.infogovernor.soc.mnt.model.SOC0301Info;

/**
 * ����: ʵʱ�������ݵ���
 * ��������: ʵʱ�������ݵ���
 * ������¼: 2012/05/17
 * �޸ļ�¼: 
 */
public class IGMNT0109Action extends BaseAction{

	static Log log = LogFactory.getLog(IGMNT0109Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm arg1,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//BLȡ��
		IGMNT01BL ctlBL = (IGMNT01BL) getBean("igmnt01BL");
		log.debug("=============ʵʱ�������ݵ�����ʼ=============");
		int mtId=Integer.parseInt(req.getParameter("MtId"));
		Map<String, List<SOC0301Info>> dataMap = ctlBL.getDataMap(mtId);//ȡ��ʵʱ�������ݼ���
		req.setAttribute("dataMap", dataMap);
		log.debug("=============ʵʱ�������ݵ�������=============");
		return mapping.findForward("DISP");
	}
}
