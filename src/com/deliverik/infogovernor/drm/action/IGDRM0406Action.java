package com.deliverik.infogovernor.drm.action;

import java.util.List;
import java.util.Set;

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
import com.deliverik.infogovernor.drm.form.IGDRM0406Form;
import com.deliverik.infogovernor.drm.vo.IGDRM04061VO;
import com.deliverik.infogovernor.drm.vo.IGDRM04071VO;

/**
 * Ӧ����Դ  ����ҳ (ѡ��Ϳ������)
 *
 */
public class IGDRM0406Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0406Action.class);

	/**
	 * 
	 * ����
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
    @SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGDRM0406Form form = (IGDRM0406Form)actionForm;
		
		//BLȡ��
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		
		//DTO����
		IGDRM04DTO dto = new IGDRM04DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			form.setEsyscodingbegin(form.getEsyscoding());
			log.debug("========�ʲ���HELP��ѯ���������ʾ����ʼ========");
			if(StringUtils.isEmpty(form.getEname()) && StringUtils.isNotEmpty(form.getEsyscoding())){
				dto.setEsyscoding(form.getEsyscoding());
				dto = ctlBL.searchEntityNameActionSOC(dto);
				form.setEname(dto.getEname());
			}
			//���²�ѯ���������
			req.getSession().removeAttribute("ADSelectEntity");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�ʲ���HELP��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		//�鿴�ʲ���ϸ��Ϣ
		if("DETAIL".equals(mapping.getParameter())){
			
			dto.setForm(form);
			log.info("================�鿴�ʲ���ϸ��Ϣ��ʼ===================");
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto= ctlBL.getEntityFullInfo(dto);
			//������ϸ��Ϣ���������ʾ�߼�����
		
			//���豸������Ϣ��������趨��VO��
			IGDRM04071VO vo = new IGDRM04071VO(dto.getSoc0124Info(),dto.getSoc0129InfoVWMap());
			super.<IGDRM04071VO>setVO(req.getSession(), vo);
			addMessage(req, new ActionMessage("IGCO10000.I001","�ʲ�������Ϣ"));
			
			log.info("================�鿴�ʲ���ϸ��Ϣ����===================");
		}
		

		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())||"SEARCH2".equals(mapping.getParameter())){
			log.debug("========�ʲ����ѯHELP����ʼ========");

			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGDRM0406");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDRM0406Form) req.getSession().getAttribute("IGDRM0406Form");
				if ( form== null){
					form = new IGDRM0406Form();
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
					form = (IGDRM0406Form) req.getSession().getAttribute("IGDRM0406Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			form.setEistatus("0");
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGDRM0406");
			dto.setSp_eiid(form.getSp_eiid());
			dto.setMaxSearchCount(maxCnt);
			dto.setForm(form);
			
			Set<String> set = (Set<String>)req.getSession().getAttribute("ADSelectEntity");
			if(set != null && set.size() > 0) {
				form.setSelectId(set.toArray(new String[0]));
			} else {
				form.setSelectId(null);
			}
			dto.setForm(form);
			dto.setPagingDto(pDto);
				dto = ctlBL.searchEntityItem0406Action(dto);
			//���ʲ�����Ϣ��������趨��VO��
			IGDRM04061VO vo = new IGDRM04061VO(dto.getSoc0124List());
			
			super.<IGDRM04061VO>setVO(req, vo);
			
			log.debug("========�ʲ���HELP��ѯ��������========");
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
