package com.hand6.health.common;/**
 * Created by Administrator on 2019/7/6.
 */

import java.math.BigDecimal;

/**
 * @author xxxx
 * @description
 * @date 2019/7/6
 */
public class ConstantUtil {

    //性别
    public static final String MAN="MAN";
    public static final String WOMAN="WOMAN";
    //运动记录状态
    public static final String ACHIEVE = "ACHIEVE";  // 达标
    public static final String NOT_ACHIEVE = "NOT_ACHIEVE"; // 未达标

    //运动类型
    public static final String RUN = "RUN";  // 跑步
    public static final String WALK = "WALK"; // 步行
    public static final String RIDE = "RIDE";  // 骑行
    public static final String OTHER = "OTHER"; // 其它

    //定时器用途
    public static final String MOTION_SUMMARY="MOTION_SUMMARY";//运动统计
    public static final String FILE_CLEAN="FILE_CLEAN";//运动统计

    public static final BigDecimal ZERO=new BigDecimal(0);
}
