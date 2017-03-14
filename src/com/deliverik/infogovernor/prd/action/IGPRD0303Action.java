/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.infogovernor.prd.bl.IGPRD03BL;
import com.deliverik.infogovernor.prd.dto.IGPRD03DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0302Form;
import com.deliverik.infogovernor.prd.form.IGPRD0303Form;
import com.deliverik.infogovernor.prd.vo.IGPRD03031VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程组关联流程保存Action
 * </p>
 * 
 * @version 1.0
 */
public class IGPRD0303Action extends BaseAction{

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGPRD0303Action.class);
		//BL取得
		IGPRD03BL ctlBL = (IGPRD03BL) getBean("igprd03BL");
		//实例化dto
		IGPRD03DTO dto = new IGPRD03DTO();
		//form取得
		IGPRD0303Form form = (IGPRD0303Form) actionForm;
		//dto参数设定
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.info("流程组成员编辑初始化开始");
			if(StringUtils.isEmpty(form.getPgdid())){
				form.setPgdid(((IGPRD0302Form)req.getAttribute("IGPRD0302Form")).getPgdid());
			}
			dto.setIgprd0303Form(form);
			ctlBL.initPGDRelition(dto);
			IGPRD03031VO vo = new IGPRD03031VO();
			vo.setInnerPds(dto.getInnerPds());
			vo.setOuterPds(dto.getOuterPds());
			vo.setProcessGroupDefinition(dto.getProcessGroupDefinition());
			super.<IGPRD03031VO>setVO(req, vo);
			log.info("流程组成员编辑初始化结束");
		}
		if("ADD".equals(mapping.getParameter())){
			log.info("流程组添加成员开始");
			dto.setIgprd0303Form(form);
			ctlBL.addMember(dto);
			log.info("流程组添加成员结束");
		}
		if("DEL".equals(mapping.getParameter())){
			log.info("删除流程组内成员开始");
			dto.setIgprd0303Form(form);
			ctlBL.delMember(dto);
			log.info("删除流程组内成员结束");
		}
		
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}

}