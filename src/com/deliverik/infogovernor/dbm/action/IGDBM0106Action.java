/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.dbm.action;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.dbm.bl.IGDBM06BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM06DTO;

/**
 * ��          ��:  �¼������ۺϷ���DashBoard ����Action
 * ����������  1.���¼�����������ռ�Ȳ�ѯ
 *           2.�¼�ƽ�����ʱ�����Ʋ�ѯ
 *           3.�¼���������
 *           4.�¼���ʱ���������
 * ������¼���Կ�    2010/11/30
 * �޸ļ�¼��n/a
 */

public class IGDBM0106Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0104Action.class);
	final String pieValue = "AD_PN1RETURN"; /*�¼�����ռ��*/
	final String incidentLineForAvg= "AD_PN2RETURN";/*�¼�ƽ�����ʱ�䷵��ֵ*/
	final String incidentLineForCount= "AD_PN3RETURN";/*�¼��������Ʒ���ֵ*/
	final String incidentLineForSolve= "AD_PN4RETURN";/*�¼���ʱ����ʷ���ֵ*/
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDBM06BL ctlBL = (IGDBM06BL) getBean("igDBM06BL");
		
		//������ת�趨
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�¼������ۺϷ������������ʾ����ʼ========");
			Calendar  c=new  GregorianCalendar();//�½����ڶ���  
			int  year=c.get(Calendar.YEAR);//��ȡ���  
			int  month=c.get(Calendar.MONTH);//��ȡ�·�  

			IGDBM06DTO dto = new IGDBM06DTO();
			dto.setTypeValue("type");
			dto.setYearValue(String.valueOf(year));
			dto.setPn1Value(String.valueOf(month));
			dto.setPn2Value("ҵ�����");
			dto.setPn3Value("ҵ�����");
			dto.setPn4Value("ҵ�����");
			dto = ctlBL.getProcessIncidentAllMode(dto);
    		req.getSession().setAttribute(pieValue, dto.getPieValue());   //�����¼�����ռ��ֵ
    		req.getSession().setAttribute(incidentLineForAvg, dto.getIncidentLineForAvg()); //�����¼�ƽ�����ʱ�䷵��ֵ
    		req.getSession().setAttribute(incidentLineForCount, dto.getIncidentLineForCount()); //�����¼��������Ʒ���ֵ
    		req.getSession().setAttribute(incidentLineForSolve, dto.getIncidentLineForSolve()); //�����¼���ʱ����ʷ���ֵ
			log.debug("========�¼������ۺϷ��������������ʾ��������========");
			return mapping.findForward("DISP");
		}
		return mapping.findForward(forward);
	}
}
