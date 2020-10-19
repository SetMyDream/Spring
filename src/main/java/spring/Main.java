package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.AppConfig;
import spring.model.User;
import spring.service.UserService;

public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("John");
        user1.setEmail("JohnDou@mail.org");
        user1.setPassword("12345");
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.add(user1);
        System.out.println(userService.listUsers());
    }
}
