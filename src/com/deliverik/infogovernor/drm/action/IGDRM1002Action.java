/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.infogovernor.drm.form.IGDRM1002Form;
import com.deliverik.infogovernor.drm.vo.IGDRM10021VO;
import com.deliverik.infogovernor.drm.vo.IGDRM10022VO;

/**
 * ��������֯�ܹ���ɫ��ϵAction
 * ������������֯�ܹ���ɫ��ϵAction
 * �����ˣ�WYW
 * ������¼��2014/06/25
 * �޸ļ�¼��
 */
public class IGDRM1002Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGDRM1002Action.class);
	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse respons) throws Exception {
		//��ʼ��DTO
		IGDRM10DTO dto = new IGDRM10DTO();
		//��ʼ��form
		IGDRM1002Form form = (IGDRM1002Form)actionForm;

		
		//��ȡBL�ӿ�ʵ��
		IGDRM10BL ctlBL = (IGDRM10BL) getBean("igdrm10BL");
		//��תҳ��
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
		}
		//��ʼ�����ѯ
		else if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("==========��֯�ܹ���ɫ��ϵ��ѯ����ʼ==========");
			dto.setForm(form);
			//��ȡ��֯�ܹ���ɫ��ϵ��ʼ����Ϣ
			dto = ctlBL.initIGDRM1002Action(dto);
		     //��ʼ��vo
	        IGDRM10021VO vo = new IGDRM10021VO();
			vo.setRelationlist(dto.getRelationlist());
			vo.setCodeDetailDef(dto.getCodDetailDef());
			super.<IGDRM10021VO>setVO(request, vo);
			log.debug("==========��֯�ܹ���ɫ��ϵ��ѯ�������==========");
		}
		//�༭
		else if("EDIT".equals(mapping.getParameter())){
			log.debug("==========��֯�ܹ���ɫ��ϵ�༭��������ʼ==========");
			dto.setForm(form);
			dto = ctlBL.editIGDRM1002Action(dto);
			addMessage(request, new ActionMessage("IGDRM0601.I001","��֯�ܹ�������ɫ�����ɹ���"));
			request.setAttribute("sign", "1");
			log.debug("==========��֯�ܹ���ɫ��ϵ�༭�����������==========");
		}
		//���»���뷽��
		else if("DELETE".equals(mapping.getParameter())){
			log.debug("==========��֯�ܹ���ɫ��ϵɾ������ʼ==========");
			dto.setForm(form);
			dto = ctlBL.deleteRoleRelation(dto);
			addMessage(request, new ActionMessage("IGDRM0601.I001","��֯�ܹ�������ɫɾ���ɹ���"));
			log.debug("==========��֯�ܹ���ɫ��ϵɾ���������==========");
		}
		//�û���ѯ
		else if("ROLESEARCH".equals(mapping.getParameter())){
            //���̶����ѯ����
            log.debug("========��ɫ��ѯ��ʼ========");
            //��ҳ��DTOȡ��
            getPaginDTO(request,"IGDRM1001");
            PagingDTO pDto;
            
            pDto = (PagingDTO)request.getAttribute("PagingDTO");
            if ("SEARCH1".equals(mapping.getParameter())){
                //����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
                form = (IGDRM1002Form) request.getSession().getAttribute("IGDRM1002Form");
                if ( form == null ) {
                    form = new IGDRM1002Form();
                }else {
                    if (request.getParameter("PAGING") == null) {
                        pDto.setFromCount(form.getFromCount());
                    } else {
                        form.setFromCount(pDto.getFromCount());
                    }
                }
            } else {
                if (request.getParameter("PAGING") == null) {
                    pDto.setFromCount(0);
//                  form = (IGPRD0301Form) req.getSession().getAttribute("IGPRD0301Form");
                    if (form !=null) {
                        form.setFromCount(0);
                    }
                }
            }
            
            //��ѯ��¼������ȡ��
            int maxCnt = getMaxDataCount("IGDRM1002");
            dto.setMaxSearchCount(maxCnt);
            dto.setPagingDto(pDto);
            dto.setForm(form);
            //��ѯ
            dto = ctlBL.searchRole(dto);
            IGDRM10022VO vo = new IGDRM10022VO();
            vo.setRolelist(dto.getRolelist());
            super.<IGDRM10022VO>setVO(request, vo);
            log.debug("========��ɫ��ѯ����========");
        }
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		
	      //���˴���
        String ccid = request.getParameter("ccid");
        request.setAttribute("ccid", ccid);
        String cid = request.getParameter("cid");
        request.setAttribute("cid", cid);
        String clevel = request.getParameter("clevel");
        request.setAttribute("clevel", clevel);
		return mapping.findForward(forward);
	}
}