/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.drm.bl.IGDRM15BL;
import com.deliverik.infogovernor.drm.dto.IGDRM15DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1501Form;
import com.deliverik.infogovernor.drm.vo.IGDRM15011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:培训计划编辑Action
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM1512Action extends BaseAction {
	static Log log = LogFactory.getLog(IGDRM1512Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionform, HttpServletRequest request,
			HttpServletResponse res) throws Exception {

		// 获得form
		IGDRM1501Form form = (IGDRM1501Form) actionform;
		// BL取得
		IGDRM15BL ctlBL = (IGDRM15BL) getBean("igdrm15BL");
		// DTO生成
		IGDRM15DTO dto = new IGDRM15DTO();
		//dto.setForm(form);
		dto.setIgdrm1501Form(form);
		// 修改
		if ("TOEDIT".equals(mapping.getParameter())) {
			log.debug("========培训计划、培训任务更新取值处理开始========");

			dto = ctlBL.searchTrainPlanMissionAction(dto);
			// 将查到的结果放到vo
			IGDRM15011VO vo = new IGDRM15011VO();
			vo.setTrainmissionInfoList(dto.getTrainmissionInfoList());
			vo.setTrainplanInfo(dto.getTrainplanInfo());
			vo.setResultList(dto.getResultList());
			super.setVO(request, vo);
			log.debug("========培训计划、培训任务更新取值处理结束========");
		}
		
		if ("TOUPDATE".equals(mapping.getParameter())) {
			log.debug("========培训计划/培训任务更新处理开始========");
			// 调用BL新增
//			IGDRM15011VO vo = new IGDRM15011VO();
            ctlBL.updateTrainPlanMission(dto);
			
			log.debug("========培训计划/培训任务更新处理结束========");
		}
		return mapping.findForward("DISP");
	}

}
