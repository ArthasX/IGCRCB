package com.deliverik.infogovernor.syslog.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.syslog.bl.IGLOG004BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00004BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG0041DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0041Form;

/**
 * <p>
 * Title : InfoGovernor 日志规则模板管理
 * </p>
 * <p>
 * Description: 查询ACTION
 * </p>
 * 
 * @author wangrongguagn@deliverik.com
 * @version 1.0
 */
public class IGLOG0042Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOG0042Action.class);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param mapping
	 *            ActionMapping
	 * @param form
	 *            ActionForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest arg2, HttpServletResponse arg3) throws Exception {

		log.info("====日志规则模板管理-删除====");
		//实例化DTO
		IGLOG0041DTO dto = new IGLOG0041DTO();
		
		//实例化form表单
		IGLOG0041Form form = (IGLOG0041Form) actionForm;
		
		//实例化ctrolBL
		IGLOG004BL ctlBL = (IGLOG004BL) getBean("iglog004BL");
		
		dto.setIgLog0041Form(form);
		
		if (form.getDeleteId() != null && form.getDeleteId().length != 0) {
			ctlBL.deleteTemp(dto);
		}
		return mapping.findForward("DISP");
	}

}
