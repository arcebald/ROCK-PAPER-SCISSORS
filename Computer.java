import java.util.Random;

public class Computer extends Player {

    private String value;

    @Override
    public String getValue() {

        return value;
    }

    public void setValue() {
        Random random = new Random();

        int num = random.nextInt(3);

        if (num == 0)
            this.value = "ROCK";
        else if (num == 1)
            this.value = "PAPER";
        else
            this.value = "SCISSORS";
    }

}