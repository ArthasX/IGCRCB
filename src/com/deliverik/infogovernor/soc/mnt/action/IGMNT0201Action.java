/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
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
 * ����:������תAction
 * ����������1.������ת
 * ������¼�����    2012/02/09
 */
public class IGMNT0201Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGMNT0201Action.class);

	/**
	 * ������ת
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
		String forward=null;
		if("DISP".equals(mapping.getParameter())){
			if (req.getParameter("btn_back")!=null) {
				log.debug("========������ת��ʼ========");
				String flag = String.valueOf(req.getSession().getAttribute("flag"));
				if("0".equals(flag)){//������͹�����
					forward="BACK0";
				}else{//��ض��������
					forward="BACK1";
				}
				log.debug("========������ת����========");
			}
			if (req.getParameter("btn_add")!=null) {
				//��ض�����ӻ�����ת
				log.debug("========��ض�����ӻ�����ת��ʼ========");
				forward="ADD";
				log.debug("========��ض�����ӻ�����ת����========");
			}
		}		
		return mapping.findForward(forward);
	}
}
