/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.condition.IG213SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG213SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG213DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG213TB;

/**
 * <p>概述:流程角色类型处理业务逻辑实现 </p>
 * <p>功能描述：1.全部流程角色类型信息</p>
 * <p>          2.条件检索流程角色类型信息</p>
 * <p>          3.根据流程ID获取流程角色类型</p>
 * <p>          4.新增流程角色类型定义处理</p>
 * <p>          5.删除处理</p>
 * <p>          6.变更处理</p>
 * <p>          7.流程模版存在检查</p>
 * <p>创建记录：
 */
public class IG213BLImpl extends BaseBLImpl implements IG213BL{
	
	/**流程角色类型*/
	protected IG213DAO ig213DAO;
	
	/**
	 * 流程角色类型定义DAO
	 * 
	 * @param ig213DAO 流程角色类型定义DAO
	 */
	public void setIg213DAO(IG213DAO ig213DAO) {
		this.ig213DAO = ig213DAO;
	}
	
	/**
	 * 功能：获流程角色类型实例
	 * 
	 * @return IG213TB
	 */
	
	public IG213TB getIG213TBInstance(){
		return new IG213TB();
	}
	
	/**
	 * 功能：条件检索流程角色类型信息
	 * @param cond 流程角色类型信息检索条件
	 * @return 流程角色类型信息结果列表
	 * @throws BLException
	 */
	public List<IG213Info> searchIG213Info(IG213SearchCond cond){
		List<IG213Info> processRoleTypeDefList = ig213DAO.findByCond(cond, 0, 0);
		return processRoleTypeDefList;
	}
	
	/**
	 * 功能：条件检索流程角色类型信息
	 * @param cond 流程角色类型信息检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 流程角色类型信息结果列表
	 * @throws BLException
	 */
	public List<IG213Info> searchIG213Info(IG213SearchCond cond, int start, int count){
		List<IG213Info> processRoleTypeDefList = ig213DAO.findByCond(cond, start, count);
		return processRoleTypeDefList;
	}
	
	/**
	 * 功能：根据流程ID获取流程角色类型
	 * @param pdid 流程ID
	 * @return 流程角色类型
	 * @throws BLException
	 */
	public IG213Info searchIG213InfoByKey(String prtdid) throws BLException{
		return checkExistIG213Info(prtdid);
	}
	
	/**
	 * 功能：新增流程角色类型定义处理
	 * 
	 * @param IG213 新增数据
	 * @return 流程角色类型定义
	 * @throws BLException
	 */
	
	public IG213Info registIG213Info(
			IG213Info ig213Info) throws BLException{
		return ig213DAO.save(ig213Info);
	}
	
	/**
	 * 功能：删除处理
	 * 
	 * @param prtdid 流程角色类型定义
	 * @throws BLException
	 */
	
	public void deleteIG213InfoByKey(String prtdid) throws BLException{
		IG213Info processRoleTypeDef = checkExistIG213Info(prtdid);
		ig213DAO.delete(processRoleTypeDef);
	}
	
	/**
	 * 功能：变更处理
	 * 
	 * @param IG213 变更数据
	 * @return 流程角色类型定义
	 */
	
	public IG213Info updateIG213Info(
			IG213Info ig213Info) throws BLException{
		return ig213DAO.save(ig213Info);
	}
	
	/**
	 * 功能：流程模版存在检查
	 * 
	 * @param ptid 流程模版ID
	 * @return 流程模版
	 * @throws BLException 
	 */
	
	protected IG213Info checkExistIG213Info(String prtdid) throws BLException{
		IG213Info info = ig213DAO.findByPK(prtdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","流程角色定义基本");
		}
		return info;
	}
	
	/**
	 * PRTDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PRTDID主键值
	 */
	public String getPrtdidSequenceNextValue(String pdid) {
		return ig213DAO.getPrtdidSequenceNextValue(pdid);
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG213SearchCondImpl cond = new IG213SearchCondImpl();
		cond.setPrtdid_like(pdid);
		List<IG213Info> lst_IG213Info = this.searchIG213Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG213>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG213Info != null) {
			for(IG213Info info : lst_IG213Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PRTDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPrtdid()) ? "" : IGStringUtils.filterXMLStr(info.getPrtdid()));
				sbf_xml.append("</PRTDID>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<ROLETYPE>");
				sbf_xml.append(StringUtils.isEmpty(info.getRoletype()) ? "" : IGStringUtils.filterXMLStr(info.getRoletype()));
				sbf_xml.append("</ROLETYPE>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG213>");
		return sbf_xml;
	}
	
	/**
	 * XML脚本导入处理
	 *
	 * @param element Element
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public void importXML(Element element) throws BLException {
		Element data = element.getChild("DATALIST");
		List<Element> dataList = data.getChildren();
		List<IG213Info> lst_IG213 = new ArrayList<IG213Info>();
		IG213TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG213TBInstance();
			entity.setPrtdid(e.getChildText("PRTDID"));
			entity.setPdid(e.getChildText("PDID"));
			entity.setRoletype(e.getChildText("ROLETYPE"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG213.add(entity);
		}
		this.ig213DAO.saveOrUpdateAll(lst_IG213);
	}
}
