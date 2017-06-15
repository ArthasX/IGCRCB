/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.asset.bl.IGASM31BL;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.form.IGASM3116Form;
import com.deliverik.infogovernor.asset.model.RiskIndexContextVWInfo;
import com.deliverik.infogovernor.asset.vo.IGASM31071VO;

/**
 * @Description: 风险展示内容查询
 * @Author       zhangqiang
 * @History      @2014-7-26新建 
 * 			
 * @Version V1.0
 */
public class IGASM3116Action extends BaseAction {

	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGASM3116Form form = (IGASM3116Form) actionForm;
		//BL取得
		IGASM31BL ctlBL = (IGASM31BL) getBean("igasm31BL");
		//实例化DTO
		IGASM31DTO dto = new IGASM31DTO();
		//获取当前时间
		Calendar calendar = Calendar.getInstance();
		
		//初始化页面时间(年月) 
		if(null == form.getYear()){
			Integer year = calendar.get(Calendar.YEAR);
			form.setYear(year.toString());
		}
		if(null == form.getMonth()){
			Integer month = calendar.get(Calendar.MONTH) + 1;
			//月份如果是1位时补全2位
			form.setMonth(month.toString().length() == 1 ? "0" + month : month.toString());
		}
		//设定form
		dto.setIgasm3116form(form);
		if("DISP".equals(mapping.getParameter())){
			//调用control查询
			ctlBL.searchRiskIndexContext(dto);
			//获取第一个值 默认显示
			RiskIndexContextVWInfo ricvw = dto.getSearchRiskIndexContextVW().get(0);
			form.setEiid(ricvw.getEiid().toString());
			form.setRimid(ricvw.getRimid().toString());
			dto.setIgasm3116form(form);
			//调用control统计图查询
			ctlBL.searchRiskIndexByRiid(dto);
			
			//风险指标配置信息登记画面初期显示逻辑调用
			dto = ctlBL.initIGASM3116Action(dto);

			IGASM31071VO vo = new IGASM31071VO();
			req.getSession().setAttribute("IGASM3116Form", dto.getIgasm3116form());
			vo.setSearchRiskIndexContextVW(dto.getSearchRiskIndexContextVW());
			vo.setSearchRiskIndexSearchVWList(dto.getSearchRiskIndexSearchVWList());
			super.<IGASM31071VO>setVO(req, vo);
		}else if("SEARCH".equals(mapping.getParameter())){
			//调用control统计图查询
			ctlBL.searchRiskIndexByRiid(dto);
			
			//风险指标配置信息登记画面初期显示逻辑调用
			dto = ctlBL.initIGASM3116Action(dto);
			
			//实例化vo
			IGASM31071VO vo = new IGASM31071VO();
			req.getSession().setAttribute("IGASM3116Form", dto.getIgasm3116form());
			vo.setSearchRiskIndexContextVW(dto.getSearchRiskIndexContextVW());
			//
			vo.setSearchRiskIndexSearchVWList(dto.getSearchRiskIndexSearchVWList());
			super.<IGASM31071VO>setVO(req, vo);
		}
			
	
		return mapping.findForward("DISP");
	}

}
