/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.wkm.action;

import java.util.Calendar;
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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;
import com.deliverik.infogovernor.wkm.bl.IGWKM01BL;
import com.deliverik.infogovernor.wkm.dto.IGWKM01DTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0102Form;
import com.deliverik.infogovernor.wkm.vo.IGWKM01011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_工作管理_个人工作查询ACTION
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

public class IGWKM0102Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGWKM0102Action.class);
	
	/**
	 * <p>
	 * Description: 个人工作action处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author sunkaiyu@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGWKM0102Form form = (IGWKM0102Form)actionForm;
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//工作查询
		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			
			log.debug("========变更查询处理开始========");
			
			//获取BL接口实例
			IGWKM01BL ctlBL = (IGWKM01BL) getBean("igwkm01BL");
			//实例化DTO
			IGWKM01DTO dto = new IGWKM01DTO();
			
			dto.setUser(user);
			form.setIsWork(1);
			String[] prTypeArray = {IGPROCESSType.WORK_PRTYPE,IGPROCESSType.NEW_WORK_PRTYPE_1,IGPROCESSType.NEW_WORK_PRTYPE_2,IGPROCESSType.SELF_DEFINING_WORK_PRTYPE};
			form.setPrTypeArray(prTypeArray);
			if(StringUtils.isNotEmpty(form.getPropentime())){
		        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(
		                "yyyy/MM/dd");
		        Calendar c = Calendar.getInstance();
		        c.set(Calendar.DATE, 1);
		        form.setPropentime(df.format(c.getTime()));
		        form.setPrclosetime(IGStringUtils.getCurrentDateTime());
			}
			//获取分页Bean
			getPaginDTO(request,"IGSVC0401");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGWKM0102Form) request.getSession().getAttribute("IGWKM0102Form");
				if ( form == null ) {
					form = new IGWKM0102Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGWKM0102Form) request.getSession().getAttribute("IGWKM0102Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGSVC0401");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			form.setUserid_q(user.getUserid());
			dto.setPrSearchCond(form);
			//调用BL查询
			dto = ctlBL.getProcessRecords(dto);
			//构造VO
			IGWKM01011VO vo = new IGWKM01011VO(dto.getProcessList());
			vo.setNameURLMap(dto.getNameURLMap());
			super.<IGWKM01011VO>setVO(request, vo);
			request.setAttribute("vo", vo);
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			log.debug("========变更查询处理终了========");
		}
		return mapping.findForward("DISP");
	}
}
