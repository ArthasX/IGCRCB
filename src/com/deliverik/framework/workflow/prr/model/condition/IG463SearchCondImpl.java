/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
 * ��������ѯ����ʵ��
 */
public class IG463SearchCondImpl implements IG463SearchCond {
	
	/**��Ȩ��ID */
	protected String ppwauthorizeuserid;
	/**������id */
	protected String ppwproxyuserid ;
	/**���������� */
	protected String ppwproxyusername ;
	/**�����˴���ʱ�� ��*/
	protected String ppwoptiontime_t;
	/**�����˴���ʱ�� ��*/
	protected String ppwoptiontime_f;
	/**�رձ�ʶ */
	protected String ppwcloseflag;
	/**����id */
	protected Integer ppwprid;
	/**���̱��*/
	protected String ppwprserialnum;
	
	/**
	 * ������idȡ��
	 * 
	 * @return ������id
	 */
	public String getPpwproxyuserid() {
		return ppwproxyuserid;
	}
	/**
	 * ������id�趨
	 *
	 * @param ppwproxyuserid ������id
	 */
	public void setPpwproxyuserid(String ppwproxyuserid) {
		this.ppwproxyuserid = ppwproxyuserid;
	}
	/**
	 * ����idȡ��
	 * 
	 * @return ����id
	 */
	public Integer getPpwprid() {
		return ppwprid;
	}
	/**
	 * ����id�趨
	 *
	 * @param ppwprid ����id
	 */
	public void setPpwprid(Integer ppwprid) {
		this.ppwprid = ppwprid;
	}
	/**
	 * ��Ȩ��IDȡ��
	 * 
	 * @return ��Ȩ��ID
	 */
	public String getPpwauthorizeuserid() {
		return ppwauthorizeuserid;
	}
	/**
	 * ��Ȩ��ID�趨
	 *
	 * @param ppwauthorizeuserid ��Ȩ��ID
	 */
	public void setPpwauthorizeuserid(String ppwauthorizeuserid) {
		this.ppwauthorizeuserid = ppwauthorizeuserid;
	}
	/**
	 * ����������ȡ��
	 * 
	 * @return ����������
	 */
	public String getPpwproxyusername() {
		return ppwproxyusername;
	}
	/**
	 * �����������趨
	 *
	 * @param ppwproxyusername ����������
	 */
	public void setPpwproxyusername(String ppwproxyusername) {
		this.ppwproxyusername = ppwproxyusername;
	}
	/**
	 * �����˴���ʱ�� ��ȡ��
	 * 
	 * @return �����˴���ʱ�� ��
	 */
	public String getPpwoptiontime_t() {
		return ppwoptiontime_t;
	}
	/**
	 * �����˴���ʱ�� ���趨
	 *
	 * @param ppwoptiontime_t �����˴���ʱ�� ��
	 */
	public void setPpwoptiontime_t(String ppwoptiontime_t) {
		this.ppwoptiontime_t = ppwoptiontime_t;
	}
	/**
	 * �����˴���ʱ�� ��ȡ��
	 * 
	 * @return �����˴���ʱ�� ��
	 */
	public String getPpwoptiontime_f() {
		return ppwoptiontime_f;
	}
	/**
	 * �����˴���ʱ�� ���趨
	 *
	 * @param ppwoptiontime_f �����˴���ʱ�� ��
	 */
	public void setPpwoptiontime_f(String ppwoptiontime_f) {
		this.ppwoptiontime_f = ppwoptiontime_f;
	}
	/**
	 * �رձ�ʶȡ��
	 * 
	 * @return �رձ�ʶ
	 */
	public String getPpwcloseflag() {
		return ppwcloseflag;
	}
	/**
	 * �رձ�ʶ�趨
	 *
	 * @param ppwcloseflag �رձ�ʶ
	 */
	public void setPpwcloseflag(String ppwcloseflag) {
		this.ppwcloseflag = ppwcloseflag;
	}
	
	/**
	 * ���̱��ȡ��
	 * 
	 * @return ���̱��
	 */
	public String getPpwprserialnum() {
		return ppwprserialnum;
	}
	
	/**
	 * ���̱���趨
	 *
	 * @param ppwprserialnum ���̱��
	 */
	public void setPpwprserialnum(String ppwprserialnum) {
		this.ppwprserialnum = ppwprserialnum;
	}
	
	
}
