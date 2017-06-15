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
import com.deliverik.infogovernor.dbm.bl.IGDBM01BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM01DTO;

/**
 * ��          ��:  ��������DashBoard ����Action
 * ���������� 1.�¼�����������
 *           2.�����¼���������������
 *           3.����ͳ��
 *           4.����¼�������ƽ�������������
 *           5.������������������
 *           6.��ȱ���������ɹ���
 *           7.��ͼ
 *           8.��ע����
 *           ����ȫ��ɾ���ˡ�
 *           
 * ������¼���κ��� 2010/10/26
 * �޸ļ�¼��Xudong Wang 2012/11/22
 */
public class IGDBM0103Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0103Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDBM01BL ctlBL = (IGDBM01BL) getBean("igDBM01BL");
		IGDBM01DTO dto = new IGDBM01DTO();
		
		//������ת�趨
		String forward = "DISP";

		if( "DISP".equals(mapping.getParameter())){
			//���̶���Ǽǻ��������ʾ����
			log.debug("========�г���ҳ���������ʾ����ʼ========");
			dto=ctlBL.setITChart(dto);
			req.setAttribute("IICHART", dto.getResultXML());
//			
			log.debug("========�г���ҳ���������ʾ��������========");
			
			return mapping.findForward("DISP");
		}
		
		

		return mapping.findForward(forward);
	}
}
