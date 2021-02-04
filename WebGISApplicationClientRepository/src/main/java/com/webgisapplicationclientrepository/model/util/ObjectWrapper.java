package com.webgisapplicationclientrepository.model.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ObjectWrapper{

    private Point fromDistance;
    private Point toDistance;
}
