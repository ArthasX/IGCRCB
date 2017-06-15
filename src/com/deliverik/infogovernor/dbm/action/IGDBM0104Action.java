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
import com.deliverik.infogovernor.dbm.bl.IGDBM04BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM04DTO;

/**
 * ��          ��:  ������ʩDashBoard ����Action
 * ���������� 1.�Ĵ�����ʹ����
 *           2.�Ĵ�������������������
 *           3.�Ĵ��������ݿ����м��ʹ����
 *           4.���Ĵ洢��������������
 *           5.����¼������������
 * ������¼�������� 2010/10/26
 * �޸ļ�¼��n/a
 */
public class IGDBM0104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0104Action.class);

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
		IGDBM04BL ctlBL = (IGDBM04BL) getBean("igDBM04BL");
		IGDBM04DTO dto = new IGDBM04DTO();
		
		//������ת�趨
		String forward = "DISP";

		if( "DISP".equals(mapping.getParameter())){
			
			log.debug("========������ʩ�����������ʾ����ʼ========");
			//���պ���ϵͳ����CPU/�ڴ�������xml
			ctlBL.setKernelUseAvg(dto);
			//����ǰ��ϵͳ����CPU/�ڴ�������xml
			ctlBL.setPrefixUseAvg(dto);
			//�����м�ҵ������CPU/�ڴ�������xml
			ctlBL.setMiddleOperationUseAvg(dto);
			//���ɵ�����������CPU/�ڴ�������xml
			ctlBL.setNetbankUseAvg(dto);
			
			//˫ɫ��
			dto = ctlBL.getDoubleColorLine(dto);
			req.setAttribute("dcl", dto.getResultXML());
			
			req.setAttribute("jsptype", req.getParameter("type"));
			
			log.debug("========������ʩ�����������ʾ��������========");
			
			return mapping.findForward("DISP");
		}
		
		

		return mapping.findForward(forward);
	}
}
