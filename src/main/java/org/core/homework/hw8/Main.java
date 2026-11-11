package org.core.homework.hw8;

public class Main {

    public static void main(String[] args) {
        HeadFactory headFactory = new HeadFactoryImplementation();
        BodyFactory bodyFactory = new BodyFactoryImplementation();

        int count = 1;
        for (int i = 0; i < 3; i++) {
            Robot.Head head = headFactory.createRobotHead();
            for (int j = 0; j < 3; j++) {
                Robot.Body body = bodyFactory.createRobotBody();
                Robot<Robot.Head, Robot.Body> robot = new Robot<>("Robot-" + count, head, body);
                System.out.println(robot);
                count++;
            }
        }
    }
}
