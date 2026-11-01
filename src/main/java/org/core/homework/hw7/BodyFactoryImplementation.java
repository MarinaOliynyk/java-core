package org.core.homework.hw7;

public class BodyFactoryImplementation implements BodyFactory {

    private int index = 0;

    @Override
    public Robot.Body createRobotBody() {
        RobotBody[] values = RobotBody.values();
        RobotBody value = values[index];
        Robot.Body body = new Robot.Body(value.getTitle());
        index++;
        if (values.length == index) {
            index = 0;
        }
        return body;
    }
}
