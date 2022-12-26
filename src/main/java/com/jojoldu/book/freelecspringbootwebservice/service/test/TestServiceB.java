package com.jojoldu.book.freelecspringbootwebservice.service.test;

import com.jojoldu.book.freelecspringbootwebservice.domain.posts.PostsRepository;
import com.jojoldu.book.freelecspringbootwebservice.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TestServiceB {
    private final PostsRepository postsRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(PostsSaveRequestDto requestDto) {
        System.out.println("하위 트랜잭션 시작");
        postsRepository.save(requestDto.toEntity());
        //throw new IllegalStateException();
    }
}