package online.jianchi.webapi;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import online.jianchi.webapi.mapper.UserMapper;
import online.jianchi.webapi.model.UserModel;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	void contextLoads() {
		System.out.println(("----- selectAll method test ------"));
        List<UserModel> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
	}

}
