/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * <p>����:���̽�ɫ���ʹ���ҵ���߼�ʵ�� </p>
 * <p>����������1.ȫ�����̽�ɫ������Ϣ</p>
 * <p>          2.�����������̽�ɫ������Ϣ</p>
 * <p>          3.��������ID��ȡ���̽�ɫ����</p>
 * <p>          4.�������̽�ɫ���Ͷ��崦��</p>
 * <p>          5.ɾ������</p>
 * <p>          6.�������</p>
 * <p>          7.����ģ����ڼ��</p>
 * <p>������¼��
 */
public class IG213BLImpl extends BaseBLImpl implements IG213BL{
	
	/**���̽�ɫ����*/
	protected IG213DAO ig213DAO;
	
	/**
	 * ���̽�ɫ���Ͷ���DAO
	 * 
	 * @param ig213DAO ���̽�ɫ���Ͷ���DAO
	 */
	public void setIg213DAO(IG213DAO ig213DAO) {
		this.ig213DAO = ig213DAO;
	}
	
	/**
	 * ���ܣ������̽�ɫ����ʵ��
	 * 
	 * @return IG213TB
	 */
	
	public IG213TB getIG213TBInstance(){
		return new IG213TB();
	}
	
	/**
	 * ���ܣ������������̽�ɫ������Ϣ
	 * @param cond ���̽�ɫ������Ϣ��������
	 * @return ���̽�ɫ������Ϣ����б�
	 * @throws BLException
	 */
	public List<IG213Info> searchIG213Info(IG213SearchCond cond){
		List<IG213Info> processRoleTypeDefList = ig213DAO.findByCond(cond, 0, 0);
		return processRoleTypeDefList;
	}
	
	/**
	 * ���ܣ������������̽�ɫ������Ϣ
	 * @param cond ���̽�ɫ������Ϣ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ���̽�ɫ������Ϣ����б�
	 * @throws BLException
	 */
	public List<IG213Info> searchIG213Info(IG213SearchCond cond, int start, int count){
		List<IG213Info> processRoleTypeDefList = ig213DAO.findByCond(cond, start, count);
		return processRoleTypeDefList;
	}
	
	/**
	 * ���ܣ���������ID��ȡ���̽�ɫ����
	 * @param pdid ����ID
	 * @return ���̽�ɫ����
	 * @throws BLException
	 */
	public IG213Info searchIG213InfoByKey(String prtdid) throws BLException{
		return checkExistIG213Info(prtdid);
	}
	
	/**
	 * ���ܣ��������̽�ɫ���Ͷ��崦��
	 * 
	 * @param IG213 ��������
	 * @return ���̽�ɫ���Ͷ���
	 * @throws BLException
	 */
	
	public IG213Info registIG213Info(
			IG213Info ig213Info) throws BLException{
		return ig213DAO.save(ig213Info);
	}
	
	/**
	 * ���ܣ�ɾ������
	 * 
	 * @param prtdid ���̽�ɫ���Ͷ���
	 * @throws BLException
	 */
	
	public void deleteIG213InfoByKey(String prtdid) throws BLException{
		IG213Info processRoleTypeDef = checkExistIG213Info(prtdid);
		ig213DAO.delete(processRoleTypeDef);
	}
	
	/**
	 * ���ܣ��������
	 * 
	 * @param IG213 �������
	 * @return ���̽�ɫ���Ͷ���
	 */
	
	public IG213Info updateIG213Info(
			IG213Info ig213Info) throws BLException{
		return ig213DAO.save(ig213Info);
	}
	
	/**
	 * ���ܣ�����ģ����ڼ��
	 * 
	 * @param ptid ����ģ��ID
	 * @return ����ģ��
	 * @throws BLException 
	 */
	
	protected IG213Info checkExistIG213Info(String prtdid) throws BLException{
		IG213Info info = ig213DAO.findByPK(prtdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","���̽�ɫ�������");
		}
		return info;
	}
	
	/**
	 * PRTDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PRTDID����ֵ
	 */
	public String getPrtdidSequenceNextValue(String pdid) {
		return ig213DAO.getPrtdidSequenceNextValue(pdid);
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
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
	 * XML�ű����봦��
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
