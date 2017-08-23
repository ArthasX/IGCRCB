package com.deliverik.infogovernor.crc.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
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
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.crc.bl.IGCRC02BL;
import com.deliverik.infogovernor.crc.dto.IGCRC02DTO;
import com.deliverik.infogovernor.crc.model.vo.IGCRC0301VO;
import com.deliverik.infogovernor.wkm.bl.IGWKM01BL;
import com.deliverik.infogovernor.wkm.dto.IGWKM01DTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_��������_���˹�����ѯACTION
 * </p>
 *  
 * @author zhaoziting@deliverik.com
 * @version 1.0
 */

public class IGCRC0209Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC0209Action.class);
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ʵ����FORM
		IGWKM0101Form form = (IGWKM0101Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGWKM01BL ctlBL = (IGWKM01BL) getBean("igwkm01BL");
		IGCRC02BL igcrc02bl = (IGCRC02BL) getBean("igcrc02bl");
		IGWKM01DTO dto = new IGWKM01DTO();
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setPrtype(form.getPrtype());
		//����ѯ���ͱ�ʶ�Ž�dto��
		dto.setType(form.getType());
		//�ж��Ƿ��Ƕ��Ʋ�ѯҳ��
		if(!"0".equals(form.getCustom())) {
			dto.setPdid(form.getPrpdid());//�趨���̶���ID
			//��ȡ���̲�ѯҳ·��
			dto = ctlBL.searchForwardJsp(dto);
		}

		UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
		String actname = req.getParameter("actname");//�˵�IDȡ��
		String actsortid = perm.getActsortid(actname);//��ȡָ���˵�ID��ACTSORTID
		//��ȡ�˵�����
		dto.setUserPermission(perm);
		dto.setActname(actname);
		String actlabel = ctlBL.getActionName(dto);
		        
		if(actname != null){
			actsortid = perm.getActsortid(req.getParameter("actname"));
		} else if(StringUtils.isNotEmpty(form.getActname())){
			actsortid = perm.getActsortid(form.getActname());
		}
		if(StringUtils.isNotEmpty(actsortid)){
			setSessionAttribute(req, "firstactid", actsortid.substring(0, 2));
			if(actsortid.length()>=4){
				setSessionAttribute(req, "secondactid", actsortid.substring(0,4));
		    }  
		}else{
			//��ȡ�˵�Ȩ��
			perm = (UserPermission)req.getSession().getAttribute("UserPermission");					
			//���ø����˵�
			if(perm != null) {
				actsortid = perm.getActsortid("ACT02SVC09");//��ȡָ���˵�ID��ACTSORTID
				if(StringUtils.isNotEmpty(actsortid)){
					setSessionAttribute(req, "firstactid", actsortid.substring(0, 2));
					setSessionAttribute(req, "secondactid", actsortid.substring(0, 4));
				}
			}
		}
		//��̬���ø��ݱ���ѯ 20130313 start wangtingzhi
		//�жϱ���ѯ�����Ƿ��Ѿ�����
		if(req.getSession().getAttribute("AD_ProcessInfoQueryMap")==null){
			//pdidȡ��
			if(StringUtils.isEmpty(form.getPrpdid())){
				if(req.getParameter("prpdid")!=null){
					form.setPrpdid(req.getParameter("prpdid"));
				}
			}
		    //dto�����趨
		    dto.setIgwkm0101From(form);
			ctlBL.getPivarQueryInfoAction(dto);
			req.getSession().setAttribute("AD_ProcessInfoQueryMap", dto.getProcessInfoQueryMap());
		}
				
		//�������״̬�����б�
		dto = ctlBL.searchPdid7BitAction(dto);
		List<LabelValueBean> statusBeanList = new ArrayList<LabelValueBean>();
		if (dto.getiG333InfoList() != null && dto.getiG333InfoList().size() > 0) {
			List<IG333Info> statusList = dto.getiG333InfoList();
			statusBeanList.add(new LabelValueBean());
			for (int i = 0; i < statusList.size(); i++) {
				statusBeanList.add(new LabelValueBean(statusList.get(i).getPsdname(), statusList.get(i).getPsdcode()));
			}
		}
		req.setAttribute("statusBeanList", statusBeanList);
				
				
		//��̬���ø��ݱ���ѯ 20130313 end wangtingzhi
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��ѯ���������ʾ����ʼ========");
					//Ϊ�˶�̬ȡ��ҳ���ϵĵ�����Ϣ��ӵĴ���
					
			setSessionAttribute(req, "igactionid", actsortid);
			IGCRC0301VO vo = new IGCRC0301VO();
			dto.setPrtype(form.getPrtype());
			dto.setPdid(form.getPrpdid());
			if(req.getParameter("prpdid")!=null){
				req.getSession().setAttribute("AD_prpdid", req.getParameter("prpdid"));
			}else{
				if(req.getSession().getAttribute("AD_prpdid")!=null){
					req.removeAttribute("AD_prpdid");
				}
			}
					
			dto = ctlBL.getProcessTemplate(dto);
			vo.setProcessDefinitionList(dto.getProcessDefinitionList());
			vo.setActlabel(actlabel);//��װ�����˵�����
			req.setAttribute("vo", vo);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========��ѯ���������ʾ��������========");
			//��ת������JSP
			if(StringUtils.isNotEmpty(dto.getForwardJsp())){
				return new ActionForward(dto.getForwardJsp());
			} else {
				return mapping.findForward("DISP");
			}
		}
				
		//������ѯ
		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
					
				log.debug("========������ѯ����ʼ========");
					
				if(req.getSession().getAttribute("AD_prpdid")!=null&&StringUtils.isEmpty(form.getPrpdid())){
						form.setPrpdid(String.valueOf(req.getSession().getAttribute("AD_prpdid")));
				}
					
				form.setIsWork(1);
					
				//��ȡ��ҳBean
				getPaginDTO(req,"IGWKM0101");
				PagingDTO pDto;
				pDto = (PagingDTO)req.getAttribute("PagingDTO");
					
				if ("SEARCH1".equals(mapping.getParameter())){
					//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
					form = (IGWKM0101Form) req.getSession().getAttribute("IGWKM0101Form");
					if ( form == null ) {
						form = new IGWKM0101Form();
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
						form = (IGWKM0101Form) req.getSession().getAttribute("IGWKM0101Form");
						if (form != null) {
							form.setFromCount(0);
						}
					}
				}
					
					//pDto.setFromCount(form.getFromCount());
				int maxCnt = getMaxDataCount("IGWKM0101");
				form.setUserid_q(user.getUserid());
				//�����ʶȡ��
				String orderVal = req.getParameter("orderVal");		
					
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
				IG500SearchCondImpl cond = new IG500SearchCondImpl();
				try {
					BeanUtils.copyProperties(cond,form);
				} catch (Exception e) {
					log.error("",e);
				}
				dto.setPrSearchCond(cond);
				dto.setMaxSearchCount(maxCnt);
				dto.setPagingDto(pDto);
				//����BL��ѯ
				IGCRC02DTO igcrc02dto = new IGCRC02DTO();
				igcrc02dto.setPrSearchCond(cond);
				igcrc02dto.setMaxSearchCount(maxCnt);
				igcrc02dto.setPagingDto(pDto);
				igcrc02dto.setPrtype(form.getPrtype());
					
//					dto = ctlBL.getProcessRecords(dto);	//ԭ���̲�ѯ
				igcrc02dto = igcrc02bl.getProblemProcessRecords(igcrc02dto);//�Զ������̲�ѯ

				req.setAttribute("isAdmin",dto.getIsAdmin());
				//����VO
				IGCRC0301VO vo = new IGCRC0301VO(igcrc02dto.getProblemproList());
				vo.setNameURLMap(dto.getNameURLMap());
				vo.setProcessTemplateList(dto.getProcessTemplateList());
				vo.setProcessDefinitionList(dto.getProcessDefinitionList());
				vo.setActlabel(actlabel);//��װ�����˵�����
				super.<IGCRC0301VO>setVO(req, vo);
				req.setAttribute("vo", vo);
				req.setAttribute("showFlag", form.getShowFlag());
				log.debug("========������ѯ��������========");
			}

				
		List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			//��ת������JSP
			if(StringUtils.isNotEmpty(dto.getForwardJsp())){
				return new ActionForward(dto.getForwardJsp());
			} else {
				return mapping.findForward("DISP");
			}
	}

}
