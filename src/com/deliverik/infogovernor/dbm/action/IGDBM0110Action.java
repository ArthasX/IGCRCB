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
import com.deliverik.infogovernor.dbm.bl.IGDBM10BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM10DTO;

/**
 * @����������������ҵ��ʵʱ�����ҳaction
 * @�������� 1.����ҵ��ʵʱ���         
 *			2.db2��Ϣ        
 *			3.���������HCAMP״̬         
 *			4.cpuռ����TOP5
 *			5.Omnibus�¼�����
 * @������¼��������    2010/12/01
 * @version 1.0
 */

public class IGDBM0110Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0110Action.class);
	
	/**
	 * ����ҵ��ʵʱ����
	 */
	protected String channelsBusinessRealtime = "AD_PN1RETURN";
	
	/**
	 * db2��Ϣ����
	 */
	protected String db2Information = "AD_PN2RETURN";
	
	/**
	 * ���������HCAMP״ֵ̬
	 */
	protected String backupAndHCAMPType = "AD_PN3RETURN";
	
	/**
	 * cpuռ����TOP5ֵ
	 */
	protected String cpuOccupancyrateTOP5 = "AD_PN4RETURN";
	
	/**
	 * Omnibus�¼�����ֵ
	 */
	protected String omnibusEventWarning = "AD_PN5RETURN";
	
	/**
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDBM10BL ctlBL = (IGDBM10BL) getBean("igDBM10BL");
		
		//������ת�趨
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��������ҵ��ʵʱ������������ʾ����ʼ========");
			
			IGDBM10DTO dto = new IGDBM10DTO();
			
			dto = ctlBL.getChannelsBusinessRealtime(dto);
    		req.getSession().setAttribute(channelsBusinessRealtime, dto.getChannelsBusinessRealtime());   //��������ҵ��ʵʱ���
    		dto = ctlBL.getDB2Information(dto);
    		req.getSession().setAttribute(db2Information, dto.getDb2Information()); //db2��Ϣ����
    		dto = ctlBL.getBackupAndHCAMPType(dto);
    		req.getSession().setAttribute(backupAndHCAMPType, dto.getBackupAndHCAMPType()); //���������HCAMP״ֵ̬
    		dto = ctlBL.getCPUOccupancyrateTOP5(dto);
    		req.getSession().setAttribute(cpuOccupancyrateTOP5, dto.getCpuOccupancyrateTOP5()); //cpuռ����TOP5ֵ
    		dto = ctlBL.getOmnibusEventWarning(dto);
    		req.getSession().setAttribute(omnibusEventWarning, dto.getOmnibusEventWarning()); //Omnibus�¼�����ֵ
    		
			log.debug("========��������ҵ��ʵʱ������������ʾ��������========");
			return mapping.findForward("DISP");
		}
		return mapping.findForward(forward);
	}
}
