package br.com.clear.clearnativeapi.web.controller.dto;

public record TokenDto(String accessToken, long expireIn) {
}
