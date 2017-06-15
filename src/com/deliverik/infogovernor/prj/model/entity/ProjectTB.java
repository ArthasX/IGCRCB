package com.deliverik.infogovernor.prj.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.fin.model.entity.BudgetTB;
import com.deliverik.infogovernor.prj.model.Project;


/**
 * 
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="Project")
public class ProjectTB extends BaseEntity implements Serializable, Cloneable, Project {

	@Id
	@TableGenerator(
		    name="PROJECT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="PROJECT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PROJECT_TABLE_GENERATOR")
	/** ����ID*/
	protected Integer pid;

	/** ��Ŀ����*/
	protected String ptype;
	
	/** ��Ŀ���*/
	protected String pcode;
	
	/** ��Ŀ����*/
	protected String pname;
	
	/** ��Ŀ���*/
	protected String pdesc;
	
	protected String pinfo;
	
	/** ��ʼʱ��*/
	protected String popentime;
	
	/** ����ʱ��*/
	protected String pclosetime;
	
	/** ״̬*/
	protected String pstatus;
	
	/** �Ǽ��˻���ID*/
	protected String porg;
	
	/** �Ǽ��˽�ɫ*/
	protected String prole;
	
	/** �Ǽ���*/
	protected String puser;
	
	/** ��ĿԤ�㣬��ӦԤ����е�Ԥ������*/
	protected String pamount;
	
	/** ��Ŀ��;*/
	protected String ppurpose;
	
	/** ��ĿԤ����;*/
	protected String puse;
	
	/** ��ĿԤ����*/
	protected Double plimit;
	
	/** ������*/
	protected String pbranch;
	
	/** Ԥ������ID*/
	protected Integer pbid;
	
	/** ��ĿĿ��*/
	protected String paim;
	
	/** ʹ��Ԥ��*/
	protected String isUseBudget;
	
	/** �ƻ�����ʱ�� */
	protected String pplanclosetime;
	
	/** ��Ŀ �ʱ��� ����*/
	protected Double pzdevelop;
	
	/** ��Ŀ �ʱ��� Ӳ��*/
	protected Double pzhardware;
	
	/** ��Ŀ �ʱ��� ���*/
	protected Double pzsoftware;
	
	/** ��Ŀ �ʱ��� ����*/
	protected Double pzproject;
	
	/** ��Ŀ �ʱ��� ����*/
	protected Double pzelse;
	
	/** ��Ŀ �ɱ��� ʵʩ*/
	protected Double pcimplement;
	
	/** ��Ŀ �ɱ��� ����*/
	protected Double pcelse;
	
	/** ��ͬ��� */
	protected Integer plcid;
	
	/** ��Ŀ���� */
	protected String ppquality ;
	
	/** �û�������Ϣʵ�� */
	@OneToOne
	@JoinColumn(name="pbid", referencedColumnName="bid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected  BudgetTB budgetTB;

	public Serializable getPK() {
		return pid;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof ProjectTB))
			return false;
		Project target = (Project) obj;
		if (!(getPid()==target.getPid()))
			return false;

		return true;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getPinfo() {
		return pinfo;
	}

	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}

	public String getPopentime() {
		return popentime;
	}

	public void setPopentime(String popentime) {
		this.popentime = popentime;
	}

	public String getPclosetime() {
		return pclosetime;
	}

	public void setPclosetime(String pclosetime) {
		this.pclosetime = pclosetime;
	}

	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

	public String getPorg() {
		return porg;
	}

	public void setPorg(String porg) {
		this.porg = porg;
	}

	public String getProle() {
		return prole;
	}

	public void setProle(String prole) {
		this.prole = prole;
	}

	public String getPuser() {
		return puser;
	}

	public void setPuser(String puser) {
		this.puser = puser;
	}

	public String getPamount() {
		return pamount;
	}

	public void setPamount(String pamount) {
		this.pamount = pamount;
	}

	/**
	 * �ƻ�����ʱ��ȡ��
	 * @return pplanclosetime �ƻ�����ʱ��
	 */
	public String getPplanclosetime() {
		return pplanclosetime;
	}

	/**
	 * �ƻ�����ʱ���趨
	 * @param pplanclosetime �ƻ�����ʱ��
	 */
	public void setPplanclosetime(String pplanclosetime) {
		this.pplanclosetime = pplanclosetime;
	}

	public String getPuse() {
		return puse;
	}

	public void setPuse(String puse) {
		this.puse = puse;
	}

	public Double getPlimit() {
		return plimit;
	}

	public void setPlimit(Double plimit) {
		this.plimit = plimit;
	}

	public String getPbranch() {
		return pbranch;
	}

	public void setPbranch(String pbranch) {
		this.pbranch = pbranch;
	}

	public Integer getPbid() {
		return pbid;
	}

	public void setPbid(Integer pbid) {
		this.pbid = pbid;
	}

	public String getPaim() {
		return paim;
	}

	public void setPaim(String paim) {
		this.paim = paim;
	}

	/**
	 * ��ȡ��Ŀ��;
	 * @return fppurpose ��Ŀ��;
	 */
	public String getPpurpose() {
		return ppurpose;
	}

	/**
	 * ������Ŀ��;
	 * @param ppurpose  ��Ŀ��;
	 */
	public void setPpurpose(String ppurpose) {
		this.ppurpose = ppurpose;
	}
	
	/**
	 * Ԥ���ʵ��
	 * @param ppurpose  Ԥ���ʵ��
	 */
	public BudgetTB getBudgetTB() {
		return budgetTB;
	}
	/**
	 * ����Ԥ���ʵ��
	 * @param ppurpose  Ԥ���ʵ��
	 */
	public void setBudgetTB(BudgetTB budgetTB) {
		this.budgetTB = budgetTB;
	}
	
	/**
	 * ��ȡʹ��Ԥ��
	 * @return fisUseBudget ʹ��Ԥ��
	 */
	public String getIsUseBudget() {
		return isUseBudget;
	}

	/**
	 * ����ʹ��Ԥ��
	 * @param isUseBudget  ʹ��Ԥ��
	 */
	public void setIsUseBudget(String isUseBudget) {
		this.isUseBudget = isUseBudget;
	}
	

	/**
	 * ��Ŀ�ʱ��𿪷�ȡ��
	 * @return pbzdevelop ��Ŀ�ʱ��𿪷�
	 */
	public Double getPzdevelop() {
		return pzdevelop;
	}

	/**
	 * ��Ŀ�ʱ��𿪷��趨
	 * @param pbzdevelop ��Ŀ�ʱ��𿪷�
	 */
	public void setPzdevelop(Double pzdevelop) {
		this.pzdevelop = pzdevelop;
	}

	/**
	 * ��Ŀ�ʱ���Ӳ��ȡ��
	 * @return pbzhardware ��Ŀ�ʱ���Ӳ��
	 */
	public Double getPzhardware() {
		return pzhardware;
	}

	/**
	 * ��Ŀ�ʱ���Ӳ���趨
	 * @param pbzhardware ��Ŀ�ʱ���Ӳ��
	 */
	public void setPzhardware(Double pzhardware) {
		this.pzhardware = pzhardware;
	}

	/**
	 * ��Ŀ�ʱ������ȡ��
	 * @return pbzsoftware ��Ŀ�ʱ������
	 */
	public Double getPzsoftware() {
		return pzsoftware;
	}

	/**
	 * ��Ŀ�ʱ�������趨
	 * @param pbzsoftware ��Ŀ�ʱ������
	 */
	public void setPzsoftware(Double pzsoftware) {
		this.pzsoftware = pzsoftware;
	}

	/**
	 * ��Ŀ�ʱ��𹤳�ȡ��
	 * @return pbzproject ��Ŀ�ʱ��𹤳�
	 */
	public Double getPzproject() {
		return pzproject;
	}

	/**
	 * ��Ŀ�ʱ��𹤳��趨
	 * @param pbzproject ��Ŀ�ʱ��𹤳�
	 */
	public void setPzproject(Double pzproject) {
		this.pzproject = pzproject;
	}

	/**
	 * ��Ŀ�ʱ�������ȡ��
	 * @return pbzelse ��Ŀ�ʱ�������
	 */
	public Double getPzelse() {
		return pzelse;
	}

	/**
	 * ��Ŀ�ʱ��������趨
	 * @param pbzelse ��Ŀ�ʱ�������
	 */
	public void setPzelse(Double pzelse) {
		this.pzelse = pzelse;
	}

	/**
	 * ��Ŀ�ɱ���ʵʩȡ��
	 * @return pbcimplement ��Ŀ�ɱ���ʵʩ
	 */
	public Double getPcimplement() {
		return pcimplement;
	}

	/**
	 * ��Ŀ�ɱ���ʵʩ�趨
	 * @param pbcimplement ��Ŀ�ɱ���ʵʩ
	 */
	public void setPcimplement(Double pcimplement) {
		this.pcimplement = pcimplement;
	}

	/**
	 * ��Ŀ�ɱ�������ȡ��
	 * @return pbcelse ��Ŀ�ɱ�������
	 */
	public Double getPcelse() {
		return pcelse;
	}

	/**
	 * ��Ŀ�ɱ��������趨
	 * @param pbcelse ��Ŀ�ɱ�������
	 */
	public void setPcelse(Double pcelse) {
		this.pcelse = pcelse;
	}
	
	/**
	 * ��ͬ���ȡ��
	 * @return plcid ��ͬ���
	 */
	public Integer getPlcid() {
		return plcid;
	}

	/**
	 * ��ͬ����趨
	 * @param plcid ��ͬ���
	 */
	public void setPlcid(Integer plcid) {
		this.plcid = plcid;
	}

	/**
	 * ��Ŀ����ȡ��
	 * @return ppquality ��Ŀ����
	 */
	public String getPpquality() {
		return ppquality;
	}

	/**
	 * ��Ŀ�����趨
	 * @param ppquality ��Ŀ����
	 */
	public void setPpquality(String ppquality) {
		this.ppquality = ppquality;
	}

	public ProjectTB clone(Project project){
		this.setPclosetime(project.getPclosetime());
		this.setPcode(project.getPcode());
		this.setPdesc(project.getPdesc());
		this.setPinfo(project.getPinfo());
		this.setPname(project.getPname());
		this.setPopentime(project.getPopentime());
		this.setPorg(project.getPorg());
		this.setProle(project.getProle());
		this.setPstatus(project.getPstatus());
		this.setPtype(project.getPtype());
		this.setPuser(project.getPuser());
		this.setPamount(project.getPamount());
		this.setPuse(project.getPuse());
		this.setPbranch(project.getPbranch());
		this.setPbid(project.getPbid());
		this.setPlimit(project.getPlimit());
		this.setPaim(project.getPaim());
		this.setPpurpose(project.getPpurpose());
		this.setBudgetTB(project.getBudgetTB());
		return this;
	}

}
