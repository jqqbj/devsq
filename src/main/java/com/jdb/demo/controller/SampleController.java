package com.jdb.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdb.demo.elasticsearch.domain.Article;
import com.jdb.demo.elasticsearch.repository.ArticeRepository;
import com.jdb.demo.entity.Person;
import com.jdb.demo.exception.LoginException;
import com.jdb.demo.helper.RedisHelper;
import com.jdb.demo.jpa.PersonDao;
import com.jdb.demo.mybatis.mapper.MyPerson;
import com.jdb.demo.mybatis.mapper.PersonMapper;
import com.jdb.demo.service.PersonService;
import com.jdb.demo.task.AsyncTask;
import com.jdb.demo.utils.JsonUtils;
import com.jdb.demo.utils.SpringUtil;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.jms.Queue;
import java.util.Date;
import java.util.concurrent.Future;


@Controller
@PropertySource({"classpath:application.properties"})
public class SampleController {

    @Value("${name}")
    private String name;

    @ModelAttribute
    public void bb(String name){
        System.err.println("执行ModelAttribute->"+name);
    }

    @RequestMapping("/")
    @ResponseBody
    String home(String name) {
        //int i = 9/0;
        System.out.println("bbb"+name);
        return name;
    }

    @Autowired
    private User user;

    @RequestMapping("/pro")
    @ResponseBody
    User pro(Model model, ModelMap map) {
        int i= 9/0;
        //model.asMap();
        throw new LoginException("我是自定义异常");
        //return user;
    }

    @RequestMapping("/ftl")
    ModelAndView ftl1() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("user","qiang");
        mav.addObject("user2","qiang2");
        mav.setViewName("test");
        return mav;
    }

    @Resource
    PersonDao personDao;

    @Resource
    PersonMapper personMapper;

    @RequestMapping("/ftl2")
    String ftl2(Model model, ModelMap modelmap) {
        System.out.println("JPA-->"+personDao.getOne(1L).getName());
        System.out.println("Mybatis 注解-->"+personMapper.getId(1L).getName());
        System.out.println("Mybatis XML-->"+personMapper.getOne(1L).get("name"));
        model.addAttribute("user","qiang");
        modelmap.addAttribute("user2","qiang2");
        return "test";
    }

    @Resource
    PersonService personService;

    @RequestMapping("/tx")
    @ResponseBody
    String ftl2(Model model) {
        personService.addPerson();
        return "ok";
    }


    @Resource
    RedisTemplate redisTemplate;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisHelper redishp;

    @RequestMapping("/redis")
    @ResponseBody
    String ftl3() {
        redisTemplate.opsForValue().set("name","qiang");
        System.err.println("Redis String Key="+redisTemplate.opsForValue().get("name"));
        redisTemplate.opsForValue().set("user",new MyPerson(1L,"qiangqiang"));
        System.err.println("Redis String Key="+((MyPerson)redisTemplate.opsForValue().get("user")).getName());
        System.err.println("RedisHelper->"+redishp.get("name"));
        return "redis";
    }

    @Resource
    AsyncTask asyncTask;

    @RequestMapping("/async")
    @ResponseBody
    String async() {
        System.err.println("异步-start"+new Date());
        Future future1 = asyncTask.task1();
        Future future2 = asyncTask.task2();
        for(;;){
            if(future1.isDone()&&future2.isDone()){
                System.err.println("任务已全部执行完毕");
                break;
            }
        }
        System.err.println("异步-end"+new Date());
        return "async";
    }


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/log")
    @ResponseBody
    String log() {
        logger.debug("这是debug日志");
        logger.info("这是info日志");
        logger.error("这是error日志");
        logger.warn("这是warn日志");
        return "log";
    }

    @Autowired
    ArticeRepository articeRepository;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/search")
    @ResponseBody
    Object search(String title) throws JsonProcessingException {
        Article article = new Article();
        article.setId(3L);
        article.setTitle("springboot");
        article.setContent("你好，你好，你好，你好");
        article.setTime(new Date());
//        articeRepository.save(article);
        QueryBuilder qb = QueryBuilders.matchQuery("title",title);
        Iterable<Article> list= articeRepository.search(qb);
        for(Article a:list){
            System.err.println(a.getContent());
        }
        //System.out.println("JSON:"+objectMapper.writeValueAsString(article));
        System.out.println(JsonUtils.obj2String(article));
        return list;
        //return "search";
    }


    @Autowired
    JmsMessagingTemplate jmsTemplate;

    @Resource //(name="query1")
    Queue defalutQuery;

//    @Resource(name="query2")
//    Queue query2;

    @RequestMapping("/queue")
    @ResponseBody
    Object queue(String title) throws JsonProcessingException {
        //jmsTemplate.convertAndSend("大家好，我是默认队列集成"+new Date());
        jmsTemplate.convertAndSend(new ActiveMQQueue("jdb.queue"),"大家好，我是SpringBOOT集成query1"+new Date());
        //jmsTemplate.convertAndSend(new ActiveMQQueue("test.queue"),"大家好，我是SpringBOOT集成query1"+new Date());
        //jmsTemplate.convertAndSend(defalutQuery,"大家好，我是默认");
        // jmsTemplate.convertAndSend(query2,"大家好，我是SpringBOOT集成query2"+new Date());
        return "queue";
    }

    @RequestMapping("/topic")
    @ResponseBody
    Object topic(String title) throws JsonProcessingException {
        jmsTemplate.convertAndSend(new ActiveMQTopic("jdb.topic"),"大家好，我是SpringBOOT集成topic"+new Date());
        return "topic";
    }


    @RequestMapping(value = "/push",produces = "text/event-stream;charset=UTF-8")
    @ResponseBody
    public String push(){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // 默认chrome 3秒 刷一次 可以在返回的 data 前 加上 retry:1000\n 自定义刷新时间
        return "retry:1000\ndata:" + new Date().toString() + "\n\n";
        //return "data:" + new Date().toString() + "\n\n";
    }



    @Autowired
    Person person1;

    @Autowired
    Person person2;

    @RequestMapping("/bean")
    @ResponseBody
    String bean(){
       // 按类型报错有多个对象
       // SpringUtil.getBean(Person.class);
        SpringUtil.getBean("person1");

        System.out.println("person1:"+ person1.getId());
        System.out.println("person2:"+ person2.getId());
        return "bean";
    }

}
