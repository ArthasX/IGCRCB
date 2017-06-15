package com.deliverik.infogovernor.util;


/**
 * �������ݷ��ೣ������<br>
 *
 * 
 *
 * @author 
 * @updateDate 2014/04/10 LuJiayuan
 * (1)Ǩ����ƹ������"853"/"854"/"855"ö������
 */
public enum CodeDefine {
	
	/** �ʲ�ģ�ͷ��� */
	ENTITY_CATEGORY_CODE("001"),
	/** �ʲ�ģ�ͷ����� */
	ENTITY_TYPE_CODE("890"),
	/** ���� */
	ENTITY_EKEY1_CODE("002"),
	/** ���� */
	ENTITY_EKEY2_CODE("003"),
	/** ���� */
	ENTITY_EKEY3_CODE("004"),
	/** �ʲ�ģ��״̬ */
	ENTITY_STATUS_CODE("005"),

	/** �ʲ�ģ�����Ե�λ */
	CONFIGURATION_UNIT_CODE("006"),
	/** �ʲ�ģ������״̬ */
	CONFIGURATION_STATUS_CODE("007"),
	/** �ʲ�ģ�����Է��� */
	CONFIGURATION_CATEGORY_CODE("008"),

	/** �ʲ�״̬ */
	ENTITY_ITEM_STATUS_CODE("009"),

	/** �ʲ�����״̬ */
	CONFIG_ITEM_STATUS_CODE("010"),

	/** �ʲ���ϵ���� */
	ENTITY_ITEM_RELATION_CODE("011"),

	/** �ʲ�ģ�������������� */
	CONFIGURATION_ATTACH_CODE("012"),
	/** Ԥ���½����� */
	CONFIGURATION_PLAN_CODE("013"),
	
	/** ���� */
	PROJECT_TYPE_CATEGORY_CODE("021"),

	/** Ԥ������ */
	BUDGET_TYPE_CATEGORY_CODE("031"),

	/** �������ݱ༭��ʶ */
	EDIT_STATUS_CODE("999"),

	/** ��ɫ���� */
	ROLE_CATEGORY_CODE("100"),

	/** Ӱ��̶� */
	IMPACT_GRADE_CODE("101"),
	
	/** �¼����ȼ� */
	PROCESS_PRIORITY_I("142"),

	/** �Զ����������� */
	PROCESS_TYPE_CODE("230"),
	
	/**  */
	I("103"),
	P("104"),
	C("105"),
	D("106"),
	
	
	
	/**  */
	WA("107"),
	WB("108"),
	WS("221"),
	
    /** ���Ƶ����� */
    RISK_FREQUENCY_TYPE("272"),
	
	/**  */
	INCIDENT_CATEGORY_CODE("109"),
	
	/** ���ȷ�ʽ  */
	STRATEGY_WORK_CODE("110"),
	
	/** �������  */
	SERVER_CATEGORY_CODE("111"),
	
	/** ��Ŀ״̬  */
	PROJECT_STATUS_CODE("112"),
	
	/** ��������ʹ��״̬  */
	ENABLED_STATUS_CODE("113"),
	
	/** ����  */
	EQUIPMENT_STATUS_CODE("114"),
	
	/** ����  */
	PERSON_CATEGORY_CODE("115"),
	
	/** ����  */
	SERVICE_CATEGORY_CODE("116"),
	
	/** ���̱����״̬  */
	CSUB("117"),
	
	/** ���̷�����״̬  */
	DSUB("118"),
	
	/** �����¼���״̬  */
	ISUB("242"),
	
	/** ����������״̬  */
	PSUB("243"),
	
	/** ���̷���������״̬  */
	SSUB("244"),
	
	/** ���˹�����״̬  */
	WBSUB("245"),
	
	/** ָ�ɹ�����״̬  */
	WASUB("246"),
	
	/** ����֧�ֹ�����״̬  */
	WSSUB("247"),
	
	/** ��������  */
	RFDPICTYPE("260"),

	/** ����ˮƽ���� */
	SERVICE_LEVEL_GRADE("120"),
	/** �¼������̶� */
	IURGENCY_GRADE_CODE("119"),
	/** ��������̶� */
	PURGENCY_GRADE_CODE("102"),
	/** ��������̶� */
	CURGENCY_GRADE_CODE("121"),
	/** ���������̶� */
	DURGENCY_GRADE_CODE("122"),
	/** ָ�ɹ��������̶� */
	WAURGENCY_GRADE_CODE("123"),
	/** ���˹��������̶� */
	WBURGENCY_GRADE_CODE("124"),

	/**  */
	S("125"),
	/** ������������̶� */
	SURGENCY_GRADE_CODE("126"),
	/** ������������̶� */
	WDURGENCY_GRADE_CODE("127"),
	
	/** ���̱������� */
	PROCESSINFODEF_TYPE_CODE("128"),
	/** ���ճ̶� */
	RADRISKLEVEL_CODE("129"),
	/** ����Ƶ�� */
	RADFREQUENCY_CODE("130"),
	/** �����ֶ� */
	RADMODE_CODE("131"),
	/** �������� */
	RADTYPE_CODE("132"),
	/** �ƶȽ������� */
	RARPLANSCORE_CODE("133"),
	/** �ƶ�ִ������ */
	RAREXECSCORE_CODE("134"),
	/** �������� */
	RAROVERALLSCORE_CODE("135"),
	/** ���ռ���� */
	RISKCHECKRESULT_CODE("136"),
	/** ���ռ������ */
	RISKCHECK_CLASS_CODE("143"),
	
	/** ��鷽ʽ*/
	RISKCHECK_CLASS_TYPE("144"),
	
	/** ���ռ������   �����Ҫ�̶� */
	RISKCHECK_TYPE_CODE("137"),
	/**  */
	INCIDENT_IMPACT_CODE("138"),
	/**  */
	INCIDENT_SUPERVISION_NOTIFYTIME("139"),
	/**  */
	INCIDENT_SUPERVISION_REPORTTIME("140"),
	/**  */
	INCIDENT_SUPERVISION_RESOLVETIME("141"),
	/** ��� */
	YEAR_CODE("150"),
	/** �·� */
	MONTH_CODE("151"),
	/** �ʼ� */
	EMAIL_CODE("152"),
	/** ���� */
	SMS_CODE("153"),
	/** LDAP */
	LDAP_CODE("154"),
	/** ���� */
	BIRT_CODE("155"),
	/**������*/
	DUTY_TYPE("203"),
	/**�ʱ������*/
	DUTY_LIMIT_TIME("204"),
	/**�����*/
	DUTY_CONTENT("205"),
	/**���˵��*/
	DUTY_INFO("206"),
	/** ֵ��ƻ����� */
	DUTY_PLANTYPE("207"),
	DAYSHIFT_DUTY_PERIOD("201"),
	NIGHTSHIFT_DUTY_PERIOD("202"),
	LOM_GOODS_TYPE("216"),
	
	/** �������-������� */
	REOPRT_TYPE_CODE("217"),
	
	/** �Զ������̽ڵ����� */
	PROCESS_NODE_TYPE_CODE("218"),
	
	/** ���񹤵�����-״̬ */
	SERVICEFORM_STATUS("219"),

	/** ���񹤵�����-������� */
	SERVICEFORM_TYPE("220"),
	/** ������������̶� */
	WSURGENCY_GRADE_CODE("222"),
	
	/** �Զ������̽ڵ�ģʽ */
	PROCESS_NODE_MODE_CODE("231"),
	
	/** �Զ������̽ڵ��Ƿ�ɶ�̬���� */
	PROCESS_NODE_DYNAMIC_CODE("223"),
	
	PROCESS_LINK_CODE("232"),
	/** �Զ�������ҳ������*/
	PROCESS_JSP_CODE("292"),
	
	/** ֪ʶ���״̬ */
	RECOR_STATUS_CODE("233"),
	
	/** �ɶ�����Ե��������� */
	PROCESS_STRATEGY_DEF_PRTYPE("234"),
	
	/** ����״̬ */
	PROCESS_ASSESSMENT_STATUS("240"),
	
	/** �¼����趨����״̬ */
	I_STRATEGY_STATUS("249"),
	
	/** ������趨����״̬ */
	P_STRATEGY_STATUS("250"),
	
	/** ������趨����״̬ */
	C_STRATEGY_STATUS("251"),
	
	/** ϵͳ���� */
	BUSINESS_SYSTEM_CODE("241"),
	/** ֪ʶ���� */
	KNOWLEDGE_TYPE_CODE("252"),
	
	/** ֪ʶ״̬ */
	KNOWLEDGE_STATUS("253"),
	
	/** ֪ʶ��Դ */
	KNOWLEDGE_FROM("254"),
	
	/** �ؼ��� */
	KNOWLEDGE_KEYS("258"),
	
	/** CI�������������״̬ */
	EIWAITTASK_STATUS("262"),
	
	/** CI2�������������״̬ */
	CIWAITTASK_TWO_STATUS("273"),
	
	
	/** ���CI�������������״̬ */
	AUDITWAITTASK_STATUS("263"),
	
	/** ��ƶԱȽ������ */
	AUDITRESULT_AUCMPTYPE("264"),
	
	/** ��ƶԱȽ�������ʶ */
	AUDITRESULT_AUFLAG("265"),
	
	/** CI���µ������������״̬ */
	CIWAITTASK_STATUS("266"),
	
	/** CI���¶ԱȽ������ */
	CIRESULT_CICMPTYPE("267"),
	
	/** CI���¶ԱȽ�������ʶ */
	CIRESULT_CIFLAG("268"),
	
	/** �������״̬ */
	AUTSTATUS("269"),
	
	/** CI��������״̬ */
	CISTATUS("270"),
	
	/** �ɼ�����״̬ */
	CI_COLLECT_STATUS("271"),
	
	/** �����ʶ */
	SELF_CODE("156"),
	
	/** ���̱�ģʽ */
	PROCESSINFODEF_MODE_CODE("276"),
	
	/** ���̱���ʾ��� */
	PROCESSINFODEF_ROWWIDTH_CODE("277"),
	
	/** ���̱�˽��Ȩ�޷�Χ */
	PROCESSINFODEF_PRIVATEACCESS_SCOPE("278"),
	
	/** �ɱ����ɲ��������� */
	PROCESSSTATUSDEF_PSDASSIGN("279"),
	
	/** �Ƿ�������� */
	PROCESSSTATUSDEF_PSDORG("280"),
	
	/** ����ȷ�ϲ��� */
	PROCESSSTATUSDEF_PSDCONFIRM("281"),
	
	/** �� */
	DAYS_CODE("282"),
	
	/** Сʱ */
	HOURS_CODE("283"),
	
	/** �� */
	MINUTES_CODE("285"),
	
	/** ���̲���֪ͨ������ */
	PRSTRATEGY_NOTIFIER_TYPE_CODE("286"),
	/** �Զ������̱����� */
	PROCESSINFODEF_TYPE_CODE_WD("287"),
	
	/** �����Ŀ״̬ */
	IAPSTATUS("853"),
    /** ��������Դ*/
    IAPSOURCE("854"),    
    /** ��Ʊ�������*/
    AUDITREPORTTYPE("855"),
    
	/** ������Դ */
	SERVICEFORM_SFSOURCE("288"),
	/** ������� */
	CHANG_CONTENT("289"),
	/** ������ͱ�ʶ */
    COMPONENT_TYPE_CODE("800"),
    /** SYSTEM_KPI��ʶ */
    SYSTEM_KPI_CODE("801"),
    /** SYSTEM�ɼ������ʶ */
    SYSTEM_VAL_CODE("802"),
	/** ҵ�������ʲ� */
	BUSINESSRUN_ENTITYITEM("823"),
	
	/** ͳ�Ʒ�������2012/08/14 */
	/** ʱ������ */
	REPORT_DATETYPE_CODE("824"),
	/** ʱ������:���� */
	REPORT_DATETYPEQ_CODE("825"),
	/** �澯�ȼ���ʶ ԭSOC ccid=270*/
    ALARM_SEVERITY_CODE("820"),
    /** �澯���ͱ�ʶ ԭSOC ccid=271*/
    ALARM_TYPE_CODE("821"),
    /** ������ع������� ԭSOC ccid=272 */
    CAPCITY_OBJECT_LIST_TYPE("822"),
    /** �ʲ���ϵ */
    ENTITYITEM_RELATION_CODE("832"),
    /** ��ع�������2012/09/29 */
    /** �澯���ȼ� */
    ALARM_PRIORITY("850"),
    /** �澯�Ƿ��޸� */
    ALARM_FIXED("851"),
    /** Ħ���澯���ȼ� */
    MOCHAALARM_PRIORITY("852"),
    /** ����ʱ�� */
    CHECK_TIME("292"),
    /** ���ݿ��������� */
    CONNECT_TYPE("295"),
	/** ִ��SQL��Դ */
    CONNECT_DB_FROM("296"),
    /** ϵͳ����û���¼ʱ���ʶ */
    LOGIN_TIME_FLAG("297"),
	/** ������� */
	LEAVE_TYPE("294"),
	/** ����ҳ������ */
    ASSIGN_PAGE_TYPE("291"),
    /** ����ģ�� */
    RFDFILEMODEL("333"),
    
    /**��������*/
	PWD_TYPE("162"),
	/**��־Ԥ������*/
	LOG_WARN_TYPE("163"),
	/**�޸�״̬*/
	LOG_UPSTATUS("323"),
	/**��־�ɹ�״̬*/
	LOG_STATUS("322"),
    
    /************��Ŀ��ʼ********************/
	/** ��Ŀ�Ƿ�ʹ��Ԥ��*/
	Project_ISUSEBUDGET("310"),
	/** ��Ŀ���� */
	BUDGET_QUALITY_CODE("311"),
	/** ������ */
	BUDGET_NEED_DISPART_CODE("312"),
	/** Ԥ����� */
	BUDGET_BUGGET_FORM_CODE("313"),
	/** Ԥ����; */
	BUDGET_USE_CODE("314"),
	/** ��Ŀ��־��� */
	Project_LOGTYPE("315"),
	/** ��ĿԤ����; */
	Project_CATEGORY("316"),
	/** ��Ŀ������ */
	Project_NEEDBRANCH("317"),
	/** ��Ŀ���� */
	Project_QUALITY("318"),
	
	/** SOC��Ϣʱ���趨�������� */
	DATETYPE("900"),
	/** �������÷������� */
	HOST_CMDB("841"),
	/** ���������÷������� */
	SWITCH_CMDB("842"),
	/** �洢���÷������� */
	STORAGE_CMDB("843"),
	/** ���� */
	QUARTER_CODE("320"),
	/** ��ϵ*/
	BELONG_RELATION_TYPE("011"),
	
	/** CMDB���ܼ�ض������� */
	PERF_MONITOR_TYPE("340"),
	
	/** CMDB���ܼ��ָ�� */
	PERF_MONITOR_CATEGORY("341"),
	
	/** ������������ʶ */
	HASATTACH("350"),
	
    /** �豸��־�澯���ȼ� */
    SYSLOGALARM_PRIORITY("951"),
	
	/** ���ʽ����ʾģʽ��ʶ */
	TABLEFORM_DISPLAY("351"),	
	/** ���ʽ��ʹ��ģʽ��ʶ */
	TABLEFORM_USE("352"),
	/** ���ʽ���ӱ����� */
	TABLEFORM_PROCESSINFODEF_TYPE_CODE_WD("353"),	
	/** ���ʽ���Ƿ��������� */
	TABLEFORM_HIDE_COLUMN_NAME("354"),
	/** ����״̬��ʱ���Դ���BL */
	PROCESSTACTICSBL_STATUS("700"),
	/** �������峬ʱ���Դ���BL */
	PROCESSTACTICSBL_ALL("701"),
	/** ���̱�תͼƬ��ʾ */
	PROCESSINFOTOIMG("702"),
	
	TOPO_DEVICE_TYPE("171"),
	/**�Ա�����*/
	COMPARE_TYPE("360"),
	
	NMS_EXECUTABLE_FILE_PATH("172"),
	/**�����ʲ��û�esyscoding ��������CCID*/
	USERS_CCID("166"),
	NET_CCID("173"),
    EIRRELATION("165"),
    RELATIONCODE("167"),
    /**�Զ�������ģ��*/
	PRPDID("335"),
	SYSLOG_DEVICETYPE("301"),
	VMBILLINGCI_CCID("960"),
	
	/** �����¼�״̬ */
	RISK_STATUS("994"),
	
	/** �����¼������� */
	RISK_REVIEW_RESULT("995"),
	
	/** ����Ӧ�Բ��� */
	RISK_POLICY("996"),
	
	/** �����¼���Դ */
	RISK_CASE_ORIGIN("997"),
	
	/** �����¼��������� */
	RISK_CASE_CATEGORY("998"),
	/** ר��Ԥ������������ϵ */
	PLAN_CONDITIONS_RELATION("050"),
	
	/** ��̬��֧���� */
	PROCESS_DYNAMICBRANCH_COND("224")
	;
	
	
	/** */
	protected String ccid;

	/**
	 * 
	 *
	 * @param ccid
	 */
	private CodeDefine(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * 
	 *
	 * @param id
	 */
	public static CodeDefine getCodeDefine(String id) {
		for (CodeDefine c : CodeDefine.values()) {
			if (c.name().equalsIgnoreCase(id)) {
				return c;
			}
		}
		return null;
	}

	public String getCcid() {
		return ccid;
	}
}