/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 
 * @Description:֪ʶ���ѯ��Cond��
 * @Author
 * @History
 * @Version V1.0
 */
public class KnowLedgeInfoSearchCondImpl implements KnowLedgeInfoSearchCond {
	/**
	 *֪ʶ�����
	 */
	protected String knclass;

	/**
	 *֪ʶ�����ȡ��
	 * 
	 * @return ֪ʶ�����
	 */
	public String getKnclass() {
		return knclass;
	}

	/**
	 *֪ʶ������趨
	 * 
	 * @param knclass֪ʶ�����
	 */
	public void setKnclass(String knclass) {
		this.knclass = knclass;
	}

	/**
	 *�ؼ���
	 */
	protected String knkey;

	/**
	 *�ؼ���ȡ��
	 * 
	 * @return �ؼ���
	 */
	public String getKnkey() {
		return knkey;
	}

	/**
	 *�ؼ����趨
	 * 
	 * @param knkey�ؼ���
	 */
	public void setKnkey(String knkey) {
		this.knkey = knkey;
	}

	/**
	 *֪ʶ����
	 */
	protected String kntitle;

	/**
	 *֪ʶ����ȡ��
	 * 
	 * @return ֪ʶ����
	 */
	public String getKntitle() {
		return kntitle;
	}

	/**
	 *֪ʶ�����趨
	 * 
	 * @param kntitle֪ʶ����
	 */
	public void setKntitle(String kntitle) {
		this.kntitle = kntitle;
	}

	/**
	 *�¼�
	 */
	protected String knapprovetime;

	/**
	 *�¼�ȡ��
	 * 
	 * @return �¼�
	 */
	public String getKnapprovetime() {
		return knapprovetime;
	}

	/**
	 *�¼��趨
	 * 
	 * @param knapprovetime�¼�
	 */
	public void setKnapprovetime(String knapprovetime) {
		this.knapprovetime = knapprovetime;
	}

	/**
	 *������
	 */
	protected Integer grade;

	/**
	 *������ȡ��
	 * 
	 * @return ������
	 */
	public Integer getGrade() {
		return grade;
	}

	/**
	 *�������趨
	 * 
	 * @param grade������
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	/**
	 *������
	 */
	protected String kndealno;

	/**
	 *������ȡ��
	 * 
	 * @return ������
	 */
	public String getKndealno() {
		return kndealno;
	}

	/**
	 *�������趨
	 * 
	 * @param kndealno������
	 */
	public void setKndealno(String kndealno) {
		this.kndealno = kndealno;
	}

	/**
	 *������
	 */
	protected String knerrno;

	/**
	 *������ȡ��
	 * 
	 * @return ������
	 */
	public String getKnerrno() {
		return knerrno;
	}

	/**
	 *�������趨
	 * 
	 * @param knerrno������
	 */
	public void setKnerrno(String knerrno) {
		this.knerrno = knerrno;
	}
}
