package TitatoExam;

import java.util.Arrays;
import java.util.regex.Pattern;

public class TicTacToeGameManager {


    private BlockEntry[][] gameTable;
    private boolean isGameEnd;
    private int rowCount;
    private int colCount;

    public TicTacToeGameManager(int rowCount, int colCount) {
        //init value
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.gameTable = new BlockEntry[rowCount][colCount];
        //init block object in game table
        for(int x = 0; x< rowCount; x++)
            for(int y = 0; y< colCount; y++)
                gameTable[x][y] = new BlockEntry();
        this.isGameEnd = false;

    }

    public boolean isGameEnd() {
        return isGameEnd;
    }
    public BlockEntry[][] getGameTable() {return  gameTable;}

    public void drawGameTable()
    {
        //clean screen cmd
        System.out.print("\033[H\033[2J");
        System.out.flush();
        //draw game table
        System.out.println("----------");
        for (int row = 0; row < this.rowCount; row++) {
            System.out.print("| ");
            for (int col = 0; col < this.colCount; col++) {
                System.out.print(gameTable[row][col].getDrawSymbol() + " ");
            }
            System.out.println(" |");
        }
        System.out.println("----------");
    }

    public boolean playerOnePlay(String coordinates)
    {

        Pattern pattern = Pattern.compile("[0-9\\s]*");
        coordinates = coordinates.trim();
        //check coordinates pattern from "[number] [number]"
        if(!pattern.matcher(coordinates).matches() || !(coordinates.length() == 3) || !coordinates.contains(" ")) {
            System.out.println("Coordinates Incorrect");
            return false;
        }

        //split to row and col
        String[] target = coordinates.split(" ");
        //cast to int
        int[] targetInInt = Arrays.stream(target).mapToInt(Integer::parseInt).toArray();
        //check target in range
        if(targetInInt[0] >= 1 && targetInInt[0] <= rowCount && targetInInt[1] >= 1 && targetInInt[1] <= colCount) {
            //set ot game table change block stage to X
            gameTable[targetInInt[0] - 1][targetInInt[1] - 1].setBlockStage(BlockEntry.BlockStage.O);
        }else {
            System.out.println("Coordinates Incorrect");
            return false;
        }
        return true;
    }

    public boolean playerTwoPlay(String coordinates)
    {

        Pattern pattern = Pattern.compile("[0-9\\s]*");
        coordinates = coordinates.trim();
        //check coordinates pattern from "[number] [number]"
        if(!pattern.matcher(coordinates).matches() || !(coordinates.length() == 3) || !coordinates.contains(" ")) {
            System.out.println("Coordinates Incorrect");
            return false;
        }

        //split to row and col
        String[] target = coordinates.split(" ");
        //cast to int
        int[] targetInInt = Arrays.stream(target).mapToInt(Integer::parseInt).toArray();
        //check target in range
        if(targetInInt[0] >= 1 && targetInInt[0] <= rowCount && targetInInt[1] >= 1 && targetInInt[1] <= colCount) {
            //set ot game table change block stage to X
            gameTable[targetInInt[0] - 1][targetInInt[1] - 1].setBlockStage(BlockEntry.BlockStage.X);
        }else {
            System.out.println("Coordinates Incorrect");
            return false;
        }
        return true;
    }

    public BlockEntry.BlockStage checkWin()
    {
        BlockEntry.BlockStage sideWin = BlockEntry.BlockStage.NONE;

        //check horizontal
        for (int i = 0; i<this.rowCount; i++)
        {
            BlockEntry.BlockStage temWinSide = gameTable[i][0].getBlockStage();
            if(temWinSide == BlockEntry.BlockStage.NONE)
                continue;
            for(int j = 0; j<this.colCount; j++)
            {
                if(temWinSide != gameTable[i][j].getBlockStage())
                    break;
                else
                {
                    //check win
                    if(j == this.rowCount - 1)
                    {
                        sideWin = temWinSide;
                        return sideWin;
                    }
                }
            }
        }

        //check vertical
        for (int i = 0; i<this.colCount; i++)
        {
            BlockEntry.BlockStage temWinSide = gameTable[0][i].getBlockStage();
            if(temWinSide == BlockEntry.BlockStage.NONE)
                continue;
            for(int j = 0; j<this.rowCount; j++)
            {
                if(temWinSide != gameTable[j][i].getBlockStage())
                    break;
                else
                {
                    //check win
                    if(j == this.rowCount - 1)
                    {
                        sideWin = temWinSide;
                        return sideWin;
                    }
                }
            }
        }

        // Diagonal
        //init get first block
        BlockEntry.BlockStage temWinSide = gameTable[0][0].getBlockStage();
        int i = 1;
        int j = 1;
        while(i <= this.rowCount - 1)
        {
            if(temWinSide != gameTable[i][j].getBlockStage())
                break;
            else
            {
                //check win in last index
                if(i == this.colCount - 1)
                {
                    sideWin = temWinSide;
                    return sideWin;
                }
            }
            i++;
            j++;
        }


        temWinSide = gameTable[this.rowCount - 1][0].getBlockStage();
        i = this.rowCount - 1;
        j = 1;
        while(i <= this.rowCount - 1)
        {
            if(temWinSide != gameTable[i][j].getBlockStage())
                break;
            else
            {
                //check win in last index
                if(i == this.colCount - 1)
                {
                    sideWin = temWinSide;
                    return sideWin;
                }
            }
            i--;
            j++;

        }



        return BlockEntry.BlockStage.NONE;
    }



}
