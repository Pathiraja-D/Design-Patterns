package TemplatePattern;

interface Game {
    void initialize();
    void startPlay();
    void endPlay();

    public default  void play(){
        initialize();
        startPlay();
        endPlay();
    }
}

class Cricket implements Game {
    @Override
    public void initialize(){
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    public void startPlay(){
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    @Override
    public void endPlay(){
        System.out.println("Cricket Game Finished!");
    }
}

class Football implements Game {
    @Override
    public void initialize(){
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    public void startPlay(){
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    public void endPlay(){
        System.out.println("Football Game Finished!");
    }
}


public class TemplatePattern {
    public static void main(String[] args){
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
