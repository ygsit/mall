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


		// 上传文件流。
		InputStream inputStream = new FileInputStream("D:\\Picture\\Pictures\\4.jpg");
		ossClient.putObject("mall-yu", "4.jpg", inputStream);

		// 关闭OSSClient。
		ossClient.shutdown();
	}

}
