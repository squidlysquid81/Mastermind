package mastermind;
//@author edwardsdw
public class Set  {
    private static int PIECES = 4 //GAME CAN ONLY HANDLE A MAX OF /6/ WITH ITS CURRENT STATIC POOL!!!!!
    public Piece[] section;
    public Set()  {
        section = new Piece[PIECES];
        for (int count = 0; count < section.length; count++)  {
            section[count] = new Piece();
        }
    }
    public static int rPIECES()  {
        return PIECES;
    }
    public Piece rSection(int place)  {
        Piece output = new Piece();
        if (place >= 0 && place < section.length)
            output = section[place];
        return output;
    }
    public void sSection(Piece iSect, int place)  {
        Piece sect = new Piece();
        sect.sPool(iSect.rPool());
        sect.sColor(iSect.rColor());
        if (place >= 0 && place < section.length)
            section[place] = sect;
    }
    public int test(Set iGuess)  {
        Set guess = new Set();
        boolean[] nums = new boolean[PIECES];
        boolean[] colors = new boolean[PIECES];
        boolean tNums = true, tColors = true, sNums = false, sColors = false;
        int response;
        for (int count = 0; count < PIECES; count++)  {
            guess.sSection(iGuess[count], count);
            nums[count] = false;
            colors[count] = false;
        }
        for (int count = 0; count < PIECES; count++)  {
            if (section[count].rColor() == guess[count].rColor())  {
                nums[count] = true;
                colors[count] = true;
            }
            else  {
                for (int place = 0; place < PIECES; place++)  {
                    if (section[count].rColor() == guess[place].rColor())
                        colors[count] = true;
                }
            }
        }
        for (int count = 0; count < PIECES; count++)  {
            if (nums[count])
                sNums = true;
            else
                tNums = false;
            if (colors[count])
                sColors = true;
            else
                tColors = false;
        }
        if (tNums)
            response = 9;
        else if (tColors)
            response = 5;
        else if (sNums && sColors)
            response = 7;
        else if (sColors)
            response = 3;
        else
            response = 1;
        return response;
    }
    public void update(int response)  {
        if (response == 1)  {
            for (int count = 0; count < PIECES; count++)  {
                for (int place = 0; place < PIECES; place++)  {
                    section[count].zeroProb(section[place].rColor());
                }
            }
        }
        else if (response == 3)  {
            for (int count = 0; count < PIECES; count++)  {
                for (int place = 0; place < PIECES; place++)  {
                    if (place != count)
                        section[count].incProb(section[place].rColor());
                }
            }
        }
        else if (response == 5)  {
            String colorSave = new String("");
            for (int count = 0; count < PIECES; count++)  {
                colorSave += section[count].rColor();
            }
            for (int count = 0; count < colorSave.length(); count++)  {
                for (int place = 0; place < PIECES; place++)  {
                    section[place].zeroProb(colorSave.charAt(count));
                }
            }
        }
        else if (response == 7)  {
            for (int count = 0; count < PIECES; count++)  {
                section[count].incProb();
            }
        }
        else if (response == 9)  {
            for (int count = 0; count < PIECES; count++)  {
                section[count].singProb();
            }
        }
        else
            System.out.println("\nPlease use a given response.");
    }
    public String toString()  {
        String output = new String("");
        for (int count = 0; count < PIECES; count++)  {
            output += section[count].rColor();
            output += " ";
        }
        output = output.substring(0, (output.length() - 1));
        return output;
    }
}
