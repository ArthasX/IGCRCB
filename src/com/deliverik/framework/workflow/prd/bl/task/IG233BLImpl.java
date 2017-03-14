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
import com.deliverik.framework.workflow.prd.model.IG233Info;
import com.deliverik.framework.workflow.prd.model.condition.IG233SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG233SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG233DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG233PK;
import com.deliverik.framework.workflow.prd.model.entity.IG233TB;

/**
  * 概述: 自定义流程分派定义表业务逻辑实现
  * 功能描述: 自定义流程分派定义表业务逻辑实现
  * 创建记录: 2013/03/12
  * 修改记录: 
  */
public class IG233BLImpl extends BaseBLImpl implements IG233BL {

	/** 自定义流程分派定义表DAO接口 */
	protected IG233DAO ig233DAO;
	
	/**
	 * 自定义流程分派定义表DAO接口设定
	 *
	 * @param iG233DAO 自定义流程分派定义表DAO接口
	 */
	public void setIg233DAO(IG233DAO ig233DAO) {
		this.ig233DAO = ig233DAO;
	}

	/**
	 * 自定义流程分派定义表实例取得
	 *
	 * @return 自定义流程分派定义表实例
	 */
	public IG233TB getIG233TBInstance() {
		return new IG233TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG233Info> searchIG233() {
		return ig233DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG233Info searchIG233ByPK(IG233PK pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG233SearchCond cond) {
		return ig233DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG233Info> searchIG233(IG233SearchCond cond) {
		return ig233DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG233Info> searchIG233(IG233SearchCond cond, int start,int count) {
		return ig233DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 根据状态id查询
	 * @param psdid
	 * @return
	 */
	public List<IG233Info> searchByPsdid(String psdid){
		if(StringUtils.isEmpty(psdid)){
			return null;
		}
		IG233SearchCondImpl cond = new IG233SearchCondImpl();
		cond.setPsdid(psdid);
		return this.searchIG233(cond);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG233Info registIG233(IG233Info instance) throws BLException {
		return ig233DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG233Info updateIG233(IG233Info instance) throws BLException {
		checkExistInstance(new IG233PK(instance.getPsdid(), instance.getAssignpsdid()));
		return ig233DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG233ByPK(IG233PK pk) throws BLException {
		ig233DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG233(IG233Info instance) throws BLException {
		ig233DAO.delete(instance);
	}
	
	/**
	 * 集合删除
	 * @param list
	 */
	public void deleteIG233(List<IG233Info> list){
		ig233DAO.delete(list);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG233Info checkExistInstance(IG233PK pk) throws BLException {
		IG233Info instance = ig233DAO.findByPK(pk);
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
		IG233SearchCondImpl cond = new IG233SearchCondImpl();
		cond.setPdid(pdid);
		List<IG233Info> lst_IG233Info = this.searchIG233(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG233>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG233Info != null) {
			for(IG233Info info : lst_IG233Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("<ASSIGNPSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getAssignpsdid()) ? "" : IGStringUtils.filterXMLStr(info.getAssignpsdid()));
				sbf_xml.append("</ASSIGNPSDID>");
				sbf_xml.append("<ASSIGNPBDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getAssignpbdid()) ? "" : IGStringUtils.filterXMLStr(info.getAssignpbdid()));
				sbf_xml.append("</ASSIGNPBDID>");
				sbf_xml.append("<ASSIGNFLAG>");
				sbf_xml.append(StringUtils.isEmpty(info.getAssignflag()) ? "" : IGStringUtils.filterXMLStr(info.getAssignflag()));
				sbf_xml.append("</ASSIGNFLAG>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG233>");
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
		List<IG233Info> lst_IG233 = new ArrayList<IG233Info>();
		IG233TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG233TBInstance();
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			entity.setAssignpsdid(e.getChildText("ASSIGNPSDID"));
			entity.setAssignpbdid(e.getChildText("ASSIGNPBDID"));
			entity.setAssignflag(e.getChildText("ASSIGNFLAG"));
			lst_IG233.add(entity);
		}
		this.ig233DAO.saveOrUpdateAll(lst_IG233);
	}

}