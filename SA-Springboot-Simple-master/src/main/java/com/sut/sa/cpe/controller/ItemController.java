package com.sut.sa.cpe.controller;

import com.sut.sa.cpe.repository.CategoryRepository;
import com.sut.sa.cpe.repository.HashtagRepository;
import com.sut.sa.cpe.repository.ItemRepository;
import com.sut.sa.cpe.repository.UserRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sut.sa.cpe.entity.Category;
import com.sut.sa.cpe.entity.Hashtag;
import com.sut.sa.cpe.entity.Item;
import com.sut.sa.cpe.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.util.Collection;
import java.util.stream.Collectors;
import java.io.IOException;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ItemController {
    @Autowired
    private final ItemRepository itemRepository;
    @Autowired
    private final HashtagRepository hashtagRepository;
    @Autowired
    private final CategoryRepository categoryRepository;
    @Autowired
    private final UserRepository userRepository;

    public ItemController(ItemRepository itemRepository,HashtagRepository hashtagRepository,CategoryRepository categoryRepository,UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.hashtagRepository = hashtagRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/Item")
    public Collection<Item> item() {
        return itemRepository.findAll().stream().collect(Collectors.toList());
    }
                            

    
   @PostMapping("/item/{catID}/{userID}/{tagID}")
   public Item newItem(@RequestBody Item item,
                        @PathVariable Long catID,
                        @PathVariable Long userID,
                        @PathVariable Long tagID )  {
        final String decoded = URLDecoder.decode(dataComment, "UTF-8");
        dataComment = decoded;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(dataComment);

        JsonNode jsonText = actualObj.get("textSelect");
        JsonNode jsonImg = actualObj.get("imgSelect");
        JsonNode jsonRating = actualObj.get("ratingSelect");
                            Category category = categoryRepository.findById(catID).get();
                            User user = userRepository.findById(userID).get();
                            Hashtag hashtag = hashtagRepository.findById(tagID).get();

                            item.setCategory(category);
                            item.setHashtag(hashtag);
                            item.setUser(user);
       return itemRepository.save(item);
   }
   @DeleteMapping("/item/{itemID}")
   public void deleteItem(@PathVariable Long itemID){
    itemRepository.deleteById(itemID);
   }
}
