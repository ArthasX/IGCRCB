/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.condition;

import java.util.List;

/**
 * <p>����:��־��Ϣ��������ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public class IG036SearchCondImpl implements IG036SearchCond {

	/** ���̼�¼ID */
	protected Integer prid;
	
	/** ��־������ID */
	protected String rluserid;
	
	/** ��־���������� */
	protected String rlusername;
	
	/** �û���ɫ */
	protected List<Integer> roleid;
	
	/** ����ɫ��ѯ�����ʶ */
	protected boolean roleorder;
	
	/** �ų�������־���� */
	protected String notEqualrlType;
	
	/** ��־���� */
	protected String rlType;

	/** ����״̬���� */
	protected String psdcode;
	
	/** �����ʶ */
	protected String roleorder_type;
	
	/** ��ɫ�����˱�ʶ */
	protected String rolemanger;
	
	/** ����״̬ID */
	protected String psdid;
	
	/** ����״̬��֧��� */
	protected Integer psdnum;
	
	/**
	 * ���ܣ���ɫ�����˱�ʶȡ��
	 * @return ��ɫ�����˱�ʶ
	 */
	public String getRolemanger() {
		return rolemanger;
	}

	/**
	 * ���ܣ���ɫ�����˱�ʶ�趨
	 * @param rolemanger ��ɫ�����˱�ʶ
	 */
	public void setRolemanger(String rolemanger) {
		this.rolemanger = rolemanger;
	}
	
	/**
	 * ���ܣ������ʶȡ��
	 * @return �����ʶ
	 */
	public String getRoleorder_type() {
		return roleorder_type;
	}

	/**
	 * ���ܣ������ʶ�趨
	 * @param roleorder_type �����ʶ
	 */
	public void setRoleorder_type(String roleorder_type) {
		this.roleorder_type = roleorder_type;
	}

	/**
	 * ���ܣ�����״̬����ȡ��
	 * @return ����״̬����
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * ���ܣ�����״̬�����趨
	 * @param psdcode ����״̬����
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	/**
	 * ���ܣ���ȡ�ų�������־����
	 * @return notEqualrlType
	 */
	public String getNotEqualrlType() {
		return notEqualrlType;
	}

	/**
	 * ���ܣ������ų�������־����
	 * @param notEqualrlType
	 */
	public void setNotEqualrlType(String notEqualrlType) {
		this.notEqualrlType = notEqualrlType;
	}

	/**
	 * ���ܣ���ȡ��־����
	 * @return rlType
	 */
	public String getRlType() {
		return rlType;
	}

	/**
	 * ���ܣ�������־����
	 * @param rlType
	 */
	public void setRlType(String rlType) {
		this.rlType = rlType;
	}

	/**
	 * ���ܣ���ȡ����ɫ��ѯ�����ʶ
	 * @return roleorder
	 */
	public boolean isRoleorder() {
		return roleorder;
	}

	/**
	 * ���ܣ����ð���ɫ��ѯ�����ʶ
	 * @param roleorder
	 */
	public void setRoleorder(boolean roleorder) {
		this.roleorder = roleorder;
	}

	/**
	 * ���ܣ���ȡ�û���ɫ
	 * @return roleid
	 */
	public List<Integer> getRoleid() {
		return roleid;
	}

	/**
	 * ���ܣ������û���ɫ
	 * @param roleid
	 */
	public void setRoleid(List<Integer> roleid) {
		this.roleid = roleid;
	}

	/**
	 * ���ܣ����̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���ܣ����̼�¼ID�趨
	 * @param prid ���̼�¼ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���ܣ���־������IDȡ��
	 * @return ��־������ID
	 */
	public String getRluserid() {
		return rluserid;
	}

	/**
	 * ���ܣ���־������ID�趨
	 * @param rluserid ��־������ID
	 */
	public void setRluserid(String rluserid) {
		this.rluserid = rluserid;
	}
	
	/**
	 * ���ܣ���־����������ȡ��
	 * @return ��־����������
	 */
	public String getRlusername() {
		return rlusername;
	}

	/**
	 * ���ܣ���־�����������趨
	 * @param rlusername ��־����������
	 */
	public void setRlusername(String rlusername) {
		this.rlusername = rlusername;
	}

	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬ID�趨
	 * @param psdid ����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ����״̬��֧���ȡ��
	 * @return ����״̬��֧���
	 */
	public Integer getPsdnum() {
		return psdnum;
	}

	/**
	 * ����״̬��֧���
	 * @param psdnum ����״̬��֧���
	 */
	public void setPsdnum(Integer psdnum) {
		this.psdnum = psdnum;
	}
	
}
