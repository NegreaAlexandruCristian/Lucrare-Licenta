package com.webgisapplicationclientgeotools.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ObjectWrapper{

    private Point startingDistance;
    private Point finishDestination;
}
