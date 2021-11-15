package com.unimini.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //어노테이션 유지 범위
@Target(ElementType.PARAMETER) // 어노테이션 적용위치
@AuthenticationPrincipal(expression = "#this == 'anonymousUser' ? null : UserInfo")
public @interface CurrentUser {}