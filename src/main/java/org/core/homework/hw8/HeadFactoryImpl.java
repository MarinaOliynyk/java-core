package org.core.homework.hw8;

public class HeadFactoryImpl implements HeadFactory {

    private int index;

    @Override
    public Robot.Head createRobotHead() {
        RobotHead[] currentHead = RobotHead.values();
        RobotHead headType = currentHead[index];
        Robot.Head head = new Robot.Head(headType.getTitle(), headType);
        index++;
        if (currentHead.length == index) {
            index = 0;
        }
        return head;
    }
}
