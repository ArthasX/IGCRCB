/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.infogovernor.crc.bl.IGCRC04ExcelBL;
import com.deliverik.infogovernor.crc.bl.IGCRC14BL;
import com.deliverik.infogovernor.crc.dto.IGCRC04ExcelDTO;
import com.deliverik.infogovernor.crc.dto.IGCRC14DTO;
import com.deliverik.infogovernor.crc.form.IGCRC1401Form;
import com.deliverik.infogovernor.crc.model.vo.IGCRC14011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 变更批量处理查询Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCRC1401Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse response) throws Exception {
		
		IGCRC1401Form form = (IGCRC1401Form)actionForm;
		//日志对象取得
		Log log = LogFactory.getLog(IGCRC1401Action.class);
		//BL取得
		IGCRC14BL ctlBL = (IGCRC14BL) getBean("igCRC14BL");
		//实例化dto
		IGCRC14DTO dto = new IGCRC14DTO();
		//画面跳转设定
		String forward = "";
		//登录用户取得
		User user = (User) req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto参数设定
		dto.setUser(user);
		//设置form
		dto.setForm(actionForm);
		/*//判断表单查询条件是否已经存在
		if(request.getSession().getAttribute("AD_ProcessInfoQueryMap")==null){
			ctlBL.getPivarQueryInfoAction(dto);
			request.getSession().setAttribute("AD_ProcessInfoQueryMap", dto.getProcessInfoQueryMap());
		}*/
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========查询变更流程处理开始========");
			forward = "DISP";
			log.debug("========查询变更流程处理终了========");
		}else if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			getPaginDTO(req,"IGCRC1401");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//文档查询处理
			log.debug("========查询变更流程处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGCRC1401Form) req.getSession().getAttribute("IGCRC1401Form");
				if ( form== null){
					form = new IGCRC1401Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGCRC1401Form) req.getSession().getAttribute("IGCRC1401Form");
					if (form !=null) {
						form.setFromCount(0);
					}else{
						form = new IGCRC1401Form();
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCRC1401");
			dto.setForm(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//添加流程状态下拉列表
			dto = ctlBL.searchPdid7BitAction(dto);
			List<LabelValueBean> statusBeanList = new ArrayList<LabelValueBean>();
			if (dto.getIg333InfoList() != null && dto.getIg333InfoList().size() > 0) {
				List<IG333Info> statusList = dto.getIg333InfoList();
				statusBeanList.add(new LabelValueBean());
				for (int i = 0; i < statusList.size(); i++) {
					statusBeanList.add(new LabelValueBean(statusList.get(i).getPsdname(), statusList.get(i).getPsdcode()));
				}
			}
			req.setAttribute("statusBeanList", statusBeanList);
			//文档检索逻辑调用
			dto = ctlBL.searchEntityItemAction(dto);
			
			//将文档信息检索结果设定到VO中
			IGCRC14011VO vo = dto.getIgcrc14011VO();
			if(vo == null){
				vo = new IGCRC14011VO();
			}
			vo.setChangeProcessVWInfos(dto.getChangeProcessVWInfos());
			super.<IGCRC14011VO>setVO(req, vo);
			req.setAttribute("showFlag", form.getShowFlag());
			forward = "SUCCESS";	
			log.debug("========查询变更流程处理终了========");
		}else if("EXCEL".equals(mapping.getParameter())){
			int maxCnt = getMaxDataCount("IGCRC1401");
			//获取翻页DTO
			PagingDTO pDto = getPaginDTO(req, "IGCRC1401");
			//修改翻页DTO,查询全部存量数据
			pDto.setFromCount(0);
			pDto.setPageDispCount(maxCnt);
			
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto = ctlBL.searchEntityItemAction(dto);
			dto = ctlBL.getExcelDataList(dto);
			//设置excel DTO
			IGCRC04ExcelDTO excelDTO = new IGCRC04ExcelDTO();
			if(dto.getIgcrc14011VO() == null){
				dto.setIgcrc14011VO(new IGCRC14011VO());
			}
			excelDTO.setVoLists(dto.getIgcrc14011VO().getIgcrc14012vos());
			// 取得Excel处理BL
			IGCRC04ExcelBL excelBL = (IGCRC04ExcelBL) getBean("igcrc04ExcelBL");
			// 填充参与人集合
			excelDTO.setProcessParticipantList(dto.getProcessParticipantList());
			
			excelDTO.setProcessStatusDefList(dto.getProcessStatusDefList());
			// 填充模板编号
			excelDTO.setFileid("CRC0404");
			excelDTO.setResponse(response);
			//excelBL.initExcel(excelDTO);
			excelBL.initExcel(excelDTO);
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward(forward);
	}

}
