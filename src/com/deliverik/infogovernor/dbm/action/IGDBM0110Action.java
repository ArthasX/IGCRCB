/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * @概述锦州银行渠道业务实时情况首页action
 * @功能描述 1.渠道业务实时情况         
 *			2.db2信息        
 *			3.备份情况及HCAMP状态         
 *			4.cpu占用率TOP5
 *			5.Omnibus事件警告
 * @创建记录：李旭峙    2010/12/01
 * @version 1.0
 */

public class IGDBM0110Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM0110Action.class);
	
	/**
	 * 渠道业务实时数据
	 */
	protected String channelsBusinessRealtime = "AD_PN1RETURN";
	
	/**
	 * db2信息数据
	 */
	protected String db2Information = "AD_PN2RETURN";
	
	/**
	 * 备份情况及HCAMP状态值
	 */
	protected String backupAndHCAMPType = "AD_PN3RETURN";
	
	/**
	 * cpu占用率TOP5值
	 */
	protected String cpuOccupancyrateTOP5 = "AD_PN4RETURN";
	
	/**
	 * Omnibus事件警告值
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
		
		//画面跳转设定
		String forward = "DISP";
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========设置渠道业务实时情况画面初期显示处理开始========");
			
			IGDBM10DTO dto = new IGDBM10DTO();
			
			dto = ctlBL.getChannelsBusinessRealtime(dto);
    		req.getSession().setAttribute(channelsBusinessRealtime, dto.getChannelsBusinessRealtime());   //设置渠道业务实时情况
    		dto = ctlBL.getDB2Information(dto);
    		req.getSession().setAttribute(db2Information, dto.getDb2Information()); //db2信息数据
    		dto = ctlBL.getBackupAndHCAMPType(dto);
    		req.getSession().setAttribute(backupAndHCAMPType, dto.getBackupAndHCAMPType()); //备份情况及HCAMP状态值
    		dto = ctlBL.getCPUOccupancyrateTOP5(dto);
    		req.getSession().setAttribute(cpuOccupancyrateTOP5, dto.getCpuOccupancyrateTOP5()); //cpu占用率TOP5值
    		dto = ctlBL.getOmnibusEventWarning(dto);
    		req.getSession().setAttribute(omnibusEventWarning, dto.getOmnibusEventWarning()); //Omnibus事件警告值
    		
			log.debug("========设置渠道业务实时情况画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		return mapping.findForward(forward);
	}
}
