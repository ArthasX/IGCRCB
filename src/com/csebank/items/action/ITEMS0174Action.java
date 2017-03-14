package com.csebank.items.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.csebank.items.bl.ITEMS01BL;
import com.csebank.items.dto.ITEMS01DTO;
import com.csebank.items.form.ITEMS0174Form;
import com.csebank.items.util.DefineUtils;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.sym.vo.IGSYM01011VO;

/**
 * �Ե�һ֧�н����˶�����Ʒ���²�����
 * @author 
 *
 */
public class ITEMS0174Action extends BaseAction {
	
	static Log log = LogFactory.getLog(ITEMS0174Action.class);
	
	/**
	 * <p>
	 * Description: ����action����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		ITEMS0174Form form = (ITEMS0174Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		ITEMS01BL ctlBL = (ITEMS01BL) getBean("items01BL");
		//ʵ����DTO
		ITEMS01DTO dto = new ITEMS01DTO();
		
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========������ѯ���������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			
			
			log.debug("========������ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){	//������ѯ
			log.debug("========������ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(request,"ITEMS0174");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (ITEMS0174Form) request.getSession().getAttribute("ITEMS0174Form");
				if ( form== null){
					form = new ITEMS0174Form();
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
					form = (ITEMS0174Form) request.getSession().getAttribute("ITEMS0174Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("ITEMS0174");
			
			form.setOrgsuper(9);
			form.setSortType(CommonDefineUtils.SORT_BY_ORGSYSCODING);
			
			ArrayList<String> not_in_syscoding_area = new ArrayList<String>();
			String orgTemp = DefineUtils.NOT_SHOW_LIST;
			if(orgTemp!=null){
				String[] temp = orgTemp.split(",");
				if(temp!=null && temp.length>0){
					for(int i=0,j=temp.length;i<j;i++){
						not_in_syscoding_area.add(temp[i]);
					}
				}
			}

			form.setNot_in_syscoding_area(not_in_syscoding_area);
			form.setXbtype(DefineUtils.XB_TYPE_ZHIH);//ֻ�ɼ�֧��
			form.setIs_in_use("1");
			dto.setItems0174form(form);
			
			dto.setOrganizationSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchOrganizationAction(dto);

			request.setAttribute("nameMap", dto.getCompletenameMap());
			//����VO
			IGSYM01011VO vo = new IGSYM01011VO(dto.getOrganizationCondList());
			vo.setTreeNodeMap(dto.getTreeNodeMap());
			super.<IGSYM01011VO>setVO(request, vo);
			log.debug("========������ѯ��������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
