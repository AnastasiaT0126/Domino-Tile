package Project;

public class DominoTable {
	
	public final int ARR_SIZE = 28;
	public final int LEFT = 1;
	public final int RIGHT = 2;
	
	private DominoTie[] table;
	private int lastElement;
	
	private TableEventListener eventListener;

	public DominoTable()
	{
		this.table = new DominoTie[ARR_SIZE];
		this.lastElement = 0;
	}

	public DominoTie[] getTable()
	{
		return this.table;
	}
	
	private boolean posible()
	{
		if(lastElement + 1 < ARR_SIZE)
		{
			return true;
		}
		return false;
	}
	
	private void move()
	{
		for(int i = lastElement + 1; i > 0; i--)
		{
			table[i] = table[i - 1];
		}
		lastElement++;
	}
	
	public boolean addLeft(DominoTie newTile)
	{
		if(table[0] == null)
		{
			if(eventListener != null)
			{
				table[0] = newTile;
				eventListener.onTableChanged(this);
				return true;
			}
		}
		if(posible() && table[0].equalSides(newTile, LEFT))
		{
			if(eventListener != null)
			{
				move();
				table[0] = newTile;
				eventListener.onTableChanged(this);
				return true;
			}
		}
		return false;
	}
	
	public boolean addRight(DominoTie newTile)
	{
		if(posible())
		{
			if(table[lastElement] == null)
			{
				if(eventListener != null)
				{
					table[lastElement] = newTile;
					eventListener.onTableChanged(this);
					return true;
				}
			}
			if(table[lastElement].equalSides(newTile, RIGHT))
			{
				if(eventListener != null)
				{
					lastElement++;
					table[lastElement] = newTile;
					eventListener.onTableChanged(this);
					return true;
				}
			}
		}
		return false;
	}
	
	public void print()
	{
		String firstRow = "";
		String secondRow = "";
		String thirdRow = "";
		
		for(int i = 0; i <= lastElement && table[i] != null; i++)
		{
			String element = table[i].toString();
			firstRow = firstRow + element.substring(0, 6);
			secondRow = secondRow + element.substring(6, 12);
			thirdRow = thirdRow + element.substring(12, 18);
		}
		System.out.println(firstRow);
		System.out.println(secondRow);
		System.out.println(thirdRow);
	}
	
	public void addTableEventListener(TableEventListener listener)
	{
		this.eventListener = listener;
	}
}
