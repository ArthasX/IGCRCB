package com.deliverik.infogovernor.drm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.drm.bl.IGDRM01BL;
import com.deliverik.infogovernor.drm.dto.IGDRM01DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0105Form;
import com.deliverik.infogovernor.drm.vo.IGDRM01151VO;
import com.google.gson.Gson;

/**
 * Ӧ���ƶȷ������
 * 
 * @author zhangjian
 * 
 *
 */
public class IGDRM0105Action extends BaseAction {

    static Log log = LogFactory.getLog(IGDRM0105Action.class);

    /**
	 * Ӧ���ƶȷ������Action����
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

		IGDRM01BL ctlBL = (IGDRM01BL) getBean("igdrm01BL");

		IGDRM0105Form form = (IGDRM0105Form) actionForm;

		IGDRM01DTO dto = new IGDRM01DTO();

		Gson g = new Gson();

		if ("TREE".equals(mapping.getParameter())) {
			log.info("================Ӧ���ƶȷ�������ѯ��ʼ=============");

			ctlBL.searchEntityTreeForIgdrm0105Action(dto);

			IGDRM01151VO vo = new IGDRM01151VO();

			vo.setNodeMapJson(g.toJson(dto.getNodeMap()));

			super.<IGDRM01151VO> setVO(req, vo);

			log.info("================Ӧ���ƶȷ�������ѯ���=============");

		} else if ("EXPORT".equals(mapping.getParameter())) {


		} else if ("INSERT".equals(mapping.getParameter())) {

		} else if ("SEARCH".equals(mapping.getParameter())) {
			log.info("=============Ӧ���ƶȷ����ѯ��ʼ==============");

			// ��ҳ��DTOȡ��
			getPaginDTO(req, "IGDRM0105");

			PagingDTO pDto;

			pDto = (PagingDTO) req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())) {
				// ����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDRM0105Form) req.getSession().getAttribute("IGDRM0105Form");
				if (form == null) {
					form = new IGDRM0105Form();
				} else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}

			// ��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGDRM0105");


			dto.setMaxSearchCount(maxCnt);

			dto.setPagingDto(pDto);
			dto.setForm(form);

			ctlBL.searchEntityList(dto);

			IGDRM01151VO vo = new IGDRM01151VO();

			super.<IGDRM01151VO> setVO(req, vo);

			log.info("=============Ӧ���ƶȷ����ѯ���==============");
		}

        return mapping.findForward("DISP");
    }
}
