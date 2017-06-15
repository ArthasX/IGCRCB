package com.deliverik.infogovernor.soc.vir.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.vir.bl.IGVIR09BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR09DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0901Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR09011VO;

/**
 * 虚拟化分析信息详细画面Action处理
 *
 */
public class IGVIR0901Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVIR0901Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGVIR0901Form form = (IGVIR0901Form)actionForm;
		
		//BL取得
		IGVIR09BL ctlBL = (IGVIR09BL) getBean("igvir09BL");
		
		//DTO生成
		IGVIR09DTO dto = new IGVIR09DTO();
		
		String forward = "DISP";
		
		if("INSERT_DISP".equals(mapping.getParameter())){
			log.debug("========虚拟化资源计费策略登记画面初期显示处理开始========");
			
			dto = ctlBL.getConfigItemList(dto);
			
			IGVIR09011VO vo = new IGVIR09011VO();
			
			vo.setConfigItemList(dto.getConfigItemList());
			
			super.<IGVIR09011VO>setVO(req, vo);
			
			log.debug("========虚拟化资源计费策略登记画面初期显示处理结束========");
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========虚拟化资源计费策略登记处理开始========");
			
			dto.setIgvir0901Form(form);
			
			ctlBL.insertBillingStrategy(dto);
			
			log.debug("========虚拟化资源计费策略登记处理结束========");
		}else if("DISP".equals(mapping.getParameter())){
			log.debug("========虚拟化资源计费策略查询处理开始========");
			
			dto = ctlBL.getConfigItemList(dto);
			
			IGVIR09011VO vo = new IGVIR09011VO();
			
			vo.setConfigItemList(dto.getConfigItemList());
			
			super.<IGVIR09011VO>setVO(req, vo);
			
			log.debug("========虚拟化资源计费策略查询处理结束========");
		}else if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("========虚拟化资源计费策略查询处理开始========");
			
			getPaginDTO(req,"IGVIR0901");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			dto.setStrategyName_eq(form.getStrategyName_eq());
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGVIR0901Form) req.getSession().getAttribute("IGVIR0901Form");
				if ( form == null ) {
					form = new IGVIR0901Form();
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
					form = (IGVIR0901Form) req.getSession().getAttribute("IGVIR0901Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGVIR0901");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setIgvir0901Form(form);
			
			dto = ctlBL.searchBillingStrategy(dto);
			
			IGVIR09011VO vo = new IGVIR09011VO();
			
			vo.setStrategies(dto.getStrategies());
			
			if(dto.getStrategies().size() == 0) vo.setStrategies(null);
			
			dto = ctlBL.getConfigItemList(dto);
			
			vo.setConfigItemList(dto.getConfigItemList());
			
			super.<IGVIR09011VO>setVO(req, vo);
			
			log.debug("========虚拟化资源计费策略查询处理结束========");
		}else if("EDIT_DISP".equals(mapping.getParameter())){
			log.debug("========虚拟化资源计费策略修改初期显示处理开始========");
			dto.setIgvir0901Form(form);
			
			dto = ctlBL.getConfigItemList(dto);
			
			dto = ctlBL.getBillingStrategyByID(dto);
			
			IGVIR09011VO vo = new IGVIR09011VO();
			
			vo.setConfigItemList(dto.getConfigItemList());
			
			vo.setStrategyEntity(dto.getStrategyEntity());
			
			super.<IGVIR09011VO>setVO(req, vo);
			
			log.debug("========虚拟化资源计费策略初期显示处理结束========");
		}else if("EDIT".equals(mapping.getParameter())){
			log.debug("========虚拟化资源计费策略修改处理开始========");
			
			dto.setIgvir0901Form(form);
			
			dto = ctlBL.updateBillingStrategy(dto);
			
			log.debug("========虚拟化资源计费策略修改处理结束========");
		}else if("DELETE".equals(mapping.getParameter())){
			log.debug("========虚拟化资源计费策略删除处理开始========");
			
			dto.setIgvir0901Form(form);
			
			dto = ctlBL.deleteBillingStrategy(dto);
			
			log.debug("========虚拟化资源计费策略删除处理结束========");
		}
		
		return mapping.findForward(forward);
	}
}
