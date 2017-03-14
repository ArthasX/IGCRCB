/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM17BL;
import com.deliverik.infogovernor.drm.dto.IGDRM17DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1702Form;
import com.deliverik.infogovernor.drm.vo.IGDRM17021VO;

/**
 * <p>
 * Title : InfoGovernor 模块名称
 * </p>
 * <p>
 * Description:培训记录新增Action
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
public class IGDRM1702Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//日志对象取得 
		Log log = LogFactory.getLog(IGDRM1702Action.class);
		//BL取得
		IGDRM17BL ctlBL = (IGDRM17BL) getBean("igdrm17BL");
		//实例化DTO
		IGDRM17DTO dto = new IGDRM17DTO();
		//form取得
		IGDRM1702Form form = (IGDRM1702Form) actionForm;
		//dto参数设定
		dto.setForm(actionForm);
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("===============培训记录新增操作开始==================");
			dto = ctlBL.initTrainRecordAction(dto);
			//实例化vo
			IGDRM17021VO vo = new IGDRM17021VO();
			vo.setAttachmentList(dto.getAttList());
			vo.setTrainparticipantList(dto.getTrainparticipantList());
			super.setVO(request, vo);
			saveToken(request);
			log.debug("===============培训记录新增操作结束==================");
		}
		//新增操作
		if("CHANGE".equals(mapping.getParameter())){
			if (isTokenValid(request, true)){
				if(form.getTrid() != null && form.getTrid() > 0){
					log.debug("=============培训记录修改操作开始=================");
					dto = ctlBL.changeTrainRecordAction(dto);
					log.debug("=============培训记录修改操作结束=================");
				}else{
					log.debug("=============培训记录新增操作开始=================");
					dto = ctlBL.insertTrainRecordAction(dto);
					log.debug("=============培训记录新增操作结束=================");
				}
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		
		if(StringUtils.isNotEmpty(request.getParameter("backUrl"))){
			request.setAttribute("backUrl", request.getParameter("backUrl"));
			return mapping.findForward("DETAIL");
		}else{
			return mapping.findForward("DISP");
		}
		
	}

}
