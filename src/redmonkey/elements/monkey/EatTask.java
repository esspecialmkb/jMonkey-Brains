/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package redmonkey.elements.monkey;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import redmonkey.RMFinishedAnim;

/**
 *
 */
public class EatTask extends LeafTask<RMMonkey> {

    RMFinishedAnim irq;
    
    @Override
    public void run(RMMonkey monkey) {
        if (!monkey.getStateMachine().getCurrentState().equals(RMMonkeyState.EAT_BANANA)){
            monkey.getStateMachine().changeState(RMMonkeyState.EAT_BANANA);
            irq=new RMFinishedAnim(monkey);
        }
        if (irq.testForInterrupt()){
            if (irq.didISucceed())
                success();
            else
                fail();
        }
        running();
    }

    @Override
    protected Task<RMMonkey> copyTo(Task<RMMonkey> task) {
        EatTask eat = (EatTask) task;
        return eat;
    }
}
