/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.rpt.model.condition;


/**
 * 
 * @Description:�Զ��������ɱ�Cond��
 * @Author
 * @History
 * @Version V1.0
 * �޸ļ�¼��2012/08/09 ��REPORT_GDATA_ITEMSearchCondImpl������ΪSOC0201SearchCondImpl
 */
public class SOC0201SearchCondImpl implements SOC0201SearchCond{
/**
*ͳ������
*/
protected String r_category;

/**
*ͳ������ȡ��
* @return ͳ������
*/
public String getR_category(){
return r_category;
}
/**
*ͳ�������趨
* @param r_categoryͳ������
*/
public void setR_category(String r_category){
this.r_category=r_category;
}
/**
*�����ļ�����
*/
protected String r_path;

/**
*�����ļ�����ȡ��
* @return �����ļ�����
*/
public String getR_path(){
return r_path;
}
/**
*�����ļ������趨
* @param r_path�����ļ�����
*/
public void setR_path(String r_path){
this.r_path=r_path;
}
/**
*��������id
*/
protected Integer r_rcid;

/**
*��������idȡ��
* @return ��������id
*/
public Integer getR_rcid(){
return r_rcid;
}
/**
*��������id�趨
* @param r_rcid��������id
*/
public void setR_rcid(Integer r_rcid){
this.r_rcid=r_rcid;
}
/**
*����ͳ������
*/
protected String r_time;

/**
*����ͳ������ȡ��
* @return ����ͳ������
*/
public String getR_time(){
return r_time;
}
/**
*����ͳ�������趨
* @param r_time����ͳ������
*/
public void setR_time(String r_time){
this.r_time=r_time;
}
}

