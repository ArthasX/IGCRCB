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
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG334VWInfo;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG334DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG334TB;

/**
  * 概述: 通知策略基本信息业务逻辑实现
  * 功能描述: 通知策略基本信息业务逻辑实现
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
public class IG334BLImpl extends BaseBLImpl implements
		IG334BL {

	/** 通知策略基本信息DAO接口 */
	protected IG334DAO ig334DAO;
	
	/**
	 * 通知策略基本信息DAO接口设定
	 * @param ig334DAO 通知策略基本信息DAO接口
	 */
	public void setIg334DAO(IG334DAO ig334dao) {
		ig334DAO = ig334dao;
	}
	
	/**
	 * 通知策略基本信息实例取得
	 *
	 * @return 通知策略基本信息实例
	 */
	public IG334TB getIG334TBInstance() {
		return new IG334TB();
	}

	

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG334Info> searchIG334() {
		return ig334DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG334Info searchIG334ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG334SearchCond cond) {
		return ig334DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG334Info> searchIG334(
			IG334SearchCond cond) {
		return ig334DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG334Info> searchIG334(
			IG334SearchCond cond, int start,
			int count) {
		return ig334DAO.findByCond(cond, start, count);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG334VWInfo> findByCondTactics(final IG334SearchCond cond){
		return this.ig334DAO.findByCondTactics(cond);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG334Info registIG334(IG334Info instance)
		throws BLException {
		return ig334DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG334Info updateIG334(IG334Info instance)
		throws BLException {
		checkExistInstance(instance.getPdid());
		return ig334DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG334ByPK(String pk)
		throws BLException {
		ig334DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG334(IG334Info instance)
		throws BLException {
		ig334DAO.delete(instance);
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG334Info checkExistInstance(String pk)
		throws BLException {
		IG334Info instance = ig334DAO.findByPK(pk);
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
		
		IG334SearchCondImpl cond = new IG334SearchCondImpl();
		cond.setPdid_like(pdid);
		List<IG334Info> lst_IG335Info = this.searchIG334(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG334>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG335Info != null) {
			for(IG334Info info : lst_IG335Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<SMS>");
				sbf_xml.append(StringUtils.isEmpty(info.getSms()) ? "" : IGStringUtils.filterXMLStr(info.getSms()));
				sbf_xml.append("</SMS>");
				sbf_xml.append("<EMAIL>");
				sbf_xml.append(StringUtils.isEmpty(info.getEmail()) ? "" : IGStringUtils.filterXMLStr(info.getEmail()));
				sbf_xml.append("</EMAIL>");
				sbf_xml.append("<PIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidid()) ? "" : IGStringUtils.filterXMLStr(info.getPidid()));
				sbf_xml.append("</PIDID>");
				sbf_xml.append("<PIDNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidname()) ? "" : IGStringUtils.filterXMLStr(info.getPidname()));
				sbf_xml.append("</PIDNAME>");
				sbf_xml.append("<NOTIFYD>");
				sbf_xml.append(info.getNotifyd() == null ? "0" : info.getNotifyd());
				sbf_xml.append("</NOTIFYD>");
				sbf_xml.append("<NOTIFYH>");
				sbf_xml.append(info.getNotifyh() == null ? "0" : info.getNotifyh());
				sbf_xml.append("</NOTIFYH>");
				sbf_xml.append("<NOTIFYM>");
				sbf_xml.append(info.getNotifym() == null ? "0" : info.getNotifym());
				sbf_xml.append("</NOTIFYM>");
				sbf_xml.append("<ROLEID>");
				sbf_xml.append(info.getRoleid() == null ? "0" : "&roleid_" + info.getRoleid().toString() + ";");
				sbf_xml.append("</ROLEID>");
				sbf_xml.append("<PROCESSBL>");
				sbf_xml.append(StringUtils.isEmpty(info.getProcessbl()) ? "" : IGStringUtils.filterXMLStr(info.getProcessbl()));
				sbf_xml.append("</PROCESSBL>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG334>");
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
		List<IG334Info> lst_IG334 = new ArrayList<IG334Info>();
		IG334TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG334TBInstance();
			entity.setPdid(e.getChildText("PDID"));
			entity.setSms(e.getChildText("SMS"));
			entity.setEmail(e.getChildText("EMAIL"));
			entity.setPidid(e.getChildText("PIDID"));
			entity.setPidname(e.getChildText("PIDNAME"));
			entity.setNotifyd(Integer.parseInt(e.getChildText("NOTIFYD")));
			entity.setNotifym(Integer.parseInt(e.getChildText("NOTIFYM")));
			entity.setNotifyh(Integer.parseInt(e.getChildText("NOTIFYH")));
			entity.setRoleid(Integer.parseInt(e.getChildText("ROLEID")));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			entity.setProcessbl(e.getChildText("PROCESSBL"));
			lst_IG334.add(entity);
		}
		this.ig334DAO.saveOrUpdateAll(lst_IG334);
		lst_IG334 = null;
	}

}