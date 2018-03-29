import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program
{		
	private static GenericHeapSort ghs = new GenericHeapSort();
	private static BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
	private static int size = 0;
	private static String input = "";
			
    public static void main(String[] args) 
    {    	
    		System.out.println("input 'INTEGER' if you would like to sort integer numbers, input 'STRING' if you would like to sort strings, or 'END' for exit");
    		    		
    		try 
    		{
    			input = reader.readLine();
			}
    		catch (IOException e) 
    		{
				e.printStackTrace();
			}
    		   		
    		if(input.equals("INTEGER"))
    		{    			
    			size = getSize();
    			Integer[] intArr = new Integer[size];
    			System.out.println("input " + size + " integer numbers");
    			
    			for(int i = 0; i < size; i++)
    			{
    				try 
    				{    					
    					System.out.print(i + 1 + ".");
						intArr[i] = Integer.parseInt(reader.readLine());
					} 
    				catch (Exception e) 
    				{
						System.out.println("input must be an integer, try it one more time");
						i--;
					}
    			}
    			
    			System.out.println( "\nArray contains:" ); 	   
    	        printArray(intArr); 
    	        ghs.sort(intArr);
    	        
    	        System.out.println( "After generic heap sort array contains:" ); 	   
    	        printArray(intArr); 
    	       
    			
    		}
    		else if(input.equals("STRING"))
    		{
    			size = getSize();
    			String[] stringArr = new String[size];
    			System.out.println("input " + size + " strings");
    			
    			for(int i = 0; i < size; i++)
    			{
    				System.out.print(i + 1 + ".");
    				try 
    				{
						stringArr[i] = reader.readLine();
					} 
    				catch (IOException e) 
    				{						
						e.printStackTrace();
					}
    			}
    			
    			System.out.println( "\nArray contains:" ); 	   
    	        printArray(stringArr); 
    	        ghs.sort(stringArr);
    	        
    	        System.out.println( "After generic heap sort array contains:" ); 	   
    	        printArray(stringArr); 
    	        	        
    		}
    		else if(input.equals("END"))
    		{
    			try 
    			{
					reader.close();
				} 
    			catch (IOException e) 
    			{					
					e.printStackTrace();
				}
    			
    			System.out.println("Exit");
    		}
    		else
    			System.out.println("Unknown command");
    		   		    		
    		if(!input.equals("END"))
    			main(new String[0]);	//repeat program until 'END' command
		  
    }
    
	private static int getSize() 
	{
		int size = 0;
		System.out.println("Input size of an array");
		try 
    	{
			size = Integer.parseInt(reader.readLine());
			
			if(size <= 0)
				throw new IOException();
		} 
    	catch (Exception e) 
    	{
			System.out.println("Size of an array should be an inetegr bigger than 0");
			getSize();
		}
		return size;
	}

	// generic method printArray                         
   public static < E > void printArray( E[] inputArray ) 
   {             
         for ( E element : inputArray )      
            System.out.printf( "%s ", element );
         
         System.out.println();
   }
   
   
}
