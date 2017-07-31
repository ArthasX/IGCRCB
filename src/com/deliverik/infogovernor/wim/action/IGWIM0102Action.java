/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wim.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.wim.bl.IGWIM01BL;
import com.deliverik.infogovernor.wim.dto.IGWIM01DTO;
import com.deliverik.infogovernor.wim.form.IGWIM0102Form;
import com.deliverik.infogovernor.wim.vo.IGWIM01012VO;
import com.google.gson.Gson;

/**
 * 
 * @Description �������ѯ��ɾ��Action
 *
 * @date 2017��6��14��
 *
 * @author wangliang@deliverik.com
 *
 * @version 1.0
 *
 */
public class IGWIM0102Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGWIM0101Action.class);

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//Formȡ��
		IGWIM0102Form form = (IGWIM0102Form) actionForm;
		//BLȡ��
		IGWIM01BL ctlBL  = (IGWIM01BL) getBean("igwim01BL");
		//DTO����
		IGWIM01DTO dto = new IGWIM01DTO();
		//��ȡ��¼�û�
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//��½�û�����
		dto.setUser(user);
		//����Form
		dto.setIgwim0102Form(form);
		
		if("DISP".equals(mapping.getParameter())){
			
			log.info("==========������Action��ʼ����ʾ��ʼ==========");
			//��ҳ��DTOȡ��
			getPaginDTO(request,"IGWIM0102");
			//ʵ����VO
			IGWIM01012VO vo = new IGWIM01012VO();
			
			super.<IGWIM01012VO>setVO(request, vo);
			
			log.info("==========������Action��ʼ����ʾ����==========");
			
		}else if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			
			log.info("==========�������ѯ����Action��ʼ==========");
			
			//��ҳ��DTOȡ��
			getPaginDTO(request,"IGWIM0102");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGWIM0102Form) request.getSession().getAttribute("IGWIM0102Form");
				if ( form == null ) {
					
					form = new IGWIM0102Form();
				}else {
					
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			}else {
				if (request.getParameter("PAGING") == null) {
					
					pDto.setFromCount(0);
					form = (IGWIM0102Form) request.getSession().getAttribute("IGWIM0102Form");
					
					if (form !=null) {
						form.setFromCount(0);
					}
				 }
			}
			
			//��ȡ������������
			int maxCnt = getMaxDataCount("IGWIM0102");
			
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			
			//���÷�ҳDTO
			dto.setPagingDto(pDto);
			
			//����bl���ݼ���
			ctlBL.searchWorkDefinition(dto);

			//ʵ����IGWIM01012VO
			IGWIM01012VO vo = new IGWIM01012VO();
			vo.setIgwim0102Form(form);
			
			//������
			vo.setDefinitionInfos(dto.getDefinitionInfos());
			
			super.<IGWIM01012VO>setVO(request,vo);
			
			log.info("==========�������ѯ����Action����==========");
			
		}else if ("DELETE".equals(mapping.getParameter())){
			log.debug("========������ɾ��Action����ʼ========");
			
			//ȡ�������
			PrintWriter out = null;
			try {
				//���������ʽ
				out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"utf-8"));
				//DTO��������趨
				dto.setDeleteEntityItem(form.getDeleteEiid());
				//��������Ϣɾ���߼�����
				ctlBL.deleteWorkDefinitoinAction(dto);
				//ʵ����Gson
				Gson gson = new Gson();
				//������ʾ��Ϣ
				out.print(gson.toJson(dto.getMsg()));
				
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
				e.printStackTrace();
			}finally {
				
				if(out!=null){
					out.close();
				}
			}
			log.debug("========������ɾ��Action�������========");
			
			return null;
		}else if("IMPORT".equals(mapping.getParameter())){
			log.debug("=============���������ݵ���Action��ʼ=================");
			try{
				ctlBL.importData(dto);
			}catch(Exception e){
				
			}
			log.debug("=============���������ݵ���Action����=================");
		}
		
		return mapping.findForward("DISP");
	}
}
