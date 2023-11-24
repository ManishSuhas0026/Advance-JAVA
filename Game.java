public class Game {
    private static final String LEFT_LETTERS = "wpbs";
    private static final String RIGHT_LETTERS = "mqdz";

    private int getStrength(char letter) {
        if (LEFT_LETTERS.indexOf(letter) != -1) {
            switch (letter) {
                case 'w':
                    return 4;
                case 'p':
                    return 3;
                case 'b':
                    return 2;
                case 's':
                    return 1;
            }
        } else if (RIGHT_LETTERS.indexOf(letter) != -1) {
            switch (letter) {
                case 'm':
                    return 4;
                case 'q':
                    return 3;
                case 'd':
                    return 2;
                case 'z':
                    return 1;
            }
        }
        return 0; 
    }

    public String Result(String word) {
        int leftStrength = 0;
        int rightStrength = 0;

        for (char letter : word.toCharArray()) {
            int strength = getStrength(letter);
            leftStrength += (LEFT_LETTERS.indexOf(letter) != -1) ? strength : 0;
            rightStrength += (RIGHT_LETTERS.indexOf(letter) != -1) ? strength : 0;
        }

        if (leftStrength > rightStrength) {
            return "Left side wins!";
        } else if (rightStrength > leftStrength) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    public static void main(String[] args) {
        Game defaultGame = new Game();
        System.out.println(defaultGame.Result("z")); 

        Game customGame = new Game();
        System.out.println(customGame.Result("zdqmwpbs")); 

        Game customStrengthGame = new Game();
        System.out.println(customStrengthGame.Result("wwwwwwz")); 
    }
}
