/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.asset;

/**
 * 资产属性关键字常量类
 */
public final class EntityItemKeyWords {
	
	/** 关键字起始编号 */
	public final static String COMMON_CONFIG_LABEL_MIN = "IG_0001";
	
	/** 关键字终了编号 */
	public final static String COMMON_CONFIG_LABEL_MAX = "IG_9999";
	
	
	/**
	 * 设备（模型标识：001）关键字
	 * 
	 */
	//设备状态
	public static final String ENTITY_DEFAULT_PROPERTY_STATUS = "IG_0001";
	//操作人ID
	public static final String ENTITY_DEFAULT_PROPERTY_OPERATORID = "IG_0002";
	//操作人姓名
	public static final String ENTITY_DEFAULT_PROPERTY_OPERATORNAME = "IG_0003";
	//接收人姓名
	public static final String ENTITY_DEFAULT_PROPERTY_RECIVENAME = "IG_0004";
	//接收人所属机构名称
	public static final String ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME = "IG_0005";
	//接收人所属机构层次码
	public static final String ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE = "IG_0006";
	//资产ID
	public static final String ENTITY_DEFAULT_DEVICE_EIID = "IG_0007";
	//资产名称
	public static final String ENTITY_DEFAULT_DEVICE_ENAME = "IG_0008";
	//资产模型ID
	public static final String ENTITY_DEFAULT_DEVICE_EID = "IG_0009";
	//资产模型标识
	public static final String ENTITY_DEFAULT_DEVICE_ECATEGORY = "IG_0010";
	//服务商ID
	public static final String ENTITY_DEFAULT_SERVICE_EIID = "IG_0011";
	//服务商名称
	public static final String ENTITY_DEFAULT_SERVICE_ENAME = "IG_0012";
	//服务商模型ID
	public static final String ENTITY_DEFAULT_SERVICE_EID = "IG_0013";
	//服务商模型标识
	public static final String ENTITY_DEFAULT_SERVICE_ECATEGORY = "IG_0014";
	//设备位置
	public static final String CLABEL_U_VALUE = "IG_0015";
	//设备高度
    public static final String CLABEL_U_WIDTH = "IG_0016";
    //型号
    public static final String ENTITY_DEFAULT_MODEL = "IG_0026";
    //序列号
    public static final String ENTITY_DEFAULT_SERIAL_NUMBER = "IG_0027";
    //购买日期
    public static final String ENTITY_DEFAULT_PURCHASE_DATE = "IG_0028";
    //维保日期
	public static final String ENTITY_DEFAULT_MAINTAIN_DATE = "IG_0029";
	
	//机架宽度(W)
	public static final String CLABEL_W_TOTAL = "IG_0104";
	//容器类型
	public static final String CLABEL_L_TOTAL = "IG_0105";
	//机架位置
	public static final String CLABEL_WZ_VALUE = "IG_0106";
	
	/**
	 * 机房（模型标识：007）关键字
	 * 
	 */
	//横向宽度
	public static final String CLABEL_X_TOTAL = "IG_0017";
	//纵向宽度
	public static final String CLABEL_Y_TOTAL = "IG_0018";
	//负责人
	public static final String CLABEL_MANANGER = "IG_0019";
	//联系电话
	public static final String CLABEL_TEL = "IG_0020";
	
	/**
	 * 机柜（模型标识：008）关键字
	 * 
	 */
	//机柜位置X
	public static final String CLABEL_X_VALUE = "IG_0021";
	//机柜位置Y
	public static final String CLABEL_Y_VALUE = "IG_0022";
	//机柜高度(U)
	public static final String CLABEL_U_TOTAL = "IG_0023";
	//机柜横向宽
	public static final String CLABEL_X_WIDTH = "IG_0024";
	//机柜纵向宽
	public static final String CLABEL_Y_WIDTH = "IG_0025";
	//层
	public static final String CLABEL_GRAPHINDEX = "IG_0030";
	//是否已设置
	public static final String CLABEL_GRAPHSTATUS = "IG_0031";
	//类型标识
	public static final String CLABEL_GRAPHTYPEID = "IG_0032";
	//类型名称
	public static final String CLABEL_GRAPHTYPENAME = "IG_0033";
	//额定电压
	public static final String CLABEL_VOLTAGE = "IG_0034";
	//机柜重量
	public static final String CLABEL_WEIGHT = "IG_0035";
	//机柜规格
	public static final String CLABEL_STANDARD = "IG_0036";
	
	/** 资产编号位数*/
	public static final int LABEL_LENGTH = 6;
	
	/** 资产编号其余位数*/
	public static final int LABEL_LEFT_LENGTH = 6;
	
	/** 资产编号最小值*/
	public static final String LABEL_MIN_ID = "000001";
	
	/** 资产编号最大值*/
	public static final String LABEL_MAX_ID = "999999";

	/** 资产编号位数 唐晓娜 修改于2010-7-2*/
	public static final int LABEL_LENGTH_FX = 3;
	
	/** 资产编号其余位数  唐晓娜 修改于2010-7-2*/
	public static final int LABEL_LEFT_LENGTH_FX = 13;
	
	/** 资产编号最小值    唐晓娜 修改于2010-7-2*/
	public static final String LABEL_MIN_ID_FX = "001";
	
	/** 资产编号最大值    唐晓娜 修改于2010-7-2*/
	public static final String LABEL_MAX_ID_FX = "999999";
	
	/** 资产编号填充符*/
	public static final String LABEL_LEFT_PAD = "0";
	
	/** 资产模型类别（配置资产模型） */
	public static final String EMODELTYPE_CONFIGURATION = "1";
	
	/** 容器类型机柜编号*/
	public static final String CLABEL_PULLDOWN="0" ;
	
	/** 容器类型机架编号*/
	public static final String VALUE_PULLDOWN="1" ;
	
	/** 容器GRAPHSTATUS值 */
	public static final String graphstatusN = "0";
	
	/** 容器GRAPHSTATUS值 */
	public static final String graphstatusY = "1";
	
	/** 容器类型UPS编号前缀*/
	public static final String VALUE_UPS = "999001024001";
	
	/** 容器类型空调编号前缀*/
	public static final String VALUE_AIR_CONDITION = "999001024002";
	
	/** 机房类型编号 */
	public static final String COMPUTER_ROOM_ESYSCODING = "999007";
	
	/** 机柜类型编号 */
	public static final String CONTAINER = "999008";
	
	/** 容器GRAPHSTATUS属性ID*/
	public static final int GRAPHSTATUS_ID = 104;
	
	/** 容器类型编号*/
	public static final int LABEL_PULLDOWN = 627;
	
	/** 应用-软件 code*/
	public static final String APP_SW_RelationCODE="003-002";
	
	/** 应用-服务 code*/
	public static final String APP_SERVICE_RelationCODE="003-003";
	
	private EntityItemKeyWords() {
	}
}
