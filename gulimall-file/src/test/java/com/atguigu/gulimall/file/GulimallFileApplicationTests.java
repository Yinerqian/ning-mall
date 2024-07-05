package com.atguigu.gulimall.file;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class GulimallFileApplicationTests {

    @Autowired
    private OSSClient ossClient;

    @Test
    public void uploadTest() throws Throwable {
        // 创建PutObjectRequest对象:参数 bucket 和 文件名

        File file = new File("C:\\Users\\Administrator\\Desktop\\球团项目\\beishao-bottom.png");

        PutObjectRequest putObjectRequest = new PutObjectRequest("ningmall-file", "beishao-bottom.png", file);

        // 上传文件。
        ossClient.putObject(putObjectRequest);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    @Test
    void contextLoads() {

        // Endpoint 地域端点
        String endpoint = "http://oss-cn-nanjing.aliyuncs.com";

        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI5tCTrAv3hw5ajBMCaQZ8";
        String accessKeySecret = "gq2q8qPss3aydEYW7yHwu57hrjkf15";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        File file = new File("D:\\BaiduNetdiskDownload\\谷粒商城\\Guli Mall(包含代码、课件、sql)\\Guli Mall\\分布式基础\\谷粒商城-微服务架构图.jpg");

        // 创建PutObjectRequest对象。 ，
        PutObjectRequest putObjectRequest = new PutObjectRequest("ningmall-file", "谷粒商城-微服务架构图.jpg", file);

        // 上传文件。
        ossClient.putObject(putObjectRequest);

        // 关闭OSSClient。
        ossClient.shutdown();

        System.out.println("oss upload success");
    }

}
