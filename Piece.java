package mastermind;
//@author edwardsdw
public class Piece  {
    private static String COLOR_POOL = "ROYGBIV";
    private String colorPool;
    private char color;
    public Piece()  {
        colorPool = COLOR_POOL;
        int rand;
        rand = (int)(Math.random()*COLOR_POOL.length());
        color = COLOR_POOL.charAt(rand);
    }
    public char rColor()  {
        return color;
    }
    public void sColor(char iColor)  {
        if (iColor == 'R' || iColor == 'O' || iColor == 'Y' || iColor == 'G' || iColor == 'B' || iColor == 'I' || iColor == 'V')
            color = iColor;
    }
    public void randColor()  {
        int rand;
        rand = (int)(Math.random()*colorPool.length());
        color = colorPool.charAt(rand);
    }
    public void updatePool(int response, char color2, char color3)  {
        if (response == 7) //Some colors are correct, and in the right location.
            incProb();
        else if (response == 9) //The guess is correct.
            singProb();
    }
    private void incProb()  {
        colorPool += color;
    }
    private void singProb()  {
        colorPool = color;
    }
}
