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
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG335DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG335PK;
import com.deliverik.framework.workflow.prd.model.entity.IG335TB;

/**
  * 概述: 表单策略表业务逻辑实现
  * 功能描述: 表单策略表业务逻辑实现
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
public class IG335BLImpl extends BaseBLImpl implements
		IG335BL {

	/** 表单策略表DAO接口 */
	protected IG335DAO ig335DAO;
	 
	/**
	 * 表单策略表DAO接口设定
	 * @param ig335DAO 表单策略表DAO接口
	 */
	public void setIg335DAO(IG335DAO ig335dao) {
		ig335DAO = ig335dao;
	}

	/**
	 * 表单策略表实例取得
	 *
	 * @return 表单策略表实例
	 */
	public IG335TB getIG335TBInstance() {
		return new IG335TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG335Info> searchIG335() {
		return ig335DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG335Info searchIG335ByPK(IG335PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG335SearchCond cond) {
		return ig335DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG335Info> searchIG335(
			IG335SearchCond cond) {
		return ig335DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG335Info> searchIG335(
			IG335SearchCond cond, int start,
			int count) {
		return ig335DAO.findByCond(cond, start, count);
	}

	/**
	 * 超时通知策略查询
	 * 
	 * @param pdid 流程定义ID
	 * @param psdid 状态定义ID
	 * @param pidid 表单定义ID
	 * @return  超时通知策略列表
	 */
	public List<IG335Info> searchIG335Info(String pdid,  String psdid, String pidid, String psdconfirm){
		return ig335DAO.searchIG335Info(pdid, psdid, pidid, psdconfirm);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG335Info registIG335(IG335Info instance)
		throws BLException {
		return ig335DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG335Info updateIG335(IG335Info instance)
		throws BLException {
		checkExistInstance(new IG335PK(instance.getPsdid(), instance.getPidid(), instance.getPivalue(), instance.getPsdconfirm(), instance.getPdid()));
		return ig335DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG335ByPK(IG335PK pk)
		throws BLException {
		ig335DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG335(IG335Info instance)
		throws BLException {
		ig335DAO.delete(instance);
	}
	
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG335(List<IG335Info> instanceList)
			throws BLException {
		ig335DAO.delete(instanceList);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG335Info checkExistInstance(IG335PK pk)
		throws BLException {
		IG335Info instance = ig335DAO.findByPK(pk);
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
		
		IG335SearchCondImpl cond = new IG335SearchCondImpl();
		cond.setPidid_like(pdid);
		List<IG335Info> lst_IG335Info = this.searchIG335(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG335>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG335Info != null) {
			for(IG335Info info : lst_IG335Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<PIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidid()) ? "" : IGStringUtils.filterXMLStr(info.getPidid()));
				sbf_xml.append("</PIDID>");
				sbf_xml.append("<PIVALUE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPivalue()) ? "" : IGStringUtils.filterXMLStr(info.getPivalue()));
				sbf_xml.append("</PIVALUE>");
				sbf_xml.append("<PSDCONFIRM>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdconfirm()) ? "" : IGStringUtils.filterXMLStr(info.getPsdconfirm()));
				sbf_xml.append("</PSDCONFIRM>");
				sbf_xml.append("<NOTIFYD>");
				sbf_xml.append(info.getNotifyd() == null ? "0" : info.getNotifyd());
				sbf_xml.append("</NOTIFYD>");
				sbf_xml.append("<NOTIFYH>");
				sbf_xml.append(info.getNotifyh() == null ? "0" : info.getNotifyh());
				sbf_xml.append("</NOTIFYH>");
				sbf_xml.append("<NOTIFYM>");
				sbf_xml.append(info.getNotifym() == null ? "0" : info.getNotifym());
				sbf_xml.append("</NOTIFYM>");
				sbf_xml.append("<REPORTD>");
				sbf_xml.append(info.getReportd() == null ? "0" : info.getReportd());
				sbf_xml.append("</REPORTD>");
				sbf_xml.append("<REPORTH>");
				sbf_xml.append(info.getReporth() == null ? "0" : info.getReporth());
				sbf_xml.append("</REPORTH>");
				sbf_xml.append("<REPORTM>");
				sbf_xml.append(info.getReportm() == null ? "0" : info.getReportm());
				sbf_xml.append("</REPORTM>");
				sbf_xml.append("<ROLEID>");
				sbf_xml.append(info.getRoleid() == null ? "0" : "&roleid_" + info.getRoleid().toString() + ";");
				sbf_xml.append("</ROLEID>");
				sbf_xml.append("<ROLENAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getRolename()) ? "" : IGStringUtils.filterXMLStr(info.getRolename()));
				sbf_xml.append("</ROLENAME>");
				sbf_xml.append("<ROLEMANAGER>");
				sbf_xml.append(StringUtils.isEmpty(info.getRolemanager()) ? "" : IGStringUtils.filterXMLStr(info.getRolemanager()));
				sbf_xml.append("</ROLEMANAGER>");
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
		sbf_xml.append("</IG335>");
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
		List<IG335Info> lst_IG335 = new ArrayList<IG335Info>();
		IG335TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG335TBInstance();
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPidid(e.getChildText("PIDID"));
			entity.setPdid(e.getChildText("PDID"));
			entity.setPivalue(e.getChildText("PIVALUE"));
			entity.setPsdconfirm(e.getChildText("PSDCONFIRM"));
			if(StringUtils.isNotEmpty(e.getChildText("NOTIFYD"))){
				entity.setNotifyd(Integer.parseInt(e.getChildText("NOTIFYD")));
			}
			if(StringUtils.isNotEmpty(e.getChildText("NOTIFYM"))){
				entity.setNotifym(Integer.parseInt(e.getChildText("NOTIFYM")));
			}
			if(StringUtils.isNotEmpty(e.getChildText("NOTIFYH"))){
				entity.setNotifyh(Integer.parseInt(e.getChildText("NOTIFYH")));
			}
			if(StringUtils.isNotEmpty(e.getChildText("REPORTH"))){
				entity.setReporth(Integer.parseInt(e.getChildText("REPORTH")));
			}
			if(StringUtils.isNotEmpty(e.getChildText("REPORTD"))){
				entity.setReportd(Integer.parseInt(e.getChildText("REPORTD")));
			}
			if(StringUtils.isNotEmpty(e.getChildText("REPORTM"))){
				entity.setReportm(Integer.parseInt(e.getChildText("REPORTM")));
			}
			if(StringUtils.isNotEmpty(e.getChildText("ROLEID"))){
				entity.setRoleid(Integer.parseInt(e.getChildText("ROLEID")));
			}
			entity.setRolename(e.getChildText("ROLENAME"));
			entity.setRolemanager(e.getChildText("ROLEMANAGER"));
			entity.setProcessbl(e.getChildText("PROCESSBL"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG335.add(entity);
		}
		this.ig335DAO.saveOrUpdateAll(lst_IG335);
		lst_IG335 = null;
	}
}