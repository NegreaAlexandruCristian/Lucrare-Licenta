package com.webgisapplicationfeignclient.model.util;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectWrapper{

    private Point startingDistance;
    private Point finishDestination;
}
