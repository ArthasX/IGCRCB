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
 * Description: ����������ϢForm
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP0105Form extends BaseForm{

	/** �ƻ�ID */
	protected Integer id;
	
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
}
