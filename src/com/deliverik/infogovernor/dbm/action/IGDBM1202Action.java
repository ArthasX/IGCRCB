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
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 科技运行综合分析二
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDBM1202Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGDBM1202Action.class);
		//BL取得
		IGDBM12BL ctlBL = (IGDBM12BL) getBean("igdbm12BL");
		//实例化dto
		IGDBM12DTO dto = new IGDBM12DTO();
		//dto参数设定
		dto.setForm(actionForm);
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("=============科技运行综合分析二页面初始化操作开始===============");
			log.debug("=============科技运行综合分析二页面初始化操作结束===============");
			return mapping.findForward("DISP");
		}
		//工单各类别数量占比
		if("GETWORKORDER".equals(mapping.getParameter())){
			log.debug("================工单个类别数量占比数据取得操作开始===============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				dto = ctlBL.getWorkOrderAction(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("================工单个类别数量占比数据取得操作结束===============");
		}
		//变更结果占比
		if("CHANGERESULT".equals(mapping.getParameter())){
			log.debug("=============变更结果占比统计数据取得操作开始==============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				dto = ctlBL.getChangeResultAction(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("=============变更结果占比统计数据取得操作结束==============");
		}
		
		//时间趋势分析
		if("EVENTTREND".equals(mapping.getParameter())){
			log.debug("============时间趋势分析数据取得操作开始============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				dto = ctlBL.getEventTrendAction(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("============时间趋势分析数据取得操作结束============");
		}
		
		//问题解决数量对比
		if("QOTN".equals(mapping.getParameter())){
			log.debug("================问题解决数量对象数据取得操作开始==================");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				dto = ctlBL.getQotnDataAction(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("================问题解决数量对象数据取得操作结束==================");
		}
		//变更计划
		if("SETCALENDAR".equals(mapping.getParameter())){
			log.debug("===============变更计划数据取得操作开始================");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
				dto = ctlBL.setChangePlan(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===============变更计划数据取得操作结束================");
		}
		return null;
	}

}
