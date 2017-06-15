/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.nms.model.NMS01Info;
import com.deliverik.infogovernor.nms.model.NMS02Info;
import com.deliverik.infogovernor.nms.model.NMS03Info;

/**
 * ����: �Զ�����DTO
 * ��������: �Զ�����DTO
 * ������¼: 2013/12/20
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGNMS01DTO extends BaseDTO{
	
	/** SNMP������Ϣ */
	protected NMS02Info nms02Info;
	
	/** SNMP�����б� */
	protected List<NMS02Info> lst_NMS02Info;
	
	/** ����������Ϣ */
	protected NMS03Info nms03Info;
	
	/** ���������б� */
	protected List<NMS03Info> lst_NMS03Info; 
	
	/** ����Ϣ */
	protected NMS01Info nms01Info;

	/** �û�id */
	protected String userid;
	
	/** ��ID */
	protected Integer groupId;
	
	/** �汾 */
	protected Integer groupVersion;
	
	/** ������ͼ���ͣ�1��ȫ������ 2���û����ˣ� */
	protected String topoType;
	
	/** ��Ҫ���µ��豸 */
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
    protected String subNetRegion;
    
    /** �޸�����������Ϣ */
    protected String updateRegionStr;
    
    /** ɾ���������� */
    protected String delRegionStr;
    
	/** ����չʾ��xml */
	protected String xml;
	
	/** ���ر�ʶ��0ʧ�ܣ�1�ɹ���-1ɨ�����ִ���ļ������ڣ� */
	protected int flag;
	
	/** ����С */
	protected String panelSize;
	
	/** ����Сxml */
	protected String panelSizeInfoXml;
	
	/** �����豸ͼƬ·��xml */
	protected String imgUrlXml;
	
	/** �����豸����xml */
	protected String devTypeXml;
	
	/** ����չ�����ͣ�1��ȫ������ͼ 2�������豸����ͼ�� */
    protected String showType;
    
	/**
	 * SNMP������Ϣȡ��
	 * @return SNMP������Ϣ
	 */
	public NMS02Info getNms02Info() {
		return nms02Info;
	}

	/**
	 * SNMP������Ϣ�趨
	 * @param nms02Info SNMP������Ϣ
	 */
	public void setNms02Info(NMS02Info nms02Info) {
		this.nms02Info = nms02Info;
	}

	/**
	 * SNMP�����б�ȡ��
	 * @return SNMP�����б�
	 */
	public List<NMS02Info> getLst_NMS02Info() {
		return lst_NMS02Info;
	}

	/**
	 * SNMP�����б��趨
	 * @param lst_NMS02Info SNMP �����б�
	 */
	public void setLst_NMS02Info(List<NMS02Info> lst_NMS02Info) {
		this.lst_NMS02Info = lst_NMS02Info;
	}

	/**
	 * ����������Ϣȡ��
	 * @return ����������Ϣ
	 */
	public NMS03Info getNms03Info() {
		return nms03Info;
	}

	/**
	 * ����������Ϣ�趨
	 * @param nms03Info ����������Ϣ
	 */
	public void setNms03Info(NMS03Info nms03Info) {
		this.nms03Info = nms03Info;
	}

	/**
	 * ���������б�ȡ��
	 * @return ���������б�
	 */
	public List<NMS03Info> getLst_NMS03Info() {
		return lst_NMS03Info;
	}

	/**
	 * ���������б��趨
	 * @param lst_NMS03Info ���������б�
	 */
	public void setLst_NMS03Info(List<NMS03Info> lst_NMS03Info) {
		this.lst_NMS03Info = lst_NMS03Info;
	}

    /**
     * ��ȡ����Ϣ
     * @return ����Ϣ 
     */
    public NMS01Info getNms01Info() {
        return nms01Info;
    }

    /**
     * ��������Ϣ
     * @param nms01Info ����Ϣ
     */
    public void setNms01Info(NMS01Info nms01Info) {
        this.nms01Info = nms01Info;
    }

    /**
     * ��ȡ�û�id
     * @return �û�id 
     */
    public String getUserid() {
        return userid;
    }

    /**
     * �����û�id
     * @param userid �û�id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * ��ȡ��ID
     * @return ��ID 
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * ������ID
     * @param groupId ��ID
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * ��ȡ�汾
     * @return �汾 
     */
    public Integer getGroupVersion() {
        return groupVersion;
    }

    /**
     * ���ð汾
     * @param groupVersion �汾
     */
    public void setGroupVersion(Integer groupVersion) {
        this.groupVersion = groupVersion;
    }

    /**
     * ��ȡ������ͼ���ͣ�1��ȫ������2���û����ˣ�
     * @return ������ͼ���ͣ�1��ȫ������2���û����ˣ� 
     */
    public String getTopoType() {
        return topoType;
    }

    /**
     * ����������ͼ���ͣ�1��ȫ������2���û����ˣ�
     * @param topoType ������ͼ���ͣ�1��ȫ������2���û����ˣ�
     */
    public void setTopoType(String topoType) {
        this.topoType = topoType;
    }

    /**
     * ��ȡ��Ҫ���µ��豸
     * @return ��Ҫ���µ��豸 
     */
    public String getUpdateDevice() {
        return updateDevice;
    }

    /**
     * ������Ҫ���µ��豸
     * @param updateDevice ��Ҫ���µ��豸
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
     * subNetRegion is returned.
     * @return subNetRegion
     */
    public String getSubNetRegion() {
        return subNetRegion;
    }

    /**
     * subNetRegion is set.
     * @param subNetRegion subNetRegion
     */
    public void setSubNetRegion(String subNetRegion) {
        this.subNetRegion = subNetRegion;
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
     * ��ȡ����չʾ��xml
     * @return ����չʾ��xml 
     */
    public String getXml() {
        return xml;
    }

    /**
     * ��������չʾ��xml
     * @param xml ����չʾ��xml
     */
    public void setXml(String xml) {
        this.xml = xml;
    }

	/**
	 * �Ƿ�ɹ���ʶȡ��
	 * @return �Ƿ�ɹ���ʶ
	 */
	public int getFlag() {
		return flag;
	}

	/**
	 * �Ƿ�ɹ���ʶ�趨
	 * @param flag �Ƿ�ɹ���ʶ
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}

    /**
     * ��ȡ����С
     * @return ����С 
     */
    public String getPanelSize() {
        return panelSize;
    }

    /**
     * ��������С
     * @param panelSize ����С
     */
    public void setPanelSize(String panelSize) {
        this.panelSize = panelSize;
    }

    /**
     * ��ȡ����Сxml
     * @return ����Сxml 
     */
    public String getPanelSizeInfoXml() {
        return panelSizeInfoXml;
    }

    /**
     * ��������Сxml
     * @param panelSizeInfoXml ����Сxml
     */
    public void setPanelSizeInfoXml(String panelSizeInfoXml) {
        this.panelSizeInfoXml = panelSizeInfoXml;
    }

	/**
	 * �����豸ͼƬ·��xmlȡ��
	 * @return imgUrlXml �����豸ͼƬ·��xml
	 */
	public String getImgUrlXml() {
		return imgUrlXml;
	}

	/**
	 * �����豸ͼƬ·��xml�趨
	 * @param imgUrlXml �����豸ͼƬ·��xml
	 */
	public void setImgUrlXml(String imgUrlXml) {
		this.imgUrlXml = imgUrlXml;
	}

	/**
	 * �����豸����xmlȡ��
	 * @return devTypeXml �����豸����xml
	 */
	public String getDevTypeXml() {
		return devTypeXml;
	}

	/**
	 * �����豸����xml�趨
	 * @param devTypeXml �����豸����xml
	 */
	public void setDevTypeXml(String devTypeXml) {
		this.devTypeXml = devTypeXml;
	}

    /**
     * ��ȡ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @return ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ�� 
     */
    public String getShowType() {
        return showType;
    }

    /**
     * ��������չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     * @param showType ����չ�����ͣ�1��ȫ������ͼ2�������豸����ͼ��
     */
    public void setShowType(String showType) {
        this.showType = showType;
    }
	
}
