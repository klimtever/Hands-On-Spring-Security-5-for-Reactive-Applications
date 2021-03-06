package com.packtpub.book.ch06.springsecurity.router;

import com.packtpub.book.ch06.springsecurity.handler.MovieHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

  @Bean
  public RouterFunction<ServerResponse> routerFunction(MovieHandler movieHandler) {
    return route(GET("/api/movie").and(accept(MediaType.APPLICATION_JSON)), movieHandler::listMovies)
      .andRoute(GET("/api/movie/{id}").and(accept(MediaType.APPLICATION_JSON)), movieHandler::getMovieById)
      .andRoute(POST("/api/movie").and(accept(MediaType.APPLICATION_JSON)), movieHandler::saveMovie)
      .andRoute(PUT("/api/movie/{id}").and(accept(MediaType.APPLICATION_JSON)), movieHandler::putMovie)
      .andRoute(DELETE("/api/movie/{id}").and(accept(MediaType.APPLICATION_JSON)), movieHandler::deleteMovie);
  }

}
