/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.mtp.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.mtp.bl.IGMTP01BL;
import com.deliverik.infogovernor.mtp.dto.IGMTP03DTO;
import com.deliverik.infogovernor.mtp.form.IGMTP0107Form;
import com.deliverik.infogovernor.mtp.vo.IGMTP01041VO;
import com.deliverik.infogovernor.mtp.vo.IGMTP01061VO;

/**
 * 
 * 工作计划Action
 * 
 */
public class IGMTP0107Action extends BaseAction {

	static Log log = LogFactory.getLog(IGMTP0107Action.class);

	/**
	 * 工作计划
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		log.debug("========工作计划初期显示开始========");
		IGMTP01061VO vo61= (IGMTP01061VO)req.getAttribute("IGMTP01061VO");
		IGMTP01BL igmtp01BL = (IGMTP01BL) getBean("igmtp01BL");
		IGMTP03DTO dto = new IGMTP03DTO();
		IGMTP0107Form form = (IGMTP0107Form) actionForm;
		//设置上一页面发过来的选择日期,提交时需要用到
		dto.setDateList((List<String>) req.getSession(true).getAttribute("dateList"));
		dto.setIgmtp01061VO(vo61);
		dto.setIgmtp0107Form(form);
		dto.setSelectedCheck((Map<String, String>)req.getSession(true).getAttribute("selectedCheck"));

		//数据初始化
		dto = igmtp01BL.initIGMTP0107(dto);
		
		//上下月跳转
		String forward = form.getForward();
		
		Integer showYear = form.getShowYear();
		Integer showMonth = form.getShowMonth();

		// 上个月
		if ("back".equals(forward)) {
			if (showMonth == 0) {
				showYear = showYear - 1;
				showMonth = 11;
			} else {
				showMonth = showMonth - 1;
			}
		}
		// 下个月
		else if ("next".equals(forward)) {
			if (showMonth > 11) {
				showYear = showYear + 1;
				showMonth = 0;
			}
		}
		//提交下一步
		if ("NEXT".equals(mapping.getParameter())) {
			//下一步要转发的数据
			List<String> selectList = new ArrayList<String>();
			//为断送哪些是新选择的日期而设置
			Map<String,String> init = new HashMap<String,String>();
			//初始化值
			for(int i=0;i<dto.getDateList().size();i++){
				init.put(dto.getDateList().get(i).split("_")[0], dto.getDateList().get(i).split("_")[2]);
			}
			//转成List传输
			for (String key : dto.getSelectedCheck().keySet()) {
				if(init.get(key) != null){//选择日期已存在,设置其原有ID
					selectList.add(dto.getSelectedCheck().get(key)+"_"+init.get(key));
				}else{//选择日期为新选择,其ID设为0
					selectList.add(dto.getSelectedCheck().get(key)+"_0");
				}
				
			}
			//对日期进行排序
			Collections.sort(selectList);
			//发送
			req.getSession(true).setAttribute("selectList", selectList);
			return mapping.findForward("DISP");
		}


		
		int calendarYear = (showYear == null || 0 == showYear) ? dto.getSyear(): showYear;
		int calendarMonth = (showMonth == null) ? dto.getSmonth() : showMonth;
		
		dto.setCalendarYear(calendarYear);
		dto.setCalendarMonth(calendarMonth);
		//页面初始化数据处理
		dto = igmtp01BL.initIGMTP0107Action(dto);
		
		IGMTP01041VO vo = new IGMTP01041VO();
		vo.setCalendarYear(calendarYear);
		vo.setCalendarMonth(calendarMonth);
		vo.setWeekVOList(dto.getRowList());
		super.<IGMTP01041VO> setVO(req, vo);
		req.getSession(true).setAttribute("todayYMD", dto.getTodayYMD());
		req.getSession(true).setAttribute("dateList", dto.getDateList());
		req.getSession(true).setAttribute("selectedCheck", dto.getSelectedCheck());
		req.getSession(true).setAttribute("begin_time", dto.getIgmtp0107Form().getBegin_time());
		req.getSession(true).setAttribute("end_time", dto.getIgmtp0107Form().getEnd_time());
		log.debug("========工作计划初期显示结束========");
		return mapping.findForward("DISP");
	}

}
