/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.report.jdbc.query;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.utility.ResourceUtility;
import com.dev.crc.report.jdbc.connection.IGConnection;
import com.dev.crc.report.jdbc.connectpool.IGConnectPoolManager;
import com.dev.crc.report.utils.XMLUtils;
import com.dev.crc.report.xml.XMLFileManager;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����ֵ��ѯDAOʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ReportValueQueryDAOImpl implements ReportValueQueryDAO{
	
	/** ��־���� */
	protected static final Log log = LogFactory.getLog(ReportValueQueryDAOImpl.class);
	
	/** ����XML��Ӧ��ϵ������� */
	protected XMLFileManager xmlFileManager;
	
	/** ���ݿ����ӹ������ */
	protected IGConnectPoolManager connectPoolManager;

	/**
	 * ����XML��Ӧ��ϵ��������趨
	 * @param xmlFileManager ����XML��Ӧ��ϵ�������
	 */
	public void setXmlFileManager(XMLFileManager xmlFileManager) {
		this.xmlFileManager = xmlFileManager;
	}

	/**
	 * ���ݿ����ӹ�������趨
	 * @param connectPoolManager ���ݿ����ӹ������
	 */
	public void setConnectPoolManager(IGConnectPoolManager connectPoolManager) {
		this.connectPoolManager = connectPoolManager;
	}

	/**
	 * ��ѯ�����ֵ
	 * ͨ�����̶���ID��ȡ��XML�����ļ����ƣ�ͨ��XML�ļ�ȡ�ø����̶�Ӧ������ȡֵsql
	 * ͨ������ȡ�����еı�ֵ��װ��Map����
	 * ����ֵ��ʽ��key -- ��ȫ·����������������#��������#�������⣩
	 *            value -- ��ֵ���ϣ������Ƕ��У������Ǹ�List
	 * @param pdid ��������ID
	 * @return ��ֵ���
	 */
	@SuppressWarnings("unchecked")
	public Map<String,List<String>> getValue(String pdid){
		log.debug("==============��ѯ��ֵ������ʼ=============");
		//װ�ر�ֵ����
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		//�жϼ����Ƿ���
		if(Boolean.parseBoolean(ResourceUtility.getString("REPORT_IS_START"))){
			//ȡ�ö�ӦXML�ļ���·��
			String path = ResourceUtility.getString("REPORT_XML_ROOT_PATH");
			//ȡ���Ӽ�Ŀ¼���ƣ��걨�������������ڷֱ��Ӧ Annual��Quarterly��Occasional����Ŀ¼��
			String dir = xmlFileManager.getDir(pdid);
			//��������ȡ��xml�ļ�����
			String filename = xmlFileManager.getFileName(pdid);
			//����ļ�����
			if(StringUtils.isNotEmpty(filename)){
				String allFileName = path + File.separator + dir + File.separator + filename;
				//��ʼ���ĵ�
				try {
					/*
					 	�ĵ���ʽ
						<?xml version="1.0" encoding="UTF-8"?>
						<Root>
							<DATE>2014-06-11 11:10:09</DATE>
							<DATA>
								<SOURCE>ds1</SOURCE>  //��Ӧconfig.xml�����ݿ��������õ�����
								<FORMURL>��Ϣ�Ƽ�ս�Թ滮#��Ϣ�Ƽ�ս�Թ滮����</ FORMURL >  
								<SQL>select pivarname from ig.ig599 where piid = 4030</ SQL >
							</ DATA >
							<DATA>
								<SOURCE>ds1</SOURCE>  //��Ӧconfig.xml�����ݿ��������õ�����
								<FORMURL>��Ϣ�Ƽ�ս�Թ滮#�Ƿ�����Ϣ�Ƽ�ս�Թ滮</ FORMURL >  
								<DBNAME>IG1</ DBNAME >
								<SQL>select pivarname from ig.ig599 where piid = 4031</ SQL >
							</ DATA >
						</Root>
					*/
					Document doc = XMLUtils.readXmlJdom(allFileName);
					//ȡ�ø��ڵ�
					Element root = doc.getRootElement();
					//ȡ�����ü���
					List<Element> list = root.getChildren();
					//������ݴ��ڣ�ѭ�����
					if(list != null && list.size() > 0){
						for(int i=0;i<list.size();i++){
							Element e = list.get(i);
							//ȡ�����ӱ�ʶ���ƣ����ݱ�ʶ����ȥ���ӳع��������ȡ�ö�Ӧ�����ӣ�
							String sourceName = e.getChildText("SOURCE");
							//ȡ�ñ�ȫ·�� ������Ψһ��ʶ��
							String formUrl = e.getChildText("FORMURL");
							//ȡ��SQL���
							String sql = e.getChildText("SQL");
							//ȡ������
							IGConnection con = connectPoolManager.getCon(sourceName);
							if(con == null){
								throw new BLException("IGCO10000.E004","���ݿ�����");
							}
							//ȡ�����ݿ����Ӷ���
							Connection connection = con.getConnection();
							//ȡ�ò�ѯ����
							PreparedStatement pstm = connection.prepareStatement(sql);
							//��ѯ���
							ResultSet rs = pstm.executeQuery();
							//��ű�ֵ
							List<String> valueList = new ArrayList<String>();
							//�����������ű�ֵ
							while(rs.next()){
								valueList.add(rs.getString(1));
							}
							//��װ����
							if(!valueList.isEmpty()){
								map.put(formUrl, valueList);
							}
							//close �����
							rs.close();
							//close ��ѯ����
							pstm.close();
							//�ͷ����Ӷ���
							con.release();
						}
					}
					
					//�ͷ����ݿ�����Ϊ��ʼ״̬��������С��������
					connectPoolManager.release();
				} catch (Exception e) {
					log.error("",e);
				}
			}
		}
		log.debug("==============��ѯ��ֵ��������=============");
		return map;
	}
}
