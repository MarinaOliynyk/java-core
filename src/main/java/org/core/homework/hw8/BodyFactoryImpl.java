package org.core.homework.hw8;

public class BodyFactoryImpl implements BodyFactory {

    private int index;

    @Override
    public Robot.Body createRobotBody() {
        RobotBody[] currentBody = RobotBody.values();
        RobotBody bodyType = currentBody[index];
        Robot.Body body = new Robot.Body(bodyType.getTitle(), bodyType);
        index++;
        if (currentBody.length == index) {
            index = 0;
        }
        return body;
    }
}
