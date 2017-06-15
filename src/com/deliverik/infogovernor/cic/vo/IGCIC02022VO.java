/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.cic.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.cic.model.CompareobjectHistoryInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����һ���Աȶ�_����һ���Աȶ�_�ԱȽ���鿴����_��ʾ����VO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIC02022VO extends BaseVO implements Serializable{
	
    /** ҵ��ϵͳid */
    protected Integer crsystemid;

    /** ҵ��ϵͳ���� */
    protected String crsystemname;
    
    /** �Ա����� */
    protected String crtype;
    
    /** �Ա�Դ��������d */
    protected String cosourceName;

    /** �Ա�Ŀ����󼯺� */
    protected Map<String, List<IGCIC02023VO>>  cotargetVOLi;

    /** 
     * ҵ��ϵͳid ȡ��
     * @return crsystemid ҵ��ϵͳid 
     */
    public Integer getCrsystemid() {
        return crsystemid;
    }

    /** 
     * ҵ��ϵͳid �趨
     * @param crsystemid ҵ��ϵͳid 
     */
    public void setCrsystemid(Integer crsystemid) {
        this.crsystemid = crsystemid;
    }

    /** 
     * ҵ��ϵͳ���� ȡ��
     * @return crsystemname ҵ��ϵͳ���� 
     */
    public String getCrsystemname() {
        return crsystemname;
    }

    /** 
     * ҵ��ϵͳ���� �趨
     * @param crsystemname ҵ��ϵͳ���� 
     */
    public void setCrsystemname(String crsystemname) {
        this.crsystemname = crsystemname;
    }

    /** 
     * �Ա����� ȡ��
     * @return crtype �Ա����� 
     */
    public String getCrtype() {
        return crtype;
    }

    /** 
     * �Ա����� �趨
     * @param crtype �Ա����� 
     */
    public void setCrtype(String crtype) {
        this.crtype = crtype;
    }

    /** 
     * �Ա�Դ��������d ȡ��
     * @return cosourceName �Ա�Դ��������d 
     */
    public String getCosourceName() {
        return cosourceName;
    }

    /** 
     * �Ա�Դ��������d �趨
     * @param cosourceName �Ա�Դ��������d 
     */
    public void setCosourceName(String cosourceName) {
        this.cosourceName = cosourceName;
    }

    /** 
     * �Ա�Ŀ����󼯺� ȡ��
     * @return cotargetVOLi �Ա�Ŀ����󼯺� 
     */
    public Map<String, List<IGCIC02023VO>> getCotargetVOLi() {
        return cotargetVOLi;
    }

    /** 
     * �Ա�Ŀ����󼯺� �趨
     * @param cotargetVOLi �Ա�Ŀ����󼯺� 
     */
    public void setCotargetVOLi(Map<String, List<IGCIC02023VO>> cotargetVOLi) {
        this.cotargetVOLi = cotargetVOLi;
    }
    
}


