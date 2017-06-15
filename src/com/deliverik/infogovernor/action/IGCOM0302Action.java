package com.deliverik.infogovernor.action;

import java.util.List;
import java.util.Set;

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
import com.deliverik.infogovernor.bl.IGCOM03BL;
import com.deliverik.infogovernor.dto.IGCOM03DTO;
import com.deliverik.infogovernor.form.IGCOM0302Form;
import com.deliverik.infogovernor.form.IGCOM0329Form;
import com.deliverik.infogovernor.vo.IGCOM03021VO;
import com.deliverik.infogovernor.vo.IGCOM03291VO;

/**
 * 资产项查询HELP画面用Action处理
 *
 */
public class IGCOM0302Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0302Action.class);

	/**
	 * 
	 * 处理
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGCOM0329Form form = (IGCOM0329Form)actionForm;
		
		//BL取得
		IGCOM03BL ctlBL = (IGCOM03BL) getBean("igcom03BL");
		
		//DTO生成
		IGCOM03DTO dto = new IGCOM03DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			form.setEsyscodingbegin(form.getEsyscoding());
			log.debug("========资产项HELP查询画面初期显示处理开始========");
			if(StringUtils.isEmpty(form.getEname()) && StringUtils.isNotEmpty(form.getEsyscoding())){
				dto.setEsyscoding(form.getEsyscoding());
				dto = ctlBL.searchEntityNameAction(dto);
				form.setEname(dto.getEname());
			}
			//重新查询需清除缓存
			req.getSession().removeAttribute("ADSelectEntity");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========资产项HELP查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			log.debug("========资产项HELP查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========资产项HELP查询画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())||"SEARCH2".equals(mapping.getParameter())){
			log.debug("========资产项查询HELP处理开始========");

			//分页用DTO取得
			getPaginDTO(req,"IGCOM0302");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGCOM0329Form) req.getSession().getAttribute("IGCOM0329Form");
				if ( form== null){
					form = new IGCOM0329Form();
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
					form = (IGCOM0329Form) req.getSession().getAttribute("IGCOM0329Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			//公用弹出页面不显示已报废设备
			form.setEistatus("0");
//			pDto.setFromCount(form.getFromCount());
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCOM0302");
			
			//DTO输入参数设定
			dto.setSoc0214SearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			Set<String> set = (Set<String>)req.getSession().getAttribute("ADSelectEntity");
			if(set != null && set.size() > 0) {
				form.setSelectId(set.toArray(new String[0]));
			} else {
				form.setSelectId(null);
			}
			
			if("SEARCH2".equals(mapping.getParameter())){
				form.setEcategory("SVR");
				dto.setSoc0214SearchCond(form);
				//点击查询按钮清除缓存
				if (req.getParameter("PAGING") == null) {
					req.getSession().removeAttribute("ADSelectEntity");
					form.setSelectId(null);
				}
			}
			
			dto.setPagingDto(pDto);
			

			//资产项信息检索逻辑调用
			dto = ctlBL.searchEntityItemAction(dto);
			
			//将资产项信息检索结果设定到VO中
			IGCOM03291VO vo = new IGCOM03291VO(dto.getSoc0124List());
			
			super.<IGCOM03291VO>setVO(req, vo);
			
			//逻辑处理过程中的信息显示
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
				
			}
			log.debug("========资产项HELP查询处理终了========");
		}
		return mapping.findForward("DISP");
	}
}
