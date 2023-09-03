package com.music.albums.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    ENTITY_NOT_FOUND("/solucao-para-o-problema", "Recurso não econtrado"),
    CONFLICTING_REQUESTS("/solucao-para-o-problema", "Informações conflitantes"),
    ERROR_IN_REQUEST("/solucao-para-o-problema", "Houve um erro na requisição"),
    IMPROPERSIBLE_REQUIREMENT("/solucao-para-o-problema", "Requisição inválida");

    private String title;
    private String uri;

    private ProblemType(String path, String title) {
        this.uri = "http://devdosamigos.com.br" + path;
        this.title = title;
    }

}
