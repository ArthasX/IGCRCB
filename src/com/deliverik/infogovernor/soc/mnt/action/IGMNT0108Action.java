/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.mnt.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;

/**
 * ����: flash��תҳ
 * ��������: flash��תҳ
 * ������¼: 2012/05/17
 * �޸ļ�¼: 
 */
public class IGMNT0108Action extends BaseAction{

	static Log log = LogFactory.getLog(IGMNT0107Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm arg1,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		log.debug("=============��ʾDMXRealTime��ʼ=============");
		//����ת��
		//req.getRequestDispatcher("mnt/IGMNT0108.jsp").forward(req, resp);
		log.debug("=============��ʾDMXRealTime����=============");
		return mapping.findForward("DISP");
	}

}
