package br.com.clear.clearnativeapi.controller.dto;

public record TokenDto(String accessToken, long expireIn) {
}
