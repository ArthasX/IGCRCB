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
import com.deliverik.framework.workflow.prd.model.IG008Info;
import com.deliverik.framework.workflow.prd.model.condition.IG008SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG008SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG008DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG008PK;
import com.deliverik.framework.workflow.prd.model.entity.IG008TB;

/**
  * 概述: 人员表单角色限定业务逻辑实现
  * 功能描述: 人员表单角色限定业务逻辑实现
  * 创建记录: 2013/11/27
  * 修改记录: 
  */
public class IG008BLImpl extends BaseBLImpl implements IG008BL {

	/** 人员表单角色限定DAO接口 */
	protected IG008DAO ig008DAO;
	
	/**
	 * 人员表单角色限定DAO接口设定
	 *
	 * @param iG008DAO 人员表单角色限定DAO接口
	 */
	public void setIg008DAO(IG008DAO ig008DAO) {
		this.ig008DAO = ig008DAO;
	}

	/**
	 * 人员表单角色限定实例取得
	 *
	 * @return 人员表单角色限定实例
	 */
	public IG008TB getIG008TBInstance() {
		return new IG008TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG008Info> searchIG008() {
		return ig008DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG008Info searchIG008ByPK(IG008PK pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG008SearchCond cond) {
		return ig008DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG008Info> searchIG008(IG008SearchCond cond) {
		return ig008DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG008Info> searchIG008(IG008SearchCond cond, int start,int count) {
		return ig008DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG008Info registIG008(IG008Info instance) throws BLException {
		return ig008DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG008Info updateIG008(IG008Info instance)throws BLException {
		checkExistInstance(new IG008PK(instance.getPidid(), instance.getRoleid()));
		return ig008DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG008ByPK(IG008PK pk) throws BLException {
		ig008DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG008(IG008Info instance) throws BLException {
		ig008DAO.delete(instance);
	}
	
	/**
	 * 删除处理
	 *
	 * @param entitys 删除实例集合
	 */
	public void deleteIG008(List<IG008Info> entitys) throws BLException{
		ig008DAO.delete(entitys);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG008Info checkExistInstance(IG008PK pk) throws BLException {
		IG008Info instance = ig008DAO.findByPK(pk);
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
		IG008SearchCondImpl cond = new IG008SearchCondImpl();
		cond.setPdid(pdid);
		List<IG008Info> lst_IG008Info = searchIG008(cond);
		StringBuffer sbf_xml = new StringBuffer();
		sbf_xml.append("<IG008>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG008Info != null){
			for(IG008Info info : lst_IG008Info){
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidid()) ? "" : IGStringUtils.filterXMLStr(info.getPidid()));
				sbf_xml.append("</PIDID>");
				sbf_xml.append("<ROLEID>");
				sbf_xml.append(info.getRoleid() == null ? "" : "&roleid_" + info.getRoleid() + ";");
				sbf_xml.append("</ROLEID>");
				sbf_xml.append("<ROLENAME>");
				sbf_xml.append(StringUtils.isNotEmpty(info.getRolename()) ? "" : IGStringUtils.filterXMLStr(info.getRolename()));
				sbf_xml.append("</ROLENAME>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG008>");
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
		List<IG008Info> lst_IG008 = new ArrayList<IG008Info>(dataList.size());
		IG008TB entity = null;
		for(Element e : dataList){
			entity = this.getIG008TBInstance();
			entity.setPidid(e.getChildText("PIDID"));
			entity.setRoleid(StringUtils.isNotEmpty(e.getChildText("ROLEID")) ? Integer.valueOf(e.getChildText("ROLEID")) : null);
			entity.setRolename(e.getChildText("ROLENAME"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG008.add(entity);
		}
		if(lst_IG008.size() > 0){
			this.ig008DAO.saveOrUpdateAll(lst_IG008);
		}
	}
}