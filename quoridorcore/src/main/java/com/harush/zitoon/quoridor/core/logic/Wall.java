package com.harush.zitoon.quoridor.core.logic;

import com.harush.zitoon.quoridor.core.model.Orientation;

public interface Wall extends BoardPiece {

    Orientation getOrientation();

    int getLength();
}
