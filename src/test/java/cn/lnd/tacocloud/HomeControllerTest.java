package cn.lnd.tacocloud;

import cn.lnd.tacocloud.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// 导入一些方法，这样就可以在当前类中直接使用了
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.hamcrest.Matchers.containsString;

/**
 * @Author lnd
 * @Description
 * @Date 2022/7/23 17:55
 */

@SpringBootTest
public class HomeControllerTest {


    @Test
    public void test(){
        System.out.println("Jeee");
    }
}
