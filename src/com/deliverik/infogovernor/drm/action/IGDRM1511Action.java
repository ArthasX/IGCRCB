/*
\ * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.infogovernor.drm.bl.IGDRM15BL;
import com.deliverik.infogovernor.drm.dto.IGDRM15DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1501Form;
import com.deliverik.infogovernor.drm.vo.IGDRM15011VO;



/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:��ѵ�ƻ�����Action
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM1511Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1511Action.class);

	/**
	 * 
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param res
	 * @return
	 * @throws Exception
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse res) throws Exception {
		// ���form
		IGDRM1501Form form = (IGDRM1501Form) actionForm;
		// BLȡ��
		IGDRM15BL ctlBL = (IGDRM15BL) getBean("igdrm15BL");
		// DTO����
		IGDRM15DTO dto = new IGDRM15DTO();
		//������ѯ
		dto.setIgdrm1501Form(form);
		  if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())) {
			log.debug("==============��ѵ�ƻ���ѯ��ʼ=====================");
			//��ȡ��ҳbean
			getPaginDTO(request,"IGDRM1511");
			PagingDTO pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDRM1501Form) request.getSession().getAttribute("IGDRM1501Form");
				if (form == null) {
					form = new IGDRM1501Form();
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
					form = (IGDRM1501Form) request.getSession().getAttribute("IGDRM1501Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			int maxCnt = getMaxDataCount("IGDRM1511");			
			//���ò�ѯ�������
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//����blִ�в�ѯ����
			dto=ctlBL.searchTrainplanList(dto);
			//���鵽�Ľ���ŵ�vo
			IGDRM15011VO vo = new IGDRM15011VO();
			vo.setTrainplanInfoList(dto.getTrainplanInfoList());
			super.<IGDRM15011VO>setVO(request, vo);
			log.debug("==============��ѵ�ƻ���ѯ����=====================");
		}
		
		if( "DELETE".equals(mapping.getParameter())){
			log.debug("==============��ѵ�ƻ�ɾ����ʼ=====================");
//			dto.setIgdrm1501Form(form);
			dto.setDeleteEntityItem(form.getDeleteTpid());
			ctlBL.deleteEntityItemAction(dto);
			log.debug("==============��ѵ�ƻ�ɾ������=====================");
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
