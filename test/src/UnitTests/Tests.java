package src.UnitTests;

import com.flappyghost.Game;
import com.flappyghost.InputHandlers.ObjectHandler;
import com.flappyghost.Objects.Button;
import com.flappyghost.Objects.Ghost;
import com.flappyghost.Objects.Obstacle;
import com.flappyghost.Objects.ObsticleType;
import org.testng.annotations.Test;

import java.awt.*;

import static com.flappyghost.Objects.Button.checkUserMouseCollision;
import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.*;

public class Tests {

    @Test
    public void testCheckObjectGhostCollisionPositiveScenario() {

        Ghost ghost = new Ghost(0,0,10,10);
        Rectangle expectedGhostBounds = ghost.getBounds();
        Obstacle obstacle = new Obstacle(5,5,10,10, ObsticleType.TOP);

        assertFalse(Game.isGameOver());
        ghost.checkObjectGhostCollision(obstacle);

        assertEquals(expectedGhostBounds, ghost.getBounds());
        assertTrue(Game.isGameOver());
    }

    @Test
    public void testCheckObjectGhostCollisionNegativeScenario() {

        Ghost ghost = new Ghost(0,0,10,10);
        Obstacle obstacle = new Obstacle(100,100,10,10, ObsticleType.TOP);

        assertFalse(Game.isGameOver());
        ghost.checkObjectGhostCollision(obstacle);
        assertFalse(Game.isGameOver());
    }

    @Test
    public void testCheckUserMouseCollision() {

        Button btn = mock(Button.class);
        when(btn.getX()).thenReturn(10);
        when(btn.getY()).thenReturn(20);
        when(btn.getWidth()).thenReturn(50);
        when(btn.getHeight()).thenReturn(30);

        assertTrue(checkUserMouseCollision(15, 25, btn));
        assertFalse(checkUserMouseCollision(5, 15, btn));
        assertFalse(checkUserMouseCollision(-505, -9999, btn));
    }
    @Test
    public void testObstacleRemoval()
 {

        Obstacle obstacle = new Obstacle(100, 100, 50, 100, ObsticleType.BOTTOM);
        ObjectHandler.addObject(obstacle);
        obstacle.update();

        assertEquals(97, obstacle.getX());
        assertTrue(ObjectHandler.list.contains(obstacle));

        obstacle.setX(-50);
        obstacle.update();
        assertFalse(ObjectHandler.list.contains(obstacle));
    }
}

