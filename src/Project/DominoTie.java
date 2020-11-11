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
	
	

}
