/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.action;


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
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0120TB;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM02BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0204Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM02041VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_授权管理_角色授权ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGCIM0204Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGCIM0204Action.class);
	
	/**
	 * <p>
	 * Description: 角色授权action处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGCIM0204Form form = (IGCIM0204Form)actionForm;
		//获取BL接口实例
		IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		//实例化DTO
		IGCIM02DTO dto = new IGCIM02DTO();
		if ("SEARCH".equals(mapping.getParameter())){
			saveToken(request);
		    /**
		     * 获取全部资产
		     */
			List<SOC0120Info> otherImportVersionInfo = ctlBL.searchImportVersionAction(new SOC0120SearchCondImpl());
			
			/**
			 * 获取全部应用
			 */
			List<SOC0124Info> appList = ctlBL.searchAppForDomainDetail();
		  
			/**
		     * 获取资产域详细
		     */
			form.setDeleteflag("0");
            List<SOC0112Info> astEiDomainDetailInfo = ctlBL.searchEiDomainDetailAction(form);
	
            List<SOC0120Info> ownImportVersion = new ArrayList<SOC0120Info>();

			for(int i=0;i<astEiDomainDetailInfo.size();i++){
				for(int j=0;j<otherImportVersionInfo.size();j++){
					if(astEiDomainDetailInfo.get(i).getEiname().equals(otherImportVersionInfo.get(j).getImpeiname())&&
					   astEiDomainDetailInfo.get(i).getEiImportversion().equals(otherImportVersionInfo.get(j).getImpversion())	
					  ){
						ownImportVersion.add(otherImportVersionInfo.get(j));
						otherImportVersionInfo.remove(j);
						break;
					}
				}
				//将应用有的放入自己的列表，并从应用中移除
				for (int j = 0; j < appList.size(); j++) {
					if(astEiDomainDetailInfo.get(i).getEiname().equals(appList.get(j).getEiname())){
						SOC0120TB importversion = new SOC0120TB();
						importversion.setImpeiname(appList.get(j).getEiname());
						importversion.setImpversion(appList.get(j).getEiversion());
						ownImportVersion.add(importversion);
						appList.remove(j);
						break;
					}
				}
			}
			/**
			 * 将剩余的应用加进去
			 */
			for (int i = 0; i < appList.size(); i++) {
				SOC0120TB importversion = new SOC0120TB();
				importversion.setImpeiname(appList.get(i).getEiname());
				importversion.setImpversion(appList.get(i).getEiversion());
				otherImportVersionInfo.add(importversion);
			}
			//构造VO
			IGCIM02041VO vo = new IGCIM02041VO(ownImportVersion,otherImportVersionInfo);
			super.<IGCIM02041VO>setVO(request, vo);

			log.debug("========角色授权查询处理终了========");
			return mapping.findForward("DISP");
		}
		//角色授权
		if ("GRANT".equals(mapping.getParameter())){
			log.debug("========角色授权处理开始========");
			//删除用户角色
			if("0".equals(form.getMode())){
				dto.setOwneiddids(form.getOwneiddids());
				dto.setEiddid(form.getEiddid());
				dto.setEiddversion(form.getEiddversion());
				ctlBL.revokeImportVesionAction(dto);
			}else{//添加用户角色
				if (isTokenValid(request, true)){
					dto.setEiddids(form.getEiddids());
					dto.setEiddid(form.getEiddid());
					dto.setEiddversion(form.getEiddversion());
					ctlBL.InsertImportVesionAction(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}

			log.debug("========角色授权处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
