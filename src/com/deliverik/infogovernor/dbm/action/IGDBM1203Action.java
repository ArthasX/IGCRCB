/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dbm.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.dbm.bl.IGDBM12BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM12DTO;

/**
 * @概述 信息安全综合性分析DashBoard
 * @功能描述 信息安全综合性分析DashBoard 
 * @创建记录 孙东东  2014/07/17
 * @version 1.0
 */
public class IGDBM1203Action extends BaseAction{
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//日志对象
		Log log = LogFactory.getLog(IGDBM1203Action.class);
		//BL取得
		IGDBM12BL ctlBL = (IGDBM12BL) getBean("igdbm12BL");
		//实例化dto
		IGDBM12DTO dto=new IGDBM12DTO();
		//dto参数取得
		dto.setForm(actionForm);
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("========信息安全综合分析画面初期显示处理开始========");
			
			log.debug("========信息安全综合分析画面初期显示处理结束========");
			return mapping.findForward("DISP");
		}
		if("rcclass".equals(mapping.getParameter())){
			log.debug("===========检查次数年度统计数据取得操作开始===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRcclass(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========检查次数年度统计数据取得操作开始===========");
		}
		if("rcclassbymonth".equals(mapping.getParameter())){
			log.debug("=================各类问题及工作占比数据取得操作开始==============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRcclassByMonth(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("=================各类问题及工作占比数据取得操作结束==============");
			
		}
		
		if("rctestmode".equals(mapping.getParameter())){
			log.debug("=============年度工作趋势数据取得操作开始=============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRcTestMode(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("=============年度工作趋势数据取得操作结束=============");
		}
		if("riskcheckresult".equals(mapping.getParameter())){
			log.debug("============信息安全工作总体趋势数据取得操作开始============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRiskCheckResult(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("============信息安全工作总体趋势数据取得操作结束============");
		}
		
		if("questions".equals(mapping.getParameter())){
			log.debug("===========问题及整改情况数据取得操作开始=============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getQuestions(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========问题及整改情况数据取得操作结束=============");
		}
		
		return null;
	}

}
