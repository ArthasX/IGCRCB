/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.drm.bl.IGDRM10BL;
import com.deliverik.infogovernor.drm.dto.IGDRM10DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1003Form;
import com.deliverik.infogovernor.drm.vo.IGDRM10031VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��֯�ܹ�Action����
 * </p>
 * 
 * @author zyl
 */

public class IGDRM1003Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1003Action.class);

	/**
	 * ���ݷ����б���Action����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGDRM1003Form form = (IGDRM1003Form)actionForm;
		//BLȡ��
		IGDRM10BL ctlBL = (IGDRM10BL) getBean("igdrm10BL");
		
		//DTO����
		IGDRM10DTO dto = new IGDRM10DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//���ݷ����б��������ʾ����
			log.debug("========���ݷ����б��������ʾ����ʼ========");
			
			getPaginDTO(req,"IGDRM1003");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGDRM1003");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);

			//���˴���
			String orgFlag = req.getParameter("orgFlag");
			dto.setOrgFlag(orgFlag);
			
			dto = ctlBL.initIGDRM1003Action(dto);
			
			IGDRM10031VO vo = new IGDRM10031VO(dto.getCodeCategoryDefInfoList());
			
			saveToken(req);	
			req.setAttribute("orgFlag", orgFlag);
			super.<IGDRM10031VO>setVO(req, vo);
			
			log.debug("========���ݷ����б��������ʾ��������========");
		}else if("INSERTDISP".equals(mapping.getParameter())){
			log.debug("========���ݷ���Ǽǻ��������ʾ����ʼ========");
			saveToken(req);	
			log.debug("========���ݷ���Ǽǻ��������ʾ��������========");
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========���ݷ���ǼǴ���ʼ========");
			dto.setIgdrm1003Form(form);
			if (isTokenValid(req, true)){
				//����BL����
				dto = ctlBL.saveIGDRM1003Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========���ݷ���ǼǴ�������========");
		}else if ("DEL".equals(mapping.getParameter())){
			//���ݷ���ɾ������
			log.debug("========���ݷ���ɾ������ʼ========");

			//DTO��������趨
			dto.setIgdrm1003Form(form);
			
			if (isTokenValid(req, true)){
				//���ݷ���ɾ���߼�����
				ctlBL.deleteIGDRM1003Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			log.debug("========���ݷ���ɾ����������========");
		}else if("VIEW".equals(mapping.getParameter())){
			//���ݷ����б��������ʾ����
			log.debug("========���ݷ����б��������ʾ����ʼ========");
			dto.setSyscoding(req.getParameter("syscoding"));
			dto = ctlBL.initIGDRM1007Action(dto);
			dto = ctlBL.searchCodeDetailDef(dto);
			dto = ctlBL.searchRoleAndUser(dto);
			IGDRM10031VO vo = new IGDRM10031VO(dto.getCodeCategoryDefInfoList());
			vo.setCodeCategoryDefInfo(dto.getCodeCategoryDefInfo());
			vo.setCodeDetailDefInfoList(dto.getCodeDetailDefList());
			vo.setStructureRoleList(dto.getStructureRoleList());
			vo.setUserRoleMap(dto.getUserRoleMap());
			vo.setOrgArr(dto.getOrgArr());
			saveToken(req);	
			super.<IGDRM10031VO>setVO(req, vo);
			log.debug("========���ݷ����б��������ʾ��������========");
		} else if ("EXPORT".equals(mapping.getParameter())) {
			log.info("=============������֯�ܹ��б�ʼ===============");
			dto = ctlBL.searchRoleAndUser(dto);
			res.reset();// ��������

			res.setHeader("Content-disposition", "attachment; filename=" + new String("Ӧ����֯����".getBytes("gb2312"), "8859_1") + ".xls");// �趨����ļ�ͷ
			res.setContentType("application/msexcel");
			dto.setOps(res.getOutputStream());

			ctlBL.exportOrgTree(dto);

			log.info("=============������֯�ܹ��б����===============");
			return null;
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
