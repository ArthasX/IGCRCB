package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM16BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM16DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1611Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM16021VO;

/**
 * 密码关联关系画面Action处理
 *
 */
public class IGCIM1611Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1611Action.class);

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
				IGCIM1611Form form = (IGCIM1611Form)actionForm;
				
				//BL取得
				IGCIM16BL ctlBL = (IGCIM16BL) getBean("igcim16BL");
				
				//DTO生成
				IGCIM16DTO dto = new IGCIM16DTO();
				
				dto.setIgcim1611Form(form);
				
				if ("INSERT".equals(mapping.getParameter())){
					//密码信息保存
					log.debug("========密码关联关系保存处理显示开始========");
					ctlBL.insertSoc0502Info(dto);
					//req.setAttribute("addFlag", true);
					//req.setAttribute("pid",form.getPid());
					log.debug("========密码关联关系保存处理显示终了========");
					
				}
				if("DISP".equals(mapping.getParameter())){
					this.clearSessionFormData(req);
					req.setAttribute("pid", form.getPid());
				}
				if ("DELETE".equals(mapping.getParameter())){
					//密码信息删除
					log.debug("========密码关联关系删除处理显示开始========");
					ctlBL.deleteSoc0501Info(dto);
					log.debug("========密码关联关系删除处理显示终了========");
					
				}
				if("SEARCH".equals(mapping.getParameter())){
					//密码信息查找
					log.debug("========密码关联关系查找处理显示开始========");
					//分页用DTO取得
					getPaginDTO(req,"IGCIM1611");
					
					PagingDTO pDto;
					
					pDto = (PagingDTO)req.getAttribute("PagingDTO");
					
					
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(0);
						form = (IGCIM1611Form) req.getSession().getAttribute("IGCIM1611Form");
						//form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION);
						if (form !=null) {
							form.setFromCount(0);
						}
					}
					int maxCnt = getMaxDataCount("IGCIM1611");
					
					dto.setMaxSearchCount(maxCnt);
					
					dto.setPagingDto(pDto);
					
					
					ctlBL.getSoc0502Info(dto);
					
					IGCIM16021VO vo = new IGCIM16021VO();
					vo.setSoc0502Infos(dto.getSoc0502List());
					vo.setSoc0501Info(dto.getSoc0501Info());
					
					super.setVO(req, vo);
					
					log.debug("========密码关联关系查找处理显示终了========");
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
