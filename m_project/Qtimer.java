import java.util.Timer;
import java.util.TimerTask;

public class Qtimer {
    int sec = 0;
    Timer timer = new Timer();
    TimerTask task = new TimerTask(){
        public void run() {
            sec++;
        }
    };
    public void runTimer(){
        timer.schedule(task, 0, 1000);
    }
    public void endtimer(){
        timer.cancel();
    }
    public int getsec(){
        return this.sec;
    }
}
