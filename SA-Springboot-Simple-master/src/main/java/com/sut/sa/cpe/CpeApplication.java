package com.sut.sa.cpe;


import com.sut.sa.cpe.entity.*;
import com.sut.sa.cpe.repository.*;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

@SpringBootApplication
public class CpeApplication {

    

    public static void main(String[] args) {
        SpringApplication.run(CpeApplication.class, args);
    }

    @Bean
    ApplicationRunner init(UserRepository userRepository,ItemRepository itemRepository,HashtagRepository hashtagRepository,CategoryRepository categoryRepository) {
        return args -> {
            Stream.of("Tanapon","Sitthichai","Somchai").forEach(username -> {       
                User user = new User();                                         
                user.setUsername(username);                                                    
                userRepository.save(user); });
            Stream.of("เสื้อผ้าและแฟชั่น","อุปกรณ์อิเล็กทรอนิกส์","เครื่องใช้ภายในบ้าน","เครื่องประดับ","ยานยนต์","อุปกรณ์กีฬา").forEach(categoryname ->{
                Category category = new Category();
                category.setCategoryname(categoryname);
                categoryRepository.save(category);
            }
            )   ;  
            Stream.of("#ของแท้","#เครื่องใช้ไฟฟ้า","#มือถือ","#แลปท็อป","#แต่งรถยนต์","#แต่งรถมอเตอร์ไซค์").forEach(hashtagname -> {
                Hashtag hashtag = new Hashtag();
                hashtag.setHashtagname(hashtagname);
                hashtagRepository.save(hashtag);
            }); 
            // userRepository.findAll().forEach(System.out::println);
            // itemRepository.findAll().forEach(System.out::println);
            // hashtagRepository.findAll().forEach(System.out::println);
            // categoryRepository.findAll().forEach(System.out::println);
        };



}}