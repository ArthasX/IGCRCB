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
import com.deliverik.framework.workflow.prd.model.IG123Info;
import com.deliverik.framework.workflow.prd.model.condition.IG123SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG123SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG123DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG123TB;

/**
  * 概述: 自定义流程机构范围表业务逻辑实现
  * 功能描述: 自定义流程机构范围表业务逻辑实现
  * 创建记录: 2013/03/07
  * 修改记录: 
  */
public class IG123BLImpl extends BaseBLImpl implements IG123BL {

	/** 自定义流程机构范围表DAO接口 */
	protected IG123DAO ig123DAO;
	
	/**
	 * 自定义流程机构范围表DAO接口设定
	 *
	 * @param iG123DAO 自定义流程机构范围表DAO接口
	 */
	public void setIg123DAO(IG123DAO ig123DAO) {
		this.ig123DAO = ig123DAO;
	}

	/**
	 * 自定义流程机构范围表实例取得
	 *
	 * @return 自定义流程机构范围表实例
	 */
	public IG123TB getIG123TBInstance() {
		return new IG123TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG123Info> searchIG123() {
		return ig123DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG123Info searchIG123ByPK(String pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG123SearchCond cond) {
		return ig123DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG123Info> searchIG123( IG123SearchCond cond) {
		return ig123DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG123Info> searchIG123(IG123SearchCond cond, int start, int count) {
		return ig123DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG123Info registIG123(IG123Info instance) throws BLException {
		return ig123DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG123Info updateIG123(IG123Info instance) throws BLException {
		checkExistInstance(instance.getPotdid());
		return ig123DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG123ByPK(String pk) throws BLException {
		ig123DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG123(IG123Info instance) throws BLException {
		ig123DAO.delete(instance);
	}
	
	/**
	 * 集合删除处理
	 * @param list
	 * @throws BLException
	 */
	public void deleteIG123List(List<IG123Info> list) throws BLException{
		ig123DAO.delete(list);
	}
	
	/**
	 * POTDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PRTDID主键值
	 */
	public String getPotdidSequenceNextValue(String pdid) throws BLException{
		return ig123DAO.getPotdidSequenceNextValue(pdid);
	}
	
	/**
	 * 根据流程定义主键查询
	 * @param pdid 流程定义主键
	 * @return 机构范围集合
	 * @throws BLException
	 */
	public List<IG123Info> findBypdid(String pdid){
		if(StringUtils.isEmpty(pdid)) return null;
		IG123SearchCondImpl cond = new IG123SearchCondImpl();
		cond.setPdid(pdid);
		return this.searchIG123(cond);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG123Info checkExistInstance(String pk) throws BLException {
		IG123Info instance = ig123DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		List<IG123Info> ig123List = this.findBypdid(pdid);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG123>");
		sbf_xml.append("<DATALIST>");
		if(ig123List!=null){
			for(IG123Info info:ig123List){
				sbf_xml.append("<DATA>");
				sbf_xml.append("<POTDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPotdid())?"":IGStringUtils.filterXMLStr(info.getPotdid()));
				sbf_xml.append("</POTDID>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid())?"":IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<ORGID>");
				sbf_xml.append(StringUtils.isEmpty(info.getOrgid())?"":IGStringUtils.filterXMLStr(info.getOrgid()));
				sbf_xml.append("</ORGID>");
				sbf_xml.append("<ORGNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getOrgname())?"":IGStringUtils.filterXMLStr(info.getOrgname()));
				sbf_xml.append("</ORGNAME>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint())?"":IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG123>");
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
		List<IG123Info> lst_IG123 = new ArrayList<IG123Info>();
		IG123TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG123TBInstance();
			entity.setPotdid(e.getChildText("POTDID"));
			entity.setPdid(e.getChildText("PDID"));
			entity.setOrgid(e.getChildText("ORGID"));
			entity.setOrgname(e.getChildText("ORGNAME"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG123.add(entity);
		}
		this.ig123DAO.saveOrUpdateAll(lst_IG123);
	}
}