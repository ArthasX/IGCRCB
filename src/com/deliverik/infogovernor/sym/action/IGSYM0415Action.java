/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0415Form;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.vo.IGSYM04151VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_报表管理_报表授权ACTION
 * </p>
 * 
 * @author renxiaodi
 * @version 1.0
 */

public class IGSYM0415Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0415Action.class);
	
	/**
	 * <p>
	 * Description: 报表授权action处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author renxiaodi
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGSYM0415Form form = (IGSYM0415Form)actionForm;
		//获取BL接口实例
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		//实例化DTO
		IGSYM04DTO dto = new IGSYM04DTO();
		if ("SEARCH".equals(mapping.getParameter())){
			//报表授权查询
			log.debug("========报表授权查询处理开始========");
			saveToken(request);				
			
			dto.setIgSYM0415Form(form);
			dto.setRoleid(form.getRoleid());
			//获取角色名
		    dto = ctlBL.searchRolenameByRoleId(dto);
			//该角色已有的报表查询
			dto = ctlBL.searchRoleReportRfdidByRoleid(dto);
			//所有的报表查询
			dto = ctlBL.searchReportFileDefinition(dto);
			
			List<ReportFileDefinition> ownList = dto.getOwnReportFileDefinitionList();
			List<ReportFileDefinition> yroleList = new ArrayList<ReportFileDefinition>();
			List<ReportFileDefinition> allList = dto.getReportFileDefinitionList();

			//将未授权的报表添加到yroleList中
			int all = allList.size();
			int own = ownList.size();
			for(int i=0;i<all;i++){
				boolean k = true;
				for(int j=0;j<own;j++){
					
					if(allList.get(i).getRfdid().equals(ownList.get(j).getRfdid())){
						k = false;	
					}
					
				}
				if(k){
					yroleList.add(allList.get(i));
				}
			}

			form.setRolename(dto.getRolename());
			
			//构造VO
			IGSYM04151VO vo = new IGSYM04151VO(yroleList,ownList);
			//vo.setRoleMap(this.getRoleMap(allList));
			super.<IGSYM04151VO>setVO(request, vo);

			log.debug("========报表授权查询处理终了========");
			return mapping.findForward("DISP");
		}
		//菜单授权先删除原有的再添加
		if ("GRANT".equals(mapping.getParameter())){
			log.debug("========报表授权处理开始========");
			//删除报表
			dto.setRoleid(form.getRoleid());
			if("0".equals(form.getMode())){
				dto.setRfdids(form.getRfdidy());
				ctlBL.revokeRoleReportActionByRoleid(dto);
				addMessage(request, new ActionMessage("IGSYM0415.I002"));
			}else{//添加报表
				dto.setRfdids(form.getRfdids());
				ctlBL.grantRoleReportActionByRoleid(dto);
				addMessage(request, new ActionMessage("IGSYM0415.I001"));
			}

			log.debug("========报表授权处理终了========");
	}
	return mapping.findForward("DISP");}
		
}


