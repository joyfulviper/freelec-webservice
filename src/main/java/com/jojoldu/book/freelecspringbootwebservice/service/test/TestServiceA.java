package com.jojoldu.book.freelecspringbootwebservice.service.test;


import com.jojoldu.book.freelecspringbootwebservice.domain.posts.PostsRepository;
import com.jojoldu.book.freelecspringbootwebservice.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TestServiceA {
    private final TestServiceB testServiceB;
    private final PostsRepository postsRepository;

    @Transactional
    public void save(PostsSaveRequestDto requestDto) {
        System.out.println("상위 트랜잭션 시작");
        postsRepository.save(requestDto.toEntity());
        testServiceB.save(requestDto);
        throw new IllegalStateException();
    }
}
