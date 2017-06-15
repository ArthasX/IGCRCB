/* 北京递蓝科软件技术有限公司版权所有，保留所有权利。*/

package com.deliverik.plugin.PluginMgr.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.plugin.PluginMgr.bl.IGPluginMgrBLImpl;
import com.deliverik.plugin.PluginMgr.dto.IGPluginDTO;
import com.deliverik.plugin.PluginMgr.vo.IGPluginMgrVO;

/**
 * 概述: 告警信息管理页面Action处理
 * 功能描述: 告警信息管理页面Action处理
 * 创建记录: 2012/10/12
 * 修改记录: 
 */
public class IGPluginMgrAction extends BaseAction{
	static Log log=LogFactory.getLog(IGPluginMgrAction.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param request 
	 * @param response 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		IGPluginMgrBLImpl igpmbl =new IGPluginMgrBLImpl();
		IGPluginDTO dto=new IGPluginDTO();
		//查询显示
		if("DISP".equals(mapping.getParameter())){
		log.debug("========Plugin管理画面初期显示处理开始========");
			igpmbl.getPluginList(dto);
			dto.getPluginList();
			IGPluginMgrVO vo=new IGPluginMgrVO();
			vo.setPluginList(dto.getPluginList());
			super.<IGPluginMgrVO>setVO(req, vo);
			log.debug("========Plugin管理画面初期显示处理终了========");
		}
		//修改状态
		if("MODIFY".equals(mapping.getParameter())){
			log.debug("========Plugin管理状态修改处理开始========");
			dto.setPath(req.getParameter("pluginPath"));
			dto.setStatus(req.getParameter("pluginStatus"));
			dto=igpmbl.modifyPlugin(dto);
			log.debug("========Plugin管理状态修改处理终了========");
		}
		//更新数据
		if("UPDATE".equals(mapping.getParameter())){
			log.debug("========Plugin管理更新处理开始========");
			dto.setPath(req.getParameter("pluginPath"));
			dto.setStatus(req.getParameter("pluginStatus"));
			dto=igpmbl.updatePluginDataXml(dto);
			log.debug("========Plugin管理更新处理终了========");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}