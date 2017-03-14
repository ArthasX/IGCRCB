package com.csebank.items.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.time.FastDateFormat;

import com.csebank.common.TopOrgValueBean;
import com.deliverik.framework.utility.ResourceUtility;

public final class DefineUtils {
	public static final FastDateFormat DATETIME_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd HH:mm");
	public static final FastDateFormat DATE_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd");
	public static final String ITEMSCODES_STOCK_CATEGORY = "1";//物品种类
	public static final String ITEMSCODES_STOCK_TYPE = "2";//物品类型
	public static final String ITEMSCODES_STOCK_NATURE = "3";//物品性质
	public static final String ITEMSCODES_INSTOCK_STATUS = "4";//入库后状态
	public static final String ITEMSCODES_OUTSTOCK_OUTTYPE = "5";//出库类型
	public static final String ITEMSCODES_OUTSTOCK_REQSTATUS = "6";//出库状态
	public static final String ITEMSCODES_OUTSTOCK_ACCOUNTSTATUS = "7";//结账状态
	public static final String ITEMSCODES_ITEMSCODES_REQUESTSTATUS = "8";//申领状态
	
	//stock表prenum字段操作类型
	public static final String STOCK_PRENUM_RK = "0";//入库
	public static final String STOCK_PRENUM_SL = "1";//申领
	public static final String STOCK_PRENUM_XB = "2";//下拨
	public static final String STOCK_PRENUM_SY = "3";//使用
	public static final String STOCK_PRENUM_SH = "4";//损耗
	public static final String STOCK_PRENUM_XH = "5";//销毁
	public static final String STOCK_PRENUM_CK = "6";//出库
	public static final String STOCK_PRENUM_TZ = "7";//调整
	public static final String STOCK_PRENUM_SP = "8";//审批
	public static final String STOCK_PRENUM_JS = "9";//接收
	
	public static final String STOCK_PRENUM_SLXG = "10";//申领修改
	public static final String STOCK_PRENUM_SLSC = "11";//申领删除
	
	//入库后状态
	public static final String ITEMSCODES_STATUS_WCK = "1";//未出库
	public static final String ITEMSCODES_STATUS_BFCK = "2";//部分出库
	public static final String ITEMSCODES_STATUS_YCK = "3";//已出库
	public static final String ITEMSCODES_STATUS_YSH = "4";//已损耗
	public static final String ITEMSCODES_STATUS_YXH = "5";//已销毁
	
	//出库类型
	public static final String ITEMSCODES_OUTTYPE_RK = "0";//入库
	public static final String ITEMSCODES_OUTTYPE_ZHSL = "1";//支行申领
	public static final String ITEMSCODES_OUTTYPE_ZHXB = "2";//总行下拨
	public static final String ITEMSCODES_OUTTYPE_SY = "3";//使用
	public static final String ITEMSCODES_OUTTYPE_SH = "4";//损耗
	public static final String ITEMSCODES_OUTTYPE_XH = "5";//销毁
	public static final String ITEMSCODES_OUTTYPE_RKTZ = "6";//入库调整
	
	//出库状态
	public static final String ITEMSCODES_REQSTATUS_SLDSP = "1";//申领待审批
	public static final String ITEMSCODES_REQSTATUS_DCK = "2";//待出库
	public static final String ITEMSCODES_REQSTATUS_DJS = "3";//待接收
	public static final String ITEMSCODES_REQSTATUS_SPWTG = "5";//审批未通过
	public static final String ITEMSCODES_REQSTATUS_SHDSP = "7";//损耗待审批
	public static final String ITEMSCODES_REQSTATUS_XHDSP = "9";//销毁待审批
	public static final String ITEMSCODES_REQSTATUS_CKWC = "0";//出库完成、审批接收完毕、损耗审批、销毁审批通过
	
	public static final String ITEMSCODES_REQSTATUS_DJS_CKWC = "0_3";//仓库收益查询使用(待接收_出库完成)
	
	//结账状态
	/**
	 * 未结账
	 */
	public static final String ITEMSCODES_ACCOUNTSTATUS_WJZ = "0";//
	/**
	 * 已结账
	 */
	public static final String ITEMSCODES_ACCOUNTSTATUS_YJZ = "1";//
	
	//申领状态
	/**
	 * 可申领
	 */
	public static final String ITEMSCODES_REQUEST_TRUE = "1";//
	/**
	 * 不可申领
	 */
	public static final String ITEMSCODES_REQUEST_FALSE = "0";//
	

	/**
	 * 默认顶级机构
	 */
	public static final String DEFAULT_ORGNO = TopOrgValueBean.getTopOrg();

	/**
	 * 默认下拨时查询机构的上级机构
	 */
	public static final String DEFAULT_XB_ORGNO = TopOrgValueBean.getXbOrg();
	

	/**
	 * 物品种类
	 */
	public static final String CATEGORY_PZ = "CER";//凭证certificate
	public static final String CATEGORY_BGYP = "OFF";//办公用品Office Supplies
	public static final String CATEGORY_HC = "ITE";//耗材items
	public static final String CATEGORY_DZSB = "ELE";//电子设备electronics
	public static final String CATEGORY_QT = "OTH";//其他other
	
	public static Map<String,String> CATEGORY_MAP = new HashMap<String,String>();
	
	static {
		CATEGORY_MAP.put("1", CATEGORY_PZ);//凭证
		CATEGORY_MAP.put("2", CATEGORY_BGYP);//办公用品
		CATEGORY_MAP.put("3", CATEGORY_HC);//耗材
		CATEGORY_MAP.put("4", CATEGORY_DZSB);//电子设备
		CATEGORY_MAP.put("5", CATEGORY_QT);//其他
	}
	
	/**
	 * instock表查询结果的排序方式
	 */
	public static final String INSTOCK_SORT_BYINTIME = "BYINTIME";
	public static final String INSTOCK_SORT_BYINCODE = "BYINCODE";//按物品编号升序
	public static final String INSTOCK_SORT_BYINTIME_DESC = "BYINTIMEDESC";//按物品入库时间降序
	
	/**
	 * outstock查询结果的排序方式
	 */
	public static final String OUTSTOCK_SORT_BYOUTTIME = "BYOUTTIME";
	
	/**
	 * outstock查询结果的排序方式
	 */
	public static final String OUTSTOCK_SORT_BYORG = "BYORG";
	
	/**
	 * outstock查询结果的排序方式
	 */
	public static final String OUTSTOCK_SORT_BYSEQCODE = "BYSEQCODE";
	
	/**
	 * 仓库收益outstock查询结果的排序方式
	 */
	public static final String OUTSTOCK_SORTTYPE_0169 = "0169";
	
	/**
	 * 物品收益outstockdetail查询结果的排序方式
	 */
	public static final String OUTSTOCKDETAIL_SORTTYPE_0171 = "0171";
	
	/**
	 * 耗材管理默认角色类型，该类型的角色负责人可以管理总行库存
	 */
	public static final String ITEMS_ROLETYPE = ResourceUtility.getString("ITEMS_ROLETYPE");//耗材角色默认角色类型
	
	/**
	 * 物品类别启用
	 */
	public static final String ITEMSCATEGORY_STATUS_QY = "1";
	
	/**
	 * 物品类别停用
	 */
	public static final String ITEMSCATEGORY_STATUS_TY = "0";
	
	/**
	 * 未结账状态，入库调整单价可修改
	 */
	public static final String INSTOCK_PRICE_EDIT_TRUE = "1";//
	/**
	 * 已结账状态，入库调整单价不可修改
	 */
	public static final String INSTOCK_PRICE_EDIT_FALSE = "0";//
	
	/**
	 * 可结账
	 */
	public static final String ACCOUNTSTATUS_TRUE = "1";//
	/**
	 * 不可结账
	 */
	public static final String ACCOUNTSTATUS_FALSE = "0";//
	
	/**
	 * 物品性质：自制
	 */
	public static final String ITEMSCODES_STOCK_NATURE_ZZ = "1";
	
	/**
	 * 物品性质：外来
	 */
	public static final String ITEMSCODES_STOCK_NATURE_WL = "2";
	/**
	 * 不显示数据时用此符号代替
	 */
	public static final String SEPARATOR = "/";//
	
	/**
	 * 下拨时需要过滤的机构的层次码集合
	 */
	public static final String NOT_SHOW_LIST = ResourceUtility.getString("NOT_SHOW_ORGLIST");
	
	/**
	 * 下拨全部
	 */
	public static final String XB_TYPE_QB = ResourceUtility.getString("XB_QB");
	
	/**
	 * 下拨总行
	 */
	public static final String XB_TYPE_ZONGH = ResourceUtility.getString("XB_ZONGH");
	
	/**
	 * 下拨支行
	 */
	public static final String XB_TYPE_ZHIH = ResourceUtility.getString("XB_ZHIH");
	
	/**
	 * 总行机构编码
	 */
	public static final String ZONGH_ORGNO = ResourceUtility.getString("ZONGH_ORG");
	
	/**
	 * 支行机构编码
	 */
	public static final String ZHIH_ORGNO = ResourceUtility.getString("ZHIH_ORG");
	
	/**
	 * 设备监控人员默认角色类型
	 */
	public static final String MNT_ROLETYPE = ResourceUtility.getString("MNT_ROLETYPE");
}