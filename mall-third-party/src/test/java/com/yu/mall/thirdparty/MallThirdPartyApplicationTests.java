package com.yu.mall.thirdparty;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class MallThirdPartyApplicationTests {

	@Autowired
	OSSClient ossClient;

	@Test
	void contextLoads() {
	}

	@Test
	public void testUpload() throws FileNotFoundException {
        /*// Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI4G92k9RWazUYuuu7gCkZ";
        String accessKeySecret = "CITkpNcUvXfzaRa5rYZxzJi12kXVCw";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);*/

		// 上传文件流。
		InputStream inputStream = new FileInputStream("D:\\Picture\\Pictures\\4.jpg");
		ossClient.putObject("mall-yu", "4.jpg", inputStream);

		// 关闭OSSClient。
		ossClient.shutdown();
	}

}
