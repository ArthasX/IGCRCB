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
import com.deliverik.infogovernor.asset.bl.IGASM2814ExcelBL;
import com.deliverik.infogovernor.asset.bl.IGASM28BL;
import com.deliverik.infogovernor.asset.dto.IGASM2814ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM28DTO;
import com.deliverik.infogovernor.asset.form.IGASM2814Form;
import com.deliverik.infogovernor.asset.vo.IGASM28071VO;

/**
 * 风险点查询画面Action处理
 *
 */
public class IGASM2814Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2814Action.class);

	/**
	 * 风险点资产查询
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
		IGASM2814Form igasm2814form = (IGASM2814Form) actionForm;
		
		//BL取得
		IGASM28BL ctrlBL = (IGASM28BL) getBean("igasm28BL");
		
		//DTO生成
		IGASM28DTO dto = new IGASM28DTO();
		dto.setIgasm2814form(igasm2814form);
		
		
		if ("DISP".equals(mapping.getParameter())){
			//风险点修改处理显示
			log.debug("========风险点查询初始化显示开始========");
			//获取建议检查频度
			ctrlBL.searchRiskPropertyActioin(dto);
			
			IGASM28071VO vo=new IGASM28071VO();
			vo.setCheckfrequencyList(dto.getCheckfrequencyList());
			super.<IGASM28071VO>setVO(req, vo);
			//实例化vo
			log.debug("=======检查项资产查询处理结束========");
			
		}else if("SEARCH".equals(mapping.getParameter())){
			//获取建议检查频度
			ctrlBL.searchRiskPropertyActioin(dto);
			//分页用DTO取得
			getPaginDTO(req,"IGASM2814");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			
			int maxCnt = getMaxDataCount("IGASM2814");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//调用bl 进行数据处理
			ctrlBL.searchCheckItemListAction(dto);
			
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto.setIgasm2814form(igasm2814form);

			IGASM28071VO vo=new IGASM28071VO();
			vo.setIgasm2814form(igasm2814form);
			vo.setItemList(dto.getItemList());
			vo.setCheckfrequencyList(dto.getCheckfrequencyList());
			super.<IGASM28071VO>setVO(req, vo);
		}
	
		if("EXCEL".equals(mapping.getParameter())){
			log.debug("=====================检查项查询导出开始=======================");
			
			dto.setIgasm2814form(igasm2814form);
			// 取得Excel处理BL
			IGASM2814ExcelBL excelBL = (IGASM2814ExcelBL) getBean("igasm2814ExcelBL");
			//调用bl 进行数据处理
			dto=excelBL.searchCheckItemListAction(dto);
			// 实例ExeclDTO
 			IGASM2814ExcelDTO excelDTO = new IGASM2814ExcelDTO();
			excelDTO.setItemList(dto.getItemList());
			// 填充模板编号
			excelDTO.setFileid("ASM2814");
			excelDTO.setResponse(res);
			excelBL.initExcel(excelDTO);
			log.debug("=====================检查项查询导出结束=======================");
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//检查项删除处理
			log.debug("========检查项删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntityItem(igasm2814form.getDeleteEiid());
			
			//检查项信息删除逻辑调用
			ctrlBL.deleteEntityItemAction(dto);
			
			log.debug("========检查项删除处理终了========");
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
