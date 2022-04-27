package org.charlie.example.vo.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@Accessors(chain = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PagedVo<T> {

    @JsonAlias("page_index")
    int pageIndex;

    @JsonAlias("page_size")
    int pageSize;

    int total;

    @JsonAlias("record_index")
    int recordIndex;

    List<T> data;
}
