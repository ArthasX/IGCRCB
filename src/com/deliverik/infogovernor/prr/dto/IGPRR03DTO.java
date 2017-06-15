/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.infogovernor.prr.form.IGPRR0301Form;
import com.deliverik.infogovernor.prr.form.IGPRR0302Form;
import com.deliverik.infogovernor.prr.form.IGPRR0303Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Զ������̸�������dto
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR03DTO extends BaseDTO{

	/** �����ѯ������¼�� */
	protected int maxSearchCount;

	/** ��ҳBean */
	protected PagingDTO pagingDto;
	
	/** ��ɫ����Form */
	protected IGPRR0301Form igprr0301Form;
	
	/** ��ɫ��ѯform */
	protected IGPRR0302Form igprr0302Form;
	
	/** ��Ա��ѯform */
	protected IGPRR0303Form igprr0303Form;
	
	/** ��ɫ��Ϣ���� */
	protected List<Role> roleList;
	
	/** �����˽�ɫ��Ϣ���� */
	protected List<IG001Info> ig001List_A;
	
	/** ֵ���˽�ɫ��Ϣ���� */
	protected List<IG001Info> ig001List_B;
	
	/** ִ���˽�ɫ��Ϣ���� */
	protected List<IG001Info> ig001List_C;
	
	/** �û���ɫMap */
	protected Map<Integer, Map<String,List<UserRoleInfo>>> userRoleInfoMap;

	/**
	 * �����ѯ������¼��ȡ��
	 * @return �����ѯ������¼��
	 */
	public final int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����ѯ������¼���趨
	 * @param maxSearchCount �����ѯ������¼��
	 */
	public final void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳbeanȡ��
	 * @return ��ҳbean
	 */
	public final PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳbean�趨
	 * @param pagingDto ��ҳbean
	 */
	public final void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * ��ɫ����formȡ��
	 * @return ��ɫ����form
	 */
	public final IGPRR0301Form getIgprr0301Form() {
		return igprr0301Form;
	}

	/**
	 * ��ɫ����form�趨
	 * @param igprr0301Form
	 */
	public final void setIgprr0301Form(IGPRR0301Form igprr0301Form) {
		this.igprr0301Form = igprr0301Form;
	}

	/**
	 * ��ɫ��ѯformȡ��
	 * @return ��ɫ��ѯform
	 */
	public final IGPRR0302Form getIgprr0302Form() {
		return igprr0302Form;
	}

	/**
	 * ��ɫ��ѯform�趨
	 * @param igprr0302Form ��ɫ��ѯform
	 */
	public final void setIgprr0302Form(IGPRR0302Form igprr0302Form) {
		this.igprr0302Form = igprr0302Form;
	}
	
	/**
	 * ��ɫ��Ϣ����ȡ��
	 * @return ��ɫ��Ϣ����
	 */
	public final List<Role> getRoleList() {
		return roleList;
	}

	/**
	 * ��ɫ��Ϣ�����趨
	 * @param roleList ��ɫ��Ϣ����
	 */
	public final void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	/**
	 * �����˽�ɫ��Ϣ����ȡ��
	 * @return �����˽�ɫ��Ϣ����
	 */
	public final List<IG001Info> getIg001List_A() {
		return ig001List_A;
	}

	/**
	 * �����˽�ɫ��Ϣ�����趨
	 * @param ig001List_A �����˽�ɫ��Ϣ����
	 */
	public final void setIg001List_A(List<IG001Info> ig001List_A) {
		this.ig001List_A = ig001List_A;
	}

	/**
	 * ֵ���˽�ɫ��Ϣ���ȡ��
	 * @return ֵ���˽�ɫ��Ϣ����
	 */
	public final List<IG001Info> getIg001List_B() {
		return ig001List_B;
	}

	/**
	 * ֵ���˽�ɫ��Ϣ�����趨
	 * @param ig001List_B ֵ���˽�ɫ��Ϣ����
	 */
	public final void setIg001List_B(List<IG001Info> ig001List_B) {
		this.ig001List_B = ig001List_B;
	}

	/**
	 * ִ���˽�ɫ��Ϣ����ȡ��
	 * @return ִ���˽�ɫ��Ϣ����
	 */
	public final List<IG001Info> getIg001List_C() {
		return ig001List_C;
	}

	/**
	 * ִ���˽�ɫ��Ϣ�����趨
	 * @param ig001List_C ִ���˽�ɫ��Ϣ����
	 */
	public final void setIg001List_C(List<IG001Info> ig001List_C) {
		this.ig001List_C = ig001List_C;
	}

	/**
	 * ��Ա��ѯformȡ��
	 * @return igprr0303Form ��Ա��ѯform
	 */
	public IGPRR0303Form getIgprr0303Form() {
		return igprr0303Form;
	}

	/**
	 * ��Ա��ѯform�趨
	 * @param igprr0303Form ��Ա��ѯform
	 */
	public void setIgprr0303Form(IGPRR0303Form igprr0303Form) {
		this.igprr0303Form = igprr0303Form;
	}

	/**
	 * �û���ɫMapȡ��
	 * @return userRoleInfoMap �û���ɫMap
	 */
	public Map<Integer, Map<String, List<UserRoleInfo>>> getUserRoleInfoMap() {
		return userRoleInfoMap;
	}

	/**
	 * �û���ɫMap�趨
	 * @param userRoleInfoMap �û���ɫMap
	 */
	public void setUserRoleInfoMap(
			Map<Integer, Map<String, List<UserRoleInfo>>> userRoleInfoMap) {
		this.userRoleInfoMap = userRoleInfoMap;
	}
}
