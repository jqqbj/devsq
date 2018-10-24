package demo;

import com.jdb.demo.DemoApplication;
import junit.framework.TestCase;
import org.springframework.util.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes={DemoApplication.class})
public class SpringBootTest1 {

    @Test
    public void test(){
        System.out.println(
                "xxxxxxx"
        );
        Assert.isNull("xxx","kong");
      //  TestCase.assertEquals();
    }

    public static void main(String[] args) {
        Map map = new HashMap<String,String>();
        map.put("1","one");
        map.put("2","two");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        System.out.println(it);

        Object obj = null;
        String s1 = (String)obj;
        System.out.println(s1);
    }

}
