package com.deliverik.infogovernor.syslog.action;


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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.syslog.bl.IGLOG002BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG0021DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0021Form;
import com.deliverik.infogovernor.syslog.vo.IGLOG0021VO;

/**
 * <p>
 * Title : InfoGovernor 日志规则管理
 * </p>
 * <p>
 * Description: 查询ACTION
 * </p>
 * 
 * @author wangrongguagn@deliverik.com
 * @version 1.0
 */
public class IGLOG0021Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGLOG0021Action.class);
	
	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param mapping
	 *            ActionMapping
	 * @param form
	 *            ActionForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//实例化DTO
		IGLOG0021DTO dto = new IGLOG0021DTO();
		
		//告警规则form取得
		IGLOG0021Form form = (IGLOG0021Form) actionForm;
		
		//实例化ctrolBL
		IGLOG002BL ctlBL = (IGLOG002BL) getBean("iglog002BL");
		
		//将form存放在dto载体中
		dto.setIgLog0021Form(form);
		
		//管理查询页
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("========告警规则管理查询开始========");
			
			getPaginDTO(request,"IGLOG0021");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGLOG0021Form) request.getSession().getAttribute("IGLOG0021Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			pDto.setPageDispCount(10);
			
			int maxCnt = getMaxDataCount("IGLOG0021");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			
			dto = ctlBL.searchDeviceTemps(dto);
			
			IGLOG0021VO vo = new IGLOG0021VO();
			vo.setDeviceTempList(dto.getDeviceTempList());
			
			super.<IGLOG0021VO> setVO(request, vo);
			
			log.debug("========告警规则管理查询结束========");
		}
		if("EDIT_DISP".equals(mapping.getParameter())){
			
			dto = ctlBL.getDevice(dto);//获取设备信息
			dto = ctlBL.getDevicesByTypeid(dto);
			dto = ctlBL.getRuleTempsByDeviceid(dto);//据设备ID获取所属规则列表
			dto = ctlBL.getRuleTempsByTypeid(dto);//通过设备类型获取改类型规则列表
			dto = ctlBL.getRelationEntityByDeviceid(dto);
			
			IGLOG0021VO vo = new IGLOG0021VO();
			vo.setMss00001TB(dto.getMss00001TB());
			vo.setDeviceList(dto.getDeviceList());
			vo.setTempList(dto.getTempList());
			vo.setTempListFromDevice(dto.getTempListFromDevice());
			vo.setTypeid(form.getTypeid());
			vo.setMss00002TB(dto.getMss00002TB());
			
			super.<IGLOG0021VO> setVO(request, vo);
		}
		if("CHANGE_STATUS".equals(mapping.getParameter())){
			log.debug("========告警规则状态修改开始========");
			dto = ctlBL.changeTempstate(dto);
			log.debug("========告警规则状态修改结束========");
		}
		if("DELETE".equals(mapping.getParameter())){
			log.debug("========告警规则删除开始========");
			dto = ctlBL.deleteAlarmRule(dto);
			log.debug("========告警规则删除结束========");
		}
		if("EDIT".equals(mapping.getParameter())){
			
			dto = ctlBL.updateDeviceAndRules(dto);
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
