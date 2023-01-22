package com.example.gatewayservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class ClientResource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String resource_ids;
    private String client_id ;
    private String  client_secret ;
    private String  scope;
    private String authorized_grant_types;
    private String  web_server_redirect_uri;
    private String authorities;
    private String   access_token_validity;
    private String  refresh_token_validity;
    private String  additional_information;
    private String  autoapprove;
}
