package com.deliverik.infogovernor.asset.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.asset.EntityCategory;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.bl.IGASM50BL;
import com.deliverik.infogovernor.asset.dto.IGASM50DTO;
import com.deliverik.infogovernor.asset.form.IGASM5001Form;
import com.deliverik.infogovernor.asset.vo.IGASM50011VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * �ĵ���ѯ����Action����
 *
 */
public class IGASM5001Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM5001Action.class);

	/**
	 * �¼�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGASM5001Form form = (IGASM5001Form)actionForm;
		//BLȡ��
		IGASM50BL ctlBL = (IGASM50BL) getBean("igasm50BL");
		//DTO����
		IGASM50DTO dto = new IGASM50DTO();
		
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM5001");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//�ĵ���ѯ����
			log.debug("========�ĵ���ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM5001Form) req.getSession().getAttribute("IGASM5001Form");
				if ( form== null){
					form = new IGASM5001Form();
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DOCUMENT);
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
					form = (IGASM5001Form) req.getSession().getAttribute("IGASM5001Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DOCUMENT);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM5001");
			form.setEsyscoding(CommonDefineUtils.ENTIY_CATEGORY_DOCUMENT_SYSCODING_SYSTEM);
			//DTO��������趨
			dto.setEntityItemVWSearchCond(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//�ĵ������߼�����
			dto = ctlBL.searchEntityItemAction(dto);
			//Ԥ��ֵ
			if(StringUtils.isEmpty(form.getEiorgsyscoding())){
			form.setEiorgsyscoding(dto.getOrgsyscoding());
			}
			if(StringUtils.isEmpty(form.getEiorgname())){
			form.setEiorgname(dto.getOrgname());
			}
			if(StringUtils.isEmpty(form.getEname())){
				form.setEname(dto.getEname());
			}
			if(StringUtils.isEmpty(form.getEsyscoding())){
				form.setEsyscoding(dto.getEsyscoding());
			}
			//���ĵ���Ϣ��������趨��VO��
			IGASM50011VO vo = new IGASM50011VO(dto.getEntityItemVWInfoList());
			super.<IGASM50011VO>setVO(req, vo);
			
			log.debug("========�ĵ���ѯ��������========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//�ĵ�ɾ������
			log.debug("========�ĵ�ɾ������ʼ========");
			//DTO��������趨
			dto.setDeleteEntityItem(form.getDeleteEiid());
			//�ĵ���Ϣɾ���߼�����
			ctlBL.deleteEntityItemAction(dto);
			log.debug("========�ĵ�ɾ����������========");
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
