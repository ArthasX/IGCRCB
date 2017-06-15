/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0111Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01111VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 配置源数据比较版本action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCIM0111Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGCIM0111Action.class);
		//bl取得
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		//dto实例化
		IGCIM01DTO dto = new IGCIM01DTO();
		//form取得
		IGCIM0111Form form = (IGCIM0111Form) actionForm;
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("==========配置源数据比较版本操作开始===========");
			//dto参数设定
			dto.setIgcim0111Form(form);
			//调用BL查询要比较的两个版本信息
			dto = ctlBL.compareVersionsAction(dto);
			//实例化vo
			IGCIM01111VO vo = new IGCIM01111VO(dto.getCompareVersionsMap());
//			vo.setEntityItem(dto.getEntityItem());
			vo.setHost(form.getHost());
			super.<IGCIM01111VO>setVO(request, vo);
			log.debug("==========配置源数据比较版本操作结束===========");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
