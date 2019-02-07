package com.kasiyanov.week6.practicespringboot.util;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@UtilityClass
public class ListFilter {

    public static List<String> removeNullAndEmptyFields(List<String> list) {
        return list.stream().
                filter(Objects::nonNull)
                .filter(it -> it.trim().length() != 0)
                .collect(Collectors.toList());
    }
}
