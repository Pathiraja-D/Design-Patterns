package CommandPattern;

interface Command{
    void execute();
}

class Light {
    public void turnOn(){
        System.out.println("Light is ON");
    }

    public void turnOff(){
        System.out.println("Light is OFF");
    }
}

class RemoteControl{
    private Command command;
    public void setCommand(Command com)
    {
        this.command = com;
    }

    public void pressButton(){
        command.execute();
    }
}


class LightOnCommand implements Command{
    private Light light;
    public LightOnCommand(Light light)
    {
        this.light = light;
    }

    @Override
    public void execute(){
        light.turnOn();
    }
}

class LightOffCommand implements Command{
    private Light light;
    
    public LightOffCommand(Light light)
    {
        this.light = light;
    }

    @Override
    public void execute(){
        light.turnOff();
    }
}




public class CommandPattern {
    public static void main(String[] args){
        Light livingRoomLight = new Light();
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(livingRoomLightOn);
        remote.pressButton();

        remote.setCommand(livingRoomLightOff);
        remote.pressButton();
        
    }
}
