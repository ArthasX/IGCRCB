/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.report.xml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;

import com.deliverik.framework.utility.ResourceUtility;
import com.dev.crc.report.utils.XMLUtils;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������̶�ӦXML�ļ����ƹ�����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class XMLFileManagerImpl implements XMLFileManager{
	
	/** ��־���� */
	protected static final Log log = LogFactory.getLog(XMLFileManagerImpl.class);

	/** ���ݴ洢���� */
	protected Map<String, String> map = new HashMap<String, String>();
	
	/**
	 * ��ʼ��
	 */
	public void init(){
		//�жϼ����Ƿ���
		if(Boolean.parseBoolean(ResourceUtility.getString("REPORT_IS_START"))){
			/*
		 	XML��ʽ��
		 	<?xml version="1.0" encoding="UTF-8"?>
			<!-- ���ڵ� -->
			<root>
				<!-- ��Ӧ��ϵ -->
				<relation>
					<!-- ���̶�������ǰ5λ -->
					<pdid>10000</pdid>
					<!-- XML�ļ����� -->
					<filename>T-B-1.xml</filename>
				</relation>
				<!-- ��Ӧ��ϵ -->
				<relation>
					<!-- ���̶�������ǰ5λ -->
					<pdid>10001</pdid>
					<!-- XML�ļ����� -->
					<filename>T-B-2.xml</filename>
				</relation>
		  	</root>
			 */
			//�����̳߳�ʼ���ĵ���Ϣ
			Thread t = new Thread(new Runnable() {
				
				/**
				 * �߳����
				 */
				@SuppressWarnings("unchecked")
				public void run() {
					//ȡ�������ļ���
					String filename = ResourceUtility.getString("REPORT_XML_FILE_PROCESS_RELATION");
					//��ʼ���ĵ�
					try {
						//��ʼ���ĵ�
						Document doc = XMLUtils.readXmlJdom(filename);
						//ȡ�ø��ڵ�
						Element root = doc.getRootElement();
						//ȡ�����ü���
						List<Element> list = root.getChildren();
						//������ݴ��ڣ�ѭ�����
						if(list != null && list.size() > 0){
							for(int i=0;i<list.size();i++){
								Element e = list.get(i);
								//ȡ�����̶���ID
								String pdid = e.getChildText("pdid");
								//ȡ���ļ�����
								String xmlFileName = e.getChildText("filename");
								//װ������
								map.put(pdid, xmlFileName);
							}
						}
					} catch (Exception e) {
						log.error("",e);
					}
				}
			});
			//�����߳�
			t.start();
		}
	}
	
	/**
	 * ȡ��XML�ļ�����
	 * @param pdid ���̶���ID
	 * @return XML�ļ�����
	 */
	public String getFileName(String pdid){
		return map.get(pdid);
	}
	
	/**
	 * ȡ��XML�ļ�Ŀ¼
	 * @param pdid ���̶���ID
	 * @return �ļ�Ŀ¼
	 */
	public String getDir(String pdid){
		//�ļ�Ŀ¼
		String dir = null;
		//ȡ�����̶���ID��һλ���ɱ�ʶ�������1--�걨��2--������3--������
		char c = pdid.charAt(0);
		switch (c) {
		//�걨
		case '1':
			dir = "Annual";
			break;
		//����
		case '2':
			dir = "Quarterly";
			break;
		//������
		case '3':
			dir = "Occasional";
			break;

		default:
			break;
		}
		return dir;
	}
}
