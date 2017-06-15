/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * @Description: 流程策略通知人VO
 * @Author
 * @History 2009-8-23 新建
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRD01591VO extends BaseVO implements Serializable {

	/** 流程策略通知人 */
	private List<IGPRD01592VO> lst_IGPRD01592VO;

	/**
	 * 流程策略通知人取得
	 * 
	 * @return 流程策略通知人
	 */
	public List<IGPRD01592VO> getLst_IGPRD01592VO() {
		return lst_IGPRD01592VO;
	}

	/**
	 * 程策略通知人设定
	 * 
	 * @param lst_IGPRD01592VO
	 *            程策略通知人
	 */
	public void setLst_IGPRD01592VO(List<UserRoleInfo> lst_UserRoleInfo) {
		if (lst_UserRoleInfo != null) {
			if (lst_UserRoleInfo.size() > 0) {
				this.lst_IGPRD01592VO = new ArrayList<IGPRD01592VO>();
				Set<Integer> set_Roleid = new HashSet<Integer>();
				//根据角色ID创建子VO
				for (UserRoleInfo bean : lst_UserRoleInfo) {
					if (!set_Roleid.contains(bean.getRoleid())) {
						this.lst_IGPRD01592VO.add(new IGPRD01592VO(bean
								.getRoleid(), bean.getRolename(), null));
						set_Roleid.add(bean.getRoleid());
					}
				}
				//填充子VO
				for (IGPRD01592VO vo : lst_IGPRD01592VO) {
					for (UserRoleInfo bean : lst_UserRoleInfo) {
						if (bean.getRoleid().equals(vo.getRoleid())) {
							vo.getLst_userRoleInfo().add(bean);
						}
					}
				}
			}
		}
	}
}
