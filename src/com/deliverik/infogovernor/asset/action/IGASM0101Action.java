package com.deliverik.infogovernor.asset.action;

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

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.asset.bl.IGASM01BL;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.form.IGASM0101Form;
import com.deliverik.infogovernor.asset.vo.IGASM01011VO;

/**
 * @Description: 类型查询画面Action处理
 * @Author  
 * @History 2009-8-18     新建
 * @History 2010-5-07     0000428: 增加机房属性管理
 * @Version V2.0
 */
public class IGASM0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0101Action.class);

	/**
	 * 处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGASM0101Form form = (IGASM0101Form)actionForm;
		
		//BL取得
		IGASM01BL ctlBL = (IGASM01BL) getBean("igasm01BL");
		
		//DTO生成
		IGASM01DTO dto = new IGASM01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//类型查询画面初期显示处理
			log.debug("========类型查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========类型查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//类型查询画面再显示处理
			log.debug("========类型查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========类型查询画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//类型查询处理
			log.debug("========类型查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGASM0101");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM0101Form) req.getSession().getAttribute("IGASM0101Form");
				if ( form == null ) {
					form = new IGASM0101Form();
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
					form = (IGASM0101Form) req.getSession().getAttribute("IGASM0101Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0101");
			
			//DTO输入参数设定
			form.setEstatus(null);
			
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			
			dto.setEntitySearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//类型信息检索逻辑调用
			dto = ctlBL.searchEntityAction(dto);
			
			req.setAttribute("stopbuttonMap", dto.getStopbuttonMap());
			req.setAttribute("startbuttonMap", dto.getStartbuttonMap());
			
			//将类型信息检索结果设定到VO中
			IGASM01011VO vo = new IGASM01011VO(dto.getEntityList());
			
			super.<IGASM01011VO>setVO(req, vo);
			
			log.debug("========类型查询处理终了========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//类型删除处理
			log.debug("========类型删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntity(form.getDeleteEid());
			
			//类型信息删除逻辑调用
			ctlBL.deleteEntityAction(dto);
			
			log.debug("========类型删除处理终了========");
		}
		//修改模型状态1启用 2停用
		if ("CHANGE_STATUS".equals(mapping.getParameter())){
			log.debug("========资产模型状态变化处理开始========");
			if(req.getParameter("eid")!=null){
				form.setEid(req.getParameter("eid"));
			}
			if(req.getParameter("estatus")!=null){
				form.setEstatus(req.getParameter("estatus"));
			}
			dto.setEstatus(form.getEstatus());
			dto.setIgasm0101Form(form);
			ctlBL.changeEntityStatus(dto);
			
			log.debug("========资产模型状态变化处理终了========");
			return mapping.findForward("BACK");
		}
		if( "EXCCELDISP".equals(mapping.getParameter())){
			//查询处理
			log.debug("========一级模型查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGASM0112");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM0101Form) req.getSession().getAttribute("IGASM0101Form");
				if ( form == null ) {
					form = new IGASM0101Form();
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
					form = (IGASM0101Form) req.getSession().getAttribute("IGASM0101Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0112");
			
			//DTO输入参数设定
			form.setEstatus("1");
			
			//form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			
			//form.setEsyscoding_q("999");//查询上级模型为根结点的模型，即查询一级模型
			
			//form.setEsyscoding_nq("999009");//不查询服务记录及其下级模型
			
			List<String> delList_q = new ArrayList<String>();
			delList_q.add("999009");//不查询服务记录及其下级模型
			delList_q.add("999012");//不查询组件及其下级模型
			delList_q.add("999014");//不查询组件及其下级模型
			form.setDelList_q(delList_q);
			dto.setEntitySearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//类型信息检索逻辑调用
			dto = ctlBL.searchEntityActionForExportExcelModel(dto);
			
			//将类型信息检索结果设定到VO中
			IGASM01011VO vo = new IGASM01011VO(dto.getEntityList());
			
			super.<IGASM01011VO>setVO(req, vo);
			
			log.debug("========一级模型查询处理终了========");
		}
		if("EXPORTEXCEL".equals(mapping.getParameter())){
			
			dto = ctlBL.searchInfoForExportExcel(form.getEsyscoding());
			IGASM01011VO vo = new IGASM01011VO(dto.getEntityList());
			vo.setOrglist(dto.getOrglist());
			vo.setTopEntityList(dto.getTopEntityList());
			vo.setConfigurationMapList(dto.getConfigurationMapList());
			vo.setCcdList(dto.getCcdList());
			vo.setUserlist(dto.getUserlist());
			super.<IGASM01011VO>setVO(req, vo);
		}
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
