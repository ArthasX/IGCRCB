/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM09BL;
import com.deliverik.infogovernor.drm.dto.IGDRM09DTO;
import com.deliverik.infogovernor.drm.vo.IGDRM09061VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 相关流程查看复合场景
 * </p>
 * 
 * @version 1.0
 */

public class IGDRM0906Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGDRM0906Action.class);
	

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		//获取BL接口实例
		IGDRM09BL ctlBL = (IGDRM09BL) getBean("igdrm09BL");
		IGDRM09DTO dto = new IGDRM09DTO();
		
		if("SEARCH".equals(mapping.getParameter())){
			
			if(request.getParameter("pgrid")!=null)
			dto.setPgrid(Integer.valueOf(request.getParameter("pgrid").toString()));
			if(request.getParameter("prid")!=null)
			dto.setPrid(Integer.valueOf(request.getParameter("prid").toString()));
			
			dto = ctlBL.getGroupSenceInfo(dto);
			
			IGDRM09061VO vo = new IGDRM09061VO();
			
			vo.setGroupProcessRecord(dto.getGroupProcessRecord());
			
			vo.setGroupProcessRecordMembers(dto.getGroupProcessRecordMembers());
			
			vo.setGroupProcessRecordXML(dto.getGroupProcessRecordXML());;
			
			vo.setProcessList(dto.getProcessList());
			
			vo.setXmlHeight(dto.getXmlHeight());
			
			vo.setNoticeList(dto.getNoticeList());
			
			super.<IGDRM09061VO>setVO(request, vo);
			
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
