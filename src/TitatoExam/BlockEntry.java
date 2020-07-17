package TitatoExam;

public class BlockEntry {

    public enum BlockStage
    {
        NONE,
        O,
        X
    }

    private BlockStage blockStage;

    public BlockEntry()
    {
        blockStage = BlockStage.NONE;
    }

    public BlockStage getBlockStage() {
        return blockStage;
    }

    public void setBlockStage(BlockStage blockStage) {
        this.blockStage = blockStage;
    }

    public String getDrawSymbol()
    {
        if  (this.blockStage == BlockStage.NONE)
            return " ";
        else if (this.blockStage == BlockStage.X)
            return "X";
        else if (this.blockStage == BlockStage.O)
            return "O";
        return "None";
    }
}
