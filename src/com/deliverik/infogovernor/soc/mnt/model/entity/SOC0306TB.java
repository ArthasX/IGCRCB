/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
 * @Description:软件部署信息视图实体TB类 NatureIuportAlarm
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
*自动增长
*/
protected Integer id;

/**
*自动增长取得
* @return 自动增长
*/
public Integer getId(){
return id;
}
/**
*自动增长设定
* @param id自动增长
*/
public void setId(Integer id){
this.id=id;
}
/**
*symmid
*/
protected String symmid;

/**
*symmid取得
* @return symmid
*/
public String getSymmid(){
return symmid;
}
/**
*symmid设定
* @param symmidsymmid
*/
public void setSymmid(String symmid){
this.symmid=symmid;
}
/**
*创建时间
*/
protected String dataitmes;

/**
*创建时间取得
* @return 创建时间
*/
public String getDataitmes(){
return dataitmes;
}
/**
*创建时间设定
* @param dataitmes创建时间
*/
public void setDataitmes(String dataitmes){
this.dataitmes=dataitmes;
}
/**
*类型
*/
protected String symtype;

/**
*类型取得
* @return 类型
*/
public String getSymtype(){
return symtype;
}
/**
*类型设定
* @param symtype类型
*/
public void setSymtype(String symtype){
this.symtype=symtype;
}
/**
*是否已阅读
*/
protected String readdate;

/**
*是否已阅读取得
* @return 是否已阅读
*/
public String getReaddate(){
return readdate;
}
/**
*是否已阅读设定
* @param readdate是否已阅读
*/
public void setReaddate(String readdate){
this.readdate=readdate;
}
public Serializable getPK() {
return id;
}
}

