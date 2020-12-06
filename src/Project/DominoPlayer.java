package Project;

public class DominoPlayer {
	private String nickname; 
	private DominoTie[] tiles; 
	private int tilesInHands;  
	private DominoTable table; 
	
	public DominoPlayer(String nickname, DominoTie[] tiles, int tilesInHands, DominoTable table)
	{
		setNickname(nickname);
		this.tiles = tiles;
		this.tilesInHands = tilesInHands;
		this.table = table;
	}
	
	public void setNickname(String nickname)
	{
		if(nickname != null || !nickname.isEmpty())
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
	
	//тук погледнах от Гери, защото не мажах да се сетя, но го разбрах
	public void addTileAtLeft(DominoTie t)
	{
		int index = getTileIndex(t);
		if(index != -1 && table.addLeft(t))
		{
			tiles[index] = null;
			this.tilesInHands--;
		}
	}
	
	public void addTileAtRight(DominoTie t)
	{
		int index = getTileIndex(t);
		if(index != -1 && table.addRight(t))
		{
			tiles[index] = null;
			this.tilesInHands--;
		}
	}
}
