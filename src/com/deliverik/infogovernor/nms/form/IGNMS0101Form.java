/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���������Զ�����form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGNMS0101Form extends BaseForm {

	/** ��ID */
	protected Integer gid;
	
	/** ��汾 */
	protected Integer gversion;
	
	/**  ��������*/
	protected String topotype;
	
	/** �����豸 */
	protected String updateDevice;
	
	/** ����豸 */
	protected String addDevice;
	
	/** �����· */
	protected String addRela;
	
	/** ɾ���豸 */
	protected String delDevice;
	
	/** ɾ����· */
	protected String delRela;

	/** �޸��豸���� */
	protected String renameDevice;
	
	/** �������� */
	protected String regionStr;
	
	/** �޸�����������Ϣ */
	protected String updateRegionStr;
	
	/** ɾ���������� */
	protected String delRegionStr;
	
	/** �޸�����С */
	protected String panelSize;
	
	/** �༭ģʽ���� */
	protected String editModeType;
	
	/** ����չ�����ͣ�1��ȫ������ͼ 2�������豸����ͼ�� */
    protected String showtype;
	
	/**
	 * ��IDȡ��
	 * @return ��ID
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * ��ID�趨
	 * @param gid ��ID
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * ��汾ȡ��
	 * @return ��汾
	 */
	public Integer getGversion() {
		return gversion;
	}

	/**
	 * ��汾�趨
	 * @param gversion ��汾
	 */
	public void setGversion(Integer gversion) {
		this.gversion = gversion;
	}

    /**
     * ��ȡ��������
     * @return �������� 
     */
    public String getTopotype() {
        return topotype;
    }

    /**
     * ������������
     * @param topotype ��������
     */
    public void setTopotype(String topotype) {
        this.topotype = topotype;
    }

    /**
     * ��ȡ�����豸
     * @return �����豸 
     */
    public String getUpdateDevice() {
        return updateDevice;
    }

    /**
     * ���ø����豸
     * @param updateDevice �����豸
     */
    public void setUpdateDevice(String updateDevice) {
        this.updateDevice = updateDevice;
    }

    /**
     * ��ȡ����豸
     * @return ����豸 
     */
    public String getAddDevice() {
        return addDevice;
    }

    /**
     * ��������豸
     * @param addDevice ����豸
     */
    public void setAddDevice(String addDevice) {
        this.addDevice = addDevice;
    }

    /**
     * ��ȡ�����·
     * @return �����· 
     */
    public String getAddRela() {
        return addRela;
    }

    /**
     * ���������·
     * @param addRela �����·
     */
    public void setAddRela(String addRela) {
        this.addRela = addRela;
    }

    /**
     * ��ȡɾ���豸
     * @return ɾ���豸 
     */
    public String getDelDevice() {
        return delDevice;
    }

    /**
     * ����ɾ���豸
     * @param delDevice ɾ���豸
     */
    public void setDelDevice(String delDevice) {
        this.delDevice = delDevice;
    }

    /**
     * ��ȡɾ����·
     * @return ɾ����· 
     */
    public String getDelRela() {
        return delRela;
    }

    /**
     * ����ɾ����·
     * @param delRela ɾ����·
     */
    public void setDelRela(String delRela) {
        this.delRela = delRela;
    }

    /**
     * ��ȡ�޸��豸����
     * @return �޸��豸���� 
     */
    public String getRenameDevice() {
        return renameDevice;
    }

    /**
     * �����޸��豸����
     * @param renameDevice �޸��豸����
     */
    public void setRenameDevice(String renameDevice) {
        this.renameDevice = renameDevice;
    }

    /**
     * regionStr is returned.
     * @return regionStr
     */
    public String getRegionStr() {
        return regionStr;
    }

    /**
     * regionStr is set.
     * @param regionStr regionStr
     */
    public void setRegionStr(String regionStr) {
        this.regionStr = regionStr;
    }

    /**
     * updateRegionStr is returned.
     * @return updateRegionStr
     */
    public String getUpdateRegionStr() {
        return updateRegionStr;
    }

    /**
     * updateRegionStr is set.
     * @param updateRegionStr updateRegionStr
     */
    public void setUpdateRegionStr(String updateRegionStr) {
        this.updateRegionStr = updateRegionStr;
    }

    /**
     * ��ȡɾ����������
     * @return ɾ���������� 
     */
    public String getDelRegionStr() {
        return delRegionStr;
    }

    /**
     * ����ɾ����������
     * @param delRegionStr ɾ����������
     */
    public void setDelRegionStr(String delRegionStr) {
        this.delRegionStr = delRegionStr;
    }

    /**
     * ��ȡ�޸�����С
     * @return �޸�����С 
     */
    public String getPanelSize() {
        return panelSize;
    }

    /**
     * �����޸�����С
     * @param panelSize �޸�����С
     */
    public void setPanelSize(String panelSize) {
        this.panelSize = panelSize;
    }

    /**
     * ��ȡ�༭ģʽ����
     * @return �༭ģʽ���� 
     */
    public String getEditModeType() {
        return editModeType;
    }

    /**
     * ���ñ༭ģʽ����
     * @param editModeType �༭ģʽ����
     */
    public void setEditModeType(String editModeType) {
        this.editModeType = editModeType;
    }

    /**
     * ��ȡ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @return ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ�� 
     */
    public String getShowtype() {
        return showtype;
    }

    /**
     * ��������չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @param showtype ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     */
    public void setShowtype(String showtype) {
        this.showtype = showtype;
    }
	
}
