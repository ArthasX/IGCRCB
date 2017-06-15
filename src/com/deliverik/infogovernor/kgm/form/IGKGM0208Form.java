/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;


/**
 * ����: ֪ʶ��˼��������ӿ�
 * ����������֪ʶ��˼��������ӿ�
 * ������¼���κ��� 2010/12/07
 * �޸ļ�¼��
 */
public class IGKGM0208Form extends BaseForm implements KnowledgeSearchCond{

	private static final long serialVersionUID = 1L;
	
	/**
	 *����
	 */
	protected String kndepartment;
	
	/**
	 *ҳ���ʾ
	 */
	protected String showFlag;

	/**
	 *��Դ
	 */
	protected String knorigin;

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
	 *״̬
	 */
	protected String knstatus;
	
	/**
	 *����
	 */
	protected String kntitle;
	
	/**
	 *�ؼ�������
	 */
	protected String[] knkeys;
	
	/**
	 *��������
	 */
	protected String[] kntitles;
	
	/**
	 *��������
	 */
	protected String knclassname;
	
	/**
	 *֪ʶid����
	 */
	protected String[] knids;
	
	/**֪ʶ����������*/
	protected String knproffername;

	/**�鵵������ */
	protected String knapprovername;
	
	/**
	 *�鵵ʱ���
	 */
	protected String knapprovetime_f;
	
	/**
	 *�鵵ʱ�䵽
	 */
	protected String knapprovetime_t;

	/**
	 *����ʱ���
	 */
	protected String knproffertime_f;

	/**
	 *����ʱ�䵽
	 */
	protected String knproffertime_t;
	
	/**
	 *����ԭ������
	 */
	protected String[] knrejects;
	
	/**
	 *����ԭ��
	 */
	protected String knreject;
	/**
	 *�汾����
	 */
	protected String[] knversions;
	
	/**ҵ������*/
	protected String knarea;
	
	/**��������*/
	protected String kntelarea;
	
	/**��Դ����*/
	protected String knoriginname;
	
	
	/**ҵ��������*/
	protected String knareaname;
	
	
	/**����������*/
	protected String kntelareaname;
	
	/**֪ʶ�����˽�ɫ*/
	protected Integer knapproverole;
	/**֪ʶ���*/
	protected String knserial_like;
	/**�����ֶ�**/
	protected String order;
	
	protected String selectstatus;
	
	/**����ʽ**/
	protected String sing;
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
	 *��Դ����ȡ��
	 * 
	 * @return ��Դ����
	 */
	public String getKnoriginname() {
		return knoriginname;
	}
	/**
	 * ��Դ�����趨
	 * @param knoriginname ��Դ����
	 */
	public void setKnoriginname(String knoriginname) {
		this.knoriginname = knoriginname;
	}
	/**
	 *ҵ��������ȡ��
	 * 
	 * @return ҵ��������
	 */
	public String getKnareaname() {
		return knareaname;
	}
	/**
	 * ҵ��������
	 * @param knareaname ҵ��������
	 */
	public void setKnareaname(String knareaname) {
		this.knareaname = knareaname;
	}
	
	/**
	 *��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getKntelareaname() {
		return kntelareaname;
	}
	/**
	 * ��������
	 * @param kntelareaname ��������
	 */
	public void setKntelareaname(String kntelareaname) {
		this.kntelareaname = kntelareaname;
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
	 *�汾����ȡ��
	 * 
	 * @return �汾����
	 */
	public String[] getKnversions() {
		return knversions;
	}
	/**
	 * �汾�����趨
	 * @param knversions �汾����
	 */
	public void setKnversions(String[] knversions) {
		this.knversions = knversions;
	}

	/**
	 *����ԭ��ȡ��
	 * 
	 * @return ����ԭ��
	 */
	public String getKnreject() {
		return knreject;
	}
	
	/**
	 * ����ԭ���趨
	 * @param knreject ����ԭ��
	 */
	public void setKnreject(String knreject) {
		this.knreject = knreject;
	}
	
	/**
	 *����ԭ������ȡ��
	 * 
	 * @return ����ԭ������
	 */
	public String[] getKnrejects() {
		return knrejects;
	}
	/**
	 * ����ԭ�������趨
	 * @param knrejects ����ԭ������
	 */
	public void setKnrejects(String[] knrejects) {
		this.knrejects = knrejects;
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
	 *֪ʶid����ȡ��
	 * 
	 * @return ֪ʶid����
	 */
	public String[] getKnids() {
		return knids;
	}
	
	/**
	 *֪ʶid�����趨
	 * 
	 * @param knids ֪ʶid����
	 */
	public void setKnids(String[] knids) {
		this.knids = knids;
	}

	/**
	 *��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getKnclassname() {
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
	 *�����趨
	 * 
	 * @param kndepartment����
	 */
	public void setKndepartment(String kndepartment) {
		this.kndepartment = kndepartment;
	}
	
	/**
	 *���������趨
	 * 
	 * @param kndes��������
	 */
	public void setKndes(String kndes) {
		this.kndes = kndes;
	}
	
	public IGKGM0208Form() {
		// TODO Auto-generated constructor stub
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
	 *����ԭ���ܽ��趨
	 * 
	 * @param knfaultcause����ԭ���ܽ�
	 */
	public void setKnfaultcause(String knfaultcause) {
		this.knfaultcause = knfaultcause;
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

	public String getKnapprover() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getKnapprovetime() {
		// TODO Auto-generated method stub
		return null;
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
	 *��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getKndes() {
		return kndes;
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
	 *��Դȡ��
	 * 
	 * @return ��Դ
	 */
	public String getKnorigin() {
		return knorigin;
	}

	public String getKnproffer() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getKnproffertime() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getKnserial() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *����취ȡ��
	 * 
	 * @return ����취
	 */
	public String getKnsolveway() {
		return knsolveway;
	}
	
	@Override
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.knkeys = null;

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
	public Integer getKnid() {
		// TODO Auto-generated method stub
		return null;
	}
	/**ҵ��ϵͳ����*/
	protected String systemid;

	public String getSystemid() {
		return systemid;
	}
	public void setSystemid(String systemid) {
		this.systemid = systemid;
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

	public String getShowFlag() {
		return showFlag;
	}

	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}
	
}
