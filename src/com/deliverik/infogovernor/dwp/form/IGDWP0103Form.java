/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.form;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ��������������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP0103Form extends BaseForm{
	
	/** �ƻ�ID */
	protected Integer id;
	
	/** �ƻ����� */
	protected String pname;
	
	/** �ƻ����� */
	protected String pdesc;
	
	/** ���̶���ID */
	protected String pdid;
	
	/** �������� */
	protected String pdname;
	
	/** �������� */
	protected String smscontent;
	
	/** ��ʼʱ�� */
	protected String startdate;
	
	/** ����ʱ�� */
	protected String enddate;
	
	/** �ƻ�ģʽ */
	protected String pmode;
	
	/** �ƻ����� */
	protected String ptype;
	
	/** �ƻ�ִ��ʱ�䣺Сʱ */
	protected String phour;
	
	/** �ƻ�ִ��ʱ�䣺���� */
	protected String pminute;
	
	/** �����ɫ */
	protected Integer prroleid;
	
	/** ��������ϵ��ʽ */
	protected String prinfo;
	
	/** ���̱��� */
	protected String prtitle;
	
	/** �������� */
	protected String prdesc;
	
	/** ���̱�������ֵ */
	protected String[] pivarvalue;
	
	/** ���̱�������ID */
	protected String[] pidid;
	
	/**�ı��򸽼���*/
	protected Map<Integer, FormFile> fileMapMuti = new LinkedHashMap<Integer, FormFile>();
	
	/** ������map�еĶ�Ӧ�����Ƽ�˳�� */
	protected String[] att=new String[]{};
	
	/** �ʲ� */
	protected Map<Integer, String> entityMap = new LinkedHashMap<Integer, String>();
	
	protected String parprid;
	
	protected String psdid;
	
	/** �鿴״̬��0�ɱ༭��1�ɲ鿴�� */
	protected String viewstate;

	/**
	 * �ƻ�IDȡ��
	 * @return id �ƻ�ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �ƻ�ID�趨
	 * @param id �ƻ�ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * �ƻ�����ȡ��
	 * @return pname �ƻ�����
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * �ƻ������趨
	 * @param pname �ƻ�����
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * �ƻ�����ȡ��
	 * @return pdesc �ƻ�����
	 */
	public String getPdesc() {
		return pdesc;
	}

	/**
	 * �ƻ������趨
	 * @param pdesc �ƻ�����
	 */
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	/**
	 * ���̶���IDȡ��
	 * @return pdid ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ��������ȡ��
	 * @return pdname ��������
	 */
	public String getPdname() {
		return pdname;
	}

	/**
	 * ���������趨
	 * @param pdname ��������
	 */
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}

	/**
	 * ��������ȡ��
	 * @return smscontent ��������
	 */
	public String getSmscontent() {
		return smscontent;
	}

	/**
	 * ���������趨
	 * @param smscontent ��������
	 */
	public void setSmscontent(String smscontent) {
		this.smscontent = smscontent;
	}

	/**
	 * ��ʼʱ��ȡ��
	 * @return startdate ��ʼʱ��
	 */
	public String getStartdate() {
		return startdate;
	}

	/**
	 * ��ʼʱ���趨
	 * @param startdate ��ʼʱ��
	 */
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return enddate ����ʱ��
	 */
	public String getEnddate() {
		return enddate;
	}

	/**
	 * ����ʱ���趨
	 * @param enddate ����ʱ��
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	/**
	 * �ƻ�ģʽȡ��
	 * @return pmode �ƻ�ģʽ
	 */
	public String getPmode() {
		return pmode;
	}

	/**
	 * �ƻ�ģʽ�趨
	 * @param pmode �ƻ�ģʽ
	 */
	public void setPmode(String pmode) {
		this.pmode = pmode;
	}

	/**
	 * �ƻ�����ȡ��
	 * @return ptype �ƻ�����
	 */
	public String getPtype() {
		return ptype;
	}

	/**
	 * �ƻ������趨
	 * @param ptype �ƻ�����
	 */
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	/**
	 * �ƻ�ִ��ʱ�䣺Сʱȡ��
	 * @return phour �ƻ�ִ��ʱ�䣺Сʱ
	 */
	public String getPhour() {
		return phour;
	}

	/**
	 * �ƻ�ִ��ʱ�䣺Сʱ�趨
	 * @param phour �ƻ�ִ��ʱ�䣺Сʱ
	 */
	public void setPhour(String phour) {
		this.phour = phour;
	}

	/**
	 * �ƻ�ִ��ʱ�䣺����ȡ��
	 * @return pminute �ƻ�ִ��ʱ�䣺����
	 */
	public String getPminute() {
		return pminute;
	}

	/**
	 * �ƻ�ִ��ʱ�䣺�����趨
	 * @param pminute �ƻ�ִ��ʱ�䣺����
	 */
	public void setPminute(String pminute) {
		this.pminute = pminute;
	}
	
	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	public String getParprid() {
		return parprid;
	}

	public void setParprid(String parprid) {
		this.parprid = parprid;
	}

	/**
	 * �����ɫȡ��
	 * @return prroleid �����ɫ
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * �����ɫ�趨
	 * @param prroleid �����ɫ
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	/**
	 * ��������ϵ��ʽȡ��
	 * @return prinfo ��������ϵ��ʽ
	 */
	public String getPrinfo() {
		return prinfo;
	}

	/**
	 * ��������ϵ��ʽ�趨
	 * @param prinfo ��������ϵ��ʽ
	 */
	public void setPrinfo(String prinfo) {
		this.prinfo = prinfo;
	}

	/**
	 * ���̱���ȡ��
	 * @return prtitle ���̱���
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ���̱����趨
	 * @param prtitle ���̱���
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ��������ȡ��
	 * @return prdesc ��������
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * ���������趨
	 * @param prdesc ��������
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * ���̱�������ֵȡ��
	 * @return pivarvalue ���̱�������ֵ
	 */
	public String[] getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * ���̱�������ֵ�趨
	 * @param pivarvalue ���̱�������ֵ
	 */
	public void setPivarvalue(String[] pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * ���̱�������IDȡ��
	 * @return pidid ���̱�������ID
	 */
	public String[] getPidid() {
		return pidid;
	}

	/**
	 * ���̱�������ID�趨
	 * @param pidid ���̱�������ID
	 */
	public void setPidid(String[] pidid) {
		this.pidid = pidid;
	}
	
	/**
	 * ���ø���ֵ
	 * @param index ��������
	 * @param file
	 */
	public void setAttachFileMuti(int index, FormFile file) {
		fileMapMuti.put(new Integer(index), file);
	}

	/**
	 * �ı��򸽼���ȡ��
	 * @return fileMapMuti �ı��򸽼���
	 */
	public Map<Integer, FormFile> getFileMapMuti() {
		return fileMapMuti;
	}

	/**
	 * �ı��򸽼����趨
	 * @param fileMapMuti �ı��򸽼���
	 */
	public void setFileMapMuti(Map<Integer, FormFile> fileMapMuti) {
		this.fileMapMuti = fileMapMuti;
	}

	/**
	 * ������map�еĶ�Ӧ�����Ƽ�˳��ȡ��
	 * @return att ������map�еĶ�Ӧ�����Ƽ�˳��
	 */
	public String[] getAtt() {
		return att;
	}

	/**
	 * ������map�еĶ�Ӧ�����Ƽ�˳���趨
	 * @param att ������map�еĶ�Ӧ�����Ƽ�˳��
	 */
	public void setAtt(String[] att) {
		this.att = att;
	}
	
	/**
	 * �����ʲ�
	 * @param index �ʲ���������
	 * @param file �ʲ�
	 */
	public void setEntityId(int index, String entityId) {
		entityMap.put(new Integer(index), entityId);
	}

	/**
	 * �ʲ�ȡ��
	 * @return entityMap �ʲ�
	 */
	public Map<Integer, String> getEntityMap() {
		return entityMap;
	}

	/**
	 * �ʲ��趨
	 * @param entityMap �ʲ�
	 */
	public void setEntityMap(Map<Integer, String> entityMap) {
		this.entityMap = entityMap;
	}

	/**
	 * �鿴״̬��0�ɱ༭��1�ɲ鿴��ȡ��
	 * @return viewstate �鿴״̬��0�ɱ༭��1�ɲ鿴��
	 */
	public String getViewstate() {
		return viewstate;
	}

	/**
	 * �鿴״̬��0�ɱ༭��1�ɲ鿴���趨
	 * @param viewstate �鿴״̬��0�ɱ༭��1�ɲ鿴��
	 */
	public void setViewstate(String viewstate) {
		this.viewstate = viewstate;
	}
	
}
