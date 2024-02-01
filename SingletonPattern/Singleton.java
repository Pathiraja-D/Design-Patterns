package SingletonPattern;
public class Singleton {
    //private static instance
    private static Singleton instance = null;

    //private instance
    private Singleton(){

    }

    public static Singleton getInstance(){

        // eager initialization - instance is created anyway
        /* 
        private static final Singleton instance = new Singleton();
        private Singleton(){}
        public static Singleton getInstance(){
            return instance;
        }
         */

         //Lazy initialization
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
