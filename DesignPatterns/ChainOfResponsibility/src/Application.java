public class Application {
    public static void main(String[] args) {

        MessageSender messageSender = MessageSender.getDefaultMessageSender();

        Message studentLevelMessage = new Message();
        studentLevelMessage.setText("Test Message 1");
        studentLevelMessage.setMessageScope(MessageScope.STUDENT);
        messageSender.send(studentLevelMessage);

        System.out.println();

        Message teacherLevelMessage = new Message();
        teacherLevelMessage.setText("Test Message 2");
        teacherLevelMessage.setMessageScope(MessageScope.TEACHER);
        messageSender.send(teacherLevelMessage);

        System.out.println();

        Message sectionalHeadLevelMessage = new Message();
        sectionalHeadLevelMessage.setText("Test Message 3");
        sectionalHeadLevelMessage.setMessageScope(MessageScope.SECTIONAL_HEAD);
        messageSender.send(sectionalHeadLevelMessage);

        System.out.println();

        Message principalLevelMessage = new Message();
        principalLevelMessage.setText("Test Message 4");
        principalLevelMessage.setMessageScope(MessageScope.PRINCIPAL);
        messageSender.send(principalLevelMessage);

        System.out.println();

        Message systemAdminLevelMessage = new Message();
        systemAdminLevelMessage.setText("Test Message 5");
        systemAdminLevelMessage.setMessageScope(MessageScope.SYSTEM_ADMIN);
        messageSender.send(systemAdminLevelMessage);


    }
}
