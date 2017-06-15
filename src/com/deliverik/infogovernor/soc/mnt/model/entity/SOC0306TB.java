/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.soc.mnt.model.entity;

 import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.mnt.model.SOC0306Info;


/**
 * 
 * @Description:���������Ϣ��ͼʵ��TB�� NatureIuportAlarm
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0306")
public class SOC0306TB extends BaseEntity implements Serializable, Cloneable, SOC0306Info{
@Id
@TableGenerator(
name="NATUREIUPORTALARM_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
pkColumnValue="NATUREIUPORTALARM_SEQUENCE", initialValue=1, allocationSize=1
)
@GeneratedValue(strategy = GenerationType.TABLE, generator="NATUREIUPORTALARM_TABLE_GENERATOR")
/**
*�Զ�����
*/
protected Integer id;

/**
*�Զ�����ȡ��
* @return �Զ�����
*/
public Integer getId(){
return id;
}
/**
*�Զ������趨
* @param id�Զ�����
*/
public void setId(Integer id){
this.id=id;
}
/**
*symmid
*/
protected String symmid;

/**
*symmidȡ��
* @return symmid
*/
public String getSymmid(){
return symmid;
}
/**
*symmid�趨
* @param symmidsymmid
*/
public void setSymmid(String symmid){
this.symmid=symmid;
}
/**
*����ʱ��
*/
protected String dataitmes;

/**
*����ʱ��ȡ��
* @return ����ʱ��
*/
public String getDataitmes(){
return dataitmes;
}
/**
*����ʱ���趨
* @param dataitmes����ʱ��
*/
public void setDataitmes(String dataitmes){
this.dataitmes=dataitmes;
}
/**
*����
*/
protected String symtype;

/**
*����ȡ��
* @return ����
*/
public String getSymtype(){
return symtype;
}
/**
*�����趨
* @param symtype����
*/
public void setSymtype(String symtype){
this.symtype=symtype;
}
/**
*�Ƿ����Ķ�
*/
protected String readdate;

/**
*�Ƿ����Ķ�ȡ��
* @return �Ƿ����Ķ�
*/
public String getReaddate(){
return readdate;
}
/**
*�Ƿ����Ķ��趨
* @param readdate�Ƿ����Ķ�
*/
public void setReaddate(String readdate){
this.readdate=readdate;
}
public Serializable getPK() {
return id;
}
}

