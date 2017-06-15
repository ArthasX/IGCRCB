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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM16BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM16DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1633Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM16321VO;

/**
 * 密码关联关系画面Action处理
 *
 */
public class IGCIM1633Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1633Action.class);

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
				IGCIM1633Form form = (IGCIM1633Form)actionForm;
				
				//BL取得
				IGCIM16BL ctlBL = (IGCIM16BL) getBean("igcim16BL");
				
				//DTO生成
				IGCIM16DTO dto = new IGCIM16DTO();
				dto.setLocale(this.getLocale(req));
				//画面跳转设定
				String forward = null;
				
				if( "INSERT".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
					//设备关系管理画面初期显示处理
					//DTO输入参数设定
					dto.setIgcim1633Form(form);
					
					if (isTokenValid(req, true)){
						
						dto = ctlBL.insertBusiessRelation(dto);
						
						forward = "DISP";
						
					}else{
						addMessage(req, new ActionMessage("IGCO00000.E007"));
						return mapping.findForward("/error1");
					}

					log.debug("========设备关系登记处理终了========");
				}
				if ("EDIT".equals(mapping.getParameter())) {
					log.debug("==============密码关联关系添加页面预处理开始=================");
					form = new IGCIM1633Form();
					//清除session中的form表单
					req.getSession().setAttribute("IGCIM1633Form", form);
					form.setEiid(Integer.valueOf(req.getParameter("eiid")));
					dto.setIgcim1633Form(form);
					
					dto = ctlBL.initIGCIM1632EditAction(dto);
					IGCIM16321VO vo = new IGCIM16321VO();
					vo.setEntityItemData(dto.getSoc0124Info());
					setVO(req, vo);
					forward = "DISP";
					log.debug("==============密码关联关系添加页面预处理结束=================");
				}
				
				

				//逻辑处理过程中的信息显示
				List<ActionMessage> messageList = dto.getMessageList();
				
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(req, message);
					}
					
				}

				return mapping.findForward(forward);
			}
}
