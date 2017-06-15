/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.taglib.util;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����Ϣ���ɶ�Ӧ��ǩ�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface FormGeneratedTag extends Serializable{
	
	/** ������ */
	public static final String PARAMS_FORM_TYPE = "formType";
	
	/** ���������� */
	public static final String PARAMS_PIDID = "pidid";
	
	/** ������ */
	public static final String PARAMS_PIID = "piid";
	
	/** �������� */
	public static final String PARAMS_PRID = "prid";
	
	/** ״̬���� */
	public static final String PARAMS_PSDNAME = "psdname";
	
	/** ��ģʽ */
	public static final String PARAMS_PIDMODE = "pidmode";
	
	/** ����Ȩ�� */
	public static final String PARAMS_PIDACCESS = "pidaccess";
	
	/** ��ǩ���� */
	public static final String PARAMS_PROPERTY = "property";
	
	/** ��С */
	public static final String PARAMS_SIZE = "size";
	
	/** �ı��򳤶� */
	public static final String PARAMS_TEXTAREA_SIZE = "textAreaSize";
	
	/** ��ֵ */
	public static final String PARAMS_VALUE = "value";
	
	/** ˽�б���Ȩ�޷�Χ */
	public static final String PARAMS_PRIVATESCOPE = "privatescope";
	
	/** �û�ID */
	public static final String PARAMS_USERID = "userid";
	
	/** ��ɫID */
	public static final String PARAMS_ROLEID = "roleid";
	
	/** ������ */
	public static final String PARAMS_ORGID = "orgid";
	
	/** ��Ĭ��ֵ */
	public static final String PARAMS_PIDDEFAULT = "piddefault";
	
	/** ����ѡֵ */
	public static final String PARAMS_OPTIONS = "options";
	
	/** ����ID */
	public static final String PARAMS_PDID = "pdid";
	
	/** �������ݶ���ID */
	public static final String PARAMS_CCID = "ccid";
	
	/** ������ */
	public static final String PARAMS_PIDLABEL = "pidlabel";
	
	/** �ı��򸽼� */
	public static final String PARAMS_TEXTAREA_ATT_MAP = "textAreaMap";
	
	/** ��ر���Ϣ */
	public static final String PARAMS_PROCESSINFO_LIST = "processInfolist";
	
	/** ����ʲ���Ϣ */
	public static final String PARAMS_PROCESSINFO_ENTITY_LIST  = "processInfoEntityList";
	
	/** �Ƿ���� */
	public static final String PARAMS_PIDREQUIRED = "pidrequired";
	
	/** ������Χ�����б� */
	public static final String PARAMS_PROCESS_ORG_SELECTED_OPTIONS ="processOrgSelectedOptions";
	
	/** �Ƿ�������� */
	public static final String PARAMS_HASATTACH = "hasattach";
	
	/** ������ģʽ */
	public static final String PARAMS_PIDDISPLAY = "piddisplay";
	
	/** ����������Ϣ */
	public static final String PARAMS_TABLE_COLUMN_INFO = "columnInfoMap";
	
	/** �������п� */
	public static final String PARAMS_PIDWIDTH = "pidwidth";
	
	/** �������к� */
	public static final String PARAMS_ROWNUMBER = "rownumber";
	
	/** ��������ֵ */
	public static final String PARAMS_TABLE_FORM_COLUMN_VALUE = "tableColumnValueMap";
	
	/** ��������ʹ��ģʽ */
	public static final String PARAMS_PIDUSE = "piduse";
	
	/** �������̶������� */
	public static final String PARAMS_PIDROWS = "pidrows";
	
	/** �������Ƿ���ʾ�к� */
	public static final String PARAMS_SHOWROWNUM = "showrownum";
	
	/** �����������ʲ���Ϣ */
	public static final String PARAMS_TABLE_FORM_ENTITY_INFO = "tableColumnValueEntity";
	
	/** �������и�����Ϣ */
	public static final String PARAMS_TABLE_COLUMN_ATTACH_INFO = "tableColumnAttachMap";
	
	/** �������ֵMap */
	public static final String PARAMS_PROCESSINFO_FORM_VALUE_MAP = "processInfoFormValue";
	
	/** ��Ա���ֵMap */
	public static final String PARAMS_PARTICIPANT_FORM_VALUE_MAP = "participantFormValue";
	
	/** ����λ */
	public static final String PARAMS_PIDUNIT = "pidunit";
	
	/** �Ƿ������ע */
	public static final String PARAMS_REMARKS = "remarks";
	
	/** ��ע����1��ʾ�б�ע */
	public static final String REMARK_TAG = "1";
	
	/** ��ע */
	public static final String PARAMS_PIDCOMMENT ="pidcomment";
	
	/** ����ѡ��ʾ��ʽ */
	public static final String PARAMS_SHOWSTYLES ="showstyles";
	
	/** ��ʾ��ʽ����1��ʾ���� */
	public static final String SHOWSTYLES_TAG = "1";
	
	/** �������Ƿ���ʾ���� */
	public static final String PARAMS_SHOWLINE = "showline";
	
	/** ������������ʾģʽ */
	public static final String PARAMS_TITLE_DISPLAY = "titledisplay";
	
	/** �Ƿ����ر��� */
	public static final String PARAMS_PIDHIDE = "pidhide";
	
	/** ��˵�� */
	public static final String PARAMS_PIDDESC ="piddesc";
	
	/** ��js�����¼� */
	public static final String PARAMS_JSFUNCTION = "jsfunction";
	
	/** ���ʽ����ģʽ���������ݿ�ȱ��� */
	public static final String PARAMS_PIDRATIO = "pidratio";
	
	/** ��������Ƴ��� */
	public static final String PARAMS_PIDSIZE = "pidsize";
	
	/** ����д��ʶ */
	public static final String PARAMS_WRITEABLE = "writeable";
	
	/** ���α�ֻѡĩ����ʶ */
	public static final String PARAMS_SELECED_LAST = "selecedlast";
	
	/** ���ֿؼ����������� */
	public static final String PARAMS_NUMBER_TYPE = "numbertype";
	
	/** ���뷽ʽ */
	public static final String PARAMS_ALIGN = "align";
	
	/** ���̴��ڹر�״̬��״̬��˽�б�ֵmap���п�д��ֻ��  */
	public static final String PARAMS_STATUS_CLOSE = "StatusCloseDetails";
	
	/**
	 * ���п�д��ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicWriteableTag(Map<String, Object> params);
	
	/**
	 * ����ֻ����ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicReadableTag(Map<String, Object> params);
	
	/**
	 * ���в��ɼ���ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicHideTag(Map<String, Object> params);
	
	/**
	 * ˽�п�д��ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPrivateWriteableTag(Map<String, Object> params);
	
	/**
	 * ˽��ֻ����ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPrivateReadableTag(Map<String, Object> params);
	
	/**
	 * ˽�в��ɼ���ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPrivateHideTag(Map<String, Object> params);
	
	/**
	 * ˽��ȫ���ɼ���ǩ����
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPrivateReadableAllTag(Map<String, Object> params);
	
	/**
	 * ��������д������
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicWriteableTableColumn(Map<String, Object> params);
	
	/**
	 * ������ֻ��������
	 * @param params ����
	 * @return ���ɱ�ǩ�ַ���
	 */
	public String generatedPublicReadableTableColumn(Map<String, Object> params);
	
	/**
	 * ��д������ʾ����
	 * @param id ��ʾλ��dom����id
	 * @return
	 */
	public String writeableAttachmentInfoShow(Map<String, Object> params);
	
	/**
	 * ֻ��������ʾ����
	 * @param id ��ʾλ��dom����id
	 * @return
	 */
	public String readableAttachmentInfoShow(Map<String, Object> params);
	
	 /**
     * ״̬��д��ǩ����
     * @param params ����
     * @return ״̬��ǩ�ַ���
     */
    public String generatedStatusWriteableTag(Map<String, Object> params);
    
    /**
     * ״ֻ̬����ǩ����
     * @param params ����
     * @return ״̬��ǩ�ַ���
     */
    public String generatedStatusReadableTag(Map<String, Object> params);
    
    /**
     * ״̬���ɼ���ǩ����
     * @param params ����
     * @return ״̬��ǩ�ַ���
     */
    public String generatedStatusHideTag(Map<String, Object> params);
    
    /**
     *���̹ر�״̬״̬������ʾ
     * @param params ����
     * @return ���̹ر�״̬״̬������ʾ
     */
    public String generatedStatusCloseTag(Map<String, Object> params);
	
}
