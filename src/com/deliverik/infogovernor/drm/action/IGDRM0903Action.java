/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.action;

import java.util.ArrayList;
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
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.IGDRM09BL;
import com.deliverik.infogovernor.drm.dto.IGDRM09DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0903Form;
import com.deliverik.infogovernor.drm.vo.IGDRM01012VO;
import com.deliverik.infogovernor.drm.vo.IGDRM09031VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: Ӧ��ָ�������б��ѯ
 * </p>
 * 
 * @version 1.0
 */

public class IGDRM0903Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGDRM0903Action.class);
	

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGDRM0903Form form = (IGDRM0903Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGDRM09BL ctlBL = (IGDRM09BL) getBean("igdrm09BL");
		IGDRM09DTO dto = new IGDRM09DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setPrtype(form.getPrtype());
		//����ѯ���ͱ�ʶ�Ž�dto��
		dto.setType(form.getType());
		//��̬���ø��ݱ���ѯ 20130313 end wangtingzhi
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��ѯ���������ʾ����ʼ========");
			//Ϊ�˶�̬ȡ��ҳ���ϵĵ�����Ϣ��ӵĴ���

			
			IGDRM01012VO vo = new IGDRM01012VO();
			dto.setPrtype(form.getPrtype());
			dto.setPdid(form.getPrpdid());
			if(request.getParameter("prpdid")!=null){
				request.getSession().setAttribute("AD_prpdid", request.getParameter("prpdid"));
			}else{
				if(request.getSession().getAttribute("AD_prpdid")!=null){
					request.removeAttribute("AD_prpdid");
				}
			}
			vo.setProcessDefinitionList(dto.getProcessDefinitionList());
			request.setAttribute("vo", vo);
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========��ѯ���������ʾ��������========");
			//��ת������JSP
			if(StringUtils.isNotEmpty(dto.getForwardJsp())){
				return new ActionForward(dto.getForwardJsp());
			} else {
				return mapping.findForward("DISP");
			}
		}
		
		
		
		if("SEL".equals(mapping.getParameter())){
			log.info("==============Ӧ��ָ�����̵���ҳ��ѯ��ʼ================");
			dto.setPrpdidLike(IGDRMCONSTANTS.DIRECT_PROCESS_DEF_ID);
			IGDRM09031VO vo = new IGDRM09031VO();
			ctlBL.searchProcess(dto);
			vo.setProcessList(dto.getProcessList());
			super.<IGDRM09031VO>setVO(request, vo);
			log.info("==============Ӧ��ָ�����̵���ҳ��ѯ����================");
		}
		
		//������ѯ
		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			
			log.debug("========������ѯ����ʼ========");
			
			
			//��ȡ��ҳBean
			getPaginDTO(request,"IGDRM0903");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDRM0903Form) request.getSession().getAttribute("IGDRM0903Form");
				if ( form == null ) {
					form = new IGDRM0903Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				request.getSession().setAttribute("IGDRM0903Form", form);
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(0);
						if (form !=null) {
							form.setFromCount(0);
						}
					  }
			}
			
			int maxCnt = getMaxDataCount("IGDRM0903");
			form.setUserid_q(user.getUserid());
			//�����ʶȡ��
			String orderVal = request.getParameter("orderVal");		
			
			//��ҳʱ���������ʶ
			if(StringUtils.isNotEmpty(orderVal)){
				form.setOrder(orderVal);
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
			}else {//�����ʶΪ��ʱĬ�ϰ�ʱ������
				form.setOrder("propentime");
				form.setSing("DESC");
			}
			
			//�趨���̹ر�״̬��ѯ����
			if ("0001".equals(form.getPrActive())) {
			   // δ�ر� 
			   form.setPrActive("Y"); 
			} else if ("0002".equals(form.getPrActive())) {
			   // �ѹر� 
			   form.setPrActive("N"); 
			}
			dto.setUser(user);
			
			dto.setIgdrm0903Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//����BL��ѯ@@
			dto = ctlBL.getProcessRecords(dto);
			List<LabelValueBean> statusBeanList = new ArrayList<LabelValueBean>();
			if (dto.getiG333InfoList() != null && dto.getiG333InfoList().size() > 0) {
				List<IG333Info> statusList = dto.getiG333InfoList();
				statusBeanList.add(new LabelValueBean());
				for (int i = 0; i < statusList.size(); i++) {
					statusBeanList.add(new LabelValueBean(statusList.get(i).getPsdname(), statusList.get(i).getPsdcode()));
				}
			}
			request.setAttribute("statusBeanList", statusBeanList);
			request.setAttribute("isAdmin",dto.getIsAdmin());
			request.setAttribute("prpdid",form.getPrpdid());
			//����VO
			IGDRM09031VO vo = new IGDRM09031VO(dto.getProcessList());
			vo.setNameURLMap(dto.getNameURLMap());
			vo.setProcessTemplateList(dto.getProcessTemplateList());
			vo.setProcessDefinitionList(dto.getProcessDefinitionList());
			super.<IGDRM09031VO>setVO(request, vo);
			
			log.debug("========������ѯ��������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		if(StringUtils.isNotEmpty(request.getParameter("jump"))){
		    request.getSession().setAttribute("jump", request.getParameter("jump"));
		}else{
		    request.getSession().removeAttribute("jump");
		}
		//��ת������JSP
		if(StringUtils.isNotEmpty(dto.getForwardJsp())){
			return new ActionForward(dto.getForwardJsp());
		} else {
			return mapping.findForward("DISP");
		}
	}
}
