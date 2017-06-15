package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.CodeDetail;

/**
 * ���ݷ����б���Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGSYM11011VO extends BaseVO implements Serializable{
	
	/** ���ݷ����б���Ϣ������� */
	protected List<CodeCategoryInfo> codeCategoryInfoList;
	
	/**Ӱ��̶�*/
	protected List<CodeDetail> primpactList; 
	
	/**�����̶�*/
	protected List<CodeDetail> prurgencyList; 
	
	/**Ӱ��̶ȳ���*/
	protected String primpactSize; 
	
	/**�����̶ȳ���*/
	protected String prurgencySize; 
	
	/**
	 * ���캯��
	 */
	public IGSYM11011VO() {
	}
	
	/**
	 * ���캯��
	 * @param entityData�����ݷ����б���Ϣ�������
	 */
	public IGSYM11011VO(List<CodeCategoryInfo> codeCategoryInfoList) {
		this.codeCategoryInfoList = codeCategoryInfoList;
	}
	
	/**
	 * ���ݷ����б���Ϣ�������ȡ��
	 * @return ���ݷ����б���Ϣ�������
	 */
	public List<CodeCategoryInfo> getCodeCategoryInfoList() {
		return codeCategoryInfoList;
	}

	public List<CodeDetail> getPrimpactList() {
		return primpactList;
	}

	public void setPrimpactList(List<CodeDetail> primpactList) {
		this.primpactList = primpactList;
	}

	public List<CodeDetail> getPrurgencyList() {
		return prurgencyList;
	}

	public void setPrurgencyList(List<CodeDetail> prurgencyList) {
		this.prurgencyList = prurgencyList;
	}

	public String getPrimpactSize() {
		return primpactSize;
	}

	public void setPrimpactSize(String primpactSize) {
		this.primpactSize = primpactSize;
	}

	public String getPrurgencySize() {
		return prurgencySize;
	}

	public void setPrurgencySize(String prurgencySize) {
		this.prurgencySize = prurgencySize;
	}

}


