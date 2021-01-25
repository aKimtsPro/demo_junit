package com.example.demo_junit.service.mapper;

public interface BaseMapper<TDTO, TENTITY> {

    TDTO toDto(TENTITY entity);
    TENTITY toEntity(TDTO dto);

}
