/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.drm.bl.IGDRM04BL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0402Form;
import com.deliverik.infogovernor.drm.vo.IGDRM04021VO;
import com.google.gson.Gson;


/**
 * Ӧ����Դ��ѯAction
 * @author �Ž�
 *
 * 2015-2-12 ����9:51:47
 */
public class IGDRM0402Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0402Action.class);

	/**
	 * 
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
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		//BLȡ��
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		
		IGDRM0402Form form = (IGDRM0402Form)actionForm;
		
		//DTO����
		IGDRM04DTO dto = new IGDRM04DTO();
		dto.setIgdrm0402Form(form);
		dto.setUser(user);
		dto.setResourceType(form.getResourceType());
		req.setAttribute("resourceType", req.getParameter("resourceType"));
		//Ԥ��Gson
		Gson g = new Gson();
		
		//������ת�趨
		String forward = "DISP";
		if ("DISP".equals(mapping.getParameter())){
			//ҳ���ʼ��
			log.debug("========ҳ���ʼ����ʼ========");
			dto.setRootEsyscoding("000");
			dto.setResourceType(req.getParameter("resourceType"));
			ctlBL.initNewNodeMap(dto);
			req.setAttribute("ercode", form.getErcode());
			req.setAttribute("erid", form.getErid());
			req.setAttribute("esyscode", form.getEsyscoding());
			
			IGDRM04021VO vo = new IGDRM04021VO();
			
			vo.setNodeMapJson(g.toJson(dto.getNodeMap()));
			
			super.<IGDRM04021VO>setVO(req, vo);
			log.debug("========ҳ���ʼ����������========");
		}
	
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//���̶����ѯ����
			log.debug("========Ӧ����Դ��ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGDRM0401");
			
			
			log.info("canshu >>>"+req.getParameter("resourceType"));
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDRM0402Form) req.getSession().getAttribute("IGDRM0402Form");
				if ( form == null ) {
					form = new IGDRM0402Form();
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
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGDRM0402");
			
			dto.setIgdrm0402Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);

			dto = ctlBL.searchEmergencyResource(dto);
//			if(StringUtil.isEmpty(form.getEiinsdate())){
//				Calendar cal = Calendar.getInstance();
//				int year = cal.get(Calendar.YEAR);
//				req.setAttribute("eiinsdate", year);
//			}else{
//				req.setAttribute("eiinsdate", form.getEiinsdate());
//			}
			IGDRM04021VO vo = new IGDRM04021VO();
			
			vo.setEntityVWItemList(dto.getEntityVWItemList());
			
			vo.setNodeMapJson(g.toJson(dto.getNodeMap()));
			
			super.<IGDRM04021VO>setVO(req, vo);
			
			if(StringUtils.isNotEmpty(form.getOpenFlag())) forward = "OPEN";
			log.info("========Ӧ����Դ��ѯ��������========");
		}
//		if ("DELETE".equals(mapping.getParameter())){
//			//�ĵ�ɾ������
//			log.debug("========Ӧ����Դɾ������ʼ========");
//			
//			dto.setIgdrm0402Form(form);
//			
//			//DTO��������趨
//			dto.setDeleteEntityItem(form.getDeleteEiid());
//			
//			//�ĵ���Ϣɾ���߼�����
//			ctlBL.deleteEntityItemAction(dto);
//			
//			log.debug("========Ӧ����Դɾ����������========");
//		}
		
		if( "ENTITY_DISP".equals(mapping.getParameter())){
			
			req.setAttribute("erid",form.getErid());
			req.setAttribute("ercode", form.getErcode());
			getPaginDTO(req,"IGDRM0401");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0301");
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			//DTO��������趨
			dto.setIgdrm0402Form(form);
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�ʲ������߼�����
			dto = ctlBL.searchEntityDisp(dto);
			
			//���ʲ���Ϣ��������趨��VO��
			IGDRM04021VO vo = new IGDRM04021VO();
			vo.setEntityVWItemList(dto.getEntityItemVWInfoList());
			super.<IGDRM04021VO>setVO(req, vo);
		}
		
		if( "ENTITY_SEARCH".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGDRM0401");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//�ʲ���ѯ����
			log.debug("========�ʲ���ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDRM0402Form) req.getSession().getAttribute("IGDRM0402Form");
				if ( form == null ) {
					form = new IGDRM0402Form();
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
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0301");
			
			//DTO��������趨
//			dto.setEntityItemVWSearchCond(form);
			dto.setIgdrm0402Form(form);
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�ʲ������߼�����
			dto = ctlBL.searchEntityItemAction(dto);
			form = dto.getIgdrm0402Form();
			//���ʲ���Ϣ��������趨��VO��
			IGDRM04021VO vo = new IGDRM04021VO();
			vo.setEntityVWItemList(dto.getEntityItemVWInfoList());
			super.<IGDRM04021VO>setVO(req, vo);
			
			log.debug("========�ʲ���ѯ��������========");
		}
		if ("RELATION".equals(mapping.getParameter())){
			//�����ʲ�
			log.debug("========Ӧ����Դ�����ʲ�����ʼ========");
			
			//DTO��������趨
			dto.setIgdrm0402Form(form);
			dto.setRelationEiid(form.getRelationEiid());
			
			//Ӧ����Դ�����ʲ��߼�����
			ctlBL.setRelationAction(dto);
			req.setAttribute("status", "close");
			log.debug("========Ӧ����Դ�����ʲ���������========");
		}
		if ("DELETE_RELATION".equals(mapping.getParameter())){
			//�ĵ�ɾ������
			log.debug("========Ӧ����Դɾ������ʼ========");
			
			dto.setIgdrm0402Form(form);
			
			//DTO��������趨
			dto.setDeleteEntityItem(form.getDeleteEiid());
			
			//�ĵ���Ϣɾ���߼�����
			ctlBL.deleteRelationAction(dto);
			
			log.debug("========Ӧ����Դɾ����������========");
		}
		if("AJAX".equals(mapping.getParameter())){
			log.debug("============ajax�鿴�Ƿ��й������ʲ���ʼ=============");
			
			//DTO��������趨
			Integer erid = form.getErid();
			
			PrintWriter out = null;
			try {
				boolean flag = ctlBL.searchRelationAjaxAction(erid);
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                out.print(flag);
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
			
			log.debug("==============ajax�鿴�Ƿ��й������ʲ�����=============");
			
			return null;
			
		}
		
		if("GETCOUNT".equals(mapping.getParameter())){
			log.debug("===============��ȡ��������������ʼ===============");
			PrintWriter out = null;
			try {
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "UTF-8"));
				dto = ctlBL.getTreeNodeNameCountAction(dto);
				out.print(dto.getAjaxResult());
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			log.debug("===============��ȡ����������������===============");
			return null;
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}

		return mapping.findForward(forward);
	}
	
}
