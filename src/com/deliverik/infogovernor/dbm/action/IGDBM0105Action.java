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
import com.deliverik.infogovernor.dbm.bl.IGDBM05BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM05DTO;

/**
 * ��          ��:  ���������ۺϷ���DashBoard ����Action
 * ����������  1.����������������ռ�Ȳ�ѯ
 *           2.����ƽ�����ʱ�����Ʋ�ѯ
 *           3.������������
 *           4.���⼰ʱ���������
 * ������¼���Կ�    2010/11/26
 * �޸ļ�¼��n/a
 */

public class IGDBM0105Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0104Action.class);
	final String pieValue = "AD_PN1RETURN"; /*��������ռ��*/
	final String problemLineForAvg= "AD_PN2RETURN";/*����ƽ�����ʱ�䷵��ֵ*/
	final String problemLineForCount= "AD_PN3RETURN";/*�����������Ʒ���ֵ*/
	final String problemLineForSolve= "AD_PN4RETURN";/*���⼰ʱ����ʷ���ֵ*/
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDBM05BL ctlBL = (IGDBM05BL) getBean("igDBM05BL");
		
		//������ת�趨
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========���������ۺϷ������������ʾ����ʼ========");
			Calendar  c=new  GregorianCalendar();//�½����ڶ���  
			int  year=c.get(Calendar.YEAR);//��ȡ���  
			int  month=c.get(Calendar.MONTH);//��ȡ�·�  

			IGDBM05DTO dto = new IGDBM05DTO();
			dto.setTypeValue("type");
			dto.setYearValue(String.valueOf(year));
			dto.setPn1Value(String.valueOf(month));
			dto.setPn2Value("�豸����");
			dto.setPn3Value("�豸����");
			dto.setPn4Value("�豸����");
			dto = ctlBL.getProcessProblemAllMode(dto);
    		req.getSession().setAttribute(pieValue, dto.getPieValue());   //������������ռ��ֵ
    		req.getSession().setAttribute(problemLineForAvg, dto.getProblemLineForAvg()); //��������ƽ�����ʱ�䷵��ֵ
    		req.getSession().setAttribute(problemLineForCount, dto.getProblemLineForCount()); //���������������Ʒ���ֵ
    		req.getSession().setAttribute(problemLineForSolve, dto.getProblemLineForSolve()); //�������⼰ʱ����ʷ���ֵ
			log.debug("========���������ۺϷ��������������ʾ��������========");
			return mapping.findForward("DISP");
		}
		return mapping.findForward(forward);
	}
}
