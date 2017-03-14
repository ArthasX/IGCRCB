/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0111Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01111VO;

/**
 * @Description: 流程图查看Action
 * @Author  
 * @History 2010-9-13     新建 
 * @Version V1.0
 */
public class IGPRR0111Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRR0111Action.class);

	/**
	 * 流程处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.debug("========查看流程图处理开始========");
		//FORM取得
		IGPRR0111Form form = (IGPRR0111Form)actionForm;
		
		//BL取得
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		
		String forward = "DISP";
		
		//DTO生成
		IGPRR01DTO dto = new IGPRR01DTO();
		//流程ID，处理页面使用
		dto.setPrid(form.getPrid());
		//流程定义ID，发起页面使用
		dto.setPdid(form.getPdid());
		//流程状态ID，发起页面使用
		dto.setPsdid(form.getPsdid());
		if("FLOWXML".equals(mapping.getParameter())){
			//流程图查询
			dto = ctlBL.searchFlowChartXmlAction(dto);
			//VO生成
			IGPRR01111VO vo = new IGPRR01111VO();
			vo.setFlowChartXml(dto.getFlowChartXml());
			vo.setXmlheight(dto.getXmlheight());
			super.<IGPRR01111VO>setVO(req, vo);
			forward = "FLOWXML";
			log.debug("========查看流程图处理终了========");
		}
		if("CHILDFLOWXML".equals(mapping.getParameter())){
			log.debug("=========子流程流程图信息查询操作开始=========");
			PrintWriter out = null;
			try {
				dto = ctlBL.searchChileFlowChartAction(dto);
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				if(StringUtils.isNotEmpty(dto.getFlowChartXml())){
					out.print(dto.getFlowChartXml());
				}
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("=========子流程流程图信息查询操作结束=========");
			return null;
		}
		if("GETSERIAL".equals(mapping.getParameter())){
			log.debug("=========根据流程prid获取流程工单号开始=========");
			PrintWriter out = null;
			try {
				dto = ctlBL.searchSerialNum(dto);
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				if(StringUtils.isNotEmpty(dto.getSerialNum())){
					out.print(dto.getSerialNum());
				}
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("=========根据流程prid获取流程工单号结束=========");
			return null;
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		
		return mapping.findForward(forward);
	}
	
	

}
