

package supercaveadventure.entities;



/**
 * Exits the game when PlayerCharacter collides with this.
*/
public class ExitStaircase extends Staircase{

    public ExitStaircase(int x, int y) {
        super(x, y, null, null);
    }
    
    @Override
    public void onOverlap(Entity collidingEntity) {
        if(collidingEntity.getClass() == PlayerCharacter.class) {
            System.exit(0);
        }
    }
    
    
}
