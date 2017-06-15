/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 武警总院相关流程BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGZWJ01BLImpl extends BaseBLImpl implements IGZWJ01BL{
	
	/** 日志对象取得 */
	private static Log log = LogFactory.getLog(IGZWJ01BLImpl.class);
	
	/** 机构bl */
	protected OrganizationBL organizationBL;
	
	/** 用户BL */
	protected UserBL userBL;

	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	public IGZWJ01DTO searchOrgnameAction(IGZWJ01DTO dto) throws BLException {
		//实例化查询条件
		OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
		cond.setOrgsyscoding(IGZWJCONSTANT.ORGSYSCODING);	
		List<Organization> list_org = organizationBL.searchOrganization(cond);
		dto.setOrg(list_org.get(0));
		return dto;
	}
	
	public IGZWJ01DTO searchUserInfoAction(IGZWJ01DTO dto) throws BLException {
		log.debug("======== 事件发起 查询人员信息开始========");
		// 查询记录总数
		int totalCount = userBL.getUserSearchCount(dto
				.getUserSearchCond());
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		List<User> userList = userBL.searchUser(dto
				.getUserSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setUserList(userList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========事件发起 查询人员信息终止========");
		return dto;
	}
}
