/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * @Description: ���̲���֪ͨ��VO
 * @Author
 * @History 2009-8-23 �½�
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRD01591VO extends BaseVO implements Serializable {

	/** ���̲���֪ͨ�� */
	private List<IGPRD01592VO> lst_IGPRD01592VO;

	/**
	 * ���̲���֪ͨ��ȡ��
	 * 
	 * @return ���̲���֪ͨ��
	 */
	public List<IGPRD01592VO> getLst_IGPRD01592VO() {
		return lst_IGPRD01592VO;
	}

	/**
	 * �̲���֪ͨ���趨
	 * 
	 * @param lst_IGPRD01592VO
	 *            �̲���֪ͨ��
	 */
	public void setLst_IGPRD01592VO(List<UserRoleInfo> lst_UserRoleInfo) {
		if (lst_UserRoleInfo != null) {
			if (lst_UserRoleInfo.size() > 0) {
				this.lst_IGPRD01592VO = new ArrayList<IGPRD01592VO>();
				Set<Integer> set_Roleid = new HashSet<Integer>();
				//���ݽ�ɫID������VO
				for (UserRoleInfo bean : lst_UserRoleInfo) {
					if (!set_Roleid.contains(bean.getRoleid())) {
						this.lst_IGPRD01592VO.add(new IGPRD01592VO(bean
								.getRoleid(), bean.getRolename(), null));
						set_Roleid.add(bean.getRoleid());
					}
				}
				//�����VO
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
