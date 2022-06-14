package window;

public class CustomThread extends Thread {
    CustomThread(){
        super.run();
        int cpt = 0;
        for(int i=0;i<4;i++){
            System.out.println("Thread");
            cpt++;
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
