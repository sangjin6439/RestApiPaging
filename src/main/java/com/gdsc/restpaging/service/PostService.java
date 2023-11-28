package com.gdsc.restpaging.service;

import com.gdsc.restpaging.domain.PageCustomize;
import com.gdsc.restpaging.domain.Post;
import com.gdsc.restpaging.dto.PostDTO;
import com.gdsc.restpaging.dto.PostPagingDto;
import com.gdsc.restpaging.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void save(PostDTO postDTO) {
        Post post = Post.toEntity(postDTO);
        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public PageCustomize findAllPosts(PostPagingDto postPagingDto) {

        Sort sort = Sort.by(Sort.Direction.fromString(postPagingDto.getSort()), "id");
        Pageable pageable = PageRequest.of(postPagingDto.getPage(), postPagingDto.getSize(), sort);

        Page<Post> postPages = postRepository.findAll(pageable);

       List<PostDTO> postDTOList= postPages.map(PostDTO::new).getContent();

       return PageCustomize.builder()
               .content(postDTOList)
               .totalPages(postPages.getTotalPages())
               .totalElements(postPages.getTotalElements())
               .build();

    }

}
