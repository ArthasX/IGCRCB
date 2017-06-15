/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.action;

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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR12BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR12DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1202Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR12021VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 资源使用情况展示Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1202Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGVIR1202Action.class);
		//BL取得
		IGVIR12BL ctlBL = (IGVIR12BL) getBean("igvir12BL");
		//实例化dto
		IGVIR12DTO dto = new IGVIR12DTO();
		//form取得
		IGVIR1202Form form = (IGVIR1202Form) actionForm;
		//dto参数设定
		dto.setVcid(form.getVcid());
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("==============资源使用情况展示页面初始化操作开始==============");
			//查询vcenter连接信息
			dto = ctlBL.initIGVIR1202Action(dto);
			//实例化vo
			IGVIR12021VO vo = new IGVIR12021VO();
			vo.setVcid(dto.getVcid());
			vo.setVim01List(dto.getVim01List());
			vo.setHostList(dto.getHostList());
			super.<IGVIR12021VO>setVO(request, vo);
			log.debug("==============资源使用情况展示页面初始化操作结束==============");
		}
		
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("=============指定vCenter中Host资源使用情况查询操作开始============");
			dto = ctlBL.searchHostUsedAction(dto);
			//实例化vo
			IGVIR12021VO vo = new IGVIR12021VO();
			vo.setVcid(dto.getVcid());
			vo.setVim01List(dto.getVim01List());
			vo.setHostList(dto.getHostList());
			super.<IGVIR12021VO>setVO(request, vo);
			log.debug("=============指定vCenter中Host资源使用情况查询操作结束============");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
