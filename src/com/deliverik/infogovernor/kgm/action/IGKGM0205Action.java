/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.action;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0203Form;
import com.deliverik.infogovernor.kgm.vo.IGKGM02051VO;

/**
 * ����:֪ʶ���ѯAction
 * ����������֪ʶ���ѯAction
 * ������¼��wangxiaoqiang 2010/12/07
 * �޸ļ�¼��
 */
public class IGKGM0205Action extends BaseAction {

	static Log log = LogFactory.getLog(IGKGM0205Action.class);

	/**
	 * ����
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
		//FORMȡ��
		IGKGM0203Form form = (IGKGM0203Form)actionForm;
		
		//BLȡ��
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		
		//DTO����
		IGKGM03DTO dto = new IGKGM03DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//֪ʶ��ѯ���������ʾ����
			log.debug("========֪ʶ��ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========֪ʶ��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}  else if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			//֪ʶ��ѯ����
			log.debug("========֪ʶ��ѯ����ʼ========");
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGKGM0203");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGKGM0203Form) req.getSession().getAttribute("IGKGM0203Form");
				if ( form == null ) {
					form = new IGKGM0203Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGKGM0203Form) req.getSession().getAttribute("IGKGM0203Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//����ʼ
			//�����ʶȡ��
			String orderVal = req.getParameter("orderVal");		
			if(StringUtils.isEmpty(form.getSelectstatus())){
				return mapping.findForward("DISP");
			}
			//��ҳʱ���������ʶ
			if(StringUtils.isNotEmpty(orderVal)){
				form.setOrder(orderVal);
			}
			//����Ĭ�ϵ�����
			else{
				if(StringUtils.isEmpty(form.getOrder()))
				{
					form.setOrder("knserial");
				}
				if(StringUtils.isEmpty(form.getSing())){
					form.setSing("DESC");
				}
			}

			//�趨����ʽ
			if(StringUtils.isNotEmpty(form.getOrder())){
			if(StringUtils.isNotEmpty(orderVal)){
				if(orderVal.equals(form.getOrder())){
					if("DESC".equals(form.getSing())){
						form.setSing("ASC");
					}else{
						form.setSing("DESC");
					}
				}else{
					form.setSing("ASC");
				}
			  }
			}
			if(StringUtils.isEmpty(orderVal)){
				form.setOrder(form.getOrder());
			}else{
				form.setOrder(orderVal);
			}
			
			
			//�������
			
			int maxCnt = getMaxDataCount("IGKGM0106");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//DTO��������趨
			dto.setIgkgm0203Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//֪ʶ��Ϣ�����߼�����
			dto = ctlBL.searchKnowLedgeInfoAction(dto);
			
			//��֪ʶ������Ϣ��������趨��VO��
			IGKGM02051VO vo = new IGKGM02051VO();
			vo.setKnowLedgeInfoList(dto.getKnowLedgeInfoList());
			super.<IGKGM02051VO>setVO(req, vo);
			req.setAttribute("showFlag", form.getShowFlag());
			log.debug("========֪ʶ��ѯ��������========");
		} else if ("READ".equals(mapping.getParameter())){
			//֪ʶ��Ϣ�鿴
			log.debug("========֪ʶ��ϸ��Ϣ�鿴����ʼ========");
			
			//��ѯ������ϸ
			String knid = req.getParameter("knid");
			//�趨֪ʶID
			dto.setKnid(Integer.valueOf(knid));
			//�趨֪ʶ�汾��
			String knversion = req.getParameter("knversion");
			
			dto.setKnversion(Integer.valueOf(knversion));
			
			IGKGM02BL igkgm02BL = (IGKGM02BL) getBean("igkgm02BL");

			dto = igkgm02BL.searchKnowledgeDetailAction(dto);
			
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
			dto = ctlBL.getKnowledgeAppImpact(dto);
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
			
			//�����Ƿ���û�ύ�ĸ��¼�¼��total=0��ʾû�У�total>0��ʾ��
			dto = ctlBL.searchKnowledgeNotCheckActionForKGMDis(dto);
			req.setAttribute("versions", dto.getVersions());
			//������ʾ��Ϣ
			IGKGM02051VO vo = new IGKGM02051VO();
			vo.setKnowledge(dto.getKnowledge());
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
			vo.setKnowledgeAppImpactList(dto.getKnowledgeAppImpactList());
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
			if(dto.getKnowledgeProcessList()!=null && dto.getKnowledgeProcessList().size()>0){
				vo.setKnowledgeProcessList(dto.getKnowledgeProcessList());				
			}
			
			//������ʷ������ʾ start leexuzhi 2011/03/28
			int maxCnt = getMaxDataCount("IGKGM0207");
			 dto.setMaxSearchCount(maxCnt);
		
			 dto.setKnid(Integer.valueOf(knid));
			 //��ѯ֪ʶ���ֽ��
			 dto = ctlBL.searchKnowledgeGradeAction(dto);
			 vo.setKnowledgeGradeList(dto.getKnowledgeGradeList());
			 
			//������ʷ������ʾ end leexuzhi 2011/03/28
			super.<IGKGM02051VO> setVO(req.getSession(), vo);		
			log.debug("========֪ʶ��ϸ��Ϣ�鿴��������========");
		}  else if("HISTORY".equals(mapping.getParameter())){
			log.debug("========֪ʶ��ʷ��¼�鿴����ʼ========");
			String knid = req.getParameter("knid");
			
			dto.setKnid(Integer.valueOf(knid));
			
			dto = ctlBL.searchKnowledgeHistory(dto);
			
			IGKGM02051VO vo = new IGKGM02051VO();
			vo.setVoList(dto.getVoList());
			vo.setKnowledgeList(dto.getKnowledgeList());
			super.<IGKGM02051VO> setVO(req.getSession(), vo);
			log.debug("========֪ʶ��ʷ��¼�鿴�������========");
		}	else if("PROCESSANDSERVICE".equals(mapping.getParameter())){
			log.debug("=========���̹���֪ʶ�鿴����ʼ========");
			String knid = req.getParameter("knid");
			
			dto.setKnid(Integer.valueOf(knid));
			
			dto = ctlBL.searchKnowledgeProcessByKnid(dto);
			
			if(dto.getKnowledgeProcessList() == null && dto.getKnowledgeProcessList().size()<=0){
				addMessage(req, new ActionMessage("IGKGM0205.I001"));
			}
			
			IGKGM02051VO vo = new IGKGM02051VO();
			
			vo.setKnowledgeProcessList(dto.getKnowledgeProcessList());
			super.<IGKGM02051VO> setVO(req.getSession(), vo);
			log.debug("========���̹���֪ʶ�鿴�������========");
		} else if ("PRINT".equals(mapping.getParameter())){
			//֪ʶ��Ϣ�鿴
			log.debug("========֪ʶ��ϸ��Ϣ�鿴����ʼ========");
			
			//��ѯ������ϸ
			//�趨֪ʶID
			String knid = req.getParameter("knid");
			dto.setKnid(Integer.valueOf(knid));
			
			//�趨֪ʶ�汾��
			String knversion = req.getParameter("knversion");
			dto.setKnversion(Integer.valueOf(knversion));
			
			IGKGM02BL igkgm02BL = (IGKGM02BL) getBean("igkgm02BL");
			dto = igkgm02BL.searchKnowledgeDetailAction(dto);
			
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
			dto = ctlBL.getKnowledgeAppImpact(dto);
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
			
			//������ʾ��Ϣ
			IGKGM02051VO vo = new IGKGM02051VO();
			vo.setKnowledge(dto.getKnowledge());
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
			vo.setKnowledgeAppImpactList(dto.getKnowledgeAppImpactList());
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
			//�ο�����
//			if(dto.getKnowledgeProcessList()!=null && dto.getKnowledgeProcessList().size()>0){
//				vo.setKnowledgeProcessList(dto.getKnowledgeProcessList());				
//			}
			super.<IGKGM02051VO> setVO(req.getSession(), vo);		
			log.debug("========֪ʶ��ϸ��Ϣ�鿴��������========");
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
