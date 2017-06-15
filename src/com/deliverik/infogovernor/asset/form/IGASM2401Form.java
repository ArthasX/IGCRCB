package com.deliverik.infogovernor.asset.form;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * ��Ʊ��ѯ����FORM
 * 
 */
public class IGASM2401Form extends BaseForm implements IG688SearchCond{

    private static final long serialVersionUID = 1L;

    /** �ʲ�ģ�ͱ�� */
    protected String elabel;
    
    /**
     * ��ѯ��ʶ
     */
    private String queryflag;
    
    /** �ʲ�ģ���� */
    protected String ename;
    
    /** ��Ʊ��� */
    protected String eilabel;
    
    /** ��Ʊ���� */
    protected String einame;
    
    /** �ʲ�ģ�ͷ��� */
    protected String ecategory;
    
    /** �ʲ�ģ��һ������ */
    protected String ekey1;
    
    /** �ʲ�ģ�Ͷ������� */
    protected String ekey2;
    
    /** ��Ʊ����ʱ��FROM */
    protected String eiupdtime_from;
    
    /** ��Ʊ����ʱ��TO */
    protected String eiupdtime_to;
    
    /** ɾ����Ʊ���� */
    protected String[] deleteEiid;
    
    /** ��Ʊ������������������ */
    protected String[] cname = new String[4];
    
    /** ��Ʊ����ֵ������������ */
    protected String[] civalue = new String[4];
    
    /** ��Ʊ��ͨ���ñ�ż����������� */
    protected String[] cclabel = new String[2];
    
    /** ��Ʊ��ͨ����ֵ������������ */
    protected String[] ccivalue = new String[2];
    /** �ʲ�����������*/
    public String eiorgsyscoding;
    
    /** �ʲ���������������*/
    public String eiorgname;
    
    public String eistatus;
    /** �ʲ�������ģ��*/
    public String esyscoding;
    
    /** ��ƱժҪ */
    public String eidesc_like;
    
    /** �ʲ�ʹ�û���code*/
    public String usesyscoding;
    
    /** 
     * �ʲ�ģ�͵�״̬ 
     */
    protected String estatus;
    
    /**
     * �ʲ�ģ�͵�״̬ȡ��
     * @return �ʲ�ģ�͵�״̬
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * �ʲ�ģ�͵�״̬�趨
     *
     * @param estatus �ʲ�ģ�͵�״̬
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    public String getUsesyscoding() {
        return usesyscoding;
    }

    public void setUsesyscoding(String usesyscoding) {
        this.usesyscoding = usesyscoding;
    }
    
    public String getEsyscoding() {
        return esyscoding;
    }

    public void setEsyscoding(String esyscoding) {
        this.esyscoding = esyscoding;
    }

    public void setEistatus(String eistatus) {
        this.eistatus = eistatus;
    }

    public String getEistatus() {
        return eistatus;
    }
    
    public String getEiorgsyscoding() {
        return eiorgsyscoding;
    }

    public void setEiorgsyscoding(String eiorgsyscoding) {
        this.eiorgsyscoding = eiorgsyscoding;
    }

    public String getEiorgname() {
        return eiorgname;
    }

    public void setEiorgname(String eiorgname) {
        this.eiorgname = eiorgname;
    }

    /**
     * �ʲ�ģ�ͱ���ȡ��
     * @return �ʲ�ģ�ͱ���
     */
    public String getElabel() {
        return elabel;
    }

    /**
     * �ʲ�ģ�ͱ����趨
     *
     * @param elabel �ʲ�ģ�ͱ���
     */
    public void setElabel(String elabel) {
        this.elabel = elabel;
    }

    /**
     * �ʲ�ģ����ȡ��
     * @return �ʲ�ģ����
     */
    public String getEname() {
        return ename;
    }

    /**
     * �ʲ�ģ�����趨
     *
     * @param ename �ʲ�ģ����
     */
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**
     * ��Ʊ����ȡ��
     * @return ��Ʊ����
     */
    public String getEilabel() {
        return eilabel;
    }

    /**
     * ��Ʊ�����趨
     *
     * @param eilabel ��Ʊ����
     */
    public void setEilabel(String eilabel) {
        this.eilabel = eilabel;
    }

    /**
     * ��Ʊ����ȡ��
     * @return ��Ʊ����
     */
    public String getEiname() {
        return einame;
    }

    /**
     * ��Ʊ�����趨
     *
     * @param einame ��Ʊ����
     */
    public void setEiname(String einame) {
        this.einame = einame;
    }

    /**
     * �ʲ�ģ�ͷ���ȡ��
     * @return �ʲ�ģ�ͷ���
     */
    public String getEcategory() {
        return ecategory;
    }

    /**
     * �ʲ�ģ�ͷ����趨
     *
     * @param ecategory �ʲ�ģ�ͷ���
     */
    public void setEcategory(String ecategory) {
        this.ecategory = ecategory;
    }

    /**
     * �ʲ�ģ��һ������ȡ��
     * @return �ʲ�ģ��һ������
     */
    public String getEkey1() {
        return ekey1;
    }

    /**
     * �ʲ�ģ��һ�������趨
     *
     * @param ekey1 �ʲ�ģ��һ������
     */
    public void setEkey1(String ekey1) {
        this.ekey1 = ekey1;
    }

    /**
     * �ʲ�ģ�Ͷ�������ȡ��
     * @return �ʲ�ģ�Ͷ�������
     */
    public String getEkey2() {
        return ekey2;
    }

    /**
     * �ʲ�ģ�Ͷ��������趨
     *
     * @param ekey1 �ʲ�ģ�Ͷ�������
     */
    public void setEkey2(String ekey2) {
        this.ekey2 = ekey2;
    }

    /**
     * ��Ʊ����ʱ��FROMȡ��
     * @return ��Ʊ����ʱ��FROM
     */
    public String getEiupdtime_from() {
        return eiupdtime_from;
    }

    /**
     * ��Ʊ����ʱ��FROM�趨
     *
     * @param eiupdtime_from ��Ʊ����ʱ��FROM
     */
    public void setEiupdtime_from(String eiupdtime_from) {
        this.eiupdtime_from = eiupdtime_from;
    }

    /**
     * ��Ʊ����ʱ��TOȡ��
     * @return ��Ʊ����ʱ��TO
     */
    public String getEiupdtime_to() {
        return eiupdtime_to;
    }

    /**
     * ��Ʊ����ʱ��TO�趨
     *
     * @param eiupdtime_to ��Ʊ����ʱ��TO
     */
    public void setEiupdtime_to(String eiupdtime_to) {
        this.eiupdtime_to = eiupdtime_to;
    }


    /**
     * ɾ����Ʊ����ȡ��
     * @return ɾ����Ʊ����
     */
    public String[] getDeleteEiid() {
        return deleteEiid;
    }


    /**
     * ɾ����Ʊ�����趨
     *
     * @param deleteEiid ɾ����Ʊ����
     */
    public void setDeleteEiid(String[] deleteEiid) {
        this.deleteEiid = deleteEiid;
    }

    /**
     * ��Ʊ������������������ȡ��
     * @return ��Ʊ������������������
     */
    public String[] getCname() {
        return cname;
    }

    /**
     * ��Ʊ�������������������趨
     *
     * @param cname ��Ʊ������������������
     */
    public void setCname(String[] cname) {
        this.cname = cname;
    }

    /**
     * ��Ʊ����ֵ������������ȡ��
     * @return ��Ʊ����ֵ������������
     */
    public String[] getCivalue() {
        return civalue;
    }

    /**
     * ��Ʊ����ֵ�������������趨
     *
     * @param civalue ��Ʊ����ֵ������������
     */
    public void setCivalue(String[] civalue) {
        this.civalue = civalue;
    }

    /**
     * ��Ʊ��ͨ���ñ�ż�����������ȡ��
     * @return ��Ʊ��ͨ���ñ�ż�����������
     */
    public String[] getCclabel() {
        return cclabel;
    }

    /**
     * ��Ʊ��ͨ���ñ�ż������������趨
     *
     * @param cclabel ��Ʊ��ͨ���ñ�ż�����������
     */
    public void setCclabel(String[] cclabel) {
        this.cclabel = cclabel;
    }

    /**
     * ��Ʊ��ͨ����ֵ������������ȡ��
     * @return ��Ʊ��ͨ����ֵ������������
     */
    public String[] getCcivalue() {
        return ccivalue;
    }

    /**
     * ��Ʊ��ͨ����ֵ�������������趨
     *
     * @param ccivalue ��Ʊ��ͨ����ֵ������������
     */
    public void setCcivalue(String[] ccivalue) {
        this.ccivalue = ccivalue;
    }

    /**
     * ��ʼ������
     *
     * @param mapping 
     * @param request 
     */
    public void reset(ActionMapping mapping,HttpServletRequest request){
        super.reset(mapping, request);
        this.deleteEiid = null;
    }

    public String getEiorgsyscoding_q() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getEistatus_q() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getEiorgcode() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<String> getEiidList() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getWbdate_from() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getWbdate_to() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getEmodeltype_eq() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getCondudetime_from() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getCondudetime_to() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getFacilitator() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * ��ƱժҪ is returned.
     * @return eidesc_like
     */
    public String getEidesc_like() {
        return eidesc_like;
    }

    /**
     * ��ƱժҪ is set.
     * @param eidesc_like ��ƱժҪ
     */
    public void setEidesc_like(String eidesc_like) {
        this.eidesc_like = eidesc_like;
    }

    /**
     * ��ѯ��ʶ is returned.
     * @return queryflag
     */
    public String getQueryflag() {
        return queryflag;
    }

    /**
     * ��ѯ��ʶ is set.
     * @param queryflag ��ѯ��ʶ
     */
    public void setQueryflag(String queryflag) {
        this.queryflag = queryflag;
    }


}
