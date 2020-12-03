package Project;

public class DominoTie {
	
	private int left;
	private int right;
	
	public DominoTie(int leftValue, int rightValue)
	{
		if(leftValue >= 0 && leftValue <= 6 && rightValue >= 0 && rightValue <= 6)
		{
			left = leftValue;
			right = rightValue;
		}
	}
	public DominoTie()
	{
		this.left = 0;
		this.right = 0;
	}
	public int getLeft()
	{
		return left;
	}
	
	public int getRight()
	{
		return left;
	}
	
	public void exchangeSides()
	{
		int temp = left;
		left = right;
		right = temp;
	}
	
	public boolean equals(DominoTie tile)
	{
		if(this.right == tile.right && this.left == tile.left)
		{
			return true;
		}
		if(this.right == tile.left && this.left == tile.right)
		{
			return true;
		}
		return false;
	}
	
	public boolean equalSides(DominoTie newTile, int side)
	{
		if(side == 1)
		{
			if(this.left == newTile.getRight())
			{
				return true;
			}
			if(this.left == newTile.getLeft())
			{
				newTile.exchangeSides();
				return true;
			}
		}
		if(side == 2)
		{
			if(this.right == newTile.getLeft())
			{
				return true;
			}
			if(this.right == newTile.getRight())
			{
				newTile.exchangeSides();
				return true;
			}
		}
		return false;
	}
	
	private char[][] side(int points)
	{
		char[][] sideArr = new char[3][3];
		
		if(points == 6)
		{
			sideArr[1][0] = '*';
			sideArr[1][2] = '*';
		}
		
		if(points % 2 == 1)
		{
			sideArr[1][1] = '*';
		}
		
		for(int i = 0; i <= points && points != 0; i+=2)
		{
			sideArr[i][i] = '*';
			if(points > 2 && i >= 2)
			{
				sideArr[0][2] = '*';
				sideArr[2][0] = '*';
			}
		}
		return sideArr;
	}
	
}
