package com.deliverik.framework.workflow.prr.model.condition;

import java.util.List;

/**
 * ���̲����û���Ϣ��������ʵ��
 */
public class IG337SearchCondImpl implements IG337SearchCond {
	
	/**
	 * ���̼�¼ID
	 */
	protected Integer prid;
	
	/**
	 * ���̲����û���ɫID
	 */
	protected Integer pproleid;
	
	/**
	 * ���̲����û�ID
	 */
	protected String ppuserid;
	
	/**
	 * ���̲����û�ָ��ʱ��
	 */
	protected String ppinittime;
	
	/**
	 * ���̲����û��������ʱ��
	 */
	protected String ppproctime;
	
	/**
	 * ���̲����û��Ĳ���״̬��ƽ̨������
	 */
	protected String ppstatus;
	
	/**
	 * ���̲����û��Ĳ���״̬
	 */
	protected String ppstatus_q;
	
	/**
	 * ���̲����û���״̬
	 */
	protected String ppsubstatus;
	
	/**
	 * ���̲����û���Ϣ
	 */
	protected String ppuserinfo;
	
	/**
	 * ���̲����û��жϱ�ʶ��Y�ж����̲����û��Ƿ�Ϊ�գ�N�ж����̲����û��Ƿ�Ϊ�գ�
	 */
	protected String ppuseridIsNull;
	
	/**
	 * ���̲����û�������ɱ�ʶ��Y�ж����̲����û��������ʱ���Ƿ�Ϊ�գ�N�ж����̲����û��������ʱ���Ƿ�Ϊ�գ�
	 */
	protected String ppproctimeIsNull;
	
	/**
	 * ���̲����û���ϢID�����������
	 */
	protected List<Integer> ppidInList;
	
	/**
	 * ���̵����в������Ƿ���ָ���û���������
	 */
	protected String ppuserid_not;
	
	//====>130225Begin
	/**
	 * ����������������ȷ��ѯ
	 */
	protected String pporgid_eq;

	/** ����״̬����ID */
	protected String psdid;

	/** ��̬��֧��� */
	protected Integer psdnum;
	
	/** �Ƿ��Ѿ�ȷ�ϣ�1��null��0����ֵ��*/
	protected String ppbacktime_isNull;
	
	/**
	 * ����������������ȷ��ѯȡ��
	 *
	 * @return pporgid_eq ����������������ȷ��ѯ
	 */
	public String getPporgid_eq() {
		return pporgid_eq;
	}

	/**
	 * ����������������ȷ��ѯ�趨
	 *
	 * @param pporgid_eq ����������������ȷ��ѯ
	 */
	public void setPporgid_eq(String pporgid_eq) {
		this.pporgid_eq = pporgid_eq;
	}
	//====>130225End

	/**
	 * ���̲����û��Ĳ���״̬ȡ��
	 * @return ���̲����û��Ĳ���״̬
	 */
	public String getPpstatus_q() {
		return ppstatus_q;
	}

	/**
	 * ���̲����û��Ĳ���״̬�趨
	 * @param ppstatus_q ���̲����û��Ĳ���״̬
	 */
	public void setPpstatus_q(String ppstatus_q) {
		this.ppstatus_q = ppstatus_q;
	}

	/**
	 * ���̲����û��Ĳ���״̬ȡ��
	 * @return ���̲����û��Ĳ���״̬
	 */
	public String getPpstatus() {
		return ppstatus;
	}

	/**
	 * ���̲����û��Ĳ���״̬�趨
	 * @param ppstatus ���̲����û��Ĳ���״̬
	 */
	public void setPpstatus(String ppstatus) {
		this.ppstatus = ppstatus;
	}

	/**
	 * ���̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���̼�¼ID�趨
	 * @param prid ���̼�¼ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���̲����û���ɫIDȡ��
	 * @return ���̲����û���ɫID
	 */
	public Integer getPproleid() {
		return pproleid;
	}

	/**
	 * ���̲����û���ɫID�趨
	 * @param pproleid ���̲����û���ɫID
	 */
	public void setPproleid(Integer pproleid) {
		this.pproleid = pproleid;
	}

	/**
	 * ���̲����û�IDȡ��
	 * @return ���̲����û�ID
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * ���̲����û�ID�趨
	 * @param ppuserid ���̲����û�ID
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	/**
	 * ���̲����û�ָ��ʱ��ȡ��
	 * @return ���̲����û�ָ��ʱ��
	 */
	public String getPpinittime() {
		return ppinittime;
	}

	/**
	 * ���̲����û�ָ��ʱ���趨
	 * @param ppinittime ���̲����û�ָ��ʱ��
	 */
	public void setPpinittime(String ppinittime) {
		this.ppinittime = ppinittime;
	}

	/**
	 * ���̲����û��������ʱ��ȡ��
	 * @return ���̲����û��������ʱ��
	 */
	public String getPpproctime() {
		return ppproctime;
	}

	/**
	 * ���̲����û��������ʱ���趨
	 * @param ppproctime ���̲����û��������ʱ��
	 */
	public void setPpproctime(String ppproctime) {
		this.ppproctime = ppproctime;
	}


	/**
	 * ���̲����û���״̬ȡ��
	 * @return ���̲����û���״̬
	 */
	public String getPpsubstatus() {
		return ppsubstatus;
	}

	/**
	 * ���̲����û���״̬�趨
	 * @param ppsubstatus ���̲����û���״̬
	 */
	public void setPpsubstatus(String ppsubstatus) {
		this.ppsubstatus = ppsubstatus;
	}

	/**
	 * ���̲����û���Ϣȡ��
	 * @return ���̲����û���Ϣ
	 */
	public String getPpuserinfo() {
		return ppuserinfo;
	}

	/**
	 * ���̲����û���Ϣ�趨
	 * @param ppuserinfo ���̲����û���Ϣ
	 */
	public void setPpuserinfo(String ppuserinfo) {
		this.ppuserinfo = ppuserinfo;
	}
	
	/**
	 * ���̲����û��жϱ�ʶ��Y�ж����̲����û��Ƿ�Ϊ�գ�N�ж����̲����û��Ƿ�Ϊ�գ�ȡ��
	 * @return ���̲����û��жϱ�ʶ
	 */
	public String getPpuseridIsNull() {
		return ppuseridIsNull;
	}

	/**
	 * ���̲����û�������ɱ�ʶ��Y�ж����̲����û��������ʱ���Ƿ�Ϊ�գ�N�ж����̲����û��������ʱ���Ƿ�Ϊ�գ�ȡ��
	 * @return ���̲����û�������ɱ�ʶ
	 */
	public String getPpproctimeIsNull() {
		return ppproctimeIsNull;
	}

	/**
	 * ���̲����û�������ɱ�ʶ��Y�ж����̲����û��������ʱ���Ƿ�Ϊ�գ�N�ж����̲����û��������ʱ���Ƿ�Ϊ�գ��趨
	 * @param ppproctimeIsNull ���̲����û�������ɱ�ʶ
	 */
	public void setPpproctimeIsNull(String ppproctimeIsNull) {
		this.ppproctimeIsNull = ppproctimeIsNull;
	}

	
	
	/**
	 * ���̲����û��жϱ�ʶ��Y�ж����̲����û��Ƿ�Ϊ�գ�N�ж����̲����û��Ƿ�Ϊ�գ��趨
	 * @param ppuseridIsNull ���̲����û��жϱ�ʶ
	 */
	public void setPpuseridIsNull(String ppuseridIsNull) {
		this.ppuseridIsNull = ppuseridIsNull;
	}
	
	/**
	 * ���̲����û���ϢID�����������ȡ��
	 * @return ���̲����û���ϢID�����������
	 */
	public List<Integer> getPpidInList() {
		return ppidInList;
	}

	/**
	 * ���̲����û���ϢID������������趨
	 * @param ppidInList ���̲����û���ϢID�����������
	 */
	public void setPpidInList(List<Integer> ppidInList) {
		this.ppidInList = ppidInList;
	}

	/**
	 * ���̵����в������Ƿ���ָ���û���������ȡ��
	 * @return ���̵����в������Ƿ���ָ���û���������
	 */
	public String getPpuserid_not() {
		return ppuserid_not;
	}

	/**
	 * ���̵����в������Ƿ���ָ���û����������趨
	 * @param ppuserid_not ���̵����в������Ƿ���ָ���û���������
	 */
	public void setPpuserid_not(String ppuserid_not) {
		this.ppuserid_not = ppuserid_not;
	}

	/**
	 * ����״̬����IDȡ��
	 * @return ����״̬����ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬����ID�趨
	 * @param psdid ����״̬����ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ��̬��֧���ȡ��
	 * @return ��̬��֧���
	 */
	public Integer getPsdnum() {
		return psdnum;
	}

	/**
	 * ��̬��֧����趨
	 * @param psdnum ��̬��֧���
	 */
	public void setPsdnum(Integer psdnum) {
		this.psdnum = psdnum;
	}

	/**
	 * �Ƿ��Ѿ�ȷ�ϣ�1��null��0����ֵ��ȡ��
	 * @return the ppbacktime_isNull
	 */
	public String getPpbacktime_isNull() {
		return ppbacktime_isNull;
	}

	/**
	 * �Ƿ��Ѿ�ȷ�ϣ�1��null��0����ֵ���趨
	 * @param ppbacktime_isNull the �Ƿ��Ѿ�ȷ�ϣ�1��null��0����ֵ��
	 */
	public void setPpbacktime_isNull(String ppbacktime_isNull) {
		this.ppbacktime_isNull = ppbacktime_isNull;
	}
	
}
