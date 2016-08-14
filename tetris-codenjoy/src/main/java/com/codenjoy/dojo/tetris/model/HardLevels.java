package com.codenjoy.dojo.tetris.model;


import static com.codenjoy.dojo.tetris.model.Figure.Type.*;
import static com.codenjoy.dojo.tetris.model.GlassEvent.Type.LINES_REMOVED;

/**
 * User: oleksandr.baglai
 * Date: 9/23/12
 * Time: 3:18 PM
 */
public class HardLevels extends Levels {

    public HardLevels(PlayerFigures queue) {
        super(new FigureTypesLevel(queue,
                        new GlassEvent<>(LINES_REMOVED, 4),
                        O),

                new FigureTypesLevel(queue,
                        new GlassEvent<>(LINES_REMOVED, 4),
                        O, I),

                new FigureTypesLevel(queue,
                        new GlassEvent<>(LINES_REMOVED, 4),
                        O, I, J, L),

                new FigureTypesLevel(queue,
                        new GlassEvent<>(LINES_REMOVED, 4),
                        O, I, J, L,
                        S, Z, T));
    }
}