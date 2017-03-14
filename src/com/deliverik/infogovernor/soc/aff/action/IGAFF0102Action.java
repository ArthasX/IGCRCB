package com.deliverik.infogovernor.soc.aff.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.deliverik.framework.soc.asset.EntityCategory;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.soc.aff.bl.IGAFF01BL;
import com.deliverik.infogovernor.soc.aff.dto.IGAFF01DTO;
import com.deliverik.infogovernor.soc.aff.form.IGAFF0102Form;
import com.deliverik.infogovernor.soc.aff.vo.IGAFF01021VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * �豸Ӱ�����Action����
 *
 */
public class IGAFF0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGAFF0102Action.class);

	/**
	 * ���˹�ϵչʾ�¼�����
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
		// FORMȡ��
		IGAFF0102Form form = (IGAFF0102Form) actionForm;

		// BLȡ��
		IGAFF01BL ctlBL = (IGAFF01BL) getBean("igaff01BL");

		// DTO����
		IGAFF01DTO dto = new IGAFF01DTO();
		dto.setLocale(this.getLocale(req));

		if ("DISP".equals(mapping.getParameter())) {
			// �豸��ѯ���������ʾ����
			log.debug("========�豸��ѯ���������ʾ����ʼ========");

			// ***************************************************************************
			// ���ͷ���(�豸)�趨
			form = new IGAFF0102Form();
			// form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
			req.setAttribute("IGAFF0102Form", form);

			User user = (User) req.getSession().getAttribute(
					SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			// dto = ctlBL.checkEntityItemDomain(dto);
			if (EntityCategory.ENTITYITEM_PERMISSION_MODE_A
					.equals(ResourceUtility
							.getString(EntityCategory.ENTITYITEM_PERMISSION_MODE))) {
				req.getSession().setAttribute("ADmode",
						EntityCategory.ENTITYITEM_PERMISSION_MODE_A);
			} else {
				req.getSession().setAttribute("ADmode",
						EntityCategory.ENTITYITEM_PERMISSION_MODE_B);
			}
			// �����ģʽA���Ǹ����ˣ���Ȩ�����
			if (dto.getFlag()
					&& EntityCategory.ENTITYITEM_PERMISSION_MODE_A
							.equals(ResourceUtility
									.getString(EntityCategory.ENTITYITEM_PERMISSION_MODE))) {
				// req.setAttribute("deforgsys", dto.getOrgsyscoding());
				// req.setAttribute("deforgname", dto.getOrgname());
				// req.setAttribute("defassetsys", "_" + dto.getEsyscoding());
				// req.setAttribute("defassetname", dto.getEname());
				// req.getSession().setAttribute("ADrolemanager", "true");

			} else {
				// ���ó�ʼȨ����
				IGSYM03DTO sym03dto = new IGSYM03DTO();
				IGSYM03BL treeBL = (IGSYM03BL) getBean("igsym03BL");
				String roletype = req.getParameter("roletype") == null ? "IGCI01"
						: req.getParameter("roletype");
				sym03dto = treeBL.getRoleDomainTree(sym03dto, roletype, user);

				Map<String, TreeNode> treeNodeMap = sym03dto.getTreeNodeMap();
				if (treeNodeMap != null && !treeNodeMap.isEmpty()) {
					if (treeNodeMap.keySet() != null
							&& !treeNodeMap.keySet().isEmpty()) {
						Iterator<String> it = treeNodeMap.keySet().iterator();
						while (it.hasNext()) {
							Object obj = it.next();
							String key = (String) obj;
							TreeNode treeNode = treeNodeMap.get(key);
							req.setAttribute("deforgsys", treeNode.getId());
							req.setAttribute("deforgname", treeNode.getName());
							break;
						}
					}
				}

				// ���ó�ʼ�ʲ�����������
				IGSYM03DTO sym03dto1 = new IGSYM03DTO();
				IGSYM03BL treeBL1 = (IGSYM03BL) getBean("igsym03BL");
				sym03dto1.setSubtype("999001");
				String roletype1 = req.getParameter("roletype") == null ? "IGCI01"
						: req.getParameter("roletype");
				sym03dto1 = treeBL1.getAssetDomainTree(sym03dto1, roletype1,
						user);
				Map<String, TreeNode> treeNodeMap1 = sym03dto1.getTreeNodeMap();
				if (treeNodeMap1 != null && !treeNodeMap1.isEmpty()) {
					if (treeNodeMap1.keySet() != null
							&& !treeNodeMap1.keySet().isEmpty()) {
						Iterator<String> it = treeNodeMap1.keySet().iterator();
						while (it.hasNext()) {
							Object obj = it.next();
							String key = (String) obj;
							TreeNode treeNode = treeNodeMap1.get(key);
							req.setAttribute("defassetsys", treeNode.getId());
							req.setAttribute("defassetname", treeNode.getName());
							break;
						}

					}
				}
			}

			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�豸��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if ("REDISP".equals(mapping.getParameter())) {
			// �豸��ѯ��������ʾ����
			log.debug("========�豸��ѯ��������ʾ����ʼ========");

			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�豸��ѯ��������ʾ��������========");
			return mapping.findForward("DISP");
		}

		if ("SEARCH".equals(mapping.getParameter())
				|| "SEARCH1".equals(mapping.getParameter())) {
			// ��ҳ��DTOȡ��
			getPaginDTO(req, "IGAFF0101");

			PagingDTO pDto;

			pDto = (PagingDTO) req.getAttribute("PagingDTO");
			// �豸��ѯ����
			log.debug("========�豸��ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())) {
				// ����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGAFF0102Form) req.getSession().getAttribute(
						"IGAFF0102Form");
				if (form == null) {
					form = new IGAFF0102Form();
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
					form = (IGAFF0102Form) req.getSession().getAttribute(
							"IGAFF0102Form");
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}
			// ��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGAFF0101");

			// ֻ��ѯ����CI
			// if(form.getEsyscoding()!=null&&form.getEsyscoding().equals("999001")){
			// form.setTopCiFlag(true);
			// }else{
			// form.setTopCiFlag(false);
			// }
			// DTO��������趨
			// dto.setEntityItemVWSearchCond(form);

			dto.setIgaff0102Form(form);
			
			dto.setMaxSearchCount(maxCnt);

			dto.setPagingDto(pDto);

			// �豸�����߼�����
			dto = ctlBL.searchEntityItems(dto);

			// ���豸��Ϣ��������趨��VO��
			IGAFF01021VO vo = new IGAFF01021VO(dto.getSoc0118List());

			super.<IGAFF01021VO> setVO(req, vo);

			log.debug("========�豸��ѯ��������========");
		}
		if ("DELETE".equals(mapping.getParameter())) {
			// �豸ɾ������
			log.debug("========�豸ɾ������ʼ========");

			// DTO��������趨
			// dto.setDeleteEntityItem(form.getDeleteEiid());

			// �豸��Ϣɾ���߼�����
			// ctlBL.deleteEntityItemAction(dto);

			log.debug("========�豸ɾ����������========");
		}
		// �߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		log.debug("==============����Ӱ���豸��ʾ����==============");
		return mapping.findForward("DISP");
	}
}
