/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.zwj.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.infogovernor.zwj.dto.IGZWJ01DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �侯��Ժ�������BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGZWJ01BLImpl extends BaseBLImpl implements IGZWJ01BL{
	
	/** ��־����ȡ�� */
	private static Log log = LogFactory.getLog(IGZWJ01BLImpl.class);
	
	/** ����bl */
	protected OrganizationBL organizationBL;
	
	/** �û�BL */
	protected UserBL userBL;

	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	public IGZWJ01DTO searchOrgnameAction(IGZWJ01DTO dto) throws BLException {
		//ʵ������ѯ����
		OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
		cond.setOrgsyscoding(IGZWJCONSTANT.ORGSYSCODING);	
		List<Organization> list_org = organizationBL.searchOrganization(cond);
		dto.setOrg(list_org.get(0));
		return dto;
	}
	
	public IGZWJ01DTO searchUserInfoAction(IGZWJ01DTO dto) throws BLException {
		log.debug("======== �¼����� ��ѯ��Ա��Ϣ��ʼ========");
		// ��ѯ��¼����
		int totalCount = userBL.getUserSearchCount(dto
				.getUserSearchCond());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		List<User> userList = userBL.searchUser(dto
				.getUserSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setUserList(userList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========�¼����� ��ѯ��Ա��Ϣ��ֹ========");
		return dto;
	}
}
