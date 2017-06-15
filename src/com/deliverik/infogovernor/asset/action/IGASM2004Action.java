/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.action;


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

import com.deliverik.framework.asset.model.EiDomainDetailInfo;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCondImpl;
import com.deliverik.framework.asset.model.entity.ImportVersionTB;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.asset.bl.IGASM20BL;
import com.deliverik.infogovernor.asset.dto.IGASM20DTO;
import com.deliverik.infogovernor.asset.form.IGASM2004Form;
import com.deliverik.infogovernor.asset.vo.IGASM20041VO;

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

public class IGASM2004Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGASM2004Action.class);
	
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
		IGASM2004Form form = (IGASM2004Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGASM20BL ctlBL = (IGASM20BL) getBean("igasm20BL");
		//ʵ����DTO
		IGASM20DTO dto = new IGASM20DTO();
		if ("SEARCH".equals(mapping.getParameter())){
			saveToken(request);
		    /**
		     * ��ȡȫ���ʲ�
		     */
			ImportVersionSearchCondImpl cond = new ImportVersionSearchCondImpl();
			cond.setDeleteflag_eq("0");
			List<ImportVersionInfo> otherImportVersionInfo = ctlBL.searchImportVersionAction(cond);
			
			/**
			 * ��ȡȫ��Ӧ��
			 */
			List<IG688Info> appList = ctlBL.searchAppForDomainDetail();
		  
			/**
		     * ��ȡ�ʲ�����ϸ
		     */
			form.setDeleteflag("0");
            List<EiDomainDetailInfo> astEiDomainDetailInfo = ctlBL.searchEiDomainDetailAction(form);
	
            List<ImportVersionInfo> ownImportVersion = new ArrayList<ImportVersionInfo>();
            if(astEiDomainDetailInfo.size()>0){
            	form.setUpdatetime(astEiDomainDetailInfo.get(0).getEiDomainDefTB().getUpdatetime());
            }          	
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
						ImportVersionTB importversion = new ImportVersionTB();
						importversion.setImpeiname(appList.get(j).getEiname());
						importversion.setImpversion(0);
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
				ImportVersionTB importversion = new ImportVersionTB();
				importversion.setImpeiname(appList.get(i).getEiname());
				importversion.setImpversion(0);
				otherImportVersionInfo.add(importversion);
			}
			//����VO
			IGASM20041VO vo = new IGASM20041VO(ownImportVersion,otherImportVersionInfo);
			super.<IGASM20041VO>setVO(request, vo);

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
