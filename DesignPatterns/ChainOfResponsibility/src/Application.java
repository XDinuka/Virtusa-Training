public class Application {
    public static void main(String[] args) {

        Message studentLevelMessage = new Message();
        studentLevelMessage.setText("Test Message 1");
        studentLevelMessage.setMessageScope(MessageScope.STUDENT);
        Message.send(studentLevelMessage);

        System.out.println();

        Message teacherLevelMessage = new Message();
        teacherLevelMessage.setText("Test Message 2");
        teacherLevelMessage.setMessageScope(MessageScope.TEACHER);
        Message.send(teacherLevelMessage);

        System.out.println();

        Message sectionalHeadLevelMessage = new Message();
        sectionalHeadLevelMessage.setText("Test Message 3");
        sectionalHeadLevelMessage.setMessageScope(MessageScope.SECTIONAL_HEAD);
        Message.send(sectionalHeadLevelMessage);

        System.out.println();

        Message principalLevelMessage = new Message();
        principalLevelMessage.setText("Test Message 4");
        principalLevelMessage.setMessageScope(MessageScope.PRINCIPAL);
        Message.send(principalLevelMessage);

        System.out.println();

        Message systemAdminLevelMessage = new Message();
        systemAdminLevelMessage.setText("Test Message 5");
        systemAdminLevelMessage.setMessageScope(MessageScope.SYSTEM_ADMIN);
        Message.send(systemAdminLevelMessage);


    }
}
