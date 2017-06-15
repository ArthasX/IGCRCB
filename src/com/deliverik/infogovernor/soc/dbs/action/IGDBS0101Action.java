/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.dbs.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.dbs.bl.IGDBS01BL;
import com.deliverik.infogovernor.soc.dbs.dto.IGDBS01DTO;

/**
 * @����SOC EMC��ά����洢����ƽ̨��ҳaction
 * @�������� 1. ��IOPS/������
 *			2. ��������Ϣ
 *			3. ���д���ʡ�����������
 *			4. ��IOPS/������
 *			5. ��������Ϣ
 * 			6. �Ҷ�д���ʡ�����������
 *			7. ҵ���������       
 *			8. ����KPI(��ɾ��)
 *			9. ��ά������ʾ(��ɾ��)
 *			10.�洢��ͼȫ��
 *			11.�澯��ѯ
 * @������¼��������    2010/12/09
 * @version 1.0
 */

public class IGDBS0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBS0101Action.class);
	
	/**
	 * iops������
	 */
	protected String iopsThroughput = "AD_PN1RETURN";
	
	/**
	 * ������ϸ��Ϣ
	 */
	protected String hostInfo = "AD_PN2RETURN";
	
	/**
	 * ��д������
	 */
	protected String readperWriteperHitper = "AD_PN3RETURN"; 
	
	/**
	 * iops������
	 */
	protected String iopsThroughput2 = "AD_PN4RETURN";
	
	/**
	 * ������ϸ��Ϣ
	 */
	protected String hostInfo2 = "AD_PN5RETURN";
	
	/**
	 * ��д������
	 */
	protected String readperWriteperHitper2 = "AD_PN6RETURN"; 
	
	/**
	 * ҵ������
	 */
	protected String businessRus = "AD_PN7RETURN";
	
//	/**
//	 * ����KPI
//	 */
//	protected String processKPI = "AD_PN8RETURN";
//	/**
//	 * ��ά����
//	 */
//	protected String operationManagement = "AD_PN9RETURN";
	/**
	 * ��ô洢��ͼall
	 */	
	protected String getpieall ="AD_PN10RETURN";
	/**
	 * ��ø澯list
	 */
	protected String getwarninglist ="AD_PN11RETURN";
	
	
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDBS01BL ctlBL = (IGDBS01BL) getBean("igDBS01BL");
		
		//������ת�趨
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========����EMC��ά����洢����ƽ̨������ʾ����ʼ========");
			Locale currentLocale = (Locale)req.getSession().getAttribute(Globals.LOCALE_KEY);  
			IGDBS01DTO dto = new IGDBS01DTO();
			if("en".equals(currentLocale.getLanguage())){
				dto.setLanguage("en");
			}		
			dto = ctlBL.getBusinessRus(dto);
    		req.setAttribute(businessRus, dto.getBusinessRus());                 //ҵ������
			//��ȡUser��Ϣ
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
    		//dto = ctlBL.getOperationManagement(dto);
    		//req.setAttribute(operationManagement, dto.getOperationManagement()); //��ά����
    		
    		//dto = ctlBL.getProcessKPI(dto);
    		//req.setAttribute(processKPI, dto.getProcessKPI()); //����KPI
    		
    		String host1 = (String)req.getSession().getAttribute(user.getUserid()+"host1");
    		String type1 = (String)req.getSession().getAttribute(user.getUserid()+"type1");
    		dto.setSymmid(host1);
    		dto.setHostchoose(type1);
    		
    		ctlBL.getIOPSandThroughput1(dto);
    		req.setAttribute(this.iopsThroughput, dto.getIopsThroughput()); //IOPS������
    		//�ж��Ƿ���CX���͵Ĵ洢
    		if(StringUtils.isNotEmpty(dto.getSymm_type())){
    			if("CX".equalsIgnoreCase(dto.getSymm_type())){
    				ctlBL.getIOPSandThroughputCX(dto);
    			}else{
    				ctlBL.getReadperWriteperHitper1(dto);
    			}
    		}else{
    			ctlBL.getReadperWriteperHitper1(dto);
    		}
    		req.setAttribute(readperWriteperHitper, dto.getReadperWriteperHitper());//��д������
    		
    		
    		ctlBL.getHostInfo1(dto);
    		req.setAttribute(this.hostInfo, dto.getHostInfo());//����������
    		
    		String host2 = (String)req.getSession().getAttribute(user.getUserid()+"host2");
    		String type2 = (String)req.getSession().getAttribute(user.getUserid()+"type2");
    		dto.setSymmid(host2);
    		dto.setHostchoose(type2);
    		
    		ctlBL.getIOPSandThroughput2(dto);
    		req.setAttribute(this.iopsThroughput2, dto.getIopsThroughput()); //IOPS������2
    		
    		ctlBL.getReadperWriteperHitper2(dto);
    		req.setAttribute(this.readperWriteperHitper2, dto.getReadperWriteperHitper());//��д������2
    		
    		ctlBL.getHostInfo2(dto);
    		req.setAttribute(this.hostInfo2, dto.getHostInfo());//����������2
    		
    		//20120716 add ����
    		ctlBL.getPieAll(dto);
    		req.setAttribute(this.getpieall, dto.getPieall());
    		
    		ctlBL.getWarningList(dto);
    		req.setAttribute(this.getwarninglist, dto.getWarninglist());
    		//20120716 add ����
    		
			log.debug("========����EMC��ά����洢����ƽ̨������ʾ��������========");
			
//			if("en".equals(currentLocale.getLanguage())){
//				return mapping.findForward("DISP_EN");
//			}
			return mapping.findForward("DISP");//20120718��DISP_ENΪDISP ��flash�Ѿ����ʻ�
		}
		return mapping.findForward(forward);
	}

	public static void main(String[] args) {
//		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy/MM/dd HH:mm");
//		Date d = new Date();    
//		String lastdate = sdfTime.format(d);	
//		String nowdate = sdfTime.format(new Date(d.getTime()-1*60*60*1000));
//		System.out.println(lastdate);
//		System.out.println(nowdate);
//		System.out.println(d.getHours());
//		//System.out.println(df.format(date.getTime()-8*60*60*1000,""));
//		String date1="2010/01/23 12:30";
//		System.out.println(sdfTime.format(new Date(date1)));
	}
}
