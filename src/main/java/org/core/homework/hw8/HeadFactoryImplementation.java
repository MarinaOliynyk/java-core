package org.core.homework.hw8;

public class HeadFactoryImplementation implements HeadFactory {

    private int index = 0;

    @Override
    public Robot.Head createRobotHead() {
        RobotHead[] values = RobotHead.values();
        RobotHead value = values[index];
        Robot.Head head = new Robot.Head(value.getTitle(), value);
        index++;
        if (values.length == index) {
            index = 0;
        }
        return head;
    }
}
