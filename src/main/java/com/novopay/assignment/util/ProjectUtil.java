package com.novopay.assignment.util;

import com.novopay.assignment.entity.Direction;
import org.springframework.data.domain.Sort;

public class ProjectUtil {

    public static Sort.Direction getDirection(Direction direction) {
        Sort.Direction dir = Sort.Direction.ASC;
        if (direction != null) {
            if (direction == Direction.DESC) {
                dir = Sort.Direction.DESC;
            }
        }
        return dir;
    }
}
