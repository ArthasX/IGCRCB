package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM04BL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0411Form;
import com.deliverik.infogovernor.drm.vo.IGDRM04111VO;

/**
 * @Description: 类型查询画面Action处理
 * @Author  
 * @History 2009-8-18     新建
 * @History 2010-5-07     0000428: 增加机房属性管理
 * @Version V2.0
 */
public class IGDRM0411Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0411Action.class);

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
		IGDRM0411Form form = (IGDRM0411Form)actionForm;
		
		//BL取得
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		
		//DTO生成
		IGDRM04DTO dto = new IGDRM04DTO();
		
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
			getPaginDTO(req,"IGDRM0411");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDRM0411Form) req.getSession().getAttribute("IGDRM0411Form");
				if ( form == null ) {
					form = new IGDRM0411Form();
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
					form = (IGDRM0411Form) req.getSession().getAttribute("IGDRM0411Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGDRM0411");
			
			//DTO输入参数设定
			form.setEstatus(null);
			
//			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
//			form.setSyscoding_q("999040");
			dto.setIgdrm0411Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			
			
			//类型信息检索逻辑调用
			dto = ctlBL.searchEntityAction(dto);
			
			req.setAttribute("stopbuttonMap", dto.getStopbuttonMap());
			req.setAttribute("startbuttonMap", dto.getStartbuttonMap());
			
			//将类型信息检索结果设定到VO中 
			IGDRM04111VO vo = new IGDRM04111VO(null,dto.getErEntityList());
			
			super.<IGDRM04111VO>setVO(req, vo);
			
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
		//修改分类状态1启用 2停用
		if ("CHANGE_STATUS".equals(mapping.getParameter())){
			log.debug("========资产分类状态变化处理开始========");
			if(req.getParameter("eid")!=null){
				form.setEid(req.getParameter("eid"));
			}
			if(req.getParameter("estatus")!=null){
				form.setEstatus(req.getParameter("estatus"));
			}
			dto.setEstatus(form.getEstatus());
			dto.setIgdrm0411Form(form);
			ctlBL.changeEntityStatus(dto);
			
			log.debug("========资产分类状态变化处理终了========");
			return mapping.findForward("BACK");
		}
		if( "EXCCELDISP".equals(mapping.getParameter())){
			//查询处理
			log.debug("========一级分类查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGASM0112");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDRM0411Form) req.getSession().getAttribute("IGDRM0411Form");
				if ( form == null ) {
					form = new IGDRM0411Form();
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
					form = (IGDRM0411Form) req.getSession().getAttribute("IGDRM0411Form");
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
			
			//form.setEsyscoding_q("999");//查询上级分类为根结点的分类，即查询一级分类
			
			//form.setEsyscoding_nq("999009");//不查询服务记录及其下级分类
			
			List<String> delList_q = new ArrayList<String>();
			delList_q.add("999009");//不查询服务记录及其下级分类
			delList_q.add("999012");//不查询组件及其下级分类
			delList_q.add("999014");//不查询组件及其下级分类
			form.setDelList_q(delList_q);
			dto.setEntitySearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//类型信息检索逻辑调用
			dto = ctlBL.searchEntityActionForExportExcelModel(dto);
			
			//将类型信息检索结果设定到VO中
			IGDRM04111VO vo = new IGDRM04111VO(dto.getEntityList(),null);
			
			super.<IGDRM04111VO>setVO(req, vo);
			
			log.debug("========一级分类查询处理终了========");
		}
		if("EXPORTEXCEL".equals(mapping.getParameter())){
			
			dto = ctlBL.searchInfoForExportExcel(form.getEsyscoding());
			IGDRM04111VO vo = new IGDRM04111VO(dto.getEntityList(),null);
			vo.setOrglist(dto.getOrglist());
			vo.setTopEntityList(dto.getTopEntityList());
			vo.setConfigurationMapList(dto.getConfigurationMapList());
			vo.setCcdList(dto.getCcdList());
			vo.setUserlist(dto.getUserlist());
			super.<IGDRM04111VO>setVO(req, vo);
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
