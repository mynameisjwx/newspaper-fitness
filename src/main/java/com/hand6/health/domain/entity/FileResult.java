package com.hand6.health.domain.entity;/**
 * Created by Administrator on 2019/7/13.
 */

import lombok.Data;

/**
 * @author xxxx
 * @description
 * @date 2019/7/13
 */
@Data
public class FileResult {
    //文件名
    private String fileName;
    //扩展名
    private String extName;
    //文件大小
    private Long fileSize;
    //文件存储的相对地址
    private String serverPath;
}
