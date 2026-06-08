package com.nour_esmat.game.store.common;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {

    private List<T> content;
    private int number;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean isLast;
    private boolean isFirst;

}
