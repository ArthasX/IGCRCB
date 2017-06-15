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
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.asset.bl.IGASM14BL;
import com.deliverik.infogovernor.asset.dto.IGASM14DTO;
import com.deliverik.infogovernor.asset.form.IGASM1414Form;
import com.deliverik.infogovernor.asset.vo.IGASM14141VO;

/**
 * <p>
 * Title : 设备服务记录查询画面
 * </p>
 * <p>
 * Description: 设备服务记录查询画面Action
 * </p>
 * 
 * @author songhaiyang@deliverik.com
 * @version 1.0
 */
public class IGASM1414Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1414Action.class);

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
		IGASM1414Form form = (IGASM1414Form)actionForm;
		
		//BL取得
		IGASM14BL ctlBL = (IGASM14BL) getBean("igasm14BL");
		
		//DTO生成
		IGASM14DTO dto = new IGASM14DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//设备查询画面初期显示处理
			log.debug("========设备服务记录查询画面初期显示处理开始========");
			
			//***************************************************************************
			//类型分类(设备)设定
			form = new IGASM1414Form();
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
			req.setAttribute("IGASM1414Form", form);

			//***************************************************************************
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========设备服务记录查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGASM1414");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//设备查询处理
			log.debug("========设备服务记录查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，返回查询画面时的再检索处理
				form = (IGASM1414Form) req.getSession().getAttribute("IGASM1414Form");
				if ( form== null){
					form = new IGASM1414Form();
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
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
					form = (IGASM1414Form) req.getSession().getAttribute("IGASM1414Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM1414");
			
			//DTO输入参数设定
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//设备检索逻辑调用
			dto = ctlBL.searchServiceAction(dto);
			
			//将设备信息检索结果设定到VO中
			IGASM14141VO vo = new IGASM14141VO(dto.getEntityItemList());
			
			super.<IGASM14141VO>setVO(req, vo);
			
			log.debug("========设备服务记录查询处理终了========");
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
