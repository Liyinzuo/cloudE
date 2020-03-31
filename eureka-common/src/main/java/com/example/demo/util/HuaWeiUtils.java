package com.example.demo.util;

import com.obs.services.ObsClient;
import com.obs.services.model.ObjectListing;
import com.obs.services.model.ObsBucket;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class HuaWeiUtils {

    private static Logger logger = LoggerFactory.getLogger(HuaWeiUtils.class);

    /**
     * 创建桶
     * @param buckName
     * @return
     */
    public static ObsClient initObs(String buckName) {
        ObsClient obsClient = new ObsClient(Constant.HuaWei_Access_Key_Id, Constant.HuaWei_Secret_Access_Key, Constant.endPoint);
        //桶名称 存储上一级目录名称 buckName下可存放多个文件
        String location = obsClient.getBucketLocation(buckName);
        if (location.equals("") || StringUtils.isBlank(location)) {
            ObsBucket bucket = new ObsBucket();
            bucket.setBucketName(buckName);
            obsClient.createBucket(bucket);
        }
        return obsClient;
    }


    /**
     * 上传
     * @param obsClient
     * @param buckName
     * @param objectName
     * @param fileByte
     * @return
     */
    public static String putObject(ObsClient obsClient, String buckName, String objectName, byte[] fileByte) {
        String url = null;
        try {
            url = obsClient.putObject(buckName, objectName, new ByteArrayInputStream(fileByte)).getObjectUrl();
        } catch (Exception e) {
            try {
                obsClient.close();
            } catch (IOException e1) {
                logger.error("obsClient close error!");
                logger.error(e1.getMessage());
            }

        }

        return url;
    }

    /**
     * 删除
     * @param obsClient
     * @param buckName
     * @param objectName
     * @return
     */
    public static void deleteObject(ObsClient obsClient, String buckName, String objectName) {
        try {
            obsClient.deleteObject(buckName, objectName);
        } catch (Exception e) {
            try {
                obsClient.close();
            } catch (IOException e1) {
                logger.error("obsClient close error!");
                logger.error(e1.getMessage());
            }

        }
    }

    /**
     * 查询
     * @param obsClient
     * @param buckName
     * @return
     */
    public static ObjectListing listFile(ObsClient obsClient, String buckName) {
        ObjectListing o = null;
        try {
            o = obsClient.listObjects(buckName);
        } catch (Exception e) {
            try {
                obsClient.close();
            } catch (IOException e1) {
                logger.error("obsClient close error!");
                logger.error(e1.getMessage());
            }

        }
        return o;
    }

}
