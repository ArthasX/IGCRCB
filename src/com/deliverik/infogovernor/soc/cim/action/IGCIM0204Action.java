/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_��ɫ��ȨACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGCIM0204Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGCIM0204Action.class);
	
	/**
	 * <p>
	 * Description: ��ɫ��Ȩaction����
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
		//ʵ����FORM
		IGCIM0204Form form = (IGCIM0204Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		//ʵ����DTO
		IGCIM02DTO dto = new IGCIM02DTO();
		if ("SEARCH".equals(mapping.getParameter())){
			saveToken(request);
		    /**
		     * ��ȡȫ���ʲ�
		     */
			List<SOC0120Info> otherImportVersionInfo = ctlBL.searchImportVersionAction(new SOC0120SearchCondImpl());
			
			/**
			 * ��ȡȫ��Ӧ��
			 */
			List<SOC0124Info> appList = ctlBL.searchAppForDomainDetail();
		  
			/**
		     * ��ȡ�ʲ�����ϸ
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
				//��Ӧ���еķ����Լ����б�����Ӧ�����Ƴ�
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
			 * ��ʣ���Ӧ�üӽ�ȥ
			 */
			for (int i = 0; i < appList.size(); i++) {
				SOC0120TB importversion = new SOC0120TB();
				importversion.setImpeiname(appList.get(i).getEiname());
				importversion.setImpversion(appList.get(i).getEiversion());
				otherImportVersionInfo.add(importversion);
			}
			//����VO
			IGCIM02041VO vo = new IGCIM02041VO(ownImportVersion,otherImportVersionInfo);
			super.<IGCIM02041VO>setVO(request, vo);

			log.debug("========��ɫ��Ȩ��ѯ��������========");
			return mapping.findForward("DISP");
		}
		//��ɫ��Ȩ
		if ("GRANT".equals(mapping.getParameter())){
			log.debug("========��ɫ��Ȩ����ʼ========");
			//ɾ���û���ɫ
			if("0".equals(form.getMode())){
				dto.setOwneiddids(form.getOwneiddids());
				dto.setEiddid(form.getEiddid());
				dto.setEiddversion(form.getEiddversion());
				ctlBL.revokeImportVesionAction(dto);
			}else{//����û���ɫ
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

			log.debug("========��ɫ��Ȩ��������========");
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
