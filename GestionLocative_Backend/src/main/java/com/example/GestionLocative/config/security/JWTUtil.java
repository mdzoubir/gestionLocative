package com.example.GestionLocative.config.security;

public class JWTUtil {
  public static final String SECRET = "GestionLocative";
  public static final String AUTH_HEADER = "Authorization";
  public static final long EXPIRE_ACCESS_TOKEN = 6000000;
  public static final long EXPIRE_REFRESH_TOKEN = 9000000;
  public static final String PREFIX = "Bearer ";
  public static final int PREFIX_LENGTH = PREFIX.length();
  public static final String ENDPOINTS = "/refreshToken";

}
