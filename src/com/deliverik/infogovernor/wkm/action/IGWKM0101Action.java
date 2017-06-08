/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wkm.action;

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
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.wkm.bl.IGWKM01BL;
import com.deliverik.infogovernor.wkm.dto.IGWKM01DTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;
import com.deliverik.infogovernor.wkm.vo.IGWKM01011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_��������_���˹�����ѯACTION
 * </p>
 *
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

public class IGWKM0101Action extends BaseAction {

    static Log log = LogFactory.getLog(IGWKM0101Action.class);

    /**
     * <p>
     * Description: ���˹���action����
     * </p>
     *
     * @param mapping  ActionMapping
     * @param form     ActionForm
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception
     * @author sunkaiyu@deliverik.cjom
     * @update
     */

    @Override
    public ActionForward doProcess(ActionMapping mapping,
                                   ActionForm actionForm, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        // ʵ����FORM
        IGWKM0101Form form = (IGWKM0101Form) actionForm;
        // ��ȡBL�ӿ�ʵ��
        IGWKM01BL ctlBL = (IGWKM01BL) getBean("igwkm01BL");
        IGWKM01DTO dto = new IGWKM01DTO();
        User user = (User) request.getSession().getAttribute(
                SESSION_KEY_LOGIN_USER);
        dto.setPrtype(form.getPrtype());
        // ����ѯ���ͱ�ʶ�Ž�dto��
        dto.setType(form.getType());
        // �ж��Ƿ��Ƕ��Ʋ�ѯҳ��
        if (!"0".equals(form.getCustom())) {
            dto.setPdid(form.getPrpdid());// �趨���̶���ID
            // ��ȡ���̲�ѯҳ·��
            dto = ctlBL.searchForwardJsp(dto);
        }
        UserPermission perm = (UserPermission) request.getSession()
                .getAttribute("UserPermission");
        String actname = request.getParameter("actname");// �˵�IDȡ��
        String actsortid = perm.getActsortid(actname);// ��ȡָ���˵�ID��ACTSORTID
        // ��ȡ�˵�����
        dto.setUserPermission(perm);
        dto.setActname(actname);
        String actlabel = ctlBL.getActionName(dto);
        
		if(actname != null){
			actsortid = perm.getActsortid(request.getParameter("actname"));
		} else if(StringUtils.isNotEmpty(form.getActname())){
			actsortid = perm.getActsortid(form.getActname());
		}
		if(StringUtils.isNotEmpty(actsortid)){
			setSessionAttribute(request, "firstactid", actsortid.substring(0, 2));
			if(actsortid.length()>=4){
				setSessionAttribute(request, "secondactid", actsortid.substring(0,4));
			}
		}else{
			//��ȡ�˵�Ȩ��
			perm = (UserPermission)request.getSession().getAttribute("UserPermission");
			
			//���ø����˵�
			if(perm != null) {
				actsortid = perm.getActsortid("ACT02SVC09");//��ȡָ���˵�ID��ACTSORTID
				if(StringUtils.isNotEmpty(actsortid)){
					setSessionAttribute(request, "firstactid", actsortid.substring(0, 2));
					setSessionAttribute(request, "secondactid", actsortid.substring(0, 4));
				}
			}
		}
		//��̬���ø��ݱ���ѯ 20130313 start wangtingzhi
		//�жϱ���ѯ�����Ƿ��Ѿ�����
		if(request.getSession().getAttribute("AD_ProcessInfoQueryMap")==null){
			//pdidȡ��
			if(StringUtils.isEmpty(form.getPrpdid())){
				if(request.getParameter("prpdid")!=null){
					form.setPrpdid(request.getParameter("prpdid"));
				}
			}
			//dto�����趨
			dto.setIgwkm0101From(form);
			ctlBL.getPivarQueryInfoAction(dto);
			request.getSession().setAttribute("AD_ProcessInfoQueryMap", dto.getProcessInfoQueryMap());
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
		request.setAttribute("statusBeanList", statusBeanList);
		
		
		//��̬���ø��ݱ���ѯ 20130313 end wangtingzhi
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��ѯ���������ʾ����ʼ========");
			//Ϊ�˶�̬ȡ��ҳ���ϵĵ�����Ϣ��ӵĴ���

            setSessionAttribute(request, "igactionid", actsortid);
            IGWKM01011VO vo = new IGWKM01011VO();
            dto.setPrtype(form.getPrtype());
            dto.setPdid(form.getPrpdid());
            if (request.getParameter("prpdid") != null) {
                request.getSession().setAttribute("AD_prpdid",
                        request.getParameter("prpdid"));
            } else {
                if (request.getSession().getAttribute("AD_prpdid") != null) {
                    request.removeAttribute("AD_prpdid");
                }
            }

            dto = ctlBL.getProcessTemplate(dto);
            vo.setProcessDefinitionList(dto.getProcessDefinitionList());
            vo.setActlabel(actlabel);// ��װ�����˵�����
            request.setAttribute("vo", vo);
            addMessage(request, new ActionMessage("IGCO10000.I003"));
            log.debug("========��ѯ���������ʾ��������========");
            // ��ת������JSP
            if (StringUtils.isNotEmpty(dto.getForwardJsp())) {
                return new ActionForward(dto.getForwardJsp());
            } else {
                return mapping.findForward("DISP");
            }
        }

        // ������ѯ
        if ("SEARCH".equals(mapping.getParameter())
                || "SEARCH1".equals(mapping.getParameter())) {

            log.debug("========������ѯ����ʼ========");

            if (request.getSession().getAttribute("AD_prpdid") != null
                    && StringUtils.isEmpty(form.getPrpdid())) {
                form.setPrpdid(String.valueOf(request.getSession()
                        .getAttribute("AD_prpdid")));
            }

            form.setIsWork(1);

            // ��ȡ��ҳBean
            getPaginDTO(request, "IGWKM0101");
            PagingDTO pDto;
            pDto = (PagingDTO) request.getAttribute("PagingDTO");

            if ("SEARCH1".equals(mapping.getParameter())) {
                // ����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
                form = (IGWKM0101Form) request.getSession().getAttribute(
                        "IGWKM0101Form");
                if (form == null) {
                    form = new IGWKM0101Form();
                } else {
                    if (request.getParameter("PAGING") == null) {
                        pDto.setFromCount(form.getFromCount());
                    } else {
                        form.setFromCount(pDto.getFromCount());
                    }
                }
            } else {

                if (request.getParameter("PAGING") == null) {
                    pDto.setFromCount(0);
                    form = (IGWKM0101Form) request.getSession().getAttribute(
                            "IGWKM0101Form");
                    if (form != null) {
                        form.setFromCount(0);
                    }
                }
            }

            // pDto.setFromCount(form.getFromCount());
            int maxCnt = getMaxDataCount("IGWKM0101");
            form.setUserid_q(user.getUserid());
            // �����ʶȡ��
            String orderVal = request.getParameter("orderVal");

            // ��ҳʱ���������ʶ
            if (StringUtils.isNotEmpty(orderVal)) {
                form.setOrder(orderVal);
            }

            // �趨����ʽ
            if (StringUtils.isNotEmpty(form.getOrder())) {
                if (StringUtils.isNotEmpty(orderVal)) {
                    if (orderVal.equals(form.getOrder())) {
                        if ("DESC".equals(form.getSing())) {
                            form.setSing("ASC");
                        } else {
                            form.setSing("DESC");
                        }
                    } else {
                        form.setSing("ASC");
                    }
                }
            } else {// �����ʶΪ��ʱĬ�ϰ�ʱ������
                form.setOrder("propentime");
                form.setSing("DESC");
            }

            // �趨���̹ر�״̬��ѯ����
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
                BeanUtils.copyProperties(cond, form);
            } catch (Exception e) {
                log.error("", e);
            }
            /*
			 * 20170602 ԭ�ȿƼ����������ֳɶ�����󣬵��ǲ�ѯ��ʱ����� Ϊ�˷���ͳ�ơ���ѯ������ѯ�ϲ������ò�ѯ����Ϊ prpdid
			 * Ϊnull ��prpdid_like_orΪ���� ��ApplicationResources
			 * SERVICE_REQUEST_COND
			 */
            if (cond.getPrpdid().equals("01100")) {
                cond.setPrpdid(null);
                cond.setPrpdid_like_or(MessageResources
                        .getMessageResources("ApplicationResources")
                        .getMessage("SERVICE_REQUEST_COND").split(","));
            }
            dto.setPrSearchCond(cond);
            dto.setMaxSearchCount(maxCnt);
            dto.setPagingDto(pDto);
            // ����BL��ѯ
            dto = ctlBL.getProcessRecords(dto);
            request.setAttribute("isAdmin", dto.getIsAdmin());
            // ����VO
            IGWKM01011VO vo = new IGWKM01011VO(dto.getProcessList());
            vo.setNameURLMap(dto.getNameURLMap());
            vo.setProcessTemplateList(dto.getProcessTemplateList());
            vo.setProcessDefinitionList(dto.getProcessDefinitionList());
            vo.setActlabel(actlabel);// ��װ�����˵�����
            super.<IGWKM01011VO>setVO(request, vo);
            request.setAttribute("vo", vo);
            request.setAttribute("showFlag", form.getShowFlag());
            log.debug("========������ѯ��������========");
        }
        if ("DEL".equals(mapping.getParameter())) {
            dto.setPrid(form.getDelprid());
            dto = ctlBL.delProcessRecord(dto);

            // ����VO
            IGWKM01011VO vo = new IGWKM01011VO(dto.getProcessList());
            vo.setActlabel(actlabel);// ��װ�����˵�����
            super.<IGWKM01011VO>setVO(request, vo);

            request.setAttribute("vo", vo);
        }

        List<ActionMessage> messageList = dto.getMessageList();
        if (messageList != null && messageList.size() > 0) {
            for (ActionMessage message : messageList) {
                addMessage(request, message);
            }
        }
        // ��ת������JSP
        if (StringUtils.isNotEmpty(dto.getForwardJsp())) {
            return new ActionForward(dto.getForwardJsp());
        } else {
            return mapping.findForward("DISP");
        }
    }
}
