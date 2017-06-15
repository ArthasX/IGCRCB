/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.entity.IG286TB;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;

/**
 * ���̶��������Ϣ�༭����Form
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0111Form extends BaseForm implements IG007Info {
	
	/** ���̶����ID */
	protected String pdid;
	
	/** ����Ϣ��Ĭ��ֵ */
	protected String piddefault;

	/** ����Ϣ������ */
	protected String piddesc;

	/** ����Ϣ��ID */
	protected String pidid;

	/** ����Ϣ����ʾ���� */
	protected String pidlabel;

	/** ����Ϣ����ʾ���� */
	protected String pidlabel_bak;
	
	/** ����Ϣ�ĺ�̨���� */
	protected String pidname;

	/** ����Ϣ��ȡֵ��Χ */
	protected String pidoption;

	/** ����Ϣ�Ƿ������ */
	protected String pidrequired;

	/** ����Ϣ������ */
	protected String pidtype;
	
	/** ���̶����¼��ʱ��� */
	protected String fingerPrint;
	
	/** ģʽ 0�Ǽǣ�1�༭ */
	protected String mode = "0";

	/** ����ID */
	protected String pidsortid;
	
	protected Integer pidgid;
	
	/** ����Ϣ��ģʽ */
	protected String pidmode;
	
	/** ����Ϣ������ʾģʽ */
	protected String rowwidth;
	
	/** ����Ϣ������ʾģʽ */
	protected String privatescope;
	
	/** ����Ϣ��������Ϣ */
	protected String pididorder;
	
	/** �Ƿ�������� */
    protected String hasattach;
    
    /** ��������ʾģʽ */
    protected String piddisplay;
    
    /** ��������ʾģʽ */
    protected String piddisplaya;
    
    /** ������ʹ��ģʽ */
    protected String piduse;
    
    /** ��� */
    protected Integer pidwidth;
    
    /** ������������ */
    protected String ppidid;
    
    /** ���� */
    protected Integer pidrows;
    
    /** �Ƿ��������� */
    protected String pidhide;
        
    /** �Ƿ���ʾ�к� */
    protected String showrownum;
    
    /** ����λ */
    protected String pidunit;
    
    /** �Ƿ������ע */
    protected String remarks;
    
    /** �Ƿ���ʾ���� */
    protected String showline;
    
    /** ��ѡ/��ѡ��ʾ��ʽ */
    protected String showstyles;
    
    /** ������ʾģʽ */
    protected String titledisplay;
    
    /** �Ƿ����������� */
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

	/** ��������С��λ�� */
	protected String decimals;
    
    /** ��Ա����ɫ���� */
    protected String participantRoleType;
    
    /** ���뷽ʽ */
    protected String align;
    
    /** ��Ա����ɫ��Χ��Ϣ */
    protected String participantRoles;
    
    /**�ı��򸽼���*/
	protected Map<Integer, FormFile> fileMapMuti = null;
	
	/** ������Ϣ���� */
	protected List<Attachment> attList;
	
	/** ����ID���� */
	protected String [] attids;
	
	/** ����ɾ����ʶ */
	protected String [] attdel;
	
	/** �ʲ����� */
	protected String [] asmname;
	
	/** �ʲ�ID */
	protected String [] asminfo;
	
	/** �ʲ���ϢMap */
	protected Map<Integer, String> entityInfoMap;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		fileMapMuti = new HashMap<Integer, FormFile>();
	}
	
	public String getPididorder() {
		return pididorder;
	}

	public void setPididorder(String pididorder) {
		this.pididorder = pididorder;
	}

	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	protected String ccid;
	
	protected List<IG899TB> processPrivateInfoList;

	public Integer getPidgid() {
		return pidgid;
	}

	public void setPidgid(Integer pidgid) {
		this.pidgid = pidgid;
	}

	public String getPidsortid() {
		return pidsortid;
	}

	public void setPidsortid(String pidsortid) {
		this.pidsortid = pidsortid;
	}

	/**
	 * ģʽȡ��
	 * 
	 * @return ģʽ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ģʽ�趨
	 *
	 * @param mode ģʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * ���̶����IDȡ��
	 * 
	 * @return ���̶����ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶����ID�趨
	 *
	 * @param pdid ���̶����ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����Ϣ��Ĭ��ֵȡ��
	 * 
	 * @return ����Ϣ��Ĭ��ֵ
	 */
	public String getPiddefault() {
		return piddefault;
	}

	/**
	 * ����Ϣ��Ĭ��ֵ�趨
	 *
	 * @param piddefault ����Ϣ��Ĭ��ֵ
	 */
	public void setPiddefault(String piddefault) {
		this.piddefault = piddefault;
	}

	/**
	 * ����Ϣ������ȡ��
	 * 
	 * @return ����Ϣ������
	 */
	public String getPiddesc() {
		return piddesc;
	}

	/**
	 * ����Ϣ�������趨
	 *
	 * @param piddesc ����Ϣ������
	 */
	public void setPiddesc(String piddesc) {
		this.piddesc = piddesc;
	}

	/**
	 * ����Ϣ��IDȡ��
	 * 
	 * @return ����Ϣ��ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ����Ϣ��ID�趨
	 *
	 * @param pidid ����Ϣ��ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ����Ϣ����ʾ����ȡ��
	 * 
	 * @return ����Ϣ����ʾ����
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * ����Ϣ����ʾ�����趨
	 *
	 * @param pidlabel ����Ϣ����ʾ����
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	/**
	 * ����Ϣ����ʾ����ȡ��
	 * 
	 * @return ����Ϣ����ʾ����
	 */
	public String getPidlabel_bak() {
		return pidlabel_bak;
	}

	/**
	 * ����Ϣ����ʾ�����趨
	 *
	 * @param pidlabel_bak ����Ϣ����ʾ����
	 */
	public void setPidlabel_bak(String pidlabel_bak) {
		this.pidlabel_bak = pidlabel_bak;
	}

	/**
	 * ����Ϣ�ĺ�̨����ȡ��
	 * 
	 * @return ����Ϣ�ĺ�̨����
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * ����Ϣ�ĺ�̨�����趨
	 *
	 * @param pidname ����Ϣ�ĺ�̨����
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * ����Ϣ��ȡֵ��Χȡ��
	 * 
	 * @return ����Ϣ��ȡֵ��Χ
	 */
	public String getPidoption() {
		return pidoption;
	}

	/**
	 * ����Ϣ��ȡֵ��Χ�趨
	 *
	 * @param pidoption ����Ϣ��ȡֵ��Χ
	 */
	public void setPidoption(String pidoption) {
		this.pidoption = pidoption;
	}

	/**
	 * ����Ϣ���Ƿ������ȡ��
	 * 
	 * @return ����Ϣ���Ƿ������
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * ����Ϣ���Ƿ�������趨
	 *
	 * @param pidrequired ����Ϣ���Ƿ������
	 */
	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}

	/**
	 * ����Ϣ������ȡ��
	 * 
	 * @return ����Ϣ������
	 */
	public String getPidtype() {
		return pidtype;
	}

	/**
	 * ����Ϣ�������趨
	 *
	 * @param pidtype ����Ϣ������
	 */
	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	/**
	 * ����Ϣ��¼��ʱ���ȡ��
	 * 
	 * @return ����Ϣ��¼��ʱ���
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * ����Ϣ��¼��ʱ����趨
	 *
	 * @param fingerPrint ����Ϣ��¼��ʱ���
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public String getPidaccess() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPidvalue() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPiid() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<IG286TB> getProcessLinkageDefList() {
		return null;
	}

	public String getCcid() {
		// TODO Auto-generated method stub
		return ccid;
	}

	/**
	 * ��ģʽȡ��
	 *
	 * @return pidmode ��ģʽ
	 */
	public String getPidmode() {
		return pidmode;
	}

	/**
	 * ��ģʽ�趨
	 *
	 * @param pidmode ��ģʽ
	 */
	public void setPidmode(String pidmode) {
		this.pidmode = pidmode;
	}

	/**
	 * ����Ϣ������ʾģʽȡ��
	 * 
	 * @return ����Ϣ������ʾģʽ
	 */
	public String getRowwidth() {
		return rowwidth;
	}

	/**
	 * ����Ϣ������ʾģʽ�趨
	 *
	 * @param rowwidth ����Ϣ������ʾģʽ
	 */
	public void setRowwidth(String rowwidth) {
		this.rowwidth = rowwidth;
	}
	
	/**
	 * ����Ϣ������ʾģʽ�趨
	 * 
	 * @return ����Ϣ������ʾģʽ
	 */
	public String getPrivatescope() {
		return privatescope;
	}

	/**
	 * ����Ϣ������ʾģʽȡ��
	 * 
	 * @param privatescope ����Ϣ������ʾģʽ
	 */
	public void setPrivatescope(String privatescope) {
		this.privatescope = privatescope;
	}

	public List<IG899TB> getProcessPrivateInfoList() {
		// TODO Auto-generated method stub
		return processPrivateInfoList;
	}
	
	public void setProcessPrivateInfoList(List<IG899TB> processPrivateInfoList){
		this.processPrivateInfoList = processPrivateInfoList;
	}
	
	/** �鿴ģʽ 0���£��ɱ༭��1����ʷ��ֻ�鿴 */
	protected String viewhistory;

	/**
	 * �鿴ģʽ
	 *
	 * @return �鿴ģʽ
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * �鿴ģʽ
	 *
	 * @param viewHistory  0�����£�1��ʷ
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
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
	 * ��������ʾģʽȡ��
	 * @return ��������ʾģʽ
	 */
	public String getPiddisplay() {
		return piddisplay;
	}

	/**
	 * ��������ʾģʽ�趨
	 * @param piddisplay ��������ʾģʽ
	 */
	public void setPiddisplay(String piddisplay) {
		this.piddisplay = piddisplay;
	}

	/**
	 * ������ʹ��ģʽȡ��
	 * @return ������ʹ��ģʽ
	 */
	public String getPiduse() {
		return piduse;
	}

	/**
	 * ������ʹ��ģʽ�趨
	 * @param piduse ������ʹ��ģʽ
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

	public String getPiddisplaya() {
		return piddisplaya;
	}

	public void setPiddisplaya(String piddisplaya) {
		this.piddisplaya = piddisplaya;
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
	 * �Ƿ���ʾ����ȡ��
	 * @return showline �Ƿ���ʾ����
	 */
	public String getShowline() {
		return showline;
	}

	/**
	 * �Ƿ���ʾ�����趨
	 * @param showline �Ƿ���ʾ����
	 */
	public void setShowline(String showline) {
		this.showline = showline;
	}
	
	public String getPidunit() {
		return pidunit;
	}

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
	 * ������ʾģʽȡ��
	 * @return titledisplay ������ʾģʽ
	 */
	public String getTitledisplay() {
		return titledisplay;
	}

	/**
	 * ������ʾģʽ�趨
	 * @param titledisplay ������ʾģʽ
	 */
	public void setTitledisplay(String titledisplay) {
		this.titledisplay = titledisplay;
	}

	/**
	 * �Ƿ�����������ȡ��
	 * @return needidea �Ƿ�����������
	 */
	public String getNeedidea() {
		return needidea;
	}

	/**
	 * �Ƿ������������趨
	 * @param needidea �Ƿ�����������
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
	 * ��Ա����ɫ����ȡ��
	 * @return participantRoleType ��Ա����ɫ����
	 */
	public String getParticipantRoleType() {
		return participantRoleType;
	}

	/**
	 * ��Ա����ɫ�����趨
	 * @param participantRoleType ��Ա����ɫ����
	 */
	public void setParticipantRoleType(String participantRoleType) {
		this.participantRoleType = participantRoleType;
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
	 * ��������С��λ��ȡ��
	 * @return ��������С��λ��
	 */
	public String getDecimals() {
		return decimals;
	}

	/**
	 * ��������С��λ���趨
	 * @param decimals ��������С��λ��
	 */
	public void setDecimals(String decimals) {
		this.decimals = decimals;
	}

	/**
	 * ��Ա����ɫ��Χ��Ϣȡ��
	 * @return participantRoles ��Ա����ɫ��Χ��Ϣ
	 */
	public String getParticipantRoles() {
		return participantRoles;
	}

	/**
	 * ��Ա����ɫ��Χ��Ϣ�趨
	 * @param participantRoles ��Ա����ɫ��Χ��Ϣ
	 */
	public void setParticipantRoles(String participantRoles) {
		this.participantRoles = participantRoles;
	}
	
	public FormFile getAttachFileMuti(int index) {
		return (FormFile) fileMapMuti.get(new Integer(index));
	}

	public void setAttachFileMuti(int index, FormFile file) {
		fileMapMuti.put(new Integer(index), file);
	}

	public Map<Integer, FormFile> getFileMapMuti() {
		return fileMapMuti;
	}

	public void setFileMapMuti(Map<Integer, FormFile> fileMapMuti) {
		this.fileMapMuti = fileMapMuti;
	}

	public List<Attachment> getAttList() {
		return attList;
	}

	public void setAttList(List<Attachment> attList) {
		this.attList = attList;
	}

	public String[] getAttids() {
		return attids;
	}

	public void setAttids(String[] attids) {
		this.attids = attids;
	}

	public String[] getAttdel() {
		return attdel;
	}

	public void setAttdel(String[] attdel) {
		this.attdel = attdel;
	}

	public String[] getAsmname() {
		return asmname;
	}

	public void setAsmname(String[] asmname) {
		this.asmname = asmname;
	}

	public String[] getAsminfo() {
		return asminfo;
	}

	public void setAsminfo(String[] asminfo) {
		this.asminfo = asminfo;
	}

	public Map<Integer, String> getEntityInfoMap() {
		return entityInfoMap;
	}

	public void setEntityInfoMap(Map<Integer, String> entityInfoMap) {
		this.entityInfoMap = entityInfoMap;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.workflow.prd.model.IG007Info#getIsFlag()
	 */
	public String getIsFlag() {
		// TODO Auto-generated method stub
		return null;
	}
}
