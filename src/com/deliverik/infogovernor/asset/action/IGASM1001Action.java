package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM10BL;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.dto.IGASM10DTO;
import com.deliverik.infogovernor.asset.form.IGASM1001Form;
import com.deliverik.infogovernor.asset.vo.IGASM01061VO;
import com.deliverik.infogovernor.asset.vo.IGASM10011VO;

/**
 * 配置项查询画面Action处理
 *
 */
public class IGASM1001Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1001Action.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGASM1001Form form = (IGASM1001Form)actionForm;
		
		//BL取得
		IGASM10BL ctlBL = (IGASM10BL) getBean("igasm10BL");
		
		//DTO生成
		IGASM10DTO dto = new IGASM10DTO();
		String operType=req.getParameter("operType");
		
		if( "DISP".equals(mapping.getParameter())){
			//配置项查询画面初期显示处理
			log.debug("========配置项查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========配置项查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//配置项查询画面再显示处理
			log.debug("========配置项查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========配置项查询画面再显示处理终了========");
			return mapping.findForward("DISP");
		} else if("GET_CONFIGURATIONS".equals(mapping.getParameter())){
			//配置项查询画面再显示处理
			log.debug("========查询资产模型属性处理开始========");
			IGASM01DTO dto1 = new IGASM01DTO();
			dto1.setEsyscoding(req.getParameter("esyscoding"));
			dto1 = ctlBL.searchConfigurationsByEntity(dto1);
			
			//将类型配置信息检索结果设定到VO中
			IGASM01061VO vo = new IGASM01061VO(dto1.getConfigurationMap());
			
			super.<IGASM01061VO>setVO(req, vo);
			
			log.debug("========查询资产模型属性处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGASM1001");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			
			
			
			//配置项查询处理
			log.debug("========配置项查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM1001Form) req.getSession().getAttribute("IGASM1001Form");
				if ( form== null){
					form = new IGASM1001Form();
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
					form = (IGASM1001Form) req.getSession().getAttribute("IGASM1001Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			if(form!= null && form.getPageType()!=null && form.getPageType().equals("weibao")){
				if(form.getWbdate_from()==null || "".endsWith(form.getWbdate_from())){
					form.setWbdate_from("weibao");
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM1001");
			
			//DTO输入参数设定
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//配置项检索逻辑调用
			dto = ctlBL.searchEntityItemAction(dto);
			
			
			
			//将配置项信息检索结果设定到VO中
			IGASM10011VO vo = new IGASM10011VO();
			
			vo.setSocEntityDataList(dto.getSocEntityItemVWInfoList());
			
			super.<IGASM10011VO>setVO(req, vo);
			
			log.debug("========配置项查询处理终了========");
			
			if(operType!=null){ 
				if(operType.equals("wb")){
					if("weibao".endsWith(form.getWbdate_from())){
						form.setWbdate_from("");
					}
					return mapping.findForward("WBDISP");
				}
				if(operType.equals("tongji")){
					return mapping.findForward("TJDISP");
				}
			}
			String pageType=form.getPageType();
			if(pageType!=null){
				if(pageType.equals("weibao")){
					
					return mapping.findForward("WBDISP");
				}
			}
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
