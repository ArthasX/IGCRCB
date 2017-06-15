/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.dbm.bl.IGDBM01BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM01DTO;

/**
 * ��          ��:  �г���ҳDashBoard ����Action
 * ���������� 1.���ط��п���Ƿ�
 *           2.������
 *           3.������ATM��POS�ɹ����Ǳ���
 *           4.������ATM��POS�ɹ�����ͼ
 *           5.��ǰ����ͳ��
 *           6.����ƻ���ѯ
 *           7.IT��Ӫ����
 * ������¼�������� 2010/10/26
 * �޸ļ�¼��n/a
 */
public class IGDBM0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0101Action.class);

	/**
	 * 
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		//BLȡ��
		IGDBM01BL ctlBL = (IGDBM01BL) getBean("igDBM01BL");
		
		//DTO����
		IGDBM01DTO dto = new IGDBM01DTO();
		dto.setUser(user);
		
		//������ת�趨
		String forward = "DISP";

		if( "DISP".equals(mapping.getParameter())){
			//�г���ҳ���������ʾ����
			log.debug("========���̶���Ǽǻ��������ʾ����ʼ========");
			
			dto = ctlBL.setITChart(dto);
			
			req.setAttribute("chart", dto.getResultXML());
			req.setAttribute("jsptype", req.getParameter("type"));
			
			log.debug("========���̶���Ǽǻ��������ʾ��������========");
			
			return mapping.findForward("DISP");
		}
		
		

		return mapping.findForward(forward);
	}
}
