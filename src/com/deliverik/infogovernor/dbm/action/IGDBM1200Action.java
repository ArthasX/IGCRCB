/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dbm.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.dbm.bl.IGDBM12BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM12DTO;
import com.deliverik.infogovernor.dbm.form.IGDBM1200Form;
import com.deliverik.infogovernor.dbm.vo.IGDBM12001VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 报表钻取Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDBM1200Action extends BaseAction{

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGDBM1200Action.class);
		//BL取得
		IGDBM12BL ctlBL = (IGDBM12BL) getBean("igdbm12BL");
		//实例化dto
		IGDBM12DTO dto = new IGDBM12DTO();
		//dto参数设定
		IGDBM1200Form form = (IGDBM1200Form)actionForm;
		if("SEARCH".equals(mapping.getParameter())||"RISKWORK".equals(mapping.getParameter())||"RISKRISKREPOSITORY".equals(mapping.getParameter())
				||"SEARCH_RISK".equals(mapping.getParameter())||"SEARCH_COUNT".equals(mapping.getParameter())){
			//form init
			form.setPrpdid(request.getParameter("prpdid"));
			form.setPropentime_like(request.getParameter("propentime_like"));
			form.setPrclosetime_like(request.getParameter("prclosetime_like"));
			form.setOther(request.getParameter("other"));
			form.setMonth(request.getParameter("month"));
			form.setPpuserid(request.getParameter("ppuserid"));
			form.setPrActive(request.getParameter("prActive"));
			form.setEsyscoding(request.getParameter("esyscoding"));
			form.setPrclose(request.getParameter("prclose"));
			form.setPrclose(request.getParameter("pivarvalue"));
			form.setPrclose(request.getParameter("countid"));
			form.setPrclose(request.getParameter("type"));
			
			String varnames = request.getParameter("varnames");
			if(StringUtils.isNotEmpty(varnames)){
				form.setVarnames(new String[]{varnames});
			}else{
				form.setVarnames(null);
			}
			String varvalues = request.getParameter("varvalues");
			if(StringUtils.isNotEmpty(varvalues)){
				form.setVarvalues(new String[]{varvalues});
			}else{
				form.setVarvalues(null);
			}
			form.setRcrrealtime_like(request.getParameter("rcrrealtime_like"));
			form.setRcclass(request.getParameter("rcclass"));
			form.setRcrtestmode(request.getParameter("rcrtestmode"));
			
			
		}
		form = decodeForm(form);
		dto.setForm(form);
		if("SEARCH_PAGE".equals(mapping.getParameter())){
			log.debug("==============流程列表显示操作开始==============");
			dto.setPagingDto(getPaginDTO(request,"IGDBM1200"));
			dto = ctlBL.searchProcessRecordAction(dto);
			//实例化vo
			IGDBM12001VO vo = new IGDBM12001VO();
			vo.setPrList(dto.getPrList());
			super.<IGDBM12001VO>setVO(request, vo);
			log.debug("==============流程列表显示操作结束==============");
		}
		//检查工作查询操作
		if("RISKWORK_PAGE".equals(mapping.getParameter())){
			log.debug("==============检查工作查询操作开始==============");
			dto.setPagingDto(getPaginDTO(request,"IGDBM1200RC1"));
			dto = ctlBL.searchRiskWorkAction(dto);
			//实例化vo
			IGDBM12001VO vo = new IGDBM12001VO();
			vo.setRcrList(dto.getRcrList());
			super.<IGDBM12001VO>setVO(request, vo);
			log.debug("==============检查工作查询操作结束==============");
		}
		//科技风险查询操作
		if("SEARCH_RISK_PAGE".equals(mapping.getParameter())){
			log.debug("==============流程列表显示操作开始==============");
			dto.setPagingDto(getPaginDTO(request,"IGDBM1200"));
			dto = ctlBL.searchIssueCorrectiveByField(dto);
			//实例化vo
			IGDBM12001VO vo = new IGDBM12001VO();
			vo.setPrList(dto.getPrList());
			super.<IGDBM12001VO>setVO(request, vo);
			log.debug("==============流程列表显示操作结束==============");
		}
		//科技风险查询操作
		if("SEARCH_COUNT_PAGE".equals(mapping.getParameter())){
			log.debug("==============流程列表显示操作开始==============");
			dto.setPagingDto(getPaginDTO(request,"IGDBM1200"));
			dto = ctlBL.searchCounterInfo(dto);
			//实例化vo
			IGDBM12001VO vo = new IGDBM12001VO();
			if("1".equals(form.getType())){
				vo.setAssetList(dto.getAssetList());
			}else{
				vo.setPrList(dto.getPrList());
			}
			super.<IGDBM12001VO>setVO(request, vo);
			log.debug("==============流程列表显示操作结束==============");
		}
		if("RISKRISKREPOSITORY_PAGE".equals(mapping.getParameter())){
			log.debug("==============砖取资产查询操作开始==============");
			dto.setPagingDto(getPaginDTO(request,"IGDBM1200"));
			dto = ctlBL.searchRiskRepositoryAction(dto);
			//实例化vo
			IGDBM12001VO vo = new IGDBM12001VO();
			
			vo.setRiskPointList(dto.getRiskPointList());
			vo.setCheckItemList(dto.getCheckItemList());
			vo.setRiskcaseList(dto.getRiskcaseList());
			request.setAttribute("prFalg", "prFalg");
			request.setAttribute("esyscoding",((IGDBM1200Form)dto.getForm()).getEsyscoding().substring(0, 6));
			super.<IGDBM12001VO>setVO(request, vo);
			log.debug("==============砖取资产查询操作结束==============");
		}
		//初始化状态
		form.setPrstatus(null);
		return mapping.findForward("DISP");
	}

	/***
	 * 解决url传参中文乱码问题
	 * @param form
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private IGDBM1200Form decodeForm(IGDBM1200Form form) throws UnsupportedEncodingException{
		int i = 0;
		if(form.getVarnames()!=null && form.getVarnames().length>0){
			String[] varnames = new String[form.getVarnames().length];
			for (String varname : form.getVarnames()) {
				varname = URLDecoder.decode(varname, "UTF-8");
				varnames[i] = varname;
				i++;
			}
			form.setVarnames(varnames);
		}
		
		if(form.getVarvalues()!=null && form.getVarvalues().length>0){
			String[] varvalues = new String[form.getVarvalues().length];
			i = 0;
			for (String varvalue : form.getVarvalues()) {
				varvalue = URLDecoder.decode(varvalue, "UTF-8");
				varvalues[i] = varvalue;
				i++;
			}
			form.setVarvalues(varvalues);
		}
		if(form.getPivarvalue()!=null){
			form.setPivarvalue(URLDecoder.decode(form.getPivarvalue(), "UTF-8"));
		}
		return form;
	}
}
