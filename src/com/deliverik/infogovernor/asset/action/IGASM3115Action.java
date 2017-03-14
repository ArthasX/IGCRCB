/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.asset.bl.IGASM31BL;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.vo.IGASM31021VO;
import com.deliverik.infogovernor.asset.vo.IGASM31071VO;

/**
 * @Description: 风险指标展示
 * @Author       zhangqiang
 * @History      @2014-7-24新建 
 * 			
 * @Version V1.0
 */
public class IGASM3115Action extends BaseAction {

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//IGASM3115Form form = (IGASM3115Form)actionForm;
		//BL取得
		IGASM31BL ctlBL = (IGASM31BL) getBean("igasm31BL");
		//实例化DTO
		IGASM31DTO dto = new IGASM31DTO();
		
		//调用controlBL查询
		ctlBL.searchRiskIndexShow(dto);
		
		//实例化VO
		IGASM31071VO vo = new IGASM31071VO();
		vo.setRiskIndexShowList(dto.getRiskIndexShowList());
		super.<IGASM31071VO>setVO(req, vo);
		return mapping.findForward("DISP");
	}

}
