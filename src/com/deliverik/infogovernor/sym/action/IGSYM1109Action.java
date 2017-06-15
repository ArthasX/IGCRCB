/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.sym.bl.IGSYM11BL;
import com.deliverik.infogovernor.sym.dto.IGSYM11DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1109Form;
import com.deliverik.infogovernor.sym.model.Priority;
import com.deliverik.infogovernor.sym.vo.IGSYM11011VO;

/**
 * 概述: 流程优先级配置
 * 功能描述：流程优先级配置Action处理
 * 创建记录：赵俊    2010/12/14
 * 修改记录：
 */
public class IGSYM1109Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1702Action.class);

	/**
	 * 功能：流程优先级配置处理
	 * 
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGSYM1109Form form = (IGSYM1109Form)actionForm;
		
		if(StringUtils.isEmpty(form.getPprtype())){
			form.setPprtype("I");
		}
		//BL取得
		IGSYM11BL ctlBL = (IGSYM11BL) getBean("igsym11BL");
		
		//DTO生成
		IGSYM11DTO dto = new IGSYM11DTO();
		dto.setIgsym1109Form(form);
		dto.setPprtype(form.getPprtype());
		dto = ctlBL.getPrimpactAndPrurgency(dto);
		dto = ctlBL.findByPriorityCond(dto);

		
		if( "DISP".equals(mapping.getParameter())){
			//流程定义登记画面初期显示处理
			List<CodeDetail> primpactList = dto.getPrimpactList();  //影响程度
			List<CodeDetail> prurgencyList = dto.getPrurgencyList(); //紧急程度
			List<Priority> prioritieList = dto.getPrioritieList(); //优先级
			log.debug("========流程策略设定画面初期显示处理开始========");
			Map<String,String> priorityMap = new HashMap<String,String>();
			for(Priority pBean:prioritieList){
				String key = pBean.getPprtype()+pBean.getIvalue()+pBean.getUvalue();
				priorityMap.put(key,pBean.getPvalue());
			}
			
			String[][] prioritys = new String[primpactList.size()][prurgencyList.size()];
			for(int i=0;i<primpactList.size();i++){
				CodeDetail primpact = primpactList.get(i);
				for(int j=0;j<prurgencyList.size();j++){
					CodeDetail	prurgency = prurgencyList.get(j);
					String key = form.getPprtype()+primpact.getCid()+prurgency.getCid();
					prioritys[i][j] = priorityMap.get(key);
				}
			}
			form.setPvalues(prioritys);
			IGSYM11011VO vo = new IGSYM11011VO();
			vo.setPrimpactList(primpactList);
			vo.setPrimpactSize(String.valueOf(primpactList.size()));
			vo.setPrurgencyList(prurgencyList);
			vo.setPrurgencySize(String.valueOf(prurgencyList.size()));
			super.<IGSYM11011VO>setVO(req.getSession(), vo);
			
			log.debug("========流程策略设定画面初期显示处理终了========");
			
		} else if ("EDIT".equals(mapping.getParameter())){
			log.debug("========流程策略设定编辑处理开始========");
			String[][] pvalues = getPvaluesForm(dto.getPrimpactList().size(),dto.getPrurgencyList().size(),req);
			form.setPvalues(pvalues);
			ctlBL.savePriority(dto);
			addMessage(req, new ActionMessage("IGSYM1109.I001"));
			log.debug("========流程策略设定编辑处理终了========");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}

		return mapping.findForward("DISP");
	}
	
	private String[][] getPvaluesForm(int primpactSize,int prurgencySize, HttpServletRequest req){
		String[][] pvalues = new String[primpactSize][prurgencySize];
		for(int i=0;i<primpactSize;i++){
			for(int j=0;j<prurgencySize;j++){
				pvalues[i][j] = req.getParameter("pvalues["+i+"]["+j+"]");
			}
		}
		return pvalues;
	}
}
