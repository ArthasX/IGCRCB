/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_�������_������ȨACTION
 * </p>
 * 
 * @author renxiaodi
 * @version 1.0
 */

public class IGSYM0415Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0415Action.class);
	
	/**
	 * <p>
	 * Description: ������Ȩaction����
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
		//ʵ����FORM
		IGSYM0415Form form = (IGSYM0415Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		//ʵ����DTO
		IGSYM04DTO dto = new IGSYM04DTO();
		if ("SEARCH".equals(mapping.getParameter())){
			//������Ȩ��ѯ
			log.debug("========������Ȩ��ѯ����ʼ========");
			saveToken(request);				
			
			dto.setIgSYM0415Form(form);
			dto.setRoleid(form.getRoleid());
			//��ȡ��ɫ��
		    dto = ctlBL.searchRolenameByRoleId(dto);
			//�ý�ɫ���еı����ѯ
			dto = ctlBL.searchRoleReportRfdidByRoleid(dto);
			//���еı����ѯ
			dto = ctlBL.searchReportFileDefinition(dto);
			
			List<ReportFileDefinition> ownList = dto.getOwnReportFileDefinitionList();
			List<ReportFileDefinition> yroleList = new ArrayList<ReportFileDefinition>();
			List<ReportFileDefinition> allList = dto.getReportFileDefinitionList();

			//��δ��Ȩ�ı�����ӵ�yroleList��
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
			
			//����VO
			IGSYM04151VO vo = new IGSYM04151VO(yroleList,ownList);
			//vo.setRoleMap(this.getRoleMap(allList));
			super.<IGSYM04151VO>setVO(request, vo);

			log.debug("========������Ȩ��ѯ��������========");
			return mapping.findForward("DISP");
		}
		//�˵���Ȩ��ɾ��ԭ�е������
		if ("GRANT".equals(mapping.getParameter())){
			log.debug("========������Ȩ����ʼ========");
			//ɾ������
			dto.setRoleid(form.getRoleid());
			if("0".equals(form.getMode())){
				dto.setRfdids(form.getRfdidy());
				ctlBL.revokeRoleReportActionByRoleid(dto);
				addMessage(request, new ActionMessage("IGSYM0415.I002"));
			}else{//��ӱ���
				dto.setRfdids(form.getRfdids());
				ctlBL.grantRoleReportActionByRoleid(dto);
				addMessage(request, new ActionMessage("IGSYM0415.I001"));
			}

			log.debug("========������Ȩ��������========");
	}
	return mapping.findForward("DISP");}
		
}


