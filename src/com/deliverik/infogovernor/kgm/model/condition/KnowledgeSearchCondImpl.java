/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 
 * @Description:��������Cond��
 * @Author
 * @History
 * @Version V1.0
 */
public class KnowledgeSearchCondImpl implements KnowledgeSearchCond {
	
	/**
	 *id
	 */
	protected Integer knid;
	
	/**
	 *id
	 */
	protected Integer knversion;
	
	/**
	 *���
	 */
	protected String knserial;

	/**
	 *����
	 */
	protected String kndepartment;

	/**
	 *�鵵��
	 */
	protected String knapprover;

	/**
	 *�鵵ʱ���
	 */
	protected String knapprovetime_f;
	
	/**
	 *�鵵ʱ�䵽
	 */
	protected String knapprovetime_t;

	/**
	 *����
	 */
	protected String knclass;


	/**
	 *�ؼ���
	 */
	protected String knkey;


	/**
	 *��Դ
	 */
	protected String knorigin;


	/**
	 *֪ʶ������
	 */
	protected String knproffer;


	/**
	 *����ʱ���
	 */
	protected String knproffertime_f;

	/**
	 *����ʱ�䵽
	 */
	protected String knproffertime_t;
	/**
	 *����
	 */
	protected String kntitle;


	/**
	 *��������
	 */
	protected String kndes;


	/**
	 *����ԭ���ܽ�
	 */
	protected String knfaultcause;


	/**
	 *����취
	 */
	protected String knsolveway;


	/**
	 *״̬
	 */
	protected String knstatus;

	
	/**
	 *�ؼ�������
	 */
	protected String[] knkeys;

	/**ҵ��ϵͳ����*/
	protected String systemid;
	
	/**
	 *��������
	 */
	protected String kntitles[];

	/**֪ʶ����������*/
	protected String knproffername;

	/**�鵵������ */
	protected String knapprovername;
	
	/**ҵ������*/
	protected String knarea;
	
	/**��������*/
	protected String kntelarea;
	
	/**֪ʶ�����˽�ɫ*/
	protected Integer knapproverole;
	
	protected Integer[] knapproveroles;
	/**֪ʶ���*/
	protected String knserial_like;
	
	/**�����ֶ�**/
	protected String order;
	
	protected String selectstatus;
	
	/**����ʽ**/
	protected String sing;
	
	/**
	 *����ģ����ѯ
	 */
	protected String knclass_like;
	
	
	public String getKnclass_like() {
		return knclass_like;
	}

	public void setKnclass_like(String knclass_like) {
		this.knclass_like = knclass_like;
	}

	/**
	 *֪ʶ���ȡ��
	 * 
	 * @return ֪ʶ���
	 */
	public String getKnserial_like() {
		return knserial_like;
	}
	
	/**
	 * ֪ʶ���
	 * @param knserialnum_like ֪ʶ���
	 */
	public void setKnserial_like(String knserial_like) {
		this.knserial_like = knserial_like;
	}
	
	public Integer[] getKnapproveroles() {
		return knapproveroles;
	}
	public void setKnapproveroles(Integer[] knapproveroles) {
		this.knapproveroles = knapproveroles;
	}
	/**
	 *ҵ������ȡ��
	 * 
	 * @return ҵ������
	 */
	public Integer getKnapproverole() {
		return knapproverole;
	}
	/**
	 *֪ʶ�����˽�ɫ
	 * @param knapproverole ֪ʶ�����˽�ɫ
	 */
	public void setKnapproverole(Integer knapproverole) {
		this.knapproverole = knapproverole;
	}
	
	/**
	 *ҵ������ȡ��
	 * 
	 * @return ҵ������
	 */
	public String getKnarea() {
		return knarea;
	}
	/**
	 *ҵ������
	 * @param knarea ҵ������
	 */
	public void setKnarea(String knarea) {
		this.knarea = knarea;
	}
	/**
	 *��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getKntelarea() {
		return kntelarea;
	}
	/**
	 * ��������
	 * @param kntelarea ��������
	 */
	public void setKntelarea(String kntelarea) {
		this.kntelarea = kntelarea;
	}
	/**
	 *�鵵ʱ���ȡ��
	 * 
	 * @return �鵵ʱ���
	 */
	public String getKnapprovetime_f() {
		return knapprovetime_f;
	}
	/**
	 *�鵵ʱ����趨
	 * 
	 * @param knapprovetime_t �鵵ʱ���
	 */
	public void setKnapprovetime_f(String knapprovetime_f) {
		this.knapprovetime_f = knapprovetime_f;
	}
	/**
	 *�鵵ʱ�䵽ȡ��
	 * 
	 * @return �鵵ʱ�䵽
	 */
	public String getKnapprovetime_t() {
		return knapprovetime_t;
	}
	/**
	 *�鵵ʱ�䵽�趨
	 * 
	 * @param knapprovetime_t �鵵ʱ�䵽
	 */
	public void setKnapprovetime_t(String knapprovetime_t) {
		this.knapprovetime_t = knapprovetime_t;
	}
	/**
	 *����ʱ���ȡ��
	 * 
	 * @return ����ʱ���
	 */
	public String getKnproffertime_f() {
		return knproffertime_f;
	}
	/**
	 *����ʱ����趨
	 * 
	 * @param knproffertime_t ����ʱ���
	 */
	public void setKnproffertime_f(String knproffertime_f) {
		this.knproffertime_f = knproffertime_f;
	}
	/**
	 *����ʱ�䵽ȡ��
	 * 
	 * @return ����ʱ�䵽
	 */
	public String getKnproffertime_t() {
		return knproffertime_t;
	}
	/**
	 *����ʱ�䵽�趨
	 * 
	 * @param knproffertime_t ����ʱ�䵽
	 */
	public void setKnproffertime_t(String knproffertime_t) {
		this.knproffertime_t = knproffertime_t;
	}

	/**
	 *���ȡ��
	 * 
	 * @return ���
	 */
	public String getKnserial() {
		return knserial;
	}

	/**
	 *����趨
	 * 
	 * @param knserial���
	 */
	public void setKnserial(String knserial) {
		this.knserial = knserial;
	}
	

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public String getKndepartment() {
		return kndepartment;
	}

	/**
	 *�����趨
	 * 
	 * @param kndepartment����
	 */
	public void setKndepartment(String kndepartment) {
		this.kndepartment = kndepartment;
	}

	/**
	 *�鵵��ȡ��
	 * 
	 * @return �鵵��
	 */
	public String getKnapprover() {
		return knapprover;
	}

	/**
	 *�鵵���趨
	 * 
	 * @param knapprover�鵵��
	 */
	public void setKnapprover(String knapprover) {
		this.knapprover = knapprover;
	}


	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public String getKnclass() {
		return knclass;
	}

	/**
	 *�����趨
	 * 
	 * @param knclass����
	 */
	public void setKnclass(String knclass) {
		this.knclass = knclass;
	}

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
	 *��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getKndes() {
		return kndes;
	}

	/**
	 *���������趨
	 * 
	 * @param kndes��������
	 */
	public void setKndes(String kndes) {
		this.kndes = kndes;
	}

	/**
	 *��Դȡ��
	 * 
	 * @return ��Դ
	 */
	public String getKnorigin() {
		return knorigin;
	}

	/**
	 *��Դ�趨
	 * 
	 * @param knorigin��Դ
	 */
	public void setKnorigin(String knorigin) {
		this.knorigin = knorigin;
	}

	/**
	 *֪ʶ������ȡ��
	 * 
	 * @return ֪ʶ������
	 */
	public String getKnproffer() {
		return knproffer;
	}

	/**
	 *֪ʶ�������趨
	 * 
	 * @param knproffer֪ʶ������
	 */
	public void setKnproffer(String knproffer) {
		this.knproffer = knproffer;
	}

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public String getKntitle() {
		return kntitle;
	}

	/**
	 *�����趨
	 * 
	 * @param kntitle����
	 */
	public void setKntitle(String kntitle) {
		this.kntitle = kntitle;
	}

	/**
	 *����ԭ���ܽ�ȡ��
	 * 
	 * @return ����ԭ���ܽ�
	 */
	public String getKnfaultcause() {
		return knfaultcause;
	}

	/**
	 *����ԭ���ܽ��趨
	 * 
	 * @param knfaultcause����ԭ���ܽ�
	 */
	public void setKnfaultcause(String knfaultcause) {
		this.knfaultcause = knfaultcause;
	}

	/**
	 *����취ȡ��
	 * 
	 * @return ����취
	 */
	public String getKnsolveway() {
		return knsolveway;
	}

	/**
	 *����취�趨
	 * 
	 * @param knsolveway����취
	 */
	public void setKnsolveway(String knsolveway) {
		this.knsolveway = knsolveway;
	}

	/**
	 *״̬ȡ��
	 * 
	 * @return ״̬
	 */
	public String getKnstatus() {
		return knstatus;
	}

	/**
	 *״̬�趨
	 * 
	 * @param knstatus״̬
	 */
	public void setKnstatus(String knstatus) {
		this.knstatus = knstatus;
	}
	
	/**
	 *��������ȡ��
	 * 
	 * @return ��������
	 */
	public String[] getKntitles() {
		return kntitles;
	}
	
	/**
	 *���������趨
	 * 
	 * @param kntitles ��������
	 */
	public void setKntitles(String[] kntitles) {
		this.kntitles = kntitles;
	}
	
	/**
	 *�ؼ�������ȡ��
	 * 
	 * @return �ؼ�������
	 */
	public String[] getKnkeys() {
		return knkeys;
	}
	
	/**
	 *�ؼ��������趨
	 * 
	 * @param knkeys �ؼ�������
	 */
	public void setKnkeys(String[] knkeys) {
		this.knkeys = knkeys;
	}
	
	/**
	 *�鵵������ȡ��
	 * 
	 * @return �鵵������
	 */
	public String getKnapprovername() {
		return knapprovername;
	}

	/**
	 * �鵵�������趨
	 * @param knapprovername �鵵������
	 */
	public void setKnapprovername(String knapprovername) {
		this.knapprovername = knapprovername;
	}
	/**
	 *֪ʶ����������ȡ��
	 * 
	 * @return ֪ʶ����������
	 */
	public String getKnproffername() {
		return knproffername;
	}

	/**
	 * ֪ʶ�����������趨
	 * @param knproffername ֪ʶ����������
	 */
	public void setKnproffername(String knproffername) {
		this.knproffername = knproffername;
	}
	public Integer getKnid() {
		return knid;
	}
	public void setKnid(Integer knid) {
		this.knid = knid;
	}
	public String getSystemid() {
		return systemid;
	}
	public void setSystemid(String systemid) {
		this.systemid = systemid;
	}

	public Integer getKnversion() {
		return knversion;
	}

	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSelectstatus() {
		return selectstatus;
	}

	public void setSelectstatus(String selectstatus) {
		this.selectstatus = selectstatus;
	}

	public String getSing() {
		return sing;
	}

	public void setSing(String sing) {
		this.sing = sing;
	}
	
	
}
