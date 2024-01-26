package SingletonPattern;
public class Singleton {
    private static Singleton instance = null;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(instance == null){
            // Thread Safe
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
