package com.jojoldu.book.freelecspringbootwebservice.service.test;

import com.jojoldu.book.freelecspringbootwebservice.domain.posts.Posts;
import com.jojoldu.book.freelecspringbootwebservice.domain.posts.PostsRepository;
import com.jojoldu.book.freelecspringbootwebservice.web.dto.PostsSaveRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestServiceBTest {

    @Autowired
    private TestServiceA testServiceA;

    @Autowired
    private PostsRepository postsRepository;

    @Test
    public void 트랜잭션_Requires_new_테스트() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author("author")
                .build();

        testServiceA.save(requestDto);

        List<Posts> list = postsRepository.findAll();

        System.out.println(list.size());
    }
}