public class John {

    private int time;
    private int distance;
    private final JohnsActivity[] JOHNS_ACTIVITIES;
    private int nextActivity = 0;

    public John() {
        this(new JohnsActivity[] { new JohnsJump(5), new JohnsRest(1), new JohnsJump(3), new JohnsRest(2),
                new JohnsJump(1), new JohnsRest(5) });
    }

    public John(JohnsActivity... johnsActivities) {
        JOHNS_ACTIVITIES = johnsActivities;
    }

    public int getTime(){return time;}

    public int getDistance(){return distance;}

    public void jumpDistance(int distance) {
        int currentDistance = 0;
        while (distance > currentDistance) {
            doNextActivity();
            this.time += getCurrenttActivity().WAIT_TIME;
            currentDistance += getCurrenttActivity().JUMP_DISTANCE;
        }
        this.distance += currentDistance;
    }

    public void jumpTime(int time) {
        int currentTime = 0;
        while (time >= currentTime) {
            if(time-currentTime<getNextActivity().WAIT_TIME){
                break;
            }
            doNextActivity();
            currentTime += getCurrenttActivity().WAIT_TIME;
            this.distance += getCurrenttActivity().JUMP_DISTANCE;
        }
        this.time += currentTime;
    }

    private void doNextActivity() {
        if (nextActivity + 1 == JOHNS_ACTIVITIES.length)
            nextActivity = 0;
        else
            nextActivity++;
    }

    private JohnsActivity getCurrenttActivity() {
        return JOHNS_ACTIVITIES[(nextActivity == 0) ? JOHNS_ACTIVITIES.length - 1 : nextActivity - 1];
    }

    private JohnsActivity getNextActivity(){
        return JOHNS_ACTIVITIES[nextActivity];
    }

}