package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;


/**
 * ���̱���������Ϣʵ��
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG007")
public class IG007TB extends BaseEntity implements Serializable, Cloneable, IG007Info {

	/**
	 * ���̱�������ID
	 */
	@Id
	protected  String pidid;

	/**
	 * ��������ID
	 */
	protected  String pdid;

	/**
	 * ���̱�������
	 */
	protected  String pidname;

	/**
	 * ���̱�����ʾ����
	 */
	protected  String pidlabel;

	/**
	 * ���̱�������
	 */
	protected  String piddesc;

	/**
	 * ���̱�������
	 */
	protected  String pidtype;

	/**
	 * ���̱���ѡ��
	 */
	protected  String pidoption;

	/**
	 * ���̱���Ĭ��ֵ
	 */
	protected  String piddefault;

	/**
	 * ���̱����Ƿ����
	 */
	protected  String pidrequired;
	
	/**
	 * ���̱��������ʶ��1��2��3....������ԽС���ȼ�Խ�ߣ�
	 */
	protected  String pidsortid;

	/** ����Ϣ��ģʽ */
	protected String pidmode;
	
	/**
	 * ���̱���ֵ
	 */
	@Transient
	protected String pidvalue;
	
	/**
	 * �����߾��е����̱���Ȩ��
	 */
	@Transient
	protected String pidaccess;
	
	/**
	 * ���̱���ID
	 */
	@Transient
	protected Integer piid;
	
	/**
	 * ��ͨ����ID
	 */
	protected Integer pidgid;

	/**
	 * �����������̱�����CCID��ȡ��codeCategory��
	 */
	protected  String ccid;
	
	/** ����Ϣ������ʾģʽ */
	protected String rowwidth;
	
	/** ˽�б���Ȩ�޷�Χ */
	protected String privatescope;
	
	/** �Ƿ�������� */
    protected String hasattach;
    
    /** ���ģʽ */
    protected String piddisplay;
    
    /** ʹ��ģʽ */
    protected String piduse;
    
    /** ��� */
    protected Integer pidwidth;
    
    /** ������������ */
    protected String ppidid;
    
    /** ���� */
    protected Integer pidrows;
    
    /** �Ƿ��������� */
    protected String pidhide;
    
        
    
    /** �������Ƿ���ʾ���� */
    protected String showline;
    
    /** ����λ */
	protected String pidunit; 
	
	/** �Ƿ������ע */
    protected String remarks;
    
    /** ��ѡ/��ѡ��ʾ��ʽ */
    protected String showstyles;
    
    /** �Ƿ���ʾ�к� */
    protected String showrownum;
    
	/**
	 * ��ע
	 */
	@Transient
	protected String pidcomment;
	
	/** ���������ʾ��ʽ */
	protected String titledisplay;
	
	/** �Ƿ���Ҫ������� */
	protected String needidea;
	
    /** js���� */
    protected String jsfunction;
    
    /** ���ʽ����ģʽ�������ݱ��� */
    protected String pidratio;
    
    /** ����ַ��� */
    protected Integer pidsize;
    
    /** ����д��ʶ */
    protected String writeable;
    
    /** ���α�ֻ��ѡ��ĩ����ʶ */
    protected String selecedlast;
    
    /** �������� */
    protected String numbertype;
    
    /** ���뷽ʽ */
    protected String align;
	
    /** �Ƿ�Ϊ��ʶ�� */
    protected String isFlag;
    
	/**
	 * �������̱���CCIDȡ��
	 * @return �������̱���CCID
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * �������̱���CCID�趨
	  * @param ccid �������̱���CCID
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}
	
	
	public Integer getPidgid() {
		return pidgid;
	}

	public void setPidgid(Integer pidgid) {
		this.pidgid = pidgid;
	}

	/**
	 * ����ȡ��
	 * @return pidid
	 */
	public Serializable getPK() {
		return pidid;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof IG007TB))
			return false;
		IG007Info target = (IG007Info) obj;
		if (!(getPidid()==target.getPidid()))
			return false;
		return true;
	}

	/**
	 * ���̱�������IDȡ��
	 * @return ���̱�������ID
	 */
	public String getPidid() {
		return pidid;
	}
	
	/**
	 * ���̱�������ID�趨
	  * @param pidid ���̱�������ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ��������IDȡ��
	 * @return ��������ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ��������ID�趨
	  * @param pdid ��������ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * ���̱��������趨
	  * @param pidname ���̱�������
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * ���̱�����ʾ����ȡ��
	 * @return ���̱�����ʾ����
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * ���̱�����ʾ�����趨
	  * @param pidlabel ���̱�����ʾ����
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPiddesc() {
		return piddesc;
	}

	/**
	 * ���̱��������趨
	  * @param piddesc ���̱�������
	 */
	public void setPiddesc(String piddesc) {
		this.piddesc = piddesc;
	}

	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidtype() {
		return pidtype;
	}

	/**
	 * ���̱��������趨
	  * @param pidtype ���̱�������
	 */
	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	/**
	 * ���̱���ѡ��ȡ��
	 * @return ���̱���ѡ��
	 */
	public String getPidoption() {
		return pidoption;
	}

	/**
	 * ���̱���ѡ���趨
	  * @param pidoption ���̱���ѡ��
	 */
	public void setPidoption(String pidoption) {
		this.pidoption = pidoption;
	}

	/**
	 * ���̱���Ĭ��ֵȡ��
	 * @return ���̱���Ĭ��ֵ
	 */
	public String getPiddefault() {
		if(piddefault == null) {
			return "";
		} else {
			return piddefault;
		}
	}

	/**
	 * ���̱���Ĭ��ֵ�趨
	  * @param piddefault ���̱���Ĭ��ֵ
	 */
	public void setPiddefault(String piddefault) {
		this.piddefault = piddefault;
	}

	/**
	 * ���̱���IDȡ��
	 * @return ���̱���ID
	 */
	public Integer getPiid() {
		return piid;
	}

	/**
	 * ���̱���ID�趨
	  * @param piid ���̱���ID
	 */
	public void setPiid(Integer piid) {
		this.piid = piid;
	}

	/**
	 * ���̱��������ʶȡ��
	 * @return ���̱��������ʶ
	 */
	public String getPidsortid() {
		return pidsortid;
	}

	/**
	 * ���̱��������ʶ�趨
	  * @param pidsortid ���̱��������ʶ
	 */
	public void setPidsortid(String pidsortid) {
		this.pidsortid = pidsortid;
	}
	
	/**
	 * ���̱����Ƿ����ȡ��
	 * @return ���̱����Ƿ����
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * ���̱����Ƿ�����趨
	  * @param pidrequired ���̱����Ƿ����
	 */
	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}
	
	/**
	 * ���̱���ֵȡ��
	 * @return ���̱���ֵ
	 */
	public String getPidvalue() {
		return pidvalue;
	}

	/**
	 * ���̱���ֵ�趨
	 * @param pidvalue ���̱���ֵ
	 */
	public void setPidvalue(String pidvalue) {
		this.pidvalue = pidvalue;
	}
	
	/**
	 * �����߾��е����̱���Ȩ��ȡ��
	 * @return �����߾��е����̱���Ȩ��
	 */
	public String getPidaccess() {
		return pidaccess;
	}

	/**
	 * �������߾��е����̱���Ȩ���趨
	 * @param pidaccess �����߾��е����̱���Ȩ��
	 */
	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}
	
	/**
	 * ����Ϣ��ģʽȡ��
	 *
	 * @return ����Ϣ��ģʽ
	 */
	public String getPidmode() {
		return pidmode;
	}

	/**
	 * ����Ϣ��ģʽ�趨
	 *
	 * @param pidmode ����Ϣ��ģʽ
	 */
	public void setPidmode(String pidmode) {
		this.pidmode = pidmode;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="initiativepidid", referencedColumnName="pidid", updatable=false, insertable= false)
	@NotFound(action = NotFoundAction.IGNORE)
	protected List<IG286TB> processLinkageDefList;
	public List<IG286TB> getProcessLinkageDefList() {
		return processLinkageDefList;
	}

	public void setProcessLinkageDefList(
			List<IG286TB> processLinkageDefList) {
		this.processLinkageDefList = processLinkageDefList;
	}

	/**
	 * ����Ϣ������ʾģʽȡ��
	 *
	 * @return pidmode ����Ϣ������ʾģʽ
	 */
	public String getRowwidth() {
		return rowwidth;
	}

	/**
	 * ����Ϣ������ʾģʽ�趨
	 *
	 * @param pidmode ����Ϣ������ʾģʽ
	 */
	
	public void setRowwidth(String rowwidth) {
		this.rowwidth = rowwidth;
	}

	/**
	 * ˽�б���Ȩ�޷�Χ�趨
	 * 
	 * @return ˽�б���Ȩ�޷�Χ
	 */
	public String getPrivatescope() {
		return privatescope;
	}

	/**
	 * ˽�б���Ȩ�޷�Χȡ��
	 * 
	 * @param privatescope ˽�б���Ȩ�޷�Χ
	 */
	public void setPrivatescope(String privatescope) {
		this.privatescope = privatescope;
	}
	
	public void setProcessPrivateInfoList(
			List<IG899TB> processPrivateInfoList) {
		this.processPrivateInfoList = processPrivateInfoList;
	}

	/**
	 * ˽�б���ֵȡ��
	 */
	@Transient
	protected List<IG899TB> processPrivateInfoList;

	/**
	 * ˽�б��������趨
	 * 
	 * @return ˽�б�������
	 */
	public List<IG899TB> getProcessPrivateInfoList() {
		return processPrivateInfoList;
	}

	/**
	 * �Ƿ��������ȡ��
	 * @return �Ƿ��������
	 */
	public String getHasattach() {
		return hasattach;
	}

	/**
	 * �Ƿ���������趨
	 * @param hasattach �Ƿ��������
	 */
	public void setHasattach(String hasattach) {
		this.hasattach = hasattach;
	}

	/**
	 * ���ģʽȡ��
	 * @return piddisplay ���ģʽ
	 */
	public String getPiddisplay() {
		return piddisplay;
	}

	/**
	 * ���ģʽ�趨
	 * @param piddisplay ���ģʽ
	 */
	public void setPiddisplay(String piddisplay) {
		this.piddisplay = piddisplay;
	}

	/**
	 * ʹ��ģʽȡ��
	 * @return piduse ʹ��ģʽ
	 */
	public String getPiduse() {
		return piduse;
	}

	/**
	 * ʹ��ģʽ�趨
	 * @param piduse ʹ��ģʽ
	 */
	public void setPiduse(String piduse) {
		this.piduse = piduse;
	}

	/**
	 * ���ȡ��
	 * @return pidwidth ���
	 */
	public Integer getPidwidth() {
		return pidwidth;
	}

	/**
	 * ����趨
	 * @param pidwidth ���
	 */
	public void setPidwidth(Integer pidwidth) {
		this.pidwidth = pidwidth;
	}

	/**
	 * ������������ȡ��
	 * @return ppidid ������������
	 */
	public String getPpidid() {
		return ppidid;
	}

	/**
	 * �������������趨
	 * @param ppidid ������������
	 */
	public void setPpidid(String ppidid) {
		this.ppidid = ppidid;
	}

	/**
	 * ����ȡ��
	 * @return pidrows ����
	 */
	public Integer getPidrows() {
		return pidrows;
	}

	/**
	 * �����趨
	 * @param pidrows ����
	 */
	public void setPidrows(Integer pidrows) {
		this.pidrows = pidrows;
	}

	/**
	 * �Ƿ���������ȡ��
	 * @return pidhide �Ƿ���������
	 */
	public String getPidhide() {
		return pidhide;
	}

	/**
	 * �Ƿ����������趨
	 * @param pidhide �Ƿ���������
	 */
	public void setPidhide(String pidhide) {
		this.pidhide = pidhide;
	}
	
	
	/**
	 * �Ƿ���ʾ�к�ȡ��
	 * @return showrownum �Ƿ���ʾ�к�
	 */
	public String getShowrownum() {
		return showrownum;
	}

	/**
	 * �Ƿ���ʾ�к��趨
	 * @param showrownum �Ƿ���ʾ�к�
	 */
	public void setShowrownum(String showrownum) {
		this.showrownum = showrownum;
	}

	/**
	 * �������Ƿ���ʾ����ȡ��
	 * @return showline �������Ƿ���ʾ����
	 */
	public String getShowline() {
		return showline;
	}

	/**
	 * �������Ƿ���ʾ�����趨
	 * @param showline �������Ƿ���ʾ����
	 */
	public void setShowline(String showline) {
		this.showline = showline;
	}
	
	/**
	 * ����λȡ��
	 */
	public String getPidunit() {
		return pidunit;
	}
	/**
	 * ����λ�趨
	 * @param pidunit
	 */
	public void setPidunit(String pidunit) {
		this.pidunit = pidunit;
	}

	/**
	 *�Ƿ������עȡ��
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 *�Ƿ������ע����
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 *��עȡ��
	 */
	public String getPidcomment() {
		return pidcomment;
	}

	/**
	 *��ע����
	 */
	public void setPidcomment(String pidcomment) {
		this.pidcomment = pidcomment;
	}

	/**
	 *��ѡ��ѡ��ʾ��ʽȡ��
	 */
	public String getShowstyles() {
		return showstyles;
	}

	/**
	 *��ѡ��ѡ��ʾ��ʽ�趨
	 */
	public void setShowstyles(String showstyles) {
		this.showstyles = showstyles;
	}

	/**
	 * ���������ʾ��ʽȡ��
	 * @return titledisplay ���������ʾ��ʽ
	 */
	public String getTitledisplay() {
		return titledisplay;
	}

	/**
	 * ���������ʾ��ʽ�趨
	 * @param titledisplay ���������ʾ��ʽ
	 */
	public void setTitledisplay(String titledisplay) {
		this.titledisplay = titledisplay;
	}

	/**
	 * �Ƿ���Ҫ�������ȡ��
	 * @return needidea �Ƿ���Ҫ�������
	 */
	public String getNeedidea() {
		return needidea;
	}

	/**
	 * �Ƿ���Ҫ��������趨
	 * @param needidea �Ƿ���Ҫ�������
	 */
	public void setNeedidea(String needidea) {
		this.needidea = needidea;
	}

	/**
	 * js����ȡ��
	 * @return jsfunction js����
	 */
	public String getJsfunction() {
		return jsfunction;
	}

	/**
	 * js�����趨
	 * @param jsfunction js����
	 */
	public void setJsfunction(String jsfunction) {
		this.jsfunction = jsfunction;
	}

	/**
	 * ���ʽ����ģʽ�������ݱ���ȡ��
	 * @return pidratio ���ʽ����ģʽ�������ݱ���
	 */
	public String getPidratio() {
		return pidratio;
	}

	/**
	 * ���ʽ����ģʽ�������ݱ����趨
	 * @param pidratio ���ʽ����ģʽ�������ݱ���
	 */
	public void setPidratio(String pidratio) {
		this.pidratio = pidratio;
	}

	/**
	 * ����ַ���ȡ��
	 * @return pidsize ����ַ���
	 */
	public Integer getPidsize() {
		return pidsize;
	}

	/**
	 * ����ַ����趨
	 * @param pidsize ����ַ���
	 */
	public void setPidsize(Integer pidsize) {
		this.pidsize = pidsize;
	}

	/**
	 * ����д��ʶȡ��
	 * @return writeable ����д��ʶ
	 */
	public String getWriteable() {
		return writeable;
	}

	/**
	 * ����д��ʶ�趨
	 * @param writeable ����д��ʶ
	 */
	public void setWriteable(String writeable) {
		this.writeable = writeable;
	}

	/**
	 * ���α�ֻ��ѡ��ĩ����ʶȡ��
	 * @return selecedlast ���α�ֻ��ѡ��ĩ����ʶ
	 */
	public String getSelecedlast() {
		return selecedlast;
	}

	/**
	 * ���α�ֻ��ѡ��ĩ����ʶ�趨
	 * @param selecedlast ���α�ֻ��ѡ��ĩ����ʶ
	 */
	public void setSelecedlast(String selecedlast) {
		this.selecedlast = selecedlast;
	}

	/**
	 * ��������ȡ��
	 * @return numbertype ��������
	 */
	public String getNumbertype() {
		return numbertype;
	}

	/**
	 * ���������趨
	 * @param numbertype ��������
	 */
	public void setNumbertype(String numbertype) {
		this.numbertype = numbertype;
	}

	/**
	 * ���뷽ʽȡ��
	 * @return align ���뷽ʽ
	 */
	public String getAlign() {
		return align;
	}

	/**
	 * ���뷽ʽ�趨
	 * @param align ���뷽ʽ
	 */
	public void setAlign(String align) {
		this.align = align;
	}
	/**
	 * �Ƿ�Ϊ��ʶ��ȡ��
	 * @return isFlag �Ƿ�Ϊ��ʶ��
	 */
	public String getIsFlag() {
		return isFlag;
	}

	/**
	 * �Ƿ�Ϊ��ʶ���趨
	 * @param isFlag �Ƿ�Ϊ��ʶ��
	 */
	public void setIsFlag(String isFlag) {
		this.isFlag = isFlag;
	}
}
