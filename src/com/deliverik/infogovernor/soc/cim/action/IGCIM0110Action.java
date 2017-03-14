/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0110Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01101VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 配置原数据显示action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCIM0110Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGCIM0110Action.class);
		//BL取得
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		//实例化dto
		IGCIM01DTO dto = new IGCIM01DTO();
		//form取得
		IGCIM0110Form form = (IGCIM0110Form) actionForm;
		
		String otherFlag ="";
		//dto参数设定
		dto.setIgcim0110Form(form);
		//页面初始化显示操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("=============配置原数据显示页面初始化操作开始==============");
			//判断是否为第一次访问
			if(StringUtils.isNotEmpty(form.getFirstAccess())){
				otherFlag = form.getFirstAccess();
				form.reset(mapping, request);
			}
			//初始化版本信息
			dto = ctlBL.getRciVersionsAction(dto);
			//当前最新版本信息取得
			dto = ctlBL.getCurrentNewCriVersionAction(dto);
			//取得采集结果
			dto = ctlBL.getCR01InfoList(dto);
			log.debug("=============配置原数据显示页面初始化操作结束==============");
		}
		//显示对应版本信息操作
		if("HISTORY".equals(mapping.getParameter())){
			log.debug("===============对应版本信息显示操作开始================");
			//初始化版本信息
			dto = ctlBL.getRciVersionsAction(dto);
			//历史版本信息取得
			dto = ctlBL.getHostoryVersions(dto);
			//取得采集结果
			dto = ctlBL.getCR01InfoList(dto);
			log.debug("===============对应版本信息显示操作结束================");
		}
		//实例化vo
		IGCIM01101VO vo = new IGCIM01101VO();
		vo.setCr03VWList(dto.getCr03VWList());
//		vo.setEntityItem(dto.getEntityItem());
		vo.setHost(form.getHost());
//		vo.setCr03(dto.getCr03());
		vo.setCr03VW(dto.getCr03VW());
		vo.setCr01List(dto.getCr01List());
		vo.setShowFlag(dto.getShowFlag());
		vo.setOtherFlag(otherFlag);
		super.<IGCIM01101VO>setVO(request, vo);
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
