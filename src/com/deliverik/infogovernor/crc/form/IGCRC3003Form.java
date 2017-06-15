package com.deliverik.infogovernor.crc.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * ���ܣ�Զ�̶Խ��Զ����������̵�form
 */
public class IGCRC3003Form extends BaseForm{
	
	private static final long serialVersionUID = 1L;

	/** �û�id */
	protected String platformuserid;
	
	/** ������� */
	protected String title;
	
	/** ������� */
	protected String desc;
	
	/** �ƻ�ִ�п�ʼʱ�� */
	protected String begintime;
	
	/** ������� */
	protected String tree;
	
	/** ������ */
	protected String type1;
	
	/** ������� */
	protected String type2;
	
	/** ����ƽ̨ */
	protected String type3;
	
	/** ���ԭ����� */
	protected String type4;
	
	/** ���ԭ�� */
	protected String text1;
	
	/** ������� */
	protected String text2;
	
	/** �Ƿ�Ӱ��ҵ�� */
	protected String type5;
	
	/** ִ�мƻ� */
	protected String text3;
	
	/** ���˼ƻ� */
	protected String text4;
	
	/** ��֤�ƻ� */
	protected String text5;
	
	/**�ı��򸽼���*/
	protected Map<Integer, FormFile> fileMapMuti = null;
	
	/** ���� */
	protected Map<Integer, FormFile> fileMap = null;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		fileMapMuti = new HashMap<Integer, FormFile>();
		fileMap = new HashMap<Integer, FormFile>();
	}
	
	public FormFile getAttachFileMuti(int index) {
		return (FormFile) fileMapMuti.get(new Integer(index));
	}
	
	public Map<Integer, FormFile> getFileMapMuti() {
		return fileMapMuti;
	}
	
	public void setFileMapMuti(Map<Integer, FormFile> fileMapMuti) {
		this.fileMapMuti = fileMapMuti;
	}
	
	/**
	 * ��ȡ����
	 * @return ��ȡ����
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get(new Integer(index));
	}

	/**
	 * ���ø���
	 * @param index ������������
	 * @param file ����
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put(new Integer(index), file);
	}
	
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	/**
	 * �����趨
	 * @param fileMap ����
	 */
	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}

	/**
     * �û�id��ȡ
     * @return �û�id
     */
	public String getPlatformuserid() {
		return platformuserid;
	}

	/**
	 * �û�id����
	 * @param platformuserid �û�id
	 */
	public void setPlatformuserid(String platformuserid) {
		this.platformuserid = platformuserid;
	}

	/**
     * ������ƻ�ȡ
     * @return �������
     */
	public String getTitle() {
		return title;
	}

	/**
	 * �����������
	 * @param title �������
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
     * ���������ȡ
     * @return �������
     */
	public String getDesc() {
		return desc;
	}

	/**
	 * �����������
	 * @param desc �������
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
     * �ƻ�ִ�п�ʼʱ���ȡ
     * @return �ƻ�ִ�п�ʼʱ�� 
     */
	public String getBegintime() {
		return begintime;
	}

	/**
	 * �ƻ�ִ�п�ʼʱ������
	 * @param begintime �ƻ�ִ�п�ʼʱ�� 
	 */
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	
	/**
     * ������ͻ�ȡ
     * @return �������
     */
	public String getTree() {
		return tree;
	}

	/**
	 * �����������
	 * @param tree �������
	 */
	public void setTree(String tree) {
		this.tree = tree;
	}

	/**
     * ������ ��ȡ
     * @return ������ 
     */
	public String getType1() {
		return type1;
	}

	/**
	 * ������ ����
	 * @param type1  ������ 
	 */
	public void setType1(String type1) {
		this.type1 = type1;
	}

	/**
     * ��������ȡ
     * @return �������
     */
	public String getType2() {
		return type2;
	}

	/**
	 * �����������
	 * @param type2  �������
	 */
	public void setType2(String type2) {
		this.type2 = type2;
	}

	/**
     * ����ƽ̨��ȡ
     * @return ����ƽ̨
     */
	public String getType3() {
		return type3;
	}

	/**
	 * ����ƽ̨����
	 * @param type3  ����ƽ̨
	 */
	public void setType3(String type3) {
		this.type3 = type3;
	}

	/**
     * ���ԭ������ȡ
     * @return ���ԭ�����
     */
	public String getType4() {
		return type4;
	}

	/**
	 * ���ԭ���������
	 * @param type4  ���ԭ�����
	 */
	public void setType4(String type4) {
		this.type4 = type4;
	}

	/**
     * ���ԭ���ȡ
     * @return ���ԭ��
     */
	public String getText1() {
		return text1;
	}

	/**
	 * ���ԭ������
	 * @param text1  ���ԭ��
	 */
	public void setText1(String text1) {
		this.text1 = text1;
	}

	/**
     * ������ݻ�ȡ
     * @return �������
     */
	public String getText2() {
		return text2;
	}

	/**
	 * �����������
	 * @param text2  �������
	 */
	public void setText2(String text2) {
		this.text2 = text2;
	}

	/**
     * �Ƿ�Ӱ��ҵ���ȡ
     * @return �Ƿ�Ӱ��ҵ��
     */
	public String getType5() {
		return type5;
	}

	/**
	 * �Ƿ�Ӱ��ҵ������
	 * @param type5  �Ƿ�Ӱ��ҵ��
	 */
	public void setType5(String type5) {
		this.type5 = type5;
	}

	/**
     * ִ�мƻ���ȡ
     * @return ִ�мƻ�
     */
	public String getText3() {
		return text3;
	}

	/**
	 * ִ�мƻ�����
	 * @param text3 ִ�мƻ�
	 */
	public void setText3(String text3) {
		this.text3 = text3;
	}

	/**
     * ���˼ƻ���ȡ
     * @return ���˼ƻ�
     */
	public String getText4() {
		return text4;
	}

	/**
	 * ���˼ƻ�����
	 * @param text4 ���˼ƻ�
	 */
	public void setText4(String text4) {
		this.text4 = text4;
	}

	/**
     * ��֤�ƻ���ȡ
     * @return ��ʼʱ��
     */
	public String getText5() {
		return text5;
	}

	/**
	 * ��֤�ƻ�����
	 * @param text5 ��֤�ƻ�
	 */
	public void setText5(String text5) {
		this.text5 = text5;
	}
	
}
