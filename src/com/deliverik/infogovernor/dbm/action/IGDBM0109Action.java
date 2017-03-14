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
import com.deliverik.infogovernor.dbm.bl.IGDBM09BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM09DTO;

/**
 * ��          ��:  ϵͳ�����ʷ���DashBoard ����Action
 * ����������  1.��ǰʵ�ʿ�����         
 *			2.ʵ�ʿ�����ȫ���ۼ�        
 *			3.�������������         
 *			4.������ʱ���������
 * ������¼��������    2010/12/01
 * �޸ļ�¼��n/a
 */

public class IGDBM0109Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0109Action.class);
	final String currentActualAvailability = "AD_PN1RETURN"; /*��ǰʵ�ʿ�����*/
	final String yearActualAvailability= "AD_PN2RETURN";/*ʵ�ʿ�����ȫ���ۼ�*/
	final String availabilityYearTrends= "AD_PN3RETURN";/*�������������*/
	final String workTimelySolutionlyTrends= "AD_PN4RETURN";/*������ʱ���������*/
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDBM09BL ctlBL = (IGDBM09BL) getBean("igDBM09BL");
		
		//������ת�趨
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========ϵͳ�����ʷ������������ʾ����ʼ========");
			
			IGDBM09DTO dto = new IGDBM09DTO();
			dto.setSelectSystemId("link1");//Ĭ��ѡ���һ��ϵͳID
			
			dto = ctlBL.getCurrentActualAvailability(dto);
    		req.getSession().setAttribute(currentActualAvailability, dto.getCurrentActualAvailability());   //���õ�ǰʵ�ʿ�����
    		dto = ctlBL.getYearActualAvailability(dto);
    		req.getSession().setAttribute(yearActualAvailability, dto.getYearActualAvailability()); //����ʵ�ʿ�����ȫ���ۼ�
    		dto = ctlBL.getAvailabilityYearTrends(dto);
    		req.getSession().setAttribute(availabilityYearTrends, dto.getAvailabilityYearTrends()); //���ÿ������������
    		dto = ctlBL.getWorkTimelySolutionlyTrends(dto);
    		req.getSession().setAttribute(workTimelySolutionlyTrends, dto.getWorkTimelySolutionlyTrends()); //���ù�����ʱ���������
			log.debug("========ϵͳ�����ʷ��������������ʾ��������========");
			return mapping.findForward("DISP");
		}
		return mapping.findForward(forward);
	}
}
