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
public class IGDBM1204Action extends BaseAction{
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//日志对象
		Log log = LogFactory.getLog(IGDBM1204Action.class);
		//BL取得
		IGDBM12BL ctlBL = (IGDBM12BL) getBean("igdbm12BL");
		//实例化dto
		IGDBM12DTO dto=new IGDBM12DTO();
		//dto参数取得
		dto.setForm(actionForm);
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("========科技风险综合分析 画面初期显示处理开始========");
			
			log.debug("========科技风险综合分析 画面初期显示处理结束========");
			return mapping.findForward("DISP");
		}
		if("getCounter".equals(mapping.getParameter())){
			log.debug("===========风险部门工作情况数据取得操作开始===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getCounterValue(dto);
				out.print(dto.getRiskCounter());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========风险部门工作情况数据取得操作开始===========");
		}
		if("getRiskCheck".equals(mapping.getParameter())){
			log.debug("===========本年度风险工作覆盖情况数据取得操作开始===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRiskCheck(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========本年度风险工作覆盖情况数据取得操作开始===========");
		}
		if("getRiskProblem".equals(mapping.getParameter())){
			log.debug("===========本年度风险问题及整改占比 数据取得操作开始===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRiskProblem(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========本年度风险问题及整改占比数据取得操作开始===========");
		}
		if("getRiskRepository".equals(mapping.getParameter())){
			log.debug("===========风险库分布情况数据取得操作开始===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRiskRepository(dto);
				out.print(dto.getAjaxResult());
				log.debug(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========风险库分布情况数据取得操作结束===========");
		}
		if("getRiskRectification".equals(mapping.getParameter())){
			log.debug("===========风险评估工作总体情况-柱图 数据取得操作开始===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRiskRectification(dto);
				out.print(dto.getAjaxResult());
				log.debug(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========风险评估工作总体情况-柱图 数据取得操作结束===========");
		}
		if("getRiskAssess".equals(mapping.getParameter())){
			log.debug("===========风险评估工作总体情况-线图 数据取得操作开始===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getRiskAssess(dto);
				out.print(dto.getAjaxResult());
				log.debug(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========风险评估工作总体情况-线图 数据取得操作结束===========");
		}
		
		return null;
	}

}
