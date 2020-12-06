package Project;

public class DominoPlayer {
	private String nickname; // никнейм на играча
	private DominoTie[] tiles; // пулчетата, които играча има в ръцете си
	private int tilesInHands; // колко пулчета има в ръцете си 
	private DominoTable table; // масата, на която играе съответния играч
	
	public DominoPlayer(String nickname, DominoTie[] tiles, int tilesInHands, DominoTable table)
	{
		setNickname(nickname);
		this.tiles = tiles;
		this.tilesInHands = tilesInHands;
		this.table = table;
	}
	
	public void setNickname(String nickname)
	{
		if(nickname != null || nickname.isEmpty())
		{
			this.nickname = nickname;
		}
	}
	
	public String getNickname()
	{
		return this.nickname;
	}
	
	public DominoTie[] getTiles()
	{
		return this.tiles;
	}
	
	public int getTilesInHands()
	{
		return this.tilesInHands;
	}
	
	public DominoTable getTable()
	{
		return this.table;
	}
	
	private int getTileIndex(DominoTie t)
	{
		for(int i = 0; i < tiles.length; i++)
		{
			if(tiles[i] == t)
			{
				return i;
			}
		}
		return -1;
	}
}
