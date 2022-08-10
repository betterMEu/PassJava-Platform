package com.better.passjavamember;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class PassjavaMemberApplicationTests {

    @Autowired
    OSSClient ossClient;

    @Test
    void testUploadByAlicloudOss() throws FileNotFoundException {
        String bucketName = "sangyu-passjava";
        String localFile = "C:\\Users\\yls91\\Desktop\\image\\原神\\战双CG_满溢的心意.png";
        String fileKeyName = "战双CG_满溢的心意.png";
        InputStream inputStream = new FileInputStream(localFile);
        ossClient.putObject(bucketName, fileKeyName, inputStream);
        ossClient.shutdown();
    }

    @Test
    void testUploadByOss() throws FileNotFoundException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI5tGBKjrEh3MBf9cncmp9";
        String accessKeySecret = "jAVFfevg82WctgrDXLyKUIZqZZD43J";
        String bucketName = "sangyu-passjava";

        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        String localFile = "C:\\Users\\yls91\\Desktop\\image\\原神\\战双CG_热砂白贝.png";
        String fileKeyName = "战双CG_热砂白贝.png";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        InputStream inputStream = new FileInputStream(localFile);
        ossClient.putObject(bucketName, fileKeyName, inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
