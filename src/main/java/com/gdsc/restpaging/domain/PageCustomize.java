package com.gdsc.restpaging.domain;

import com.gdsc.restpaging.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageCustomize {

    private List<PostDTO> content;
    private int totalPages;
    private long totalElements;

}
