package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.domain.Order;
import com.test.domain.Product;
import com.test.service.OrderService;
import com.test.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private DiscoveryClient discoveryClient;


    //下单--fegin
    @RequestMapping("/order/product/{productId}")
    public Order order(@PathVariable("productId") Integer productId) {
        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", productId);

        //调用商品微服务,查询商品信息
        Product product = productService.findById(productId);

        if (product.getId() == -100) {
            Order order = new Order();
            order.setId(-100L);
            order.setProductName("下单失败");
            return order;
        }

        log.info("查询到{}号商品的信息,内容是:{}", productId, JSON.toJSONString(product));

        //下单(创建订单)
        Order order = new Order();
        order.setId(1L);
        order.setUserName("测试用户");
        order.setProductId(productId);
        order.setProductName(product.getName());
        order.setProductPrice(product.getPrice());
        order.setProductQuantity(1);

        //orderService.createOrder(order);

        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));

        //向mq中投递一个下单成功的消息
        //参数一: 指定topic
        //参数二: 指定消息体
        //rocketMQTemplate.convertAndSend("order-topic", order);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return order;
    }

//    //下单--ribbon负载均衡
//    @RequestMapping("/order/product/{productId}")
//    public Order order(@PathVariable("productId") Integer productId) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", productId);
//
//        //调用商品微服务,查询商品信息
//        //问题:
//        // 1 代码可读性不好
//        // 2 编程风格不统一
//        product product =
//                restTemplate.getForObject("http://service-product/product/" + productId, product.class);
//
//
//
//        log.info("查询到{}号商品的信息,内容是:{}", productId, JSON.toJSONString(product));
//
//        //下单(创建订单)
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setProductId(productId);
//        order.setProductName(product.getName());
//        order.setProductPrice(product.getProductPrice());
//        order.setProductQuantity(1);
//
//        orderService.createOrder(order);
//
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//
//        return order;
//    }

//    //下单--自定义负载均衡
//    @RequestMapping("/order/product/{productId}")
//    public Order order(@PathVariable("productId") Integer productId) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", productId);
//
//        //调用商品微服务,查询商品信息
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//        //随机选择
//        int index = new Random().nextInt(instances.size());//0 1 2
//        ServiceInstance instance = instances.get(index);
//
//        product product =
//                restTemplate.getForObject("http://service-product/product/" + productId, product.class);
//
//        log.info("查询到{}号商品的信息,内容是:{}", productId, JSON.toJSONString(product));
//
//        //下单(创建订单)
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setProductId(productId);
//        order.setProductName(product.getName());
//        order.setProductPrice(product.getProductPrice());
//        order.setProductQuantity(1);
//
//        orderService.createOrder(order);
//
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//
//        return order;
//    }


//    //下单
//    @RequestMapping("/order/product/{productId}")
//    public Order order(@PathVariable("productId") Integer productId) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", productId);
//
//        //调用商品微服务,查询商品信息
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//        ServiceInstance instance = instances.get(0);
//
//        product product =
//                restTemplate.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + productId, product.class);
//
//        log.info("查询到{}号商品的信息,内容是:{}", productId, JSON.toJSONString(product));
//
//        //下单(创建订单)
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setProductId(productId);
//        order.setProductName(product.getName());
//        order.setProductPrice(product.getProductPrice());
//        order.setProductQuantity(1);
//
//        orderService.createOrder(order);
//
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//
//        return order;
//    }

//    //下单
//    @RequestMapping("/order/product/{productId}")
//    public Order order(@PathVariable("productId") Integer productId) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", productId);
//
//        //调用商品微服务,查询商品信息
//        //问题:
//        //1 一旦服务提供者的地址信息变化了,我们就不得不去修改服务调用者的java代码
//        //2 一旦无法提供者做了集群,服务调用者一方无法实现负载均衡的去调用
//        //3 一旦微服务变得越来越多,如何来管理这个服务清单就成了问题
//        product product =
//                restTemplate.getForObject("http://localhost:8081/product/" + productId, product.class);
//
//        log.info("查询到{}号商品的信息,内容是:{}", productId, JSON.toJSONString(product));
//
//        //下单(创建订单)
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setProductId(productId);
//        order.setProductName(product.getName());
//        order.setProductPrice(product.getProductPrice());
//        order.setProductQuantity(1);
//
//        orderService.createOrder(order);
//
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//
//        return order;
//    }
}
