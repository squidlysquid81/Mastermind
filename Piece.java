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
    public String rPool()  {
        return colorPool;
    }
    public char rColor()  {
        return color;
    }
    public void sPool(String iPool)  {
        bool valid = true;
        for (int count = 0; count < iPool.length(); count++)  {
            if (iPool.charAt(count) != 'R' && iPool.charAt(count) != 'O' && iPool.charAt(count) != 'Y' && iPool.charAt(count) != 'G' && iPool.charAt(count) != 'B' && iPool.charAt(count) != 'I' && iPool.charAt(count) != 'V')
                valid = false;
        }
        if (valid)
            colorPool = iPool;
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
    public void incProb()  {
        colorPool += color;
    }
    public void incProb(char iColor)  {
        colorPool += iColor;
    }
    public void singProb()  {
        colorPool = color;
    }
    public void zeroProb()  {
        for (int count = 0; count < colorPool.length; count++)  {
            if (colorPool.charAt(count) == color)  {
                if (count == colorPool.length - 1)
                    colorPool = colorPool.substring(0, count);
                else if (count == 0)
                    colorPool = colorPool.substring(1);
                else
                    colorPool = colorPool.substring(0, count) + colorPool.substring(count + 1);
            }
        }
    }
    public void zeroProb(char iColor)  {
        for (int count = 0; count < colorPool.length; count++)  {
            if (colorPool.charAt(count) == iColor)  {
                if (count == colorPool.length - 1)
                    colorPool = colorPool.substring(0, count);
                else if (count == 0)
                    colorPool = colorPool.substring(1);
                else
                    colorPool = colorPool.substring(0, count) + colorPool.substring(count + 1);
            }
        }
    }
    public void onlyProb(char color1, char color2)  {
        for (int count = 0; count < colorPool.length; count++)  {
            if (colorPool.charAt(count) != color && colorPool.charAt(count) != color2 && colorPool.charAt(count) != color3)  {
                if (count == colorPool.length - 1)
                    colorPool = colorPool.substring(0, count);
                else if (count == 0)
                    colorPool = colorPool.substring(1);
                else
                    colorPool = colorPool.substring(0, count) + colorPool.substring(count + 1);
            }
        }
    }
}
