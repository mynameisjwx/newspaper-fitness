package com.hand6.health.bean;

import java.lang.annotation.*;

/**
 * 自定义实体类所需要的bean （Excel属性标题、位置等）
 * Created by Administrator on 2019/7/14.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelColumn {
    /**
     * Excel 标题
     */
    String value() default "";
    /**
     * excel从左到右排列位置
     */
    int col() default 0;
}
