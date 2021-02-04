package com.webgisapplicationfeignclient.model.util;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ObjectWrapper{

    private Point fromDistance;
    private Point toDistance;
}
