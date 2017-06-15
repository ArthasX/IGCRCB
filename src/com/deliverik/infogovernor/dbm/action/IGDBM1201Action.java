/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
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
 * 概 述: 科技运行综合分析DashBoard 处理Action 功能描述： 1.业务部门和科技部门工单情况 2.业务部门和科技部门工单数量对比
 * 3.各部门处理工单数量趋势分析
 * 
 * 创建记录：胡莒文 2014/07/16
 * 
 */
public class IGDBM1201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM1201Action.class);

	/**
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
		// 获取BL接口实例
		IGDBM12BL ctlBL = (IGDBM12BL) getBean("igdbm12BL");
		// 实例化DTO
		IGDBM12DTO dto = new IGDBM12DTO();
		dto.setForm(actionForm);
		// 画面跳转设定
		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========科技运行综合分析画面初期显示处理开始========");

			log.debug("========科技运行综合分析画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		if("ProcessCountYW".equals(mapping.getParameter())){
			log.debug("===========业务部门工单情况取得操作开始===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getPieValue(dto);
				out.print(dto.getProcessCountYW());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========业务部门工单情况取得操作结束===========");
		}
		if("ProcessCountKJ".equals(mapping.getParameter())){
			log.debug("===========科技部门工单情况取得操作开始===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getPieValue(dto);
				out.print(dto.getProcessCountKJ());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========科技部门工单情况取得操作结束===========");
		}
		if("businessdepart".equals(mapping.getParameter())){
			log.debug("===========业务部门各类工单占比取得操作开始===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getBusinessDepart(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========业务部门各类工单占比取得操作结束===========");
		}
		if("sciencedepart".equals(mapping.getParameter())){
			log.debug("===========科技部门各类工单占比取得操作开始===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.getScienceDepart(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========科技部门各类工单占比取得操作结束===========");
		}
		if("Line".equals(mapping.getParameter())){
			log.debug("===========各部门处理工单数量趋势分析操作开始===========");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				ctlBL.setEventAvgCost(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===========各部门处理工单数量趋势分析操作结束===========");
		}
		return mapping.findForward(forward);
	}

}
