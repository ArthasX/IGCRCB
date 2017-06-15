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
import com.deliverik.infogovernor.dbm.bl.IGDBM07BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM07DTO;

/**
 * ��          ��:  ��������ۺϷ���DashBoard ����Action
 * ����������  1.�±������������ռ�Ȳ�ѯ
 *           2.���ƽ�����ʱ�����Ʋ�ѯ
 *           3.�����������
 *           4.�����ʱ���������
 * ������¼���Կ�    2010/11/26
 * �޸ļ�¼��n/a
 */

public class IGDBM0107Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0104Action.class);
	final String pieValue = "AD_PN1RETURN"; /*�������ռ��*/
	final String changeLineForAvg= "AD_PN2RETURN";/*���ƽ�����ʱ�䷵��ֵ*/
	final String changeLineForCount= "AD_PN3RETURN";/*����������Ʒ���ֵ*/
	final String changeLineForSolve= "AD_PN4RETURN";/*�����ʱ����ʷ���ֵ*/
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDBM07BL ctlBL = (IGDBM07BL) getBean("igDBM07BL");
		
		//������ת�趨
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��������ۺϷ������������ʾ����ʼ========");
			Calendar  c=new  GregorianCalendar();//�½����ڶ���  
			int  year=c.get(Calendar.YEAR);//��ȡ���  
			int  month=c.get(Calendar.MONTH);//��ȡ�·�  

			IGDBM07DTO dto = new IGDBM07DTO();
			dto.setTypeValue("type");
			dto.setYearValue(String.valueOf(year));
			dto.setPn1Value(String.valueOf(month));
			dto.setPn2Value("��ͨ���");
			dto.setPn3Value("��ͨ���");
			dto.setPn4Value("��ͨ���");
			dto = ctlBL.getProcessChangeAllMode(dto);
    		req.getSession().setAttribute(pieValue, dto.getPieValue());   //���ñ������ռ��ֵ
    		req.getSession().setAttribute(changeLineForAvg, dto.getChangeLineForAvg()); //���ñ��ƽ�����ʱ�䷵��ֵ
    		req.getSession().setAttribute(changeLineForCount, dto.getChangeLineForCount()); //���ñ���������Ʒ���ֵ
    		req.getSession().setAttribute(changeLineForSolve, dto.getChangeLineForSolve()); //���ñ����ʱ����ʷ���ֵ
			log.debug("========��������ۺϷ��������������ʾ��������========");
			return mapping.findForward("DISP");
		}
		return mapping.findForward(forward);
	}
}
