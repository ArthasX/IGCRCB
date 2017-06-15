package com.deliverik.infogovernor.kgm.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;

public class IGKGM0202Form extends BaseForm implements KnowledgeSearchCond{
	private static final long serialVersionUID = 1L;
 
	/**
	 *knid_q
	 */
	protected Integer knid_q;

	/**
	 *֪ʶid����
	 */
	protected String[] knids;
	
	/**
	 *key
	 */
	protected Integer knid;
	
	/**
	 *key
	 */
	protected Integer knversion;
	
	/**
	 *knarea
	 */
	protected String knarea;
	
	/**
	 *knareaname
	 */
	protected String knareaname;
	
	/**
	 *kntelarea
	 */
	protected String kntelarea;
	
	/**
	 *kntelareaname
	 */
	protected String kntelareaname;
	
	/**
	 *����
	 */
	protected String[] kntitles;

	/**
	 *���
	 */
	protected String knserial;

	/**
	 *�鵵��
	 */
	protected String knapprover;

	/**
	 *�鵵ʱ��
	 */
	protected String knapprovetime;
	
	/**
	 *��������
	 */
	protected String knclassname;
	
	/**
	 *֪ʶ������
	 */
	protected String knproffer;

	/**
	 *����ʱ��
	 */
	protected String knproffertime;
	
	/**
	 *����
	 */
	protected String kndepartment;

	/**
	 *��Դ
	 */
	protected String knorigin;
	
	/**
	 *��Դ
	 */
	protected String knoriginname;

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
	 *����
	 */
	protected String knclass;

	/**
	 *�ؼ���
	 */
	protected String knkey;
	
	/**
	 *�ؼ���
	 */
	protected String knkey_p;
	
	/**
	 *״̬
	 */
	protected String knstatus;
	
	/**
	 *����˵��
	 */
	protected String knreject;
	
	/**
	 *����
	 */
	protected String kntitle;
	
	/**
	 *�ؼ�������
	 */
	protected String[] knkeys;
	
	/**֪ʶ����������*/
	protected String knproffername;

	/**�鵵������ */
	protected String knapprovername;
	
	/**֪ʶ�����˽�ɫ*/
	protected Integer knapproverole;
	/**�����ֶ�**/
	protected String order;
	
	protected String selectstatus;
	
	/**����ʽ**/
	protected String sing;
	
protected Integer[] knapproveroles;
	
	public Integer[] getKnapproveroles() {
		return knapproveroles;
	}
	public void setKnapproveroles(Integer[] knapproveroles) {
		this.knapproveroles = knapproveroles;
	}
	
	/**
	 *֪ʶ�����˽�ɫ
	 * 
	 * @return ֪ʶ�����˽�ɫ
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
	 *����˵��ȡ��
	 * 
	 * @return ����˵��
	 */
	public String getKnreject() {
		return knreject;
	}

	/**
	 * ����˵��
	 * @param file ����˵��
	 */
	public void setKnreject(String knreject) {
		this.knreject = knreject;
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
    /**
     *�ؼ�������ȡ��
     * 
     * @return �ؼ�������
     */
	public String[] getKnkeys() {
		return knkeys;
	}

    /**
     *�ؼ����趨
     * 
     * @param knkeys �ؼ���
     */
	public void setKnkeys(String[] knkeys) {
		this.knkeys = knkeys;
	}

    /**
     *keyȡ��
     * 
     * @return key
     */
	public Integer getKnid() {
		return knid;
	}

    /**
     *key�趨
     * 
     * @param key key
     */
	public void setKnid(Integer knid) {
		this.knid = knid;
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
     * @param knserial ���
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
     * @param kndepartment ����
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
     * @param knapprover �鵵��
     */
	public void setKnapprover(String knapprover) {
		this.knapprover = knapprover;
	}

    /**
     *�鵵ʱ��ȡ��
     * 
     * @return �鵵ʱ��
     */
	public String getKnapprovetime() {
		return knapprovetime;
	}

    /**
     *�鵵ʱ���趨
     * 
     * @param knapprovetime �鵵ʱ��
     */
	public void setKnapprovetime(String knapprovetime) {
		this.knapprovetime = knapprovetime;
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
     * @param knclass ����
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
     * @param knkey �ؼ���
     */
	public void setKnkey(String knkey) {
		this.knkey = knkey;
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
     * @param knorigin ��Դ
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
     * @param knproffer ֪ʶ������
     */
	public void setKnproffer(String knproffer) {
		this.knproffer = knproffer;
	}

    /**
     *����ʱ��ȡ��
     * 
     * @return ����ʱ��
     */
	public String getKnproffertime() {
		return knproffertime;
	}

    /**
     *����ʱ���趨
     * 
     * @param knproffertime ����ʱ��
     */
	public void setKnproffertime(String knproffertime) {
		this.knproffertime = knproffertime;
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
     * @param kntitle ����
     */
	public void setKntitle(String kntitle) {
		this.kntitle = kntitle;
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
     * @param kndes ��������
     */
	public void setKndes(String kndes) {
		this.kndes = kndes;
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
     * @param knfaultcause ����ԭ���ܽ�
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
     * @param knsolveway ����취
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
     * @param knstatus ״̬
     */
	public void setKnstatus(String knstatus) {
		this.knstatus = knstatus;
	}

    /**
     *�汾ȡ��
     * 
     * @return �汾
     */
	public static long getSerialVersionUID() {
		return serialVersionUID;
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
	 *��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getKnclassname(){
		return knclassname;
	}

	/**
	 *���������趨
	 * 
	 * @param knclassname ��������
	 */
	public void setKnclassname(String knclassname) {
		this.knclassname = knclassname;
	}
	
	/**
	 *ingerPrintȡ��
	 * 
	 * @return ingerPrint
	 */
	public String getFingerPrint() {
		return "";
	}

	public Integer getKnid_q() {
		return knid_q;
	}

	public void setKnid_q(Integer knid_q) {
		this.knid_q = knid_q;
	}

	public String[] getKnids() {
		return knids;
	}

	public void setKnids(String[] knids) {
		this.knids = knids;
	}
	/**
	 *�鵵ʱ���ȡ��
	 * 
	 * @return �鵵ʱ���
	 */
	public String getKnapprovetime_f(){
		return "";
	}
	/**
	 *�鵵ʱ�䵽ȡ��
	 * 
	 * @return �鵵ʱ�䵽
	 */
	public String getKnapprovetime_t(){
		return "";
	}
	
	/**
	 *����ʱ���ȡ��
	 * 
	 * @return ����ʱ���
	 */
	public String getKnproffertime_f(){
		return "";
	}
	
	/**
	 *����ʱ�䵽ȡ��
	 * 
	 * @return ����ʱ�䵽
	 */
	public String getKnproffertime_t() {
		return "";
	}

	public String getKnkey_p() {
		return knkey_p;
	}

	public void setKnkey_p(String knkey_p) {
		this.knkey_p = knkey_p;
	}

	public String getKnarea() {
		return knarea;
	}

	public void setKnarea(String knarea) {
		this.knarea = knarea;
	}

	public String getKnareaname() {
		return knareaname;
	}

	public void setKnareaname(String knareaname) {
		this.knareaname = knareaname;
	}

	public String getKntelarea() {
		return kntelarea;
	}

	public void setKntelarea(String kntelarea) {
		this.kntelarea = kntelarea;
	}

	public String getKntelareaname() {
		return kntelareaname;
	}

	public void setKntelareaname(String kntelareaname) {
		this.kntelareaname = kntelareaname;
	}

	public String getKnoriginname() {
		return knoriginname;
	}

	public void setKnoriginname(String knoriginname) {
		this.knoriginname = knoriginname;
	}

	public Integer getKnversion() {
		return knversion;
	}

	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}
	/**ҵ��ϵͳ����*/
	protected String systemid;

	public String getSystemid() {
		return systemid;
	}
	public void setSystemid(String systemid) {
		this.systemid = systemid;
	}
	public String getKnserial_like() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}
	/**
	 * @return the selectstatus
	 */
	public String getSelectstatus() {
		return selectstatus;
	}
	/**
	 * @param selectstatus the selectstatus to set
	 */
	public void setSelectstatus(String selectstatus) {
		this.selectstatus = selectstatus;
	}
	/**
	 * @return the sing
	 */
	public String getSing() {
		return sing;
	}
	/**
	 * @param sing the sing to set
	 */
	public void setSing(String sing) {
		this.sing = sing;
	}
	public String getKnclass_like() {
		// TODO Auto-generated method stub
		return null;
	}
}
